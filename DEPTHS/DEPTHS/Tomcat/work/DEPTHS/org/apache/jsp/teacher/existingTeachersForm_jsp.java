package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class existingTeachersForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<!-- DW6 -->\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n");
      out.write("<title>DEPTHS</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("  <!--\r\n");
      out.write("    .copyrightStyle {\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    color: #006699;\r\n");
      out.write("    }\r\n");
      out.write("  -->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<!-- JSP code -->\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
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
      out.write("\r\n");
      out.write("    <a href=\"editTeachersProfilePage.jsp\" >Edit my profile</a>\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </div><!--sectionLinks-->\r\n");
      out.write("  <div id=\"search\">\r\n");
      out.write("    <br/>\r\n");
      out.write("    <br/>\r\n");
      out.write("    <label>Passed concepts</label>\r\n");
      out.write("  </div> <!--search-->\r\n");
      out.write("  <div id=\"sectionLinks\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <a href=\"bla bla\" >bla bla\r\n");
      out.write("    </a><br />\r\n");
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
      out.write("  <div id=\"previousNextLinks\">\r\n");
      out.write("    <div id=\"breadCrumb\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div><!--previousNextLinks-->\r\n");
      out.write("  <br/>\r\n");
      out.write("  <br/>\r\n");
      out.write("  <h1 id=\"pageName\">Welcome to the DEPTHS teacher's page </h1>\r\n");
      out.write("  <div class=\"story\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <h2>Registration form : </h2>\r\n");
      out.write("      <p>Please, enter your username and password in the form bellow:</p>\r\n");
      out.write("      <p>&nbsp;  </p>\r\n");
      out.write("<form method=\"POST\" action=\"checkingTeacher.jsp\">\r\n");
      out.write("\r\n");
      out.write("\t\t<p>username:&nbsp;\r\n");
      out.write("\t    <input type=\"text\" name=\"textField\" size=\"35\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n");
      out.write("\t\t<p>password:&nbsp;\r\n");
      out.write("\t\t  <input name=\"passwordField\" type=\"password\" size=\"35\">\r\n");
      out.write("</p>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t      <input type=\"submit\" value=\"Submit\" name=\"Submit\">\r\n");
      out.write("        </p>\r\n");
      out.write("      </form>\r\n");
      out.write("      <p>&nbsp; </p>\r\n");
      out.write("      <p>&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
