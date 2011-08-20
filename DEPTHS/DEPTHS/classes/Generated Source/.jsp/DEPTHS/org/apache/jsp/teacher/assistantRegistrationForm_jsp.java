package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;

public final class assistantRegistrationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Vector privilegies;
String hasPrivilegies;
int numbOfCountries;                    
int countryId; 
int numbOfLanguages;  
int languageId; 
String languageName; 
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n<style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
      depths.presentationModule.teacher.TeacherBean teacherBeanId = null;
      synchronized (session) {
        teacherBeanId = (depths.presentationModule.teacher.TeacherBean) _jspx_page_context.getAttribute("teacherBeanId", PageContext.SESSION_SCOPE);
        if (teacherBeanId == null){
          teacherBeanId = new depths.presentationModule.teacher.TeacherBean();
          _jspx_page_context.setAttribute("teacherBeanId", teacherBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.admin.AdminBean adminBeanId = null;
      synchronized (session) {
        adminBeanId = (depths.presentationModule.admin.AdminBean) _jspx_page_context.getAttribute("adminBeanId", PageContext.SESSION_SCOPE);
        if (adminBeanId == null){
          adminBeanId = new depths.presentationModule.admin.AdminBean();
          _jspx_page_context.setAttribute("adminBeanId", adminBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
privilegies = teacherBeanId.getTeacherPrivilegies();
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
if (privilegies.isEmpty()){
  hasPrivilegies="guest";
}else{
  hasPrivilegies="Limited";
int privNumb=privilegies.size();
for (int i=0;i<privNumb;i++){
  String priv=privilegies.get(i).toString();

  if (priv.equals("create new teacher")){
    hasPrivilegies="create new teacher";

  }else if ((priv.equals("create new assistant"))&&(!hasPrivilegies.equals("create new teacher"))){
    hasPrivilegies="create new assistant";

  }
}
}
  
      out.write("\r\n\r\n");
if (!hasPrivilegies.equals("Limited")) {
      out.write("\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n     <a href=\"editMyProfilePage.jsp\" >Edit my profile</a>\r\n\r\n\t<br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n\r\n\r\n\r\n  <a href=\"bla bla\" >bla bla\r\n    </a><br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n\r\n    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">Welcome to the DEPTHS learning system </h1>\r\n  <div class=\"story\">\r\n\r\n\r\n      <h2>&nbsp;</h2>\r\n\r\n      <TABLE width=500 align=center>\r\n      <FORM name=userRegisterForm method=\"POST\" action=\"settingNewAssistantData.jsp\">\r\n        <TBODY>\r\n        ");
if (teacherBeanId.isTeacherUserNameExist()) {        
      out.write("\r\n          <TR>\r\n            <TD class=PageTitle colSpan=2>\r\n              <FONT color=red>\r\n                <B>\r\n                  <BIG>You have selected username that is already in use.</BIG>\r\n                </B>\r\n              </FONT>\r\n            </TD>\r\n          </TR>\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>              Please choose another one or go to the existing users page\r\n              <a href=\"existingAdminsForm.jsp\">HERE</a>\r\n            </TD>\r\n          </TR>\r\n        ");
} else {        
      out.write("\r\n\r\n          <TR>\r\n            <TD class=PageTitle colSpan=2>\r\n              <H2>New assistant registration</H2>\r\n            </TD>\r\n          </TR>\r\n        ");
if (hasPrivilegies.equals("Guest")) {        
      out.write("\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>You do not have enough privilegies to create new teacher.</TD>\r\n          </TR>\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>You can only preview this option as a guest.</TD>\r\n          </TR>\r\n        ");
} else {        
      out.write("\r\n          <TR>\r\n            <TD class=text vAlign=top align=left colSpan=2>Please fill form for new assistant.</TD>\r\n          </TR>\r\n        ");
}        
      out.write("\r\n        ");
}        
      out.write("\r\n          <TR>\r\n            <TD>&nbsp;</TD>\r\n          </TR>\r\n          <TR>\r\n            <!--\r\n              <TD class=title align=left colSpan=2>Account information / about\r\n              you</TD>\r\n            -->\r\n          </TR>\r\n          <TR>\r\n            <TD class=text align=left colSpan=2>              All fields marked with an\r\n              <FONT color=red>\r\n                <B>\r\n                  <BIG>*</BIG>\r\n                </B>\r\n              </FONT>\r\n              are required.\r\n</TD>\r\n          </TR>\r\n          <TR>\r\n            <TD colSpan=2>\r\n              <TABLE cellSpacing=1 cellPadding=2 width=\"95%\" border=0>\r\n                <TBODY>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD width=\"30%\" align=left noWrap class=text>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      First name\r\n</TD>\r\n                    <TD width=\"12%\" align=left noWrap class=text>\r\n                      <INPUT size=50 name=firstName>\r\n                    </TD>\r\n");
      out.write("                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Last name\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=50 name=lastName>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>\r\n                      <FONT color=red>                        &nbsp;\r\n                        *\r\n</FONT>\r\n                      Username\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=50 name=userName checked>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>\r\n                      <FONT color=red>                        &nbsp;\r\n                        *\r\n</FONT>\r\n                      Email address\r\n");
      out.write("</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=50 name=email>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Your Password\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT type=password size=30 name=password>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;\r\n                      <FONT color=red>*</FONT>\r\n                      Repeat password\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT type=password size=30 name=passwordConfirmation>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                      Address\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=30 name=address>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      City\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=30 name=city>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;\r\n                      &nbsp;&nbsp;\r\n                      Country of residence\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      ");
adminBeanId.getCountries();                    
      out.write("\r\n                    ");
adminBeanId.getCountriesIds();                    
      out.write("\r\n                    ");
      out.write("\r\n                    ");
      out.write("\r\n                    ");
numbOfCountries = adminBeanId.getNumbOfCountries();
      out.write("\r\n                      <select name=\"selectedCountry\">\r\n                      ");
for (int i = 0; i < numbOfCountries; i++) {
      out.write("\r\n                        ");
countryId=adminBeanId.getCountryId(i); 
      out.write("\r\n                        <OPTION value='");
      out.print(countryId);
      out.write('\'');
      out.write('>');
      out.print(adminBeanId.getCountryName(i) );
      out.write("                        </OPTION>\r\n                      ");
}
      out.write("\r\n                      </select>\r\n\r\n\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      Organization\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=50 name=organization>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n                      Web Site\r\n</TD>\r\n                    <TD align=left noWrap class=text>\r\n                      <INPUT size=60 value=http:// name=webSite>\r\n                    </TD>\r\n                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=title noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n\r\n                      Your language\r\n                      settings\r\n</TD>\r\n                    <TD align=left noWrap class=text>&nbsp;</TD>\r\n");
      out.write("                  </TR>\r\n                  <TR bgColor=#f0f0f0>\r\n                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;\r\n\r\n\r\n              ");
adminBeanId.getLanguages(); 
      out.write("\r\n                    ");
adminBeanId.getLanguagesIds();  
      out.write("\r\n                    ");
      out.write("\r\n                    ");
      out.write("\r\n                    ");
      out.write("\r\n                    ");
numbOfLanguages = adminBeanId.getNumbOfLanguages();
      out.write("\r\n                      <select name=\"language\">\r\n                      ");
for (int i = 0; i < numbOfLanguages; i++) {
      out.write("\r\n                        ");
languageId=adminBeanId.getLanguageId(i); 
      out.write("\r\n                        ");
languageName=adminBeanId.getLanguageName(i);
      out.write("\r\n\r\n                        <OPTION value='");
      out.print(languageId);
      out.write('\'');
      out.write('>');
      out.print(languageName);
      out.write(" </OPTION>\r\n\r\n                      ");
}
      out.write("\r\n                      </select>\r\n\r\n                    </TD>\r\n                    <TD align=left noWrap class=text>&nbsp;</TD>\r\n                  </TR>\r\n</tbody>\r\n              </TABLE>\r\n            </TD>\r\n\r\n          <TR>\r\n            <TD align=center colSpan=2>\r\n              <input type=\"submit\" name=\"backButton\" value=\"Back\">&nbsp;&nbsp;\r\n              <INPUT type=submit value=Submit tabindex=\"0\">\r\n            </TD>\r\n          </TR>\r\n\r\n      </FORM>\r\n                </TBODY>\r\n      </TABLE>\r\n\r\n\r\n\r\n\r\n      <p>&nbsp;</p>\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n");
} else {
      out.write("\r\n\r\n<script type=\"text/javascript\">\r\nvar name = confirm(\"ERROR: You do not have enough privilegies for this !\")\r\nif (name == true)\r\n{\r\nlocation=\"teacherWelcomeScreen.jsp\"\r\n}else{\r\n  history.go(-1);\r\n}\r\n</script>\r\n");
}
      out.write("\r\n</html>\r\n");
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
