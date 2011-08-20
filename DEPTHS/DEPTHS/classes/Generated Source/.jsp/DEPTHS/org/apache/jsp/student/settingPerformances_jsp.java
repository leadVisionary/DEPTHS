package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settingPerformances_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "knowledgeLevel",
request.getParameter("knowledgeLevelRadioGroup"));
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "detailLevel",
request.getParameter("detailLevelRadioGroup"));
      out.write("\r\n  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("registrationBeanId"), "programmingLanguage",
request.getParameter("programmingLanguageRadioGroup"));
      out.write("\r\n\r\n");
registrationBeanId.sendPerformanceToTutor();
      out.write("\r\n\r\n ");
response.sendRedirect("welcomeScreen.jsp");
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
