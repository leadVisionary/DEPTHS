package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class optionalRegistrationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 boolean firstNameAdded=false, lastNameAdded=false, userNameAdded=false, emailAdded=false, passwordAdded=false, passwordConfirmationAdded=false, passwordsSame=false; 
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
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Welcome to the DEPTHS learning system </h1>\r\n  <div class=\"story\">\r\n\r\n ");
 registrationBeanId.setFormRepeated(true);
      out.write("\r\n\t  ");
      out.write("\r\n\t  ");
firstNameAdded=registrationBeanId.getAddedData("firstName"); 
      out.write("\r\n\t  ");
lastNameAdded=registrationBeanId.getAddedData("lastName"); 
      out.write("\r\n\t  ");
userNameAdded=registrationBeanId.getAddedData("userName"); 
      out.write("\r\n\t  ");
emailAdded=registrationBeanId.getAddedData("email"); 
      out.write("\r\n\t  ");
passwordAdded=registrationBeanId.getAddedData("password"); 
      out.write("\r\n\t  ");
passwordConfirmationAdded=registrationBeanId.getAddedData("passwordConfirmation"); 
      out.write("\r\n\t  ");
passwordsSame=registrationBeanId.getPasswordSame(); 
      out.write("\r\n\r\n\r\n      <TABLE width=500 align=left>\r\n              <FORM name=userRegisterForm method=\"POST\" action=\"settingUserData.jsp\">\r\n              <TBODY>\r\n              <TR>\r\n                <TD class=PageTitle colSpan=2>\r\n                <H2 ><font color=\"#FF0000\">Registration error!</font> </H2></TD>\r\n              </TR>\r\n              <TR>\r\n                <TD>&nbsp;</TD></TR>\r\n              <TR>\r\n                <TD class=text align=left colSpan=2>All fields marked with an\r\n                  <FONT color=red><B><BIG>*</BIG></B></FONT> are required.\r\n</TD></TR>\r\n              <TR>\r\n                <TD colSpan=2>\r\n                  <TABLE cellSpacing=1 cellPadding=2 width=\"95%\" border=0>\r\n                    <TBODY>\r\n\t\t\t\t\t");
 if (firstNameAdded==false){
      out.write("\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left>&nbsp;<FONT\r\n                        color=red>*</FONT>First name</TD>\r\n                      <TD class=text noWrap align=left><INPUT size=50\r\n                        name=firstName></TD></TR>\r\n\t\t\t\t\t\t");
}
      out.write("\r\n\t\t\t\t\t\t");
 if (lastNameAdded==false){
      out.write("\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left>&nbsp;<FONT\r\n                        color=red>*</FONT>Last name</TD>\r\n                      <TD class=text noWrap align=left><INPUT size=50\r\n                        name=lastName></TD></TR>\r\n\t\t");
}
      out.write("\r\n\t\t");
 if (userNameAdded==false){
      out.write("\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left><FONT\r\n                        color=red> &nbsp;*</FONT>Username</TD>\r\n                      <TD class=text noWrap align=left><INPUT size=50\r\n                        name=userName></TD>\r\n                    </TR>\r\n\t\t");
}
      out.write("\r\n\t\t");
 if (emailAdded==false){
      out.write("\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left><FONT\r\n                        color=red>*</FONT>&nbsp;Email address</TD>\r\n                      <TD class=text noWrap align=left> <INPUT size=50 name=email>\r\n                    </TD></TR>\r\n\t\t");
}
      out.write("\r\n\t\t");
 if (passwordsSame==false){
      out.write("\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left>&nbsp;<FONT\r\n                        color=red>*</FONT>Your Password:</TD>\r\n                      <TD class=text noWrap align=left><INPUT type=password\r\n                        size=30 name=password></TD></TR>\r\n                    <TR bgColor=#f0f0f0>\r\n                      <TD class=text noWrap align=left>&nbsp;<FONT\r\n                        color=red>*</FONT>Repeat password</TD>\r\n                      <TD class=text noWrap align=left><INPUT type=password\r\n                        size=30 name=passwordConfirmation></TD></TR></TBODY></TABLE></TD>\r\n              <TR>\r\n\t\t\t  ");
}
      out.write("\r\n                <TD align=center colSpan=2><INPUT type=submit value=Submit>\r\n              </TD></TR></FORM></TBODY></TABLE>\r\n\r\n\r\n\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
