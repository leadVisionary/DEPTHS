package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settingUserData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      depths.presentationModule.RegistrationBean registrationBeanId = null;
      synchronized (session) {
        registrationBeanId = (depths.presentationModule.RegistrationBean) _jspx_page_context.getAttribute("registrationBeanId", PageContext.SESSION_SCOPE);
        if (registrationBeanId == null){
          registrationBeanId = new depths.presentationModule.RegistrationBean();
          _jspx_page_context.setAttribute("registrationBeanId", registrationBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n");
if (!registrationBeanId.getAddedData("firstName")){
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "firstName",
request.getParameter("firstName") );
      out.write("\r\n   ");
}
      out.write("\r\n  ");
if (!registrationBeanId.getAddedData("lastName")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "lastName",
request.getParameter("lastName") );
      out.write("\r\n     ");
}
      out.write('\r');
      out.write('\n');
if (!registrationBeanId.getAddedData("userName")){
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "userName",
request.getParameter("userName") );
      out.write("\r\n  ");
}
      out.write("\r\n  ");
if (!registrationBeanId.getAddedData("email")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "email",
request.getParameter("email") );
      out.write("\r\n     ");
}
      out.write('\r');
      out.write('\n');
if (!registrationBeanId.getAddedData("password")){
      out.write("\r\n    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "password",
request.getParameter("password") );
      out.write("\r\n       ");
}
      out.write("\r\n      ");
if (!registrationBeanId.getAddedData("passwordConfirmation")){
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "passwordConfirmation",
request.getParameter("passwordConfirmation") );
      out.write("\r\n     ");
}
      out.write("\r\n     ");
if (!registrationBeanId.isFormRepeated()){
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "address",
request.getParameter("address") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "city",
request.getParameter("city") );
      out.write("\r\n\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "country",
request.getParameter("selectedCountry"));
      out.write("\r\n\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "organization",
request.getParameter("organization") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "webSite",
request.getParameter("webSite") );
      out.write("\r\n     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "selectedLanguage",
request.getParameter("language") );
      out.write("\r\n           ");
}
      out.write("\r\n\r\n\r\n");
 response.sendRedirect("checkingNewUserData.jsp");
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
