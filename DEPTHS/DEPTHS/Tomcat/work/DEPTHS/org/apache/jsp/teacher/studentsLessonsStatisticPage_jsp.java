package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;

public final class studentsLessonsStatisticPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int numOfLessons,numOfTests; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<!-- DW6 -->\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n");
      out.write("<title>DEPTHS</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n");
      out.write("</style><style type=\"text/css\">\r\n");
      out.write("  <!--\r\n");
      out.write("    .copyrightStyle {\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    color: #006699;\r\n");
      out.write("    }\r\n");
      out.write("  -->\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript1.2\" src=\"js/overlib_mini.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<!-- JSP code -->\r\n");
      depths.presentationModule.teacher.StudentsStatisticBean studentStatisticBeanId = null;
      synchronized (session) {
        studentStatisticBeanId = (depths.presentationModule.teacher.StudentsStatisticBean) _jspx_page_context.getAttribute("studentStatisticBeanId", PageContext.SESSION_SCOPE);
        if (studentStatisticBeanId == null){
          studentStatisticBeanId = new depths.presentationModule.teacher.StudentsStatisticBean();
          _jspx_page_context.setAttribute("studentStatisticBeanId", studentStatisticBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"overDiv\" style=\"position:absolute; visibility:hidden; z-index:1000;\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write('\r');
      out.write('\n');
String conceptId=request.getParameter("conceptId"); 
      out.write('\r');
      out.write('\n');
String courseId=request.getParameter("courseId"); 
      out.write('\r');
      out.write('\n');
String studentId=request.getParameter("studentId"); 
      out.write('\r');
      out.write('\n');
System.out.println("studentsLessonsStatisticPage conceptId="+conceptId+" courseId="+courseId+
" studentId="+studentId); 
      out.write('\r');
      out.write('\n');
int studId=(new Integer(studentId)).intValue(); 
      out.write("\r\n");
      out.write("\r\n");
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
Vector passedConcepts=studentStatisticBeanId.getPassedConceptsForStudent(courseId,studId); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
int numOfPassedConcepts=passedConcepts.size(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("<DIV id=masthead>\r\n");
      out.write("<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n");
      out.write("<a href=\"#\">Statistic</a> |\r\n");
      out.write("<a href=\"#\">Tools</a> |\r\n");
      out.write("<a href=\"#\">Help</a>\r\n");
      out.write("</DIV><!--globalNav-->\r\n");
      out.write("</DIV><!--mastHead-->\r\n");
      out.write("  <div id=\"navBar\" class=\"column\">\r\n");
      out.write("  <div id=\"blank\">\r\n");
      out.write("    <p>&nbsp;</p>\r\n");
      out.write("    <p>&nbsp;</p>\r\n");
      out.write("    <p>&nbsp;</p>\r\n");
      out.write("  </div> <!--blank-->\r\n");
      out.write("  <div id=\"search\">\r\n");
      out.write("    <label>Links</label>\r\n");
      out.write("  </div><!--search-->\r\n");
      out.write("  <div id=\"sectionLinks\">\r\n");
      out.write("  <a href=\"conceptStatisticPage.jsp\" >Concept's statistics </a><br />\r\n");
      out.write("  <a href=\"concepts_chart.jsp\" >Concept's statistic charts </a><br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("  </div><!--sectionLinks-->\r\n");
      out.write("  <div id=\"search\">\r\n");
      out.write("    <br/>\r\n");
      out.write("    <br/>\r\n");
      out.write("    <label>Passed concepts</label>\r\n");
      out.write("  </div> <!--search-->\r\n");
      out.write(" <div id=\"sectionLinks\">\r\n");
      out.write("    ");


  double passConcDegree;
  String rating;



      out.write('\r');
      out.write('\n');
for (int i = 0; i < numOfPassedConcepts; i++) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");

  String cId=passedConcepts.get(i).toString();
  passConcDegree = studentStatisticBeanId.getStudentPassedConceptDegreeOfMast(courseId,studId,cId);
  rating = studentStatisticBeanId.getPassedConceptRating(passConcDegree);
  
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <a href=\"studentsLessonsStatisticPage.jsp?conceptId=");
      out.print(cId);
      out.write("&courseId=");
      out.print(courseId);
      out.write("&studentId=");
      out.print(studId);
      out.write("\" >\r\n");
      out.write("    ");
      out.print(studentStatisticBeanId.getConceptNameById(courseId,cId));
      out.write("</a><br />\r\n");
      out.write("    <img alt=\"\" src=\"images/");
      out.print(rating);
      out.write("\"/><br />\r\n");
      out.write("     ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </div><!--sectionLinks-->\r\n");
      out.write("  <div id=\"advert\">\r\n");
      out.write("    <p>&nbsp;</p>\r\n");
      out.write("  </div><!--adverts-->\r\n");
      out.write("  <div id=\"headlines\">\r\n");
      out.write("  </div><!--headlines-->\r\n");
      out.write("</div><!--navBar-->\r\n");
      out.write("<div id=\"content\" class=\"column\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <br/>\r\n");
      out.write("  <br/>\r\n");
      out.write("  <h1 id=\"pageName\">Concept statistic page </h1>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"story\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <h2 style=\"margin:0\">");
      out.print(studentStatisticBeanId.getConceptNameById(courseId,conceptId));
      out.write("</h2>\r\n");
      out.write("      <p style=\"margin:0\">&nbsp;</p>      <p style=\"margin:0\">&nbsp;</p>\r\n");
      out.write("\t  <table width=\"576\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td colspan=\"3\" bordercolor=\"#FFFFFF\"><div align=\"center\">\r\n");
      out.write("            <p class=\"style3\"> </p>\r\n");
      out.write("          </div></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
 degreeOfMastery=studentStatisticBeanId.getStudentPassedConceptDegreeOfMast(courseId,studId,conceptId);
      out.write("\r\n");
      out.write("          <td width=\"146\" bordercolor=\"#FFFFFF\">Feedback message: </td>\r\n");
      out.write("          ");
 if (degreeOfMastery<1.5){
      out.write("\r\n");
      out.write("          ");
  slider="slider_1.jpg";
      out.write("\r\n");
      out.write("           ");
 markText="Bad";
      out.write("\r\n");
      out.write("          ");
 }else if(degreeOfMastery<2.5){
      out.write("\r\n");
      out.write("            ");
 slider="slider_2.jpg";
      out.write("\r\n");
      out.write("            ");
 markText="Not bad";
      out.write("\r\n");
      out.write("          ");
 }else if (degreeOfMastery<3.5){
      out.write("\r\n");
      out.write("            ");
 slider="slider_3.jpg";
      out.write("\r\n");
      out.write("            ");
markText="Good";
      out.write("\r\n");
      out.write("          ");
 }else if (degreeOfMastery<4.5){
      out.write("\r\n");
      out.write("            ");
 slider="slider_4.jpg";
      out.write("\r\n");
      out.write("            ");
 markText="Very good";
      out.write("\r\n");
      out.write("          ");
 }else {
      out.write("\r\n");
      out.write("            ");
 slider="slider_5.jpg";
      out.write("\r\n");
      out.write("            ");
 markText="Excellent";}
      out.write("\r\n");
      out.write("\r\n");
      out.write("          <td colspan=\"2\">");
      out.print(markText);
      out.write(" </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bordercolor=\"#FFFFFF\">Duration: </td>\r\n");
      out.write("          <td colspan=\"2\"><strong>");
      out.print(studentStatisticBeanId.getHours());
      out.write("&nbsp;hr&nbsp;");
      out.print(studentStatisticBeanId.getMins());
      out.write("&nbsp;min&nbsp;");
      out.print(studentStatisticBeanId.getSecs());
      out.write("&nbsp;sec &nbsp; </strong> </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bordercolor=\"#FFFFFF\">Degree of mastery: </td>\r\n");
      out.write("\r\n");
      out.write("          ");
 slider2=studentStatisticBeanId.getSlider2Val(degreeOfMastery); 
      out.write("\r\n");
      out.write("          ");
 actualSkillLevelText=studentStatisticBeanId.getActualSkillLevelText(degreeOfMastery); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("          <td width=\"200\"><img src=\"images/");
      out.print(slider);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n");
      out.write("          <td width=\"202\"><strong>");
      out.print(markText);
      out.write("</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bordercolor=\"#FFFFFF\">Actual knowledge level: </td>\r\n");
      out.write("          <td width=\"140\"><img src=\"images/");
      out.print(slider2);
      out.write("\" width=\"141\" height=\"14\"> </td>\r\n");
      out.write("          <td colspan=\"2\"><strong>");
      out.print(actualSkillLevelText);
      out.write("</strong></td>\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bordercolor=\"#FFFFFF\">&nbsp;</td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>      <p style=\"margin:0\">&nbsp; </p>\r\n");
      out.write("      <p style=\"margin:0\">&nbsp;</p>\r\n");
      out.write("      <p style=\"margin:0; font-weight: bold;\">Passed lessons:</p>\r\n");
      out.write("      ");
Vector passedLessonsInConcept=studentStatisticBeanId.getPassedLessonsInConceptForStudent(courseId,studId,conceptId); 
      out.write("\r\n");
      out.write("       ");
numOfLessons=passedLessonsInConcept.size();
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <p style=\"margin:0; font-weight: bold;\">&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <table width=\"89%\" height=\"0%\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("      ");
 for (int k=0;k<numOfLessons;k++){
      out.write('\r');
      out.write('\n');
String lessonId=passedLessonsInConcept.get(k).toString(); 
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("         <td height=\"23%\" width=\"8%\"><div align=\"center\">");
      out.print((k+1));
      out.write(".</div> </td>\r\n");
      out.write("         ");
numOfPass=studentStatisticBeanId.getLessonNumberOfPassess(courseId,studId,conceptId,lessonId);
      out.write("\r\n");
      out.write("          <td>");
      out.print(studentStatisticBeanId.getLessonNameById(conceptId,lessonId));
      out.write("\r\n");
      out.write("          ");
if (numOfPass>1){ 
      out.write("\r\n");
      out.write("          <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value shows if lesson has been passed more than once.', CAPTION, 'Number of passess', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(");
      out.print(numOfPass);
      out.write(")</a>\r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("         ");
}
      out.write("\r\n");
      out.write("      </table>\r\n");
      out.write("      ");
Vector passedTests=studentStatisticBeanId.getPassedTestsInConceptForStudent(courseId,studId,conceptId); 
      out.write("\r\n");
      out.write("       ");
numOfTests=passedTests.size();
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("        ");
 for (int i=0;i<numOfTests;i++){
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <p style=\"margin:0; font-weight: bold;\">&nbsp;</p>\r\n");
      out.write("      <p><strong>Test ");
      out.print((i+1));
      out.write(":</strong></p>\r\n");
      out.write("      ");
String testId=passedTests.get(i).toString(); 
      out.write("\r\n");
      out.write("        ");
 Vector questions=studentStatisticBeanId.getQuestionsInTest(courseId,studId,conceptId,testId);
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <table width=\"89%\" height=\"0%\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th width=\"7%\" height=\"26%\"><div align=\"center\"></div></th>\r\n");
      out.write("          <th width=\"61%\"><div align=\"left\" class=\"style3\">\r\n");
      out.write("            <font size=\"1\">\r\n");
      out.write("            <div align=\"left\">Question</div>\r\n");
      out.write("            </font>\r\n");
      out.write("          </div></th>\r\n");
      out.write("          <th width=\"32%\"><div align=\"left\" class=\"style3\">\r\n");
      out.write("            <font size=\"1\">\r\n");
      out.write("            <div align=\"center\">Your answer was: </div>\r\n");
      out.write("            </font>\r\n");
      out.write("          </div></th>\r\n");
      out.write("        </tr>\r\n");
      out.write("         ");
 for (int q=0; q<numOfQuest; q++){
      out.write("\r\n");
      out.write("        ");
      out.write('\r');
      out.write('\n');
String qid=questions.get(q).toString(); 
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"23%\"><div align=\"center\"> ");
      out.print((q+1));
      out.write(".</div></td>\r\n");
      out.write("          <td>");
      out.print(studentStatisticBeanId.getQuestContent(courseId,qid));
      out.write("  </td>\r\n");
      out.write("          <td><div align=\"center\"><span class=\"style7\"><font color=\"#006633\">");
      out.print(studentStatisticBeanId.getQuestionTruth(courseId,studId,conceptId,testId,qid));
      out.write("</font></span></div></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"24\">&nbsp;</td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td class=\"style7\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      <span class=\"style8\"> </span>\r\n");
      out.write("\r\n");
 testDegreeOfMastery=studentStatisticBeanId.getTestDegreeOfMastery(courseId,studId,conceptId,testId);
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
 if (testDegreeOfMastery<1.5){
      out.write("\r\n");
      out.write("          ");
  slider3="slider_1.jpg";
      out.write("\r\n");
      out.write("           ");
 testDegreeOfMarkText="Bad";
      out.write("\r\n");
      out.write("          ");
 }else if(testDegreeOfMastery<2.5){
      out.write("\r\n");
      out.write("            ");
 slider3="slider_2.jpg";
      out.write("\r\n");
      out.write("            ");
 testDegreeOfMarkText="Not bad";
      out.write("\r\n");
      out.write("          ");
 }else if (testDegreeOfMastery<3.5){
      out.write("\r\n");
      out.write("            ");
 slider3="slider_3.jpg";
      out.write("\r\n");
      out.write("            ");
testDegreeOfMarkText="Good";
      out.write("\r\n");
      out.write("          ");
 }else if (testDegreeOfMastery<4.5){
      out.write("\r\n");
      out.write("            ");
 slider3="slider_4.jpg";
      out.write("\r\n");
      out.write("            ");
 testDegreeOfMarkText="Very good";
      out.write("\r\n");
      out.write("          ");
 }else if (testDegreeOfMastery<5.0){
      out.write("\r\n");
      out.write("            ");
 slider3="slider_4.jpg";
      out.write("\r\n");
      out.write("            ");
 testDegreeOfMarkText="Excellent";
      out.write("\r\n");
      out.write("            ");
 }else {
      out.write("\r\n");
      out.write("            ");
 slider3="slider_5.jpg";
      out.write("\r\n");
      out.write("            ");
 testDegreeOfMarkText="Expert";}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <table width=\"578\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">Test degree of mastery: </td>\r\n");
      out.write("\r\n");
      out.write("          <td width=\"47\"><strong>");
      out.print(testDegreeOfMarkText);
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\"><img src=\"images/");
      out.print(slider3);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">Your knowledge level on this test: </td>\r\n");
      out.write("          <td width=\"47\" ><strong>");
      out.print(testDegreeOfMastery );
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\">\r\n");
      out.write("            <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Student knowledge level', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-6)</a></strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">You have finish this test with: </td>\r\n");
      out.write("          <td width=\"47\" ><strong>");
      out.print(studentStatisticBeanId.getTestPointsNumber(courseId,studId,conceptId,testId) );
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\">points. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Number of points', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">Maximum number of points on this test is: </td>\r\n");
      out.write("          <td width=\"47\" ><strong>");
      out.print(studentStatisticBeanId.getTestDifficultyFactor(courseId,studId,conceptId,testId) );
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\">points. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value depends on the difficulty of each question in the test', CAPTION, 'Maximum number of points', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">Your success on this test is: </td>\r\n");
      out.write("          <td width=\"47\" ><strong>");
      out.print(studentStatisticBeanId.getTestSuccess(courseId,studId,conceptId,testId) );
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\">%. <a class=\"tiny\" href=\"#\" onMouseOver=\"return overlib('This value shows your success on the test based on the number of solved questions', CAPTION, 'Test success', HAUTO, TIMEOUT, 10000);\" onMouseOut=\"return nd();\">(0-100)</a></strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"165\" scope=\"row\"><p align=\"left\">Test solving duration: </p></td>\r\n");
      out.write("          <td width=\"47\" ><strong>");
      out.print(studentStatisticBeanId.getTestDuration(courseId,studId,conceptId,testId));
      out.write("</strong></td>\r\n");
      out.write("          <td width=\"218\">seconds.</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td scope=\"row\">&nbsp;</td>\r\n");
      out.write("          <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("\t  ");
}
      out.write("\r\n");
      out.write("<p style=\"margin:0\">&nbsp;</p>      <blockquote>\r\n");
      out.write("         <p align=\"center\"><a href=\"conceptStatisticPage.jsp\" class=\"style3\">Back</a>\r\n");
      out.write("           &nbsp;&nbsp;&nbsp;<a href=\"\" class=\"style3\" onclick=\"window.close();\">Close</a></p>\r\n");
      out.write("      </blockquote>\r\n");
      out.write("              <p>&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <p>&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("  </div><!--story-->\r\n");
      out.write("</div><!--content-->\r\n");
      out.write("<!--end content -->\r\n");
      out.write("\r\n");
      out.write("<!--end navbar -->\r\n");
      out.write("<div id=\"siteInfo\" align=\"center\">\r\n");
      out.write("  <a href=\"#\">About Us</a>\r\n");
      out.write("  |\r\n");
      out.write("  <a href=\"#\">Site Map</a>\r\n");
      out.write("  |\r\n");
      out.write("  <a href=\"#\">Privacy Policy</a>\r\n");
      out.write("  |\r\n");
      out.write("  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n");
      out.write("  <br/>\r\n");
      out.write("  <span class=\"copyrightStyle\">    &copy;\r\n");
      out.write("    2006 FON - School of Business Administration, University of Belgrade\r\n");
      out.write("</span>\r\n");
      out.write("</div><!-siteInfo-->\r\n");
      out.write("<br/>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
