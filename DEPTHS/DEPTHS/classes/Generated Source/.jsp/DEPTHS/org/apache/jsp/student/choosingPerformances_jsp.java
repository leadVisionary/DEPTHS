package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class choosingPerformances_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
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
      out.write("\r\n\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Curriculum</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n    <a href=\"bla bla\">bla bla\r\n\r\n    </a>\r\n\r\n\t<br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n\r\n\r\n\r\n  <a href=\"bla bla\" >bla bla\r\n    </a><br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n\r\n    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Welcome to the DEPTHS learning system </h1>\r\n  <div class=\"story\">\r\n\r\n\t  <form name=\"form1\" method=\"post\" action=\"settingPerformances.jsp\">\r\n\t  <table width=\"80%\" align=\"center\">\r\n\t  <tr>\r\n\t    <td colspan=\"4\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\"><strong>Choose your performances and display properties:</strong></td>\r\n\t    </tr>\r\n\t  <tr>\r\n\t    <td colspan=\"2\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;\r\n          <p>Select your knowledge level:          </p>\r\n          <p>\r\n          <label>\r\n          <input type=\"radio\" name=\"knowledgeLevelRadioGroup\" value=\"Begginer\" checked=\"checked\">\r\nBegginer</label>\r\n          <br>\r\n          <label>\r\n          <input type=\"radio\" name=\"knowledgeLevelRadioGroup\" value=\"Intermediate\">\r\nIntermediate</label>\r\n          <br>\r\n");
      out.write("          <label>\r\n<input type=\"radio\" name=\"knowledgeLevelRadioGroup\" value=\"Advanced\">\r\nAdvanced</label>\r\n        <br>\r\n        </p>\r\n        <p>Select your detail level: </p>\r\n        <p>\r\n          <label>\r\n          <input type=\"radio\" name=\"detailLevelRadioGroup\" value=\"Low\" checked=\"checked\">\r\nLow</label>\r\n          <br>\r\n          <label>\r\n          <input type=\"radio\" name=\"detailLevelRadioGroup\" value=\"Middle\">\r\nMiddle</label>\r\n          <br>\r\n          <label>\r\n          <input type=\"radio\" name=\"detailLevelRadioGroup\" value=\"High\">\r\nHigh</label>\r\n          <br>\r\n        </p>\r\n\r\n\r\n\r\n        <p>\r\n\r\n</p>\r\n\r\n\r\n\r\n\r\n\r\n\t\t</td>\r\n\t    <td colspan=\"2\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\"><p>&nbsp;</p>\r\n\t      <p>Select programming language:</p>\t      <p>\r\n          <label>\r\n          <input type=\"radio\" name=\"programmingLanguageRadioGroup\" value=\"Java\" checked=\"checked\">\r\nJava</label>\r\n          <br>\r\n          <label>\r\n          <input type=\"radio\" name=\"programmingLanguageRadioGroup\" value=\"CPP\">\r\n");
      out.write("C++</label>\r\n\t      <p>&nbsp;</p>\r\n\t      <p>Select display form:  </p>\r\n\t      <p>\r\n          <label>\r\n          <input type=\"radio\" name=\"formRadioGroup\" value=\"GoF\" checked=\"checked\">\r\nGoF Form</label>\r\n          <br>\r\n          <label>\r\n          <input type=\"radio\" name=\"formRadioGroup\" value=\"coplienForm\">\r\nCoplien Form</label>\r\n          <p>\r\n          </td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t    <td width=\"39%\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;\r\n\t       </td>\r\n\t    <td width=\"17%\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">\r\n             </td>\r\n\t    <td width=\"44%\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;</td>\r\n\t  </tr><tr>\r\n\t    <td width=\"39%\" style=\"padding-top:4;padding-bottom:4\">&nbsp;\r\n\t       </td>\r\n\t    <td width=\"17%\" style=\"padding-top:4;padding-bottom:4\">\r\n              <input type=\"submit\" name=\"Submit\" value=\"Submit\"></td>\r\n\t    <td width=\"44%\" style=\"padding-top:4;padding-bottom:4\">&nbsp;</td>\r\n\t  </tr>\r\n");
      out.write("\r\n\r\n</table>\r\n</form>\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
