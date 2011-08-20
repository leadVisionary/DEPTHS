package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import depths.teacherModule.DatabaseManager;

public final class studentsConceptsStatisticPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n\r\n<style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n\r\n");
      depths.presentationModule.teacher.StudentsStatisticBean studentStatisticBeanId = null;
      synchronized (session) {
        studentStatisticBeanId = (depths.presentationModule.teacher.StudentsStatisticBean) _jspx_page_context.getAttribute("studentStatisticBeanId", PageContext.SESSION_SCOPE);
        if (studentStatisticBeanId == null){
          studentStatisticBeanId = new depths.presentationModule.teacher.StudentsStatisticBean();
          _jspx_page_context.setAttribute("studentStatisticBeanId", studentStatisticBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.teacher.TeacherBean teacherBeanId = null;
      synchronized (session) {
        teacherBeanId = (depths.presentationModule.teacher.TeacherBean) _jspx_page_context.getAttribute("teacherBeanId", PageContext.SESSION_SCOPE);
        if (teacherBeanId == null){
          teacherBeanId = new depths.presentationModule.teacher.TeacherBean();
          _jspx_page_context.setAttribute("teacherBeanId", teacherBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n\r\n\r\n\r\n");
DatabaseManager dbMan=teacherBeanId.getDatabaseManagerRef();
      out.write('\r');
      out.write('\n');
studentStatisticBeanId.setDbManagerReg(dbMan);
      out.write("\r\n<body>\r\n\r\n");
String courseId; 
      out.write('\r');
      out.write('\n');
 String conceptId=request.getParameter("conceptId");
int teacherId=teacherBeanId.getTeacherId();
Vector teacherCourses=teacherBeanId.getTeacherCoursesIds(teacherId);
if (request.getParameter("courseId")!=null){
courseId  =request.getParameter("courseId");
}else{
  courseId=teacherCourses.get(0).toString();
}

String groupName;

Vector teacherGroups=teacherBeanId.getTeacherGroupsIds(teacherId);
Vector studentsInGroup;

int groupId;
if(request.getParameter("groupName")!=null){
  groupName=request.getParameter("groupName");
  groupId=groupName.hashCode();
  studentsInGroup=teacherBeanId.readAllStudentsInGroup(groupName);
}else{
groupId=(new Integer(teacherGroups.get(0).toString()).intValue());
groupName=teacherBeanId.getGroupNameById(groupId);
studentsInGroup=teacherBeanId.readAllStudentsInGroup(groupName);
}



String studentId;
int studId;

if (request.getParameter("studentId")==null){
studId= (new Integer( studentsInGroup.get(0).toString())).intValue();
}else{
  studentId=request.getParameter("studentId");
studId=(new Integer(studentId)).intValue();
}
      out.write("\r\n\r\n");
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
      out.write("\r\n\r\n");
int numOfPassedConcepts=passedConcepts.size(); 
      out.write("\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  <a href=\"studentsConceptsChart.jsp\" >Concept's statistic charts </a>\r\n  <br />\r\n\t<br />\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n   <div id=\"sectionLinks\">\r\n    ");


  double passConcDegree;
  String rating;



      out.write('\r');
      out.write('\n');
for (int i = 0; i < numOfPassedConcepts; i++) {
      out.write("\r\n\r\n  ");

  String cId =passedConcepts.get(i).toString();
  passConcDegree = studentStatisticBeanId.getStudentPassedConceptDegreeOfMast(courseId,studId,cId);
  rating = studentStatisticBeanId.getPassedConceptRating(passConcDegree);

  
      out.write("\r\n\r\n  <a href=\"studentsLessonsStatisticPage.jsp?conceptId=");
      out.print(cId);
      out.write("&courseId=");
      out.print(courseId);
      out.write("&studentId=");
      out.print(studId);
      out.write("\" >\r\n    ");
      out.print(studentStatisticBeanId.getConceptNameById(courseId,cId));
      out.write("</a><br />\r\n    <img alt=\"\" src=\"images/");
      out.print(rating);
      out.write("\"/><br />\r\n     ");
}
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Concept statistic page </h1>\r\n  <div class=\"story\">\r\n    <h2>Concepts' statistics: </h2>\r\n");
 if (numOfPassedConcepts==0){ 
      out.write("\r\n      There is no passed concepts.\r\n      ");
}else{
      out.write("\r\n      ");
 for (int i=0;i<numOfPassedConcepts;i++){
      out.write("\r\n\r\n        ");
      out.write("\r\n        ");
 String concId=passedConcepts.get(i).toString(); 
      out.write('\r');
      out.write('\n');
      out.write(' ');
 title=studentStatisticBeanId.getConceptNameById(courseId,concId); 
      out.write('\r');
      out.write('\n');
      out.write(' ');
int duration=studentStatisticBeanId.getConceptDuration(courseId,studId,concId); 
      out.write("\r\n        ");
 hours=studentStatisticBeanId.getHours(); 
      out.write("\r\n        ");
 min=studentStatisticBeanId.getMins(); 
      out.write("\r\n        ");
 sec=studentStatisticBeanId.getSecs(); 
      out.write("\r\n\r\n\t\t ");
 degreeOfMastery=studentStatisticBeanId.getStudentPassedConceptDegreeOfMast(courseId,studId,concId); 
      out.write("\r\n                 ");
double actualSkillLevel=studentStatisticBeanId.getStudentPassedConceptActualSkillLevel(courseId,studId,concId); 
      out.write("\r\n        ");
 actualSkillLevelText=studentStatisticBeanId.getActualSkillLevelText(actualSkillLevel); 
      out.write("\r\n        ");
 slider2=studentStatisticBeanId.getSlider2Val(actualSkillLevel); 
      out.write("\r\n\r\n      <table width=\"576\" border=\"1\"  cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n        <tr>\r\n          <td colspan=\"3\" bordercolor=\"#FFFFFF\"><div align=\"center\">\r\n            <p class=\"style3\"><strong>");
      out.print(title );
      out.write("</strong> </p>\r\n          </div></td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"146\" bordercolor=\"#FFFFFF\">Feedback message: </td>\r\n           ");
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
 }else if (degreeOfMastery<5.0){
      out.write("\r\n            ");
 slider="slider_4.jpg";
      out.write("\r\n            ");
 markText="Excellent";
      out.write("\r\n            ");
 }else {
      out.write("\r\n            ");
 slider="slider_5.jpg";
      out.write("\r\n            ");
 markText="Expert";}
      out.write("\r\n          <td colspan=\"2\">");
      out.print( markText );
      out.write(" </td>\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">Duration: </td>\r\n          <td colspan=\"2\"><strong>");
      out.print(hours);
      out.write("&nbsp;hr&nbsp;&nbsp;");
      out.print(min);
      out.write("&nbsp;min&nbsp;&nbsp;");
      out.print(sec);
      out.write("&nbsp;sec&nbsp;&nbsp;</strong></td>\r\n        </tr>\r\n\r\n        <tr>\r\n\r\n          <td bordercolor=\"#FFFFFF\">Degree of mastery: </td>\r\n\r\n          <td width=\"140\"><img src=\"images/");
      out.print(slider);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n\r\n          <td width=\"202\"><strong>");
      out.print( markText );
      out.write("</strong></td>\r\n        </tr>\r\n\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">Actual knowledge level:</td>\r\n           <td width=\"140\"><img src=\"images/");
      out.print(slider2);
      out.write("\" width=\"141\" height=\"14\"></td>\r\n          <td colspan=\"2\"><strong>");
      out.print(actualSkillLevelText);
      out.write("</strong></td>\r\n        </tr>\r\n        <tr>\r\n          <td bordercolor=\"#FFFFFF\">&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"studentsLessonsStatisticPage.jsp?conceptId=");
      out.print(concId);
      out.write("&courseId=");
      out.print(courseId);
      out.write("&studentId=");
      out.print(studId);
      out.write("\">More details >></a></td>\r\n        </tr>\r\n      </table>\r\n\r\n\t <p style=\"margin:0\">&nbsp; </p>\r\n      ");
}
      out.write("\r\n      <p style=\"margin:0\">&nbsp;</p>\r\n      ");
}
      out.write("\r\n      <p style=\"margin:0\">&nbsp;</p>\r\n      <p style=\"margin:0\">&nbsp;</p>      <blockquote>\r\n      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <p align=\"center\"><a href=\"closeThisWindow\" class=\"style3\" onClick=\"window.close();\">Close</a></p>\r\n      </blockquote>\r\n              <p>&nbsp;</p>\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
