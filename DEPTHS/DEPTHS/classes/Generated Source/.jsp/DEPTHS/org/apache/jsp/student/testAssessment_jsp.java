package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testAssessment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

int numOfConceptsToLearn, numOfUnits;
String currConcId;
String concId;
String unitTitle, unitId;  
 int numOfWrongAnsw; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n<script language=\"JavaScript\" src=\"js/overlib_mini.js\" type=\"text/javascript\"></script>\r\n<style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n<script language=\"javascript\" src=\"js/popupWindowFunctions.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
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
 registrationBeanId.setLessonsFinished(false); 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n<body>\r\n   <div id=\"overDiv\" style=\"position:absolute; visibility:hidden; z-index:1000;\"></div>\r\n");
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
      out.write("\r\n      <strong>");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</strong>\r\n    </a>\r\n    ");
} else {  
      out.write("\r\n    ");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</a>\r\n\t");
}  
      out.write("\r\n\t<br />\r\n    ");
if (concId.equals(currConcId)) {  
      out.write("\r\n\t<div style=\"margin-left:15px; padding-left:0px;\">\r\n    ");
for (int si = 0; si < numOfUnits; si++) {  
      out.write("\r\n      ");
      out.write("\r\n      ");
unitTitle = registrationBeanId.getUnitTitleByOrdNum(si + 1);  
      out.write("\r\n      ");
unitId = registrationBeanId.getUnitIdByOrdNum(si + 1);  
      out.write("\r\n      <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentLessonSelection.jsp?conceptId=");
      out.print(concId);
      out.write("&lessonId=");
      out.print(unitId );
      out.write("\">\r\n\r\n        ");
      out.print( unitTitle );
      out.write("</a>\r\n\t\t<br />\r\n\r\n        ");
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
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n      <a href=\"#\">        &lt;&lt;\r\n        Previous\r\n</a>\r\n    </div><!--breadCrumb-->\r\n    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n\r\n  <div class=\"story\">\r\n    <h2><font color=\"#0000FF\"> ");
      out.print(testBeanId.getMainTestMessage());
      out.write("</font></h2>\r\n      <p class=cp10><strong>Your knowledge level on this test is: <i>");
      out.print(testBeanId.getTestKnowledgeLevel());
      out.write("</i></strong>\r\n        <a class=\"tiny\" href=\"#\" onmouseover=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Student knowledge level', HAUTO, TIMEOUT, 10000);\" onmouseout=\"return nd();\"> (0-6) </a></p>\r\n <br />\r\n\r\n      You have finish this test with: <strong><i>");
      out.print(testBeanId.getTestPointsNumber());
      out.write("</i></strong> points.\r\n      <a class=\"tiny\" href=\"#\" onmouseover=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Number of points on test', HAUTO, TIMEOUT, 10000);\" onmouseout=\"return nd();\">(0-100)</a><br />\r\n      Maximum number of points on this test is: <strong><i>");
      out.print(testBeanId.getTestDifficultyFactor());
      out.write("</i></strong>.\r\n      <a class=\"tiny\" href=\"#\" onmouseover=\"return overlib('This value depends on the difficulty of each question in the test', CAPTION, 'Maximum number of points', HAUTO, TIMEOUT, 10000);\" onmouseout=\"return nd();\">(0-100)</a><br />\r\n      Your success on this test is: <strong><i>");
      out.print(testBeanId.getTestSuccess());
      out.write(" %</i></strong>.\r\n      <a class=\"tiny\" href=\"#\" onmouseover=\"return overlib('This value shows your success on the test based on the number of solved questions', CAPTION, 'Test success', HAUTO, TIMEOUT, 10000);\" onmouseout=\"return nd();\">(0-100%)</a><br />\r\n      You spent: <strong><i>");
      out.print(testBeanId.getTestDuration());
      out.write(" seconds </i></strong>to solve this test.\r\n      ");
      out.write("\r\n\r\n      ");
if (testBeanId.isInAddition()==false){
      out.write("\r\n\r\n      ");
 if (testBeanId.getNumOfWrongAnsw()>0){
      out.write("\r\n\r\n      ");
 numOfWrongAnsw = testBeanId.getNumOfWrongAnsw(); 
      out.write("\r\n      <p>&nbsp;</p>\r\n      <p><em><strong>You didn't answer the following question(s):</strong> </em></p>\r\n      <fieldset>\r\n\r\n        ");
for (int i=0;i<numOfWrongAnsw;i++){
      out.write("\r\n\r\n          <p>");
      out.print((i+1));
      out.write('.');
      out.write(' ');
      out.print( testBeanId.getWrongQuestContent(i+1));
      out.write("</p>\r\n          <p class=\"style3\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color=\"#0000FF\">Correct answer:</font> <span class=\"style4\">");
      out.print(  testBeanId.getWrongQuestTruthAnswer(i+1));
      out.write("</span></p>\r\n\r\n\r\n\r\n\r\n          ");
}
      out.write("\r\n\r\n        </fieldset>\r\n        <p class=\"style3\">&nbsp;</p>\r\n        <p class=\"style4\"><em><strong>Tutor recommends you to read again following lessons to reach better results:</strong> </em></p>\r\n        <fieldset>\r\n          ");
for (int i=0;i<numOfWrongAnsw;i++){
      out.write("\r\n\r\n            <p>");
      out.print((i+1));
      out.write('.');
      out.write(' ');
      out.print( testBeanId.getTitleOfLessonToReLearn(i) );
      out.write(" </p>\r\n            ");
 } 
      out.write("\r\n          </fieldset>\r\n          <p>&nbsp;      </p>\r\n          <p>To accept Tutor recommendation click &quot;Accept&quot;, other way click &quot;Decline&quot;. To save session and stop the Tutor click &quot;Exit &amp; Save&quot;. </p>\r\n          <p>&nbsp;</p>\r\n\r\n       <p>&nbsp;</p>\r\n      <form id=\"form1\" name=\"form1\" method=\"post\" action=\"assessmentHandler.jsp\">\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        <input name=\"declineButton\" type=\"submit\" value=\"Decline\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"acceptButton\" type=\"submit\" value=\"Accept\" />\r\n      </form>\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n\r\n\r\n      ");
}else{
      out.write("\r\n      <h2><font color=\"#000066;\">\r\n      Congratulations, you have answered all questions on this test!\r\n      </font>\r\n\r\n      </h2>\r\n\r\n      ");
 testBeanId.startConceptAssessment(); 
      out.write("\r\n      <p>&nbsp;</p>\r\n      <p>&nbsp;</p>\r\n\r\n       <p>&nbsp;</p>\r\n\r\n      <form id=\"form1\" name=\"form1\" method=\"post\" action=\"excellentAnswersHandler.jsp\">\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        <input name=\"exitButton\" type=\"submit\" value=\"Save & Exit\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"nextButton\" type=\"submit\" value=\"Next >\" />\r\n      </form>\r\n\r\n      <p>&nbsp;</p>\r\n\r\n      ");
}
      out.write("\r\n      ");
}else if (testBeanId.isInAddition()){
      out.write("\r\n\r\n       ");
 if (testBeanId.getNumOfWrongAnsw()>0){
      out.write("\r\n\r\n        ");
 numOfWrongAnsw = testBeanId.getNumOfWrongAnsw(); 
      out.write("\r\n\r\n\r\n        <p>&nbsp;</p>\r\n      <p><em><strong>You didn't answer the following question(s):</strong> </em></p>\r\n      <fieldset>\r\n\r\n      ");
for (int i=0;i<numOfWrongAnsw;i++){
      out.write("\r\n\r\n      <p>");
      out.print((i+1));
      out.write('.');
      out.write(' ');
      out.print( testBeanId.getWrongQuestContent(i+1));
      out.write("</p>\r\n      <p class=\"style3\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color=\"#0000FF\">Correct answer:</font> <span class=\"style4\">");
      out.print(  testBeanId.getWrongQuestTruthAnswer(i+1));
      out.write("</span></p>\r\n\r\n      ");
}
      out.write("\r\n      </fieldset>\r\n      ");
 }else {
      out.write("\r\n      <h2><font color=\"#000066;\">\r\n      Congratulations, you have answered all questions this time!\r\n      </font>\r\n\r\n      </h2>\r\n      ");
}
      out.write("\r\n       ");
 testBeanId.startConceptAssessment(); 
      out.write("\r\n      <p>&nbsp;</p>\r\n      <p>&nbsp;</p>\r\n       <p>&nbsp;</p>\r\n\r\n      <form id=\"form1\" name=\"form1\" method=\"post\" action=\"getAction.jsp\">\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        <input name=\"exitButton\" type=\"submit\" value=\"Save & Exit\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"nextButton\" type=\"submit\" value=\"Next >\" />\r\n      </form>\r\n       <p>&nbsp;</p>\r\n\r\n\r\n\r\n\r\n\r\n      ");
}
      out.write("\r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
