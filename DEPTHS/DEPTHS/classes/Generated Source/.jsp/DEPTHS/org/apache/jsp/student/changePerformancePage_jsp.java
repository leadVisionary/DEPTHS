package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changePerformancePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String detailLevel; 
 String programmLang; 
 String displayForm="GoF"; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
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
      out.write("\r\n\r\n<body>\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
 detailLevel=registrationBeanId.getDetailLevel(); 
      out.write('\r');
      out.write('\n');
 programmLang=registrationBeanId.getProgrammingLanguage(); 
      out.write("\r\n<div id=\"page\">\r\n\r\n\r\n<div id=\"content\" class=\"column\">\r\n\r\n\r\n\r\n\r\n\r\n  <!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Welcome to the DEPTHS learning system </h1>\r\n  <div align=center>\r\n  <h2 style=\"margin:0\">Change your performance:</h2>\r\n   <table width=\"416\" height=\"118\" border=\"1\" bordercolor=\"#FFFFFF\">\r\n          <tr>\r\n            <td width=\"169\" height=\"26\"><div align=\"left\">Detail level: </div></td>\r\n            <td width=\"231\"><select name=\"select\" size=\"1\">\r\n              <option value=\"Low\" ");
 if (detailLevel.equals("Low")){
      out.write("selected ");
}
      out.write(" >Low</option>\r\n              <option value=\"Middle\" ");
 if (detailLevel.equals("Middle")){
      out.write("selected ");
}
      out.write(">Middle</option>\r\n              <option value=\"High\" ");
 if (detailLevel.equals("High")){
      out.write("selected ");
}
      out.write(">High</option>\r\n            </select></td>\r\n          </tr>\r\n          <tr>\r\n            <td height=\"28\"><div align=\"left\">Programming language :</div></td>\r\n            <td><select name=\"select2\" size=\"1\">\r\n              <option value=\"Java\" ");
 if (programmLang.equals("Java")){
      out.write("selected ");
}
      out.write(">Java</option>\r\n              <option value=\"CPP\" ");
 if (programmLang.equals("CPP")){
      out.write("selected ");
}
      out.write(">C++</option>\r\n            </select></td>\r\n          </tr>\r\n          <tr>\r\n            <td height=\"26\"><div align=\"left\">Display form: </div></td>\r\n            <td><select name=\"select3\" size=\"1\">\r\n              <option value=\"GoF\"");
 if (displayForm.equals("GoF")){
      out.write("selected ");
}
      out.write(">GoF form</option>\r\n              <option value=\"CoplienForm\" ");
 if (displayForm.equals("CoplienForm")){
      out.write("selected ");
}
      out.write(">Coplien form</option>\r\n            </select></td>\r\n          </tr>\r\n          <tr>\r\n            <td height=\"26\">&nbsp;</td>\r\n            <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n              <p>              </p>\r\n\r\n              </p>\r\n            <input type=\"submit\" name=\"Submit\" value=\"Submit\" onClick=\"window.close();\"></td>\r\n          </tr>\r\n        </table>\r\n\r\n\r\n\r\n\r\n    <div id=\"bellowForm\">\r\n      <p>&nbsp;</p>\r\n    </div><!--bellowForm-->\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\" >\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n");
      out.write("</body>\r\n\r\n</html>\r\n");
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
