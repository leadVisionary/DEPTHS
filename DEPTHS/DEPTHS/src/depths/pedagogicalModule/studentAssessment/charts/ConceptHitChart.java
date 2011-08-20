package depths.pedagogicalModule.studentAssessment.charts;

/*
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * ---------------------------
 * WebHitChart.java
 * ---------------------------
 * (C) Copyright 2002-2004, by Richard Atkinson.
 *
 * Original Author:  Richard Atkinson;
 */


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.text.NumberFormat;
import javax.servlet.http.HttpSession;
import org.jfree.data.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.renderer.BarRenderer;
import org.jfree.chart.renderer.StandardXYItemRenderer;
import org.jfree.chart.renderer.StackedXYAreaRenderer;
import org.jfree.chart.renderer.XYAreaRenderer;
import org.jfree.chart.plot.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.servlet.*;
import org.jfree.chart.annotations.*;

import depths.pedagogicalModule.studentAssessment.StudentModelAssessment;

public class ConceptHitChart {
  private StudentModelAssessment smAssess;
public ConceptChartDataSet ccDataSet;
  public void sendReference(ConceptChartDataSet conceptChartData){
    ccDataSet=conceptChartData;
  }
  public void sendSmAssessRef(StudentModelAssessment smAssessRef){
    smAssess=smAssessRef;

  }

        public  String generateBarChart(String hitSection, HttpSession session, PrintWriter pw) {


                String filename = null;
                try {
                        //  Retrieve list of WebHits
                        ConceptChartDataSet cDataSet = new ConceptChartDataSet(smAssess);
                        ArrayList list = cDataSet.getDataBySection(hitSection);

                        //  Throw a custom NoDataException if there is no data
                        if (list.size() == 0) {
                                System.out.println("No data has been found");
                                throw new NoDataException();
                        }

                        //  Create and populate a CategoryDataset
                        Iterator iter = list.listIterator();
                        DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
                        while (iter.hasNext()) {
                                ConceptHit wh = (ConceptHit)iter.next();
                                //Comparable c1= Double.parseDouble(wh.getHitDegree());
                dataSet.addValue(wh.getHitDegree(),"degree of mastery for concept ",String.valueOf(wh.getHitConcept()));
                        }

                        //  Create the chart object
                        CategoryAxis categoryAxis = new CategoryAxis("Concepts");
                        ValueAxis valueAxis = new NumberAxis("Degree of Mastery");
                        valueAxis.setRange(0.0,6.0);
                        categoryAxis.setCategoryLabelPositions(new CategoryLabelPositions().createUpRotationLabelPositions(45));
                        BarRenderer renderer = new BarRenderer();
                        renderer.setDrawBarOutline(true);
                        renderer.setItemURLGenerator(new StandardCategoryURLGenerator("xy_chart.jsp","series","section"));
                        StandardCategoryToolTipGenerator scttg=new StandardCategoryToolTipGenerator();

            renderer.setToolTipGenerator(scttg);

                        Plot plot = new CategoryPlot(dataSet, categoryAxis, valueAxis, renderer);







                        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
                        chart.setBackgroundPaint(java.awt.Color.white);

                        //  Write the chart image to the temporary directory
                        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

                        filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info, session);

                        //  Write the image map to the PrintWriter
                        ChartUtilities.writeImageMap(pw, filename, info);
                        pw.flush();

                } catch (NoDataException e) {
                        System.out.println(e.toString());
                        filename = "public_nodata_500x300.png";
                } catch (Exception e) {
                        System.out.println("Exception - " + e.toString());
                        e.printStackTrace(System.out);
                        filename = "public_error_500x300.png";
                }

