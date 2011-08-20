package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import depths.teacherModule.DatabaseManager;

public final class compareGroupsStatisticPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n");
      out.write('\r');
      out.write('\n');
// page import = "PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n");
      depths.presentationModule.teacher.charts.CompareGroupHitChart compareGroupHitChart = null;
      synchronized (session) {
        compareGroupHitChart = (depths.presentationModule.teacher.charts.CompareGroupHitChart) _jspx_page_context.getAttribute("compareGroupHitChart", PageContext.SESSION_SCOPE);
        if (compareGroupHitChart == null){
          compareGroupHitChart = new depths.presentationModule.teacher.charts.CompareGroupHitChart();
          _jspx_page_context.setAttribute("compareGroupHitChart", compareGroupHitChart, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
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
      out.write('\r');
      out.write('\n');
compareGroupHitChart.sendReference(studentStatisticBeanId); 
      out.write('\r');
      out.write('\n');
DatabaseManager dbMan=teacherBeanId.getDatabaseManagerRef();
      out.write('\r');
      out.write('\n');
studentStatisticBeanId.setDbManagerReg(dbMan);
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

int teacherId=teacherBeanId.getTeacherId();
Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId);
//conceptHitChart.sendReference(conceptChartData);
	String section = request.getParameter("section");
String group = request.getParameter("group");
String compareGroup = request.getParameter("compareGroup");
String course = request.getParameter("course");
String courseId=teacherBeanId.getCourseIdByName(course);
ArrayList courseList = new ArrayList();
Vector coursesIds=teacherBeanId.getTeacherCoursesIds(teacherId);
ArrayList compareGroupList = new ArrayList();

for (int i=0;i<teacherGroupsIds.size();i++){
Integer grId=new Integer(teacherGroupsIds.get(i).toString());
String groupName=teacherBeanId.getGroupNameById(grId.intValue());
compareGroupList.add(groupName);
}
        session=request.getSession();
        if (course==null){
          courseId=coursesIds.get(0).toString();
        }
        if (section == null)
         {section = "Progress";}
         if (group == null)
         {group = "All";}
	 if (compareGroup == null)
         {compareGroup = compareGroupList.get(0).toString();}
        String filename="";
              if (section.equals("Concepts")){
            filename = compareGroupHitChart.generateBarChart(section, session, new PrintWriter(out),courseId,group,compareGroup);
          }else if (section.equals("Progress")){
            filename = compareGroupHitChart.generateXYChart(section, session, new PrintWriter(out),courseId,group,compareGroup);
          }

       // }

	String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;


	ArrayList sectionList = new ArrayList();
	  sectionList.add("Concepts");
        sectionList.add("Progress");//conceptChartDataSet.getSectionList();

ArrayList groupList = new ArrayList();
groupList.add("All");
for (int i=0;i<teacherGroupsIds.size();i++){
Integer grId=new Integer(teacherGroupsIds.get(i).toString());
String groupName=teacherBeanId.getGroupNameById(grId.intValue());
groupList.add(groupName);
}



for (int i=0;i<coursesIds.size();i++){

String courseName=teacherBeanId.getCourseNameById(coursesIds.get(i).toString());
courseList.add(courseName);
}




      out.write("\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n<style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n\r\n\r\n<body>\r\n\r\n\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  <a href=\"previewGroupStatisticPage.jsp\" >Group's statistics </a><br />\r\n");
      out.write("  <a href=\"#\" >Compare groups </a><br />\r\n  <br />\r\n\t<br />\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n   <div id=\"sectionLinks\">\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Group's statistic's chart diagrams\r\n    </h1>\r\n  <div class=\"story\">\r\n\r\n  <div align=\"center\">\r\n\r\n            ");
if (section.equals("Progress")){ 
      out.write("\r\n      </div>\r\n          <h2 align=\"center\">Group's progress throw the course</h2>\r\n          <div align=\"center\">\r\n            ");
}else if(section.equals("Concepts")){ 
      out.write("\r\n          </div>\r\n          <h2 align=\"center\">Degree of mastery for each learned concept</h2>\r\n          <div align=\"center\">\r\n            ");
} 
      out.write("\r\n\r\n\r\n            <br>\r\n\t\t\t  <img src=\"");
      out.print( graphURL );
      out.write("\" width=600 height=400 border=0 usemap=\"#");
      out.print( filename );
      out.write("\" alt=\"\">                </div>\r\n          <p align=\"center\">The chart shown above has tooltips and drilldown enabled.</p>\r\n\r\n\t      <div align=\"center\">\r\n\t        <table style=\"bordercolordark:FFFFFF; bordercolorlight:000000; width:491; cellpadding:20; cellspacing:0; border:1\" class=\"panel\">\r\n\t          <tr>\r\n\r\n\t\t\t  <td width=\"653\">\r\n\t            <table border=0 cellpadding=2 width=93%>\r\n\t              <form method=POST action=\"compareGroupsStatisticPage.jsp\">\r\n\t\t\t\t  <tr valign=top>\r\n\t                  <td width=\"33%\"><div align=\"right\" style=\"padding-right:10px\"><b>Course</b></div></td>\r\n\t\t\t  <td width=\"20%\" >\r\n\t\t\t    <select name=course class=pullDown style=\"width:150px\">\r\n\r\n                                         ");
Iterator courseIter = courseList.listIterator();
				while (courseIter.hasNext()) {
					String optionCourse = (String)courseIter.next();
					if (optionCourse.equals(course)) { 
      out.write("\r\n\t\t\t      <option selected>");
      out.print( optionCourse );
      out.write("</option>\r\n                              ");
} else { 
      out.write("\r\n\t\t\t      <option>");
      out.print( optionCourse );
      out.write("</option>\r\n  ");
					} 
      out.write("\r\n  ");
				} 
      out.write("\r\n </select>\t\t\t</td>\r\n <td width=\"42%\" rowspan=\"4\" style=\"vertical-align:middle\"><input type=image src=\"images/button_refresh.png\" style=\"width:80; height:22\" name=refresh /></td>\r\n\t                <tr valign=top>\r\n\t                  <td><div align=\"right\" style=\"padding-right:10px\"><b>Group</b></div></td>\r\n\t                  <td ><select name=\"group\" class=\"pullDown\" style=\"width:150px\">\r\n                          ");
			Iterator groupIter = groupList.listIterator();
				while (groupIter.hasNext()) {
					String optionGroup = (String)groupIter.next();
					if (optionGroup.equals(group)) { 
      out.write("\r\n                          <option selected=\"selected\">");
      out.print( optionGroup );
      out.write("</option>\r\n                          ");
					} else { 
      out.write("\r\n                          <option>");
      out.print( optionGroup );
      out.write("</option>\r\n                          ");
					} 
      out.write("\r\n                          ");
				} 
      out.write("\r\n                        </select></td>\r\n                    </tr>\r\n\t                <tr valign=top>\r\n\t                  <td width=\"33%\"><div align=\"right\" style=\"padding-right:10px\"><b>Compare group </b></div></td>\r\n\t\t\t  <td width=\"20%\" >\r\n\t\t\t    <select name=compareGroup class=pullDown style=\"width:150px\">\r\n\r\n\r\n\r\n  ");
			Iterator compareGroupIter = compareGroupList.listIterator();
				while (compareGroupIter.hasNext()) {
					String optionCompGroup = (String)compareGroupIter.next();
					if (optionCompGroup.equals(compareGroup)) { 
      out.write("\r\n\t\t\t      <option selected>");
      out.print( optionCompGroup );
      out.write("</option>\r\n  ");
					} else { 
      out.write("\r\n\t\t\t      <option>");
      out.print( optionCompGroup );
      out.write("</option>\r\n  ");
					} 
      out.write("\r\n  ");
				} 
      out.write("\r\n\t\t\t      </select>\t\t\t</td>\r\n\t\t  </tr>\r\n                  <tr valign=top>\r\n\t                  <td><div align=\"right\" style=\"padding-right:10px\"><b>Section</b></div></td>\r\n\t\t\t  <td width=\"20%\">\r\n\t\t\t    <select name=section class=pullDown style=\"width:150px\">\r\n\r\n  ");
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
      out.write("\r\n\t\t\t      </select>\t\t\t</td>\r\n\t\t\t  </tr>\r\n                  </form>\r\n\t\t  </table>\r\n\r\n\t</td>\r\n\r\n\r\n\t\t\t</tr>\r\n            </table>\r\n\r\n\t </div>\r\n\t      <p align=\"center\" style=\"margin:0\">&nbsp; </p>\r\n\r\n\t  <div align=\"center\">\r\n\t  <form name=teacherWelcomeScreen method=\"POST\" action=\"teacherWelcomeScreen.jsp\">\r\n\r\n\t    <input type=\"submit\" name=\"teachersWelcomeButton\" value=\"Main menu\" />\r\n\t  </form>\r\n\t  </div>\r\n\r\n              <p align=\"center\">&nbsp;</p>\r\n\r\n\r\n\r\n             \r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
