package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

int numbOfCountries;                    
int countryId; 
int numbOfLanguages;                    
int languageId; 
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
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Welcome to the DEPTHS learning system </h1>\r\n  <div class=\"story\">\r\n\r\n <TABLE width=500 align=center >\r\n      <FORM name=userRegisterForm method=\"POST\" action=\"settingUserData.jsp\">\r\n        <TBODY>\r\n        ");
if (registrationBeanId.isUserNameExist()) {        
      out.write("\r\n          <TR>\r\n            <TD class=PageTitle colSpan=2>\r\n              <FONT color=red>\r\n                <B>\r\n                  <BIG>You have selected username that is already in use.</BIG>\r\n                </B>\r\n              </FONT>\r\n            </TD>\r\n          </TR>\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>              Please choose another one or go to the existing users page\r\n              <a href=\"existingUsersForm.jsp\">HERE</a>\r\n            </TD>\r\n          </TR>\r\n        ");
} else {        
      out.write("\r\n          <TR>\r\n            <TD class=PageTitle colSpan=2>\r\n              <H2>New student registration</H2>\r\n            </TD>\r\n          </TR>\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>Please register below to use DEPTHS system.</TD>\r\n          </TR>\r\n        ");
}        
      out.write("\r\n          <TR>\r\n            <TD>&nbsp;</TD>\r\n          </TR>\r\n          <TR>\r\n            <!--\r\n              <TD class=title align=left colSpan=2>Account information / about\r\n              you</TD>\r\n            -->\r\n          </TR>\r\n          <TR>\r\n            <TD class=text align=left colSpan=2>              All fields marked with an\r\n              <FONT color=red>\r\n                <B>\r\n                  <BIG>*</BIG>\r\n                </B>\r\n              </FONT>\r\n              are required.\r\n</TD>\r\n          </TR>\r\n          <TR>\r\n            <TD colSpan=2>\r\n              <TABLE cellSpacing=1 cellPadding=2 width=\"95%\" border=0>\r\n                <TBODY>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      First name\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=50 name=firstName>\r\n                    </TD>\r\n                  </TR>\r\n");
      out.write("                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Last name\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=50 name=lastName>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>\r\n                      <FONT color=red>                        &nbsp;\r\n                        *\r\n</FONT>\r\n                      Username\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=50 name=userName checked>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>\r\n                      <FONT color=red>                        &nbsp;\r\n                        *\r\n</FONT>\r\n                      Email address\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n");
      out.write("                      <INPUT size=50 name=email>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Your Password\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT type=password size=30 name=password>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Repeat password\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT type=password size=30 name=passwordConfirmation>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                      Address\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=30 name=address>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      City\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=30 name=city>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;\r\n                      &nbsp;&nbsp;\r\n                      Country of residence\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                    ");
registrationBeanId.getCountries();                    
      out.write("\r\n                    ");
registrationBeanId.getCountriesIds();                    
      out.write("\r\n                    ");
      out.write("\r\n                    ");
      out.write("\r\n                    ");
numbOfCountries = registrationBeanId.getNumbOfCountries();
      out.write("\r\n\r\n                      <select name=selectedCountry>\r\n                      ");
for (int i = 0; i < numbOfCountries; i++) {
      out.write("\r\n                        ");
countryId=registrationBeanId.getCountryId(i); 
      out.write("\r\n                        <OPTION value='");
      out.print(countryId);
      out.write('\'');
      out.write('>');
      out.print(registrationBeanId.getCountryName(i) );
      out.write("                        </OPTION>\r\n                      ");
}
      out.write("\r\n                      </select>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      Organization\r\n</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=50 name=organization>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD align=left noWrap bgcolor=\"#f0f0f0\" class=text>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      Web Site</TD>\r\n                    <TD class=text noWrap align=left>\r\n                      <INPUT size=50 value=http:// name=webSite>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgcolor=\"#f0f0f0\">\r\n                    <TD align=left noWrap class=title>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n\r\n                      Your language\r\n                      settings</TD>\r\n                    <TD align=left noWrap class=text>&nbsp;</TD>\r\n");
      out.write("                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD align=left noWrap class=text>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      ");
registrationBeanId.getLanguages();                    
      out.write("\r\n                    ");
registrationBeanId.getLanguagesIds();                    
      out.write("\r\n                    ");
      out.write("\r\n                    ");
      out.write("\r\n                    ");
numbOfLanguages = registrationBeanId.getNumbOfLanguages();
      out.write("\r\n\r\n                      <select name=language>\r\n                      ");
for (int i = 0; i < numbOfLanguages; i++) {
      out.write("\r\n                        ");
languageId=registrationBeanId.getLanguageId(i); 
      out.write("\r\n                        <OPTION value='");
      out.print(languageId);
      out.write('\'');
      out.write('>');
      out.print(registrationBeanId.getLanguageName(i) );
      out.write("                        </OPTION>\r\n                      ");
}
      out.write("\r\n                      </select>\r\n                    </TD>\r\n                    <TD align=left noWrap class=text>&nbsp;</TD>\r\n                  </TR>\r\n                </TBODY>\r\n              </TABLE>\r\n            </TD>\r\n<tr><td>&nbsp;</td>\r\n</tr>\r\n          <TR>\r\n            <TD align=center colSpan=2>\r\n              <INPUT type=submit value=Submit tabindex=\"0\">\r\n            </TD>\r\n          </TR>\r\n\r\n      </FORM>\r\n</TBODY>      </TABLE>\r\n\r\n\r\n\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