                return filename;
        }

        public  String generatePieChart(String hitOrdNum, HttpSession session, PrintWriter pw) {

                String filename = null;
                try {
                        //  Retrieve list of WebHits
                        ConceptChartDataSet whDataSet = new ConceptChartDataSet(smAssess);
                        ArrayList list = whDataSet.getDataBySection(hitOrdNum);

                        //  Throw a custom NoDataException if there is no data
                        if (list.size() == 0) {
                                System.out.println("No data has been found");
                                throw new NoDataException();
                        }

                        //  Create and populate a PieDataSet
                        DefaultPieDataset data = new DefaultPieDataset();
                        Iterator iter = list.listIterator();
                        while (iter.hasNext()) {
                                ConceptHit wh = (ConceptHit)iter.next();
                                data.setValue(wh.getSection(), wh.getHitDegree());
                        }

                        //  Create the chart object
                        PiePlot plot = new PiePlot(data);
                        plot.setInsets(new Insets(0, 5, 5, 5));
                        plot.setURLGenerator(new StandardPieURLGenerator("xy_chart.jsp","section"));
            plot.setToolTipGenerator(new StandardPieItemLabelGenerator());
                        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
                        chart.setBackgroundPaint(java.awt.Color.white);

                        //  Write the chart image to the temporary directory
                        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                        filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info, session);

                        //  Write the image map to the PrintWriter
                        ChartUtilities.writeImageMap(pw, filename, info);
                        pw.flush();

                } catch (NoDataException e) {
                        System.out.println(e.toString());
                        filename = "public_nodata_500x300.png";
                } catch (Exception e) {
                        System.out.println("Exception - " + e.toString());
                        e.printStackTrace(System.out);
                        filename = "public_error_500x300.png";
                }

                return filename;
        }

        public  String generateXYChart(String section, HttpSession session, PrintWriter pw) {

                String filename = null;
                try {
                        //  Retrieve list of WebHits
                        ConceptChartDataSet cDataSet = new ConceptChartDataSet(smAssess);
                        ArrayList list = cDataSet.getDataByHitConcept(section);
                        //  Throw a custom NoDataException if there is no data
                        if (list.size() == 0) {
                                System.out.println("No data has been found");
                                throw new NoDataException();
                        }
                        //  Create and populate an XYSeries Collection
                        XYSeries dataSeries = new XYSeries("Students progress line");
                        Iterator iter = list.listIterator();
                         while (iter.hasNext()) {
                                ConceptHit ch = (ConceptHit)iter.next();
                                dataSeries.add(ch.getOrdNumb(),ch.getHitDegree());

                        }
                        XYSeriesCollection xyDataset = new XYSeriesCollection(dataSeries);


                       NumberFormat nf=NumberFormat.getIntegerInstance();
                       NumberFormat nf2=NumberFormat.getInstance();


                        String cTitle=null;
                        //StandardXYToolTipGenerator ttg = new StandardXYToolTipGenerator(StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,nf,nf2);
                        CustomXYToolTipGenerator ttg = new CustomXYToolTipGenerator( );
                        ttg.addToolTipSeries(cDataSet.getConceptNames());
                       StandardXYURLGenerator sxyUrlGen=new StandardXYURLGenerator("#",xyDataset.getSeriesName(0),"PassedConceptOrdNum");


                        ValueAxis ordNumAxis = new NumberAxis("Concept ordinal number");
                        NumberAxis valueAxis = new NumberAxis("Current knowledge");
                       // valueAxis.setAutoRangeIncludesZero(true);
                       valueAxis.setRange(0.0,6.0); // override default
                       ordNumAxis.setAutoRange(true);
                       ordNumAxis.setLowerMargin(0.0);





            StandardXYItemRenderer renderer = new StandardXYItemRenderer(
                    StandardXYItemRenderer.LINES + StandardXYItemRenderer.SHAPES,
                    ttg, sxyUrlGen);
          Marker marker=new ValueMarker(1.50);///
           Marker marker2=new ValueMarker(2.50);
           Marker marker3=new ValueMarker(3.50);
           Marker marker4=new ValueMarker(4.50);
           Marker marker5=new ValueMarker(5.00);


            renderer.setShapesFilled(true);
                        XYPlot plot = new XYPlot(xyDataset, ordNumAxis, valueAxis, renderer);

                        plot.addRangeMarker(marker);
                       plot.addRangeMarker(marker2);
                       plot.addRangeMarker(marker3);
                       plot.addRangeMarker(marker4);
                       plot.addRangeMarker(marker5);

                       XYTextAnnotation xyBad=new XYTextAnnotation("Bad",1,1);
                                 xyBad.setX(0.2);xyBad.setY(0.75);
                                 XYTextAnnotation xyNotBad=new XYTextAnnotation("Not Bad",1,1);
                                 xyNotBad.setX(0.2); xyNotBad.setY(2);
                       XYTextAnnotation xyGood=new XYTextAnnotation("Good",1,1);
                                 xyGood.setX(0.2); xyGood.setY(3);
                       XYTextAnnotation xyVeryGood=new XYTextAnnotation("Very Good",1,1);
                                 xyVeryGood.setX(0.2); xyVeryGood.setY(4);
                       XYTextAnnotation xyExcellent=new XYTextAnnotation("Excellent",1,1);
                                 xyExcellent.setX(0.2); xyExcellent.setY(4.75);

                       XYTextAnnotation xyExpert=new XYTextAnnotation("Expert",1,1);
                                 xyExpert.setX(0.2); xyExpert.setY(5.25);

                      plot.addAnnotation(xyBad);
                      plot.addAnnotation(xyNotBad);
                      plot.addAnnotation(xyGood);
                      plot.addAnnotation(xyVeryGood);
                      plot.addAnnotation(xyExcellent);
                      plot.addAnnotation(xyExpert);

                        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
                        chart.setBackgroundPaint(java.awt.Color.white);

                        //  Write the chart image to the temporary directory
                        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                        filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info, session);

                        //  Write the image map to the PrintWriter
                        ChartUtilities.writeImageMap(pw, filename, info);
                        pw.flush();

                } catch (NoDataException e) {
                        System.out.println(e.toString());
                        filename = "public_nodata_500x300.png";
                } catch (Exception e) {
                        System.out.println("Exception - " + e.toString());
                        e.printStackTrace(System.out);
                        filename = "public_error_500x300.png";
                }

                return filename;
        }

    public  String generateXYAreaChart(HttpSession session, PrintWriter pw) {
        String filename = null;
        try {
            //  Retrieve list of WebHits for each section and populate a TableXYDataset
            ConceptChartDataSet cDataSet = new ConceptChartDataSet(smAssess);
            cDataSet.setSmAssessRef(smAssess);
            ArrayList sections = cDataSet.getSections();
            Iterator sectionIter = sections.iterator();
            DefaultTableXYDataset dataset = new DefaultTableXYDataset();
            while (sectionIter.hasNext()) {
                String section = (String)sectionIter.next();
                ArrayList list = cDataSet.getDataByHitConcept(section);
                XYSeries dataSeries = new XYSeries(section, true, false);
                Iterator webHitIter = list.iterator();
                while (webHitIter.hasNext()) {
                    ConceptHit cHit = (ConceptHit)webHitIter.next();
                    dataSeries.add(cHit.getOrdNumb(), cHit.getHitDegree());
                }
                dataset.addSeries(dataSeries);
            }

            //  Throw a custom NoDataException if there is no data
            if (dataset.getItemCount() == 0) {
                System.out.println("No data has been found");
                throw new NoDataException();
            }

            //  Create tooltip and URL generators
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
            StandardXYToolTipGenerator ttg = new StandardXYToolTipGenerator(
                    StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
                    sdf, NumberFormat.getInstance());
            TimeSeriesURLGenerator urlg = new TimeSeriesURLGenerator(
                    sdf, "bar_chart.jsp", "series", "hitDate");

            //  Create the X-Axis
            DateAxis xAxis = new DateAxis(null);
            xAxis.setLowerMargin(0.0);
            xAxis.setUpperMargin(0.0);

            //  Create the X-Axis
            NumberAxis yAxis = new NumberAxis(null);
            yAxis.setAutoRangeIncludesZero(true);

            //  Create the renderer
            StackedXYAreaRenderer renderer =
                    new StackedXYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES, ttg, urlg);
            renderer.setSeriesPaint(0, new Color(255, 255, 180));
            renderer.setSeriesPaint(1, new Color(206, 230, 255));
            renderer.setSeriesPaint(2, new Color(255, 230, 230));
            renderer.setSeriesPaint(3, new Color(206, 255, 206));
            renderer.setShapePaint(Color.gray);
            renderer.setShapeStroke(new BasicStroke(0.5f));
            renderer.setShape(new Ellipse2D.Double(-3, -3, 6, 6));
            renderer.setOutline(true);

            //  Create the plot
            XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
            plot.setForegroundAlpha(0.65f);

            //  Reconfigure Y-Axis so the auto-range knows that the data is stacked
            yAxis.configure();

            //  Create the chart
            JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
            chart.setBackgroundPaint(java.awt.Color.white);

            //  Write the chart image to the temporary directory
            ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info, session);

            //  Write the image map to the PrintWriter
            ChartUtilities.writeImageMap(pw, filename, info);
            pw.flush();


        } catch (NoDataException e) {
            System.out.println(e.toString());
            filename = "public_nodata_500x300.png";
        } catch (Exception e) {
            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
        }
        return filename;
    }

        public static void main(java.lang.String[] args) {

                /* try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
                        PrintWriter pw = new PrintWriter(System.out);
                        String filename = ConceptHitChart.generateBarChart("Concepts", null, pw);
//			String filename = WebHitChart.generatePieChart(sdf.parse("01-Aug-2002"), null, pw);
//			String filename = WebHitChart.generateXYChart("service", null, pw);


                } catch (Exception e) {
                        System.out.println("Exception - " + e.toString());
                        e.printStackTrace();
                }
                return;
                */
        }

}
