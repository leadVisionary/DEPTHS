package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settingNewAdministratorData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n\r\n");
if (!adminBeanId.getAddedData("firstName")){
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newFirstName",
request.getParameter("firstName") );
      out.write("\r\n   ");
}
      out.write("\r\n  ");
if (!adminBeanId.getAddedData("lastName")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newLastName",
request.getParameter("lastName") );
      out.write("\r\n     ");
}
      out.write('\r');
      out.write('\n');
if (!adminBeanId.getAddedData("userName")){
      out.write("\r\n\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newUserName",
request.getParameter("userName") );
      out.write("\r\n  ");
}
      out.write("\r\n  ");
if (!adminBeanId.getAddedData("email")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newEmail",
request.getParameter("email") );
      out.write("\r\n     ");
}
      out.write('\r');
      out.write('\n');
if (!adminBeanId.getAddedData("password")){
      out.write("\r\n    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newPassword",
request.getParameter("password") );
      out.write("\r\n       ");
}
      out.write("\r\n      ");
if (!adminBeanId.getAddedData("passwordConfirmation")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newPasswordConfirmation",
request.getParameter("passwordConfirmation") );
      out.write("\r\n     ");
}
      out.write("\r\n     ");
if (!adminBeanId.isFormRepeated()){
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newAddress",
request.getParameter("address") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newCity",
request.getParameter("city") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newCountry",
request.getParameter("selectedCountry") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newOrganisation",
request.getParameter("organization") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newWebSite",
request.getParameter("webSite") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("adminBeanId"), "newSelectedLanguage",
request.getParameter("language") );
      out.write("\r\n           ");
}
      out.write("\r\n\r\n\r\n");
 response.sendRedirect("checkingNewAdminData.jsp");
      out.write('\r');
      out.write('\n');
} 
      out.write('\r');
      out.write('\n');
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
