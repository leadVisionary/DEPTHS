package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

public final class previewStudentsPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Vector privilegies;
String hasPrivilegies;
Vector studentsIds;
int i; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
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
      out.write("\r\n\r\n\r\n\r\n ");
int teacherId=teacherBeanId.getTeacherId(); 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
privilegies = teacherBeanId.getTeacherPrivilegies();
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
if (privilegies.isEmpty()){
  hasPrivilegies="Guest";
}else{
  hasPrivilegies="Limited";
  int privNumb=privilegies.size();
}
      out.write('\r');
      out.write('\n');
String groupSection = request.getParameter("groupSection");

        session=request.getSession();

        if (groupSection == null){
       groupSection="All";
       }
      out.write('\r');
      out.write('\n');
ArrayList groupList = new ArrayList();
      out.write("\r\n\t  ");
groupList.add("All");
      out.write("\r\n          ");
Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId); 
      out.write("\r\n          ");
int groupsNumb=teacherGroupsIds.size();
          for (int g=0;g<groupsNumb;g++){
            String groupId=teacherGroupsIds.get(g).toString();
            int grId=(new Integer(groupId)).intValue();
            String grName=teacherBeanId.getGroupNameById(grId);
            groupList.add(grName);
          }
          
      out.write("\r\n\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n    <a href=\"editMyProfilePage.jsp\" >Edit my profile</a>\r\n\r\n\t<br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n\r\n\r\n\r\n  <a href=\"bla bla\" >bla bla\r\n    </a><br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n\r\n    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n\r\n  <div class=\"story\">\r\n <h1 style=\"margin:0\">Welcome to the DEPTHS teacher's application</h1>\r\n\r\n      <p>&nbsp;</p>\r\n      ");
if (hasPrivilegies.equals("Guest")) {        
      out.write("\r\n      You are running in a guest mode.<br/>\r\n      No change will take effect in this mode.<br/>\r\n     ");
} 
      out.write("\r\n      <table width=\"616\" border=\"2\" bordercolor=\"#FFFFFF\">\r\n        <caption>\r\n          Teacher's menu\r\n          <br>\r\n        </caption>\r\n        <tr>\r\n          <td width=\"144\" height=\"26\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"assistantRegistrationForm.jsp\">Add new assistant </a></td>\r\n          <td width=\"138\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"studentRegistrationForm.jsp\">Add new student </a></td>\r\n          <td width=\"199\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"previewGroupStatisticPage.jsp\">Preview  statistics  </a></td>\r\n          <td width=\"105\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"groupRegistrationForm.jsp\">Edit course  </a></td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"24\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"previewAssistantsPage.jsp\">Preview assistants </a></td>\r\n          <td bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"previewTeachersPage.jsp\">Preview students </a></td>\r\n          <td bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"previewCoursesPage.jsp\">Preview students' performance </a></td>\r\n");
      out.write("          <td bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><a href=\"previewGroupsPage.jsp\">Preview course </a></td>\r\n        </tr>\r\n      </table>\r\n\r\n      <p>&nbsp;</p>\r\n      <table width=\"588\" border=\"0\">\r\n        <tr>\r\n          <td colspan=\"4\"><div align=\"center\"><span class=\"style9\">Students preview </span></div></td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"4\">&nbsp;</td>\r\n        </tr>\r\n        <tr>\r\n           <form name=\"form2\" method=\"post\" action=\"previewStudentsPage.jsp\">\r\n          <td width=\"142\"><div align=\"center\" class=\"style9\"></div></td>\r\n\r\n          <td width=\"142\">Select group: </td>\r\n          <td width=\"135\">\r\n\t\t  <select name=groupSection class=pullDown>\r\n\r\n  ");
			Iterator iter = groupList.listIterator();
				while (iter.hasNext()) {
					String optionGroup = (String)iter.next();
					if (optionGroup.equals(groupSection)) { 
      out.write("\r\n\t\t\t      <option selected>");
      out.print( optionGroup );
      out.write("</option>\r\n  ");
					} else { 
      out.write("\r\n\t\t\t      <option>");
      out.print( optionGroup );
      out.write("</option>\r\n  ");
					} 
      out.write("\r\n  ");
				} 
      out.write("\r\n\t\t\t      </select>\t\t</td>\r\n          <td width=\"151\"><input type=\"submit\" name=\"Refresh\" value=\"Refresh\" /></td>\r\n        </form>\r\n        </tr>\r\n      </table>\r\n      ");
      out.write("\r\n     ");
