package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;

public final class groupProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String grId;
int groupId; 
String hasPrivilegies; 
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
      depths.presentationModule.admin.AdminBean adminBeanId = null;
      synchronized (session) {
        adminBeanId = (depths.presentationModule.admin.AdminBean) _jspx_page_context.getAttribute("adminBeanId", PageContext.SESSION_SCOPE);
        if (adminBeanId == null){
          adminBeanId = new depths.presentationModule.admin.AdminBean();
          _jspx_page_context.setAttribute("adminBeanId", adminBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.admin.GroupBean groupBeanId = null;
      synchronized (session) {
        groupBeanId = (depths.presentationModule.admin.GroupBean) _jspx_page_context.getAttribute("groupBeanId", PageContext.SESSION_SCOPE);
        if (groupBeanId == null){
          groupBeanId = new depths.presentationModule.admin.GroupBean();
          _jspx_page_context.setAttribute("groupBeanId", groupBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
grId = request.getParameter("groupId");
      out.write('\r');
      out.write('\n');
Integer x=new Integer(grId); 
      out.write('\r');
      out.write('\n');
groupId=x.intValue(); 
      out.write('\r');
      out.write('\n');
hasPrivilegies=adminBeanId.getPrivilegies(); 
      out.write("\r\n\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n     <a href=\"editMyProfilePage.jsp\" >Edit my profile</a>\r\n\r\n\t<br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n\r\n\r\n\r\n  <a href=\"bla bla\" >bla bla\r\n    </a><br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n\r\n    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n\r\n  <div class=\"story\">\r\n<h1 style=\"margin:0\">Teacher's account information </h1>\r\n      <p style=\"margin:0\">&nbsp;</p>\r\n      ");
if (hasPrivilegies.equals("Guest")) {        
      out.write("\r\n      You are running in a guest mode.<br/>\r\n      No change will take effect in this mode.<br/>\r\n     ");
} 
      out.write("\r\n\r\n      <p>&nbsp;</p>\r\n      <table width=\"625\" height=\"357\" border=\"0\">\r\n        <tr>\r\n          <td colspan=\"4\"><span class=\"style8\">Group information:</span> </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"161\">&nbsp;</td>\r\n          <td ><div align=\"right\"><strong>Group name:</strong></div></td>\r\n\r\n          <td colspan=\"2\">&nbsp;");
      out.print(groupBeanId.getNewGroupDataByType("groupName",groupId) );
      out.write("</td>\r\n\r\n        </tr>\r\n\r\n        <tr>\r\n          <td>&nbsp;</td>\r\n          <td><div align=\"right\"><strong>Description:</strong></div></td>\r\n          <td colspan=\"2\">&nbsp;");
      out.print(groupBeanId.getNewGroupDataByType("description",groupId) );
      out.write("</td>\r\n        </tr>\r\n        <tr>\r\n          <td>&nbsp;</td>\r\n          <td><div align=\"right\"><strong>Language:</strong></div></td>\r\n          <td colspan=\"2\">&nbsp;");
      out.print(groupBeanId.getNewGroupLanguage(groupId) );
      out.write("</td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"4\"><hr></td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"4\"><span class=\"style8\">Administrators/Teachers information:</span> </td>\r\n        </tr>\r\n        ");
Vector administratorsIds=groupBeanId.getNewGroupVectorData("administrators",groupId); 
      out.write("\r\n                ");
int adminNumb=administratorsIds.size(); 
      out.write("\r\n\r\n        <tr>\r\n          <td rowspan=\"");
      out.print(adminNumb+1);
      out.write("\">&nbsp;</td>\r\n          <td rowspan=\"");
      out.print(adminNumb+1);
      out.write("\"><div align=\"right\"><strong>Administrators: </strong></div></td>\r\n\r\n\r\n          ");
for (int i=0;i<adminNumb;i++){ 
      out.write("\r\n            ");
String admId=administratorsIds.get(i).toString(); 
      out.write("\r\n             <tr>\r\n               <td colspan=\"");
      out.print(adminNumb+1);
      out.write("\">\r\n              &nbsp;");
      out.print(adminBeanId.getAdminDataById("firstName",admId) );
      out.write("\r\n              &nbsp;");
      out.print(adminBeanId.getAdminDataById("lastName",admId) );
      out.write("<br/>\r\n              </td>\r\n             </tr>\r\n            ");
} 
      out.write("\r\n\r\n\r\n        </tr>\r\n        ");
Vector teachersIds=groupBeanId.getNewGroupVectorData("teachers",groupId); 
      out.write("\r\n                ");
int teachersNumb=teachersIds.size(); 
      out.write("\r\n        <p>&nbsp;</p>\r\n        <tr>\r\n          <td rowspan=\"");
      out.print(teachersNumb+1);
      out.write("\">&nbsp;</td>\r\n          <td rowspan=\"");
      out.print(teachersNumb+1);
      out.write("\"><div align=\"right\"><strong>Group teachers: </strong></div></td>\r\n          ");
for (int i=0;i<teachersNumb;i++){ 
      out.write("\r\n                  ");
String teachId=teachersIds.get(i).toString(); 
      out.write("\r\n                  <tr>\r\n          <td colspan=\"");
      out.print(teachersNumb+1);
      out.write("\">&nbsp;");
      out.print(adminBeanId.getTeacherDataByTeacherId("firstName",teachId) );
      out.write("\r\n          &nbsp;");
      out.print(adminBeanId.getTeacherDataByTeacherId("lastName",teachId) );
      out.write("<br/>\r\n        </td>\r\n        </tr>\r\n        ");
} 
      out.write("\r\n        </tr>\r\n\r\n        <tr>\r\n          <td colspan=\"4\"><hr></td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"4\"><span class=\"style8\">Courses information: </span></td>\r\n        </tr>\r\n");
Vector coursesIds=groupBeanId.getNewGroupVectorData("courses",groupId); 
      out.write("\r\n                ");
int coursesNumb=coursesIds.size(); 
      out.write("\r\n\r\n        <tr>\r\n          <td rowspan=\"");
      out.print(coursesNumb+1);
      out.write("\">&nbsp;</td>\r\n          <td rowspan=\"");
      out.print(coursesNumb+1);
      out.write("\"><div align=\"right\"><strong>Courses: </strong></div></td>\r\n\r\n\r\n          ");
for (int i=0;i<coursesNumb;i++){ 
      out.write("\r\n            ");
String courseId=coursesIds.get(i).toString(); 
      out.write("\r\n             <tr>\r\n               <td colspan=\"");
      out.print(coursesNumb+1);
      out.write("\">\r\n              &nbsp;");
      out.print(adminBeanId.getCourseName(courseId) );
      out.write("\r\n              <br/>\r\n              </td>\r\n             </tr>\r\n            ");
} 
      out.write("\r\n\r\n\r\n        </tr>\r\n\r\n\r\n                  <tr>\r\n                    <td>&nbsp;</td>\r\n                    <td>&nbsp;</td>\r\n                    <td colspan=\"2\">&nbsp;</td>\r\n                    <td width=\"88\"><a href=\"editGroupProfilePage.jsp?groupId=");
      out.print(groupId);
      out.write("\">Edit</a></td>\r\n\r\n                  </tr>\r\n\r\n        <tr>\r\n          <td height=\"25\">&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n          <td colspan=\"2\">&nbsp;</td>\r\n        </tr>\r\n        <tr>\r\n      <td align=center colSpan=4>\r\n        <form action=\"buttonsAction.jsp\" method=\"get\" >\r\n\r\n          <input type=\"submit\" name=\"previewGroupsButton\" value=\"Back\" >\r\n        <input type=\"submit\" name=\"adminWelcomeButton\" value=\"Main menu\">\r\n\t  </form>\r\n\r\n      </td>\r\n      </tr>\r\n      </table>\r\n\r\n\t  <p>&nbsp;</p>\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
