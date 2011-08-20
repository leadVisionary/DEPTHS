package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lessonsStatisticPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int numOfLessons,numOfTests; 
 String conceptId; 
 int numOfQuest;
 double degreeOfMastery=0.0,testDegreeOfMastery=0.0; 
 int hours=0, min=0, sec=0; 
 String actualSkillLevelText=new String(); 
 String title=new String(); 
 String slider=new String(); 
 String markText=new String(); 
 String testDegreeOfMarkText;
 String slider2; 
 String slider3=new String(); 
int numOfPass; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript1.2\" src=\"js/overlib_mini.js\" type=\"text/javascript\"></script>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
      depths.presentationModule.StatisticBean statisticBeanId = null;
      synchronized (session) {
        statisticBeanId = (depths.presentationModule.StatisticBean) _jspx_page_context.getAttribute("statisticBeanId", PageContext.SESSION_SCOPE);
        if (statisticBeanId == null){
          statisticBeanId = new depths.presentationModule.StatisticBean();
          _jspx_page_context.setAttribute("statisticBeanId", statisticBeanId, PageContext.SESSION_SCOPE);
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
        }
      }
      out.write("\r\n<body>\r\n<div id=\"overDiv\" style=\"position:absolute; visibility:hidden; z-index:1000;\"></div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write(' ');
      out.write('\r');
      out.write('\n');
conceptId=request.getParameter("conceptId"); 
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  <a href=\"conceptStatisticPage.jsp\" >Concept's statistics </a><br />\r\n  <a href=\"concepts_chart.jsp\" >Concept's statistic charts </a><br />\r\n\t<br />\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n <div id=\"sectionLinks\">\r\n    ");

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
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Concept statistic page </h1>\r\n\r\n  <div class=\"story\">\r\n    ");
 statisticBeanId.getConceptById(conceptId); 
      out.write("\r\n    <h2 style=\"margin:0\">");
      out.print(statisticBeanId.getConcTitle());
      out.write("</h2>\r\n      <p style=\"margin:0\">&nbsp;</p>      <p style=\"margin:0\">&nbsp;</p>\r\n\t  <table width=\"576\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n\r\n\r\n        <tr>\r\n          <td colspan=\"3\" bordercolor=\"#FFFFFF\"><div align=\"center\">\r\n            <p class=\"style3\"> </p>\r\n          </div></td>\r\n        </tr>\r\n        <tr>\r\n            ");
 degreeOfMastery=statisticBeanId.getConcDegreeOfMastery();
      out.write("\r\n          <td width=\"146\" bordercolor=\"#FFFFFF\">Feedback message: </td>\r\n          ");
 if (degreeOfMastery<1.5){
      out.write("\r\n          ");
  slider="slider_1.jpg";
      out.write("\r\n           ");
 markText="Bad";
      out.write("\r\n          ");
 }else if(degreeOfMastery<2.5){
      out.write("\r\n            ");
 slider="slider_2.jpg";
      out.write("\r\n            ");
 markText="Not bad";
      out.write("\r\n          ");
 }else if (degreeOfMastery<3.5){
      out.write("\r\n            ");
 slider="slider_3.jpg";
      out.write("\r\n            ");
markText="Good";
      out.write("\r\n          ");
 }else if (degreeOfMastery<4.5){
      out.write("\r\n            ");
 slider="slider_4.jpg";
      out.write("\r\n            ");
 markText="Very good";
      out.write("\r\n          ");
 }else {
      out.write("\r\n            ");
 slider="slider_5.jpg";
      out.write("\r\n            ");
 markText="Excellent";}
      out.write("\r\n\r\n          <td colspan=\"2\">");
      out.print(markText);
      out.write(" </td>\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">Duration: </td>\r\n          <td colspan=\"2\"><strong>");
      out.print(statisticBeanId.getHours());
      out.write("&nbsp;hr&nbsp;");
      out.print(statisticBeanId.getMin());
      out.write("&nbsp;min&nbsp;");
      out.print(statisticBeanId.getSec());
      out.write("&nbsp;sec &nbsp; </strong> </td>\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">Degree of mastery: </td>\r\n\r\n          ");
 slider2=statisticBeanId.getSlider2Val(); 
      out.write("\r\n          ");
 actualSkillLevelText=statisticBeanId.getActualSkillLevelText(); 
      out.write("\r\n\r\n          <td width=\"200\"><img src=\"images/");
      out.print(slider);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n          <td width=\"202\"><strong>");
      out.print(markText);
      out.write("</strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">Actual knowledge level: </td>\r\n          <td width=\"140\"><img src=\"images/");
      out.print(slider2);
      out.write("\" width=\"141\" height=\"14\"> </td>\r\n          <td colspan=\"2\"><strong>");
      out.print(actualSkillLevelText);
      out.write("</strong></td>\r\n\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n        </tr>\r\n      </table>      <p style=\"margin:0\">&nbsp; </p>\r\n      <p style=\"margin:0\">&nbsp;</p>\r\n      <p style=\"margin:0; font-weight: bold;\">Passed lessons:</p>\r\n       ");