if (groupSection.equals("All")){ 
      out.write("\r\n     ");
studentsIds=teacherBeanId.readAllStudents(teacherId); 
      out.write("\r\n     ");
}else{ 
      out.write("\r\n     ");
studentsIds=teacherBeanId.readAllStudentsInGroup(groupSection); 
      out.write("\r\n     ");
} 
      out.write("\r\n      ");
int studentsNumb=studentsIds.size(); 
      out.write("\r\n      ");
      out.write("\r\n      ");
for (i=0;i<studentsNumb;i++){
      out.write("\r\n        ");
String sId=studentsIds.get(i).toString(); 
      out.write("\r\n        ");
Integer stId=new Integer(sId); 
      out.write("\r\n        ");
int studentId=stId.intValue(); 
      out.write("\r\n\r\n        <form name=\"form1\" method=\"post\" action=\"getPreviewStudentsPageAction.jsp?studentId=");
      out.print(studentId);
      out.write("\">\r\n\r\n          <table width=\"596\" border=\"2\" bordercolor=\"#CCCCCC\">\r\n\r\n\r\n\r\n            <tr bordercolor=\"#FFFFFF\">\r\n              <td width=\"167\" rowspan=\"4\" bgcolor=\"#FFFFFF\"><table width=\"200\" border=\"0\">\r\n                <tr>\r\n\r\n                  <td><strong>last name: </strong>");
      out.print(teacherBeanId.getStudentDataByType("lastName",studentId) );
      out.write("</td>\r\n                </tr>\r\n                <tr>\r\n                  <td><strong>first name: </strong>");
      out.print(teacherBeanId.getStudentDataByType("firstName",studentId) );
      out.write("</td>\r\n                </tr>\r\n                <tr>\r\n                  <td><strong>user name: </strong>");
      out.print(teacherBeanId.getStudentDataByType("userName",studentId) );
      out.write("</td>\r\n                </tr>\r\n               ");
String gId=teacherBeanId.getStudentDataByType("groupId",studentId); 
      out.write("\r\n               ");
Integer grId=new Integer(gId); 
      out.write("\r\n                ");
int groupId=grId.intValue(); 
      out.write("\r\n\r\n                <tr>\r\n                  <td><strong>group:</strong>");
      out.print(teacherBeanId.getGroupNameById(groupId) );
      out.write("</td>\r\n                </tr>\r\n\r\n\t\t\t\t  <tr>\r\n                    <td><strong>xxx:                  </strong></td>\r\n                  </tr>\r\n\r\n              </table></td>\r\n              <td height=\"22\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n              <td bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n              <td bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n            </tr>\r\n            <tr bordercolor=\"#FF0000\">\r\n              <td height=\"57\" rowspan=\"2\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n              <td bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><p>\r\n                <input name=\"Remove\" type=\"submit\" id=\"  Remove  \" value=\"  Remove  \">\r\n              </p>            </td>\r\n                <td rowspan=\"2\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n            </tr>\r\n              <tr bordercolor=\"#FF0000\">\r\n                <td height=\"22\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">\r\n                  <input type=\"submit\" name=\"Edit\" value=\"Edit profile\"></td>\r\n            </tr>\r\n                <tr bordercolor=\"#FF0000\">\r\n");
      out.write("                  <td width=\"28\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n                  <td width=\"83\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\"><label></label>              <label></label></td>\r\n                  <td width=\"288\" bordercolor=\"#FFFFFF\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n                </tr>\r\n          </table>\r\n              <br/>\r\n\r\n\r\n\r\n      </form>\r\n            ");
} 
      out.write("\r\n\r\n             <p>&nbsp; </p>\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
