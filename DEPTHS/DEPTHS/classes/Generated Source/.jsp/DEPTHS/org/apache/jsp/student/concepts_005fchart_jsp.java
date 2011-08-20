package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import depths.coordinator.Tutor;

public final class concepts_005fchart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Tutor ref;
 int numOfPassedConcepts=0; 
 String concId=""; 
 double degreeOfMastery=0; 
 int hours=0, min=0, sec=0; 
 String actualSkillLevelText=new String(); 
 String title=new String(); 
 String slider=new String(); 
 String slider2; 
 String markText=new String(); 
  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n\r\n");
// page import = "PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart conceptHitChart = null;
      synchronized (session) {
        conceptHitChart = (depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart) _jspx_page_context.getAttribute("conceptHitChart", PageContext.SESSION_SCOPE);
        if (conceptHitChart == null){
          conceptHitChart = new depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart();
          _jspx_page_context.setAttribute("conceptHitChart", conceptHitChart, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      depths.presentationModule.StatisticBean statisticBeanId = null;
      synchronized (session) {
        statisticBeanId = (depths.presentationModule.StatisticBean) _jspx_page_context.getAttribute("statisticBeanId", PageContext.SESSION_SCOPE);
        if (statisticBeanId == null){
          statisticBeanId = new depths.presentationModule.StatisticBean();
          _jspx_page_context.setAttribute("statisticBeanId", statisticBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.RegistrationBean registrationBeanId = null;
      synchronized (session) {
        registrationBeanId = (depths.presentationModule.RegistrationBean) _jspx_page_context.getAttribute("registrationBeanId", PageContext.SESSION_SCOPE);
        if (registrationBeanId == null){
          registrationBeanId = new depths.presentationModule.RegistrationBean();
          _jspx_page_context.setAttribute("registrationBeanId", registrationBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
 ref=registrationBeanId.sendTutorRefToStatBean(); 
      out.write('\r');
      out.write('\n');
 statisticBeanId.setTutorRef(ref); 
      out.write('\r');
      out.write('\n');
ref.setChartsRef(conceptHitChart); 
      out.write('\r');
      out.write('\n');

//conceptHitChart.sendReference(conceptChartData);
	String section = request.getParameter("section");

        session=request.getSession();

        if (section == null)
       // ? false : section.equals("All"))
       {

         section = "Progress";}
	// if (section == null ? false : section.equals("All")) section = null;
        String filename=""; //ConceptHitChart.generateXYChart(section, session, new PrintWriter(out));

       // if (section!=null){
          if (section.equals("Concepts")){

            filename = conceptHitChart.generateBarChart(section, session, new PrintWriter(out));

          }else if (section.equals("Progress")){

            filename = conceptHitChart.generateXYChart(section, session, new PrintWriter(out));
          }
       // }

	String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;


	ArrayList sectionList = new ArrayList();
	  sectionList.add("Concepts");
        sectionList.add("Progress");//conceptChartDataSet.getSectionList();


      out.write("\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n\r\n\r\n<body>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
 statisticBeanId.getNumOfPassedConcFromSM();
      out.write('\r');
      out.write('\n');
 numOfPassedConcepts=statisticBeanId.getNumberOfPassedConcepts(); 
      out.write("\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  <a href=\"conceptStatisticPage.jsp\" >Concept's statistics </a><br />\r\n  <br />\r\n\t<br />\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n   <div id=\"sectionLinks\">\r\n    ");

  int numOfPassedConcepts;
  double passConcDegree;
  String rating;
  numOfPassedConcepts = registrationBeanId.getNumberOfPassedConcepts();


      out.write('\r');
      out.write('\n');
for (int i = 0; i < numOfPassedConcepts; i++) {
      out.write("\r\n\r\n  ");

  passConcDegree = registrationBeanId.getPassedConceptDegreeOfMastByOrdNum(i);
  rating = registrationBeanId.getPassedConceptRating(passConcDegree);
  
      out.write("\r\n\r\n  <a href=\"lessonsStatisticPage.jsp?conceptId=");
      out.print(registrationBeanId.getPassedConceptIdByOrdNum(i));
      out.write("\" >\r\n    ");
      out.print(registrationBeanId.getPassedConceptTitleByOrdNum(i));
      out.write("</a><br />\r\n    <img alt=\"\" src=\"images/");
      out.print(rating);
      out.write("\"/><br />\r\n     ");
}
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Concept statistic's chart diagrams\r\n    </h1>\r\n  <div class=\"story\">\r\n\r\n  <div align=\"center\">\r\n\r\n            ");
if (section.equals("Progress")){ 
      out.write("\r\n          </div>\r\n          <h2 align=\"center\">Student's progress throw the course</h2>\r\n          <div align=\"center\">\r\n            ");
}else if(section.equals("Concepts")){ 
      out.write("\r\n          </div>\r\n          <h2 align=\"center\">Knowledge level for each learned concept</h2>\r\n          <div align=\"center\">\r\n            ");
} 
      out.write("\r\n\r\n\r\n            <br>\r\n\t\t\t  <img src=\"");
      out.print( graphURL );
      out.write("\" width=600 height=400 border=0 usemap=\"#");
      out.print( filename );
      out.write("\">                </div>\r\n          <p align=\"center\">The chart shown above has tooltips and drilldown enabled.</p>\r\n\r\n\t      <div align=\"center\">\r\n\t        <table bordercolordark=\"FFFFFF\" bordercolorlight=\"000000\" width=\"400\" cellpadding=\"20\" cellspacing=\"0\" border=\"1\" class=\"panel\">\r\n\t          <tr><td>\r\n\t            <table border=0 cellpadding=2 width=100%>\r\n\t              <form method=POST action=\"concepts_chart.jsp\">\r\n\t                <tr valign=top>\r\n\t                  <td><b>Section</b></td>\r\n\t\t\t  <td>\r\n\t\t\t    <select name=section class=pullDown>\r\n\r\n  ");
			Iterator iter = sectionList.listIterator();
				while (iter.hasNext()) {
					String optionSection = (String)iter.next();
					if (optionSection.equals(section)) { 
      out.write("\r\n\t\t\t      <option selected>");
      out.print( optionSection );
      out.write("</option>\r\n  ");
					} else { 
      out.write("\r\n\t\t\t      <option>");
      out.print( optionSection );
      out.write("</option>\r\n  ");
					} 
      out.write("\r\n  ");
				} 
      out.write("\r\n\t\t\t      </select>\t\t\t</td>\r\n\t\t\t  <td>\r\n\t\t\t    <input type=image src=\"images/button_refresh.png\" width=80 height=22 name=refresh>\t\t\t</td>\r\n\t\t  </tr>\r\n\t                </form>\r\n\t\t  </table>\r\n\r\n\t</td></tr>\r\n                  </table>\r\n\r\n\t </div>\r\n\t      <p align=\"center\" style=\"margin:0\">&nbsp; </p>\r\n\r\n      <p align=\"center\" style=\"margin:0\">&nbsp;</p>\r\n\r\n      <p align=\"center\" style=\"margin:0\">&nbsp;</p>\r\n      <p align=\"center\" style=\"margin:0\">&nbsp;</p>\r\n      <div align=\"center\">\r\n        <blockquote> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   </blockquote>\r\n      </div>\r\n      <blockquote><p align=\"center\"><a href=\"closeThisWindow\" class=\"style3\" onClick=\"window.close();\">Close</a></p>\r\n      </blockquote>\r\n              <p align=\"center\">&nbsp;</p>\r\n\r\n\r\n\r\n              <p>&nbsp;</p>\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n");
      out.write("  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
