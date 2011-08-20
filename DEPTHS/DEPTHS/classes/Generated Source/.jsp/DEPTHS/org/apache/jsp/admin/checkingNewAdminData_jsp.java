package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkingNewAdminData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 private boolean userNameExist=false; 
 private boolean dataIsGood=false; 
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
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
 userNameExist=adminBeanId.checkNewUserName();
      out.write("\r\n\r\n");
 if (userNameExist){
      out.write("\r\n\r\n");
 response.sendRedirect("adminRegistrationForm.jsp");
      out.write("\r\n\r\n");
}else{
      out.write("\r\n\r\n\r\n");
 dataIsGood=adminBeanId.checkNewAdminData();
      out.write("\r\n\r\n");
 if (dataIsGood==true){
      out.write("\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
 response.sendRedirect("choosingAdminPrivilegies.jsp");
      out.write("\r\n\r\n ");
} else{
      out.write("\r\n\r\n\r\n\r\n ");
 response.sendRedirect("optionalRegistrationForm.jsp");
      out.write("\r\n\r\n ");
}
      out.write('\r');
      out.write('\n');
      out.write(' ');
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