numOfLessons=statisticBeanId.getNumbOfLessons();
      out.write("\r\n\r\n      <p style=\"margin:0; font-weight: bold;\">&nbsp;</p>\r\n\r\n\r\n\r\n      <table width=\"89%\" height=\"0%\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">\r\n        ");
      out.write("\r\n      ");
 for (int k=0;k<numOfLessons;k++){
      out.write("\r\n\r\n        <tr>\r\n         <td height=\"23%\" width=\"8%\"><div align=\"center\">");
      out.print((k+1));
      out.write(".</div> </td>\r\n         ");
numOfPass=statisticBeanId.getLessonNumberOfPassess(k);
      out.write("\r\n          <td>");
      out.print(statisticBeanId.getLessonTitle(k));
      out.write("\r\n          ");
if (numOfPass>1){ 
      out.write("\r\n          <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value shows if lesson has been passed more than once.', CAPTION, 'Number of passess', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(");
      out.print(numOfPass);
      out.write(")</a>\r\n         ");
} 
      out.write("\r\n\r\n          </td>\r\n\r\n        </tr>\r\n\r\n         ");
}
      out.write("\r\n      </table>\r\n       ");
numOfTests=statisticBeanId.getNumbOfTests();
      out.write("\r\n      ");
statisticBeanId.setConceptForStatPage(conceptId);
      out.write("\r\n        ");
 for (int i=0;i<numOfTests;i++){
      out.write("\r\n        ");
statisticBeanId.setStatisticTest(i);
      out.write("\r\n\r\n      <p style=\"margin:0; font-weight: bold;\">&nbsp;</p>\r\n      <p><strong>Test ");
      out.print((i+1));
      out.write(":</strong></p>\r\n        ");
 numOfQuest=statisticBeanId.getNumbOfQuestions();
      out.write("\r\n\r\n      <table width=\"89%\" height=\"0%\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n        <tr>\r\n          <th width=\"7%\" height=\"26%\"><div align=\"center\"></div></th>\r\n          <th width=\"61%\"><div align=\"left\" class=\"style3\">\r\n            <font size=\"1\">\r\n            <div align=\"left\">Question</div>\r\n            </font>\r\n          </div></th>\r\n          <th width=\"32%\"><div align=\"left\" class=\"style3\">\r\n            <font size=\"1\">\r\n            <div align=\"center\">Your answer was: </div>\r\n            </font>\r\n          </div></th>\r\n        </tr>\r\n         ");
 for (int q=0; q<numOfQuest; q++){
      out.write("\r\n        ");
statisticBeanId.getQuestionDataFromSM(q);
      out.write("\r\n\r\n        <tr>\r\n          <td height=\"23%\"><div align=\"center\"> ");
      out.print((q+1));
      out.write(".</div></td>\r\n          <td>");
      out.print(statisticBeanId.getQuestContent());
      out.write("  </td>\r\n          <td><div align=\"center\"><span class=\"style7\"><font color=\"#006633\">");
      out.print(statisticBeanId.isQuestTruth());
      out.write("</font></span></div></td>\r\n        </tr>\r\n          ");
}
      out.write("\r\n\r\n\r\n        <tr>\r\n          <td height=\"24\">&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n          <td class=\"style7\">&nbsp;</td>\r\n        </tr>\r\n      </table>\r\n      <span class=\"style8\"> </span>\r\n\r\n");
 testDegreeOfMastery=statisticBeanId.getTestDegreeOfMastery();
      out.write("\r\n\r\n ");
 if (testDegreeOfMastery<1.5){
      out.write("\r\n          ");
  slider3="slider_1.jpg";
      out.write("\r\n           ");
 testDegreeOfMarkText="Bad";
      out.write("\r\n          ");
 }else if(testDegreeOfMastery<2.5){
      out.write("\r\n            ");
 slider3="slider_2.jpg";
      out.write("\r\n            ");
 testDegreeOfMarkText="Not bad";
      out.write("\r\n          ");
 }else if (testDegreeOfMastery<3.5){
      out.write("\r\n            ");
 slider3="slider_3.jpg";
      out.write("\r\n            ");
testDegreeOfMarkText="Good";
      out.write("\r\n          ");
 }else if (testDegreeOfMastery<4.5){
      out.write("\r\n            ");
 slider3="slider_4.jpg";
      out.write("\r\n            ");
 testDegreeOfMarkText="Very good";
      out.write("\r\n          ");
 }else if (testDegreeOfMastery<5.0){
      out.write("\r\n            ");
 slider3="slider_4.jpg";
      out.write("\r\n            ");
 testDegreeOfMarkText="Excellent";
      out.write("\r\n            ");
 }else {
      out.write("\r\n            ");
 slider3="slider_5.jpg";
      out.write("\r\n            ");
 testDegreeOfMarkText="Expert";}
      out.write("\r\n\r\n\r\n\r\n      <table width=\"578\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n\r\n        <tr>\r\n          <td scope=\"row\">Test degree of mastery: </td>\r\n\r\n          <td width=\"47\"><strong>");
      out.print(testDegreeOfMarkText);
      out.write("</strong></td>\r\n          <td width=\"218\"><img src=\"images/");
      out.print(slider3);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n        </tr>\r\n        <tr>\r\n          <td scope=\"row\">Your knowledge level on this test: </td>\r\n          <td width=\"47\" ><strong>");
      out.print(statisticBeanId.getTestDegreeOfMastery() );
      out.write("</strong></td>\r\n          <td width=\"218\">\r\n            <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Student knowledge level', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-6)</a></strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td scope=\"row\">You have finish this test with: </td>\r\n          <td width=\"47\" ><strong>");
      out.print(statisticBeanId.getTestPointsNumber() );
      out.write("</strong></td>\r\n          <td width=\"218\">points. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Number of points', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td scope=\"row\">Maximum number of points on this test is: </td>\r\n          <td width=\"47\" ><strong>");
      out.print(statisticBeanId.getTestDifficultyFactor() );
      out.write("</strong></td>\r\n          <td width=\"218\">points. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value depends on the difficulty of each question in the test', CAPTION, 'Maximum number of points', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td scope=\"row\">Your success on this test is: </td>\r\n          <td width=\"47\" ><strong>");
      out.print(statisticBeanId.getTestSuccess() );
      out.write("</strong></td>\r\n          <td width=\"218\">%. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value shows your success on the test based on the number of solved questions', CAPTION, 'Test success', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"165\" scope=\"row\"><p align=\"left\">Test solving duration: </p></td>\r\n          <td width=\"47\" ><strong>");
      out.print(statisticBeanId.getTestDuration());
      out.write("</strong></td>\r\n          <td width=\"218\">seconds.</strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td scope=\"row\">&nbsp;</td>\r\n          <td colspan=\"2\">&nbsp;</td>\r\n        </tr>\r\n      </table>\r\n\t  ");
}
      out.write("\r\n<p style=\"margin:0\">&nbsp;</p>      <blockquote>\r\n         <p align=\"center\"><a href=\"conceptStatisticPage.jsp\" class=\"style3\">Back</a>\r\n           &nbsp;&nbsp;&nbsp;<a href=\"\" class=\"style3\" onclick=\"window.close();\">Close</a></p>\r\n      </blockquote>\r\n              <p>&nbsp;</p>\r\n\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
