/*
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * ---------------------------
 * WebHitDataSet.java
 * ---------------------------
 * (C) Copyright 2002-2004, by Richard Atkinson.
 *
 * Original Author:  Richard Atkinson;
 */
package depths.pedagogicalModule.studentAssessment.charts;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import depths.pedagogicalModule.studentAssessment.StudentModelAssessment;

public class ConceptChartDataSet {
        protected ArrayList data = new ArrayList();
        public java.util.List l=new ArrayList();
         public StudentModelAssessment sma;


        //public void setRefToStudModelAssessment(StudentModelAssessment ref){
          //  sma=ref;


  //}
  public void setSmAssessRef(StudentModelAssessment smAssess){
    sma=smAssess;
  }


    public ConceptChartDataSet(StudentModelAssessment smAssess) throws ParseException {
      sma=smAssess;


                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.UK);
                String [] concepts=sma.getConceptsTitles();


                   // new String []{"Abstract Factory", "Builder","Factory Method","Prototype","Singleton", "Adapter", "Bridge",
                     //              "Composite","Decorator","Facade","Flywieght", "Proxy","Chain of Responsibility","Command","Interpreter"};
                double degrees[] =sma.getConceptsDegrees();
                    //{1.1, 1.2, 3.43, 3.12, 2.76, 5.12, 3.403, 4.21, 5.44, 2.34, 3.42, 1.23, 3.76, 4.56, 2.54};
                double knLev[] =sma.getActualKnowledgeLevel();
                    //{5.0, 3.4, 4.43, 3.72, 3.26, 3.82, 3.63, 3.91, 4.24, 4.04, 3.92, 3.63, 3.71, 3.96, 3.54};
                //String st="Inicial knowledge="+knLev[0];

                for (int i=0;i<concepts.length;i++){
                    data.add(new ConceptHit(concepts[i],"Concepts",i,degrees[i]));
                    String s=concepts[i]+"="+knLev[i];

                    l.add(s);

                }
                for (int i=0;i<concepts.length;i++){
                    data.add(new ConceptHit(concepts[i],"Progress",i,knLev[i]));

                }
                for (int i=0;i<concepts.length;i++){
                                    data.add(new ConceptHit(concepts[i],"Tracking",i,degrees[i]));
                                }
               for (int i=0;i<concepts.length;i++){
                                    data.add(new ConceptHit(concepts[i],"Service",i,knLev[i]));
                                }
    }
    public java.util.List getConceptNames(){
        return l;
    }

        public ArrayList getDataByHitConcept(String filterSection) {

                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        ConceptHit cHit = (ConceptHit)iter.next();
                        if (filterSection == null ? true : filterSection.equals(cHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(cHit.getHitConcept());
                                if (position == null) {
                                        results.add(cHit);
                                        conceptMap.put(cHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        ConceptHit previousConceptHit = (ConceptHit)results.get(position.intValue());
                                        previousConceptHit.setHitDegree(previousConceptHit.getHitDegree() + cHit.getHitDegree());
                                }
                        }
                }
                return results;
        }
        public ArrayList getDataBySection(String filterHitConcept) {

                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        ConceptHit cHit = (ConceptHit)iter.next();
                        if (filterHitConcept.equals("Progress") ? true : filterHitConcept.equals(cHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(cHit.getHitConcept());
                                if (position == null) {
                                        results.add(cHit);
                                        conceptMap.put(cHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        ConceptHit previousConceptHit = (ConceptHit)results.get(position.intValue());
                                        previousConceptHit.setHitDegree(previousConceptHit.getHitDegree() + cHit.getHitDegree());
                                }
                        }
                }

                return results;
        }

    public ArrayList getSections() {
        ArrayList list = new ArrayList();
        list.add("Catalog");
        list.add("Checkout");
        list.add("Tracking");
        list.add("Service");
        return list;
    }

        public static void main(java.lang.String[] args) {
          /*
          try {

                        ConceptChartDataSet cDataSet = new ConceptChartDataSet(smAssess);
                        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.UK);
                        String cTitle=null;
                        ArrayList results = cDataSet.getDataBySection("Concepts");
                        Iterator iter = results.listIterator();
                        while (iter.hasNext()) {
                                ConceptHit wh = (ConceptHit)iter.next();

                        }


                } catch (Exception e) {
                        e.printStackTrace();
                }
          */
        }

        public static ArrayList getDateList() {
                ArrayList dateList = new ArrayList();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.UK);

                        dateList.add("Abstract Factory");
                        dateList.add("Factory");
                        dateList.add("Bridge");
                        dateList.add("Proxy");


                return dateList;
        }

        public  ArrayList getSectionList() {
                ArrayList sectionList = new ArrayList();
                sectionList.add("Concepts");
                sectionList.add("Progress");
                sectionList.add("Service");
                sectionList.add("Tracking");
                return sectionList;
        }

}
