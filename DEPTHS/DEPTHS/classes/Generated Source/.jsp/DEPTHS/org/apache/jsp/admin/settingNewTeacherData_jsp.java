package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settingNewTeacherData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String fName, lName, uName, email, passw, passwConf, address, city, country, organisation,webS, lang; 
boolean uNameExist=false,passwOK=false; 
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
if (request.getParameter("backButton")!=null){ 
      out.write('\r');
      out.write('\n');
response.sendRedirect("adminWelcomeScreen.jsp"); 
      out.write('\r');
      out.write('\n');
}else{ 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
fName=request.getParameter("firstName"); 
      out.write('\r');
      out.write('\n');
lName=request.getParameter("lastName"); 
      out.write('\r');
      out.write('\n');
uName=request.getParameter("userName"); 
      out.write('\r');
      out.write('\n');
email=request.getParameter("email"); 
      out.write('\r');
      out.write('\n');
passw=request.getParameter("password"); 
      out.write('\r');
      out.write('\n');
passwConf=request.getParameter("passwordConfirmation"); 
      out.write('\r');
      out.write('\n');
address=request.getParameter("address"); 
      out.write('\r');
      out.write('\n');
city=request.getParameter("city"); 
      out.write('\r');
      out.write('\n');
country=request.getParameter("selectedCountry"); 
      out.write('\r');
      out.write('\n');
organisation=request.getParameter("organization"); 
      out.write('\r');
      out.write('\n');
webS=request.getParameter("webSite"); 
      out.write('\r');
      out.write('\n');
lang=request.getParameter("language"); 
      out.write("\r\n\r\n");
uNameExist=adminBeanId.checkTeacherUserName(uName);
      out.write('\r');
      out.write('\n');
if (!uNameExist){
      out.write("\r\n\r\n");
passwOK=adminBeanId.checkPasswords(passw,passwConf); 
      out.write('\r');
      out.write('\n');
if (passwOK==true){ 
      out.write("\r\n\r\n");
adminBeanId.createNewTeacher(fName,lName,uName,email,passw,address,city,country,organisation,webS,lang);
      out.write('\r');
      out.write('\n');
response.sendRedirect("choosingTeacherPrivilegies.jsp?teacherUserName="+uName); 
      out.write('\r');
      out.write('\n');
}else{ 
      out.write("\r\n\r\n");
} 
      out.write("\r\n\r\n  ");
}else{
      out.write("\r\n\r\n  ");
} 
      out.write('\r');
      out.write('\n');
} 
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
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
