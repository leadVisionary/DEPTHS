package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class unitTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String svgUri;
String currUnitId; 
int numOfConceptsToLearn, numOfUnits;
String currConcId;
String concId;
String unitTitle, unitId;  
int numOfFragm;
String type;
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n<script language=\"javascript\" src=\"js/popupWindowFunctions.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
      depths.presentationModule.RegistrationBean registrationBeanId = null;
      synchronized (session) {
        registrationBeanId = (depths.presentationModule.RegistrationBean) _jspx_page_context.getAttribute("registrationBeanId", PageContext.SESSION_SCOPE);
        if (registrationBeanId == null){
          registrationBeanId = new depths.presentationModule.RegistrationBean();
          _jspx_page_context.setAttribute("registrationBeanId", registrationBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.TestBean testBeanId = null;
      synchronized (session) {
        testBeanId = (depths.presentationModule.TestBean) _jspx_page_context.getAttribute("testBeanId", PageContext.SESSION_SCOPE);
        if (testBeanId == null){
          testBeanId = new depths.presentationModule.TestBean();
          _jspx_page_context.setAttribute("testBeanId", testBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
svgUri = registrationBeanId.getSVG_uri();
      out.write("\r\n\r\n");
if (registrationBeanId.getInTestFlag()) {
      out.write('\r');
      out.write('\n');
response.sendRedirect("getNext.jsp");
      out.write('\r');
      out.write('\n');
} else {
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
currUnitId=registrationBeanId.getCurrUnitId(); 
      out.write("\r\n\r\n<body>\r\n");
registrationBeanId.putNumOfConceptsToLearn();
      out.write('\r');
      out.write('\n');
registrationBeanId.putNumOfUnitsToLearn();
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
currConcId = registrationBeanId.readCurrConcID();
      out.write('\r');
      out.write('\n');
numOfConceptsToLearn = registrationBeanId.getNumOfConceptsToLearn();
      out.write('\r');
      out.write('\n');
numOfUnits = registrationBeanId.getNumOfUnitsToLearni();
      out.write("\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav>\r\n<a href=\"#\" onclick=\"popupSmallWindow('changePerformancePage.jsp')\">Performance</a> |\r\n<a href=\"#\" onclick=\"popupWindow('conceptStatisticPage.jsp')\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Curriculum</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  ");
for (int i = 0; i < numOfConceptsToLearn ; i++) {  
      out.write("\r\n    ");
concId = registrationBeanId.getConceptIdByOrdNum(i);  
      out.write("\r\n    <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentSelection.jsp?conceptId=");
      out.print(concId);
      out.write("\">\r\n      ");
if (concId == currConcId) {    
      out.write("\r\n\r\n      <strong>");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</strong>\r\n    </a>\r\n    ");
} else {  
      out.write("\r\n\r\n    ");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</a>\r\n\t");
}  
      out.write("\r\n\t<br />\r\n    ");
if (concId.equals(currConcId)) {  
      out.write("\r\n\t<div style=\"margin-left:15px; padding-left:0px;\">\r\n    ");
for (int si = 0; si < numOfUnits; si++) {  
      out.write("\r\n      ");
      out.write("\r\n      ");
unitTitle = registrationBeanId.getUnitTitleByOrdNum(si+1);  
      out.write("\r\n      ");
unitId = registrationBeanId.getUnitIdByOrdNum(si+1);  
      out.write("\r\n      <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentLessonSelection.jsp?conceptId=");
      out.print(concId);
      out.write("&lessonId=");
      out.print(unitId );
      out.write("\">\r\n        ");
if ((registrationBeanId.getUnitTitle()).equals(unitTitle)) {    
      out.write("\r\n        <strong>");
      out.print( unitTitle );
      out.write("</strong> </a>\r\n\t\t");
} else {  
      out.write("\r\n        ");
      out.print( unitTitle );
      out.write("</a>\r\n\t\t");
}  
      out.write("<br />\r\n\r\n        ");
}  
      out.write("\r\n\t<a href=\"#\">Questionnaire</a><br/>\r\n        </div><!--style-->\r\n        ");
} 
      out.write("\r\n\r\n\r\n        ");
} 
      out.write("\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n    ");

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
  
      out.write("\r\n  <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentRelearningSelection.jsp?conceptId=");
      out.print(registrationBeanId.getPassedConceptIdByOrdNum(i));
      out.write("\" >\r\n    ");
      out.print(registrationBeanId.getPassedConceptTitleByOrdNum(i));
      out.write("</a><br />\r\n    <img alt=\"\" src=\"images/");
      out.print(rating);
      out.write("\"/><br />\r\n     ");
}
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n </div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n      <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentLessonSelection.jsp?conceptId=");
      out.print(currConcId);
      out.write("&findPrevious=");
      out.print(currUnitId );
      out.write("\">        &lt;&lt;\r\n        Previous\r\n</a>\r\n    </div><!--breadCrumb-->\r\n    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">");
      out.print( registrationBeanId.getCurrConceptTitle());
      out.write("</h1>\r\n  <div class=\"story\">\r\n    <h2>");
      out.print( registrationBeanId.getUnitTitle());
      out.write("</h2>\r\n\r\n    ");
      out.write('\r');
      out.write('\n');
numOfFragm = registrationBeanId.getNumberOfFragmentsInUnit();
      out.write('\r');
      out.write('\n');
for (int i = 0; i < numOfFragm ; i++) {
      out.write('\r');
      out.write('\n');
registrationBeanId.getFragmentByOrdNumber(i);
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
type = registrationBeanId.getFragmentType();
      out.write('\r');
      out.write('\n');
if (type.equals("whole")) {
      out.write("\r\n  <h3>");
      out.print( registrationBeanId.getFragmentTitle() );
      out.write("  </h3>\r\n\r\n");
      out.print( registrationBeanId.getFragmentContent() );
      out.write('\r');
      out.write('\n');
}else if (type.equals("part-of")) {
      out.write('\r');
      out.write('\n');
      out.print( registrationBeanId.getFragmentContent() );
      out.write('\r');
      out.write('\n');
} else if (type.equals("first")) {
      out.write("\r\n  <h3>");
      out.print( registrationBeanId.getFragmentTitle() );
      out.write("  </h3>\r\n\r\n");
      out.print( registrationBeanId.getFragmentContent() );
      out.write('\r');
      out.write('\n');
} else if (type.equals("picture_big")) {
      out.write("\r\n  <embed src=\"");
      out.print(svgUri );
      out.print( registrationBeanId.getFragmentContent() );
      out.write(".svg\" height=\"550\" width=\"820\" type=\"image/svg+xml\" align=\"center\"/>\r\n\r\n");
} else if (type.equals("picture_middle")) {
      out.write("\r\n  <embed src=\"");
      out.print(svgUri );
      out.print( registrationBeanId.getFragmentContent() );
      out.write(".svg\" height=\"350\" width=\"620\" type=\"image/svg+xml\" align=\"center\"/>\r\n\r\n");
} else if (type.equals("picture_small")) {
      out.write("\r\n\r\n  <embed src=\"");
      out.print(svgUri );
      out.print( registrationBeanId.getFragmentContent() );
      out.write(".svg\" height=\"300\" width=\"520\" type=\"image/svg+xml\" align=\"center\"/>\r\n");
} else if (type.equals("list")) {
      out.write("\r\n  <img src=\"images/BD21435_.GIF\" alt=\"\" width=\"11\" height=\"11\" border=\"0\">\r\n</a>  &nbsp;&nbsp;\r\n");
      out.print( registrationBeanId.getFragmentContent() );
      out.write('\r');
      out.write('\n');
} else if (type.equals("list2")) {
      out.write("\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n  -\r\n  &nbsp;&nbsp;\r\n");
      out.print( registrationBeanId.getFragmentContent() );
} else if (type.equals("code")) {
      out.write("\r\n  <blockquote style=\"margin-left:30; margin-right:170; background-color:#ECECEC;\">");
      out.print( registrationBeanId.getFragmentContent() );
      out.write("  </blockquote>\r\n");
}
      out.write("\r\n<br />\r\n<br />\r\n");
}
      out.write("\r\n\r\n\r\n\r\n       <p>&nbsp;</p>\r\n\r\n\r\n\r\n\r\n      <form id=\"form1\" name=\"form1\" method=\"post\" action=\"getNext.jsp\">\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        <input name=\"exitButton\" type=\"submit\" value=\"Save & Exit\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"nextButton\" type=\"submit\" value=\"Next >\" />\r\n          </form>\r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n");
      out.write("</div>\r\n</body>\r\n");
}
      out.write("\r\n</html>\r\n");
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
