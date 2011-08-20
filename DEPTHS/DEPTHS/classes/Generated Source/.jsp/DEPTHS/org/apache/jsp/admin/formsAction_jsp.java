package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formsAction_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String hasPrivilegies=adminBeanId.getPrivilegies();

//obrajuje stranu za promenu privilegija administratora
//editProfilePage.jsp
  if (request.getParameter("changePrivilegie") != null) {
    String admId=request.getParameter("adminId");
    String newPrivilegie=request.getParameter("privilegie");
    if (hasPrivilegies.equals("Full")){
      adminBeanId.changePrivilegie(admId,newPrivilegie);
      response.sendRedirect("previewAdminsPage.jsp");
    }else{
      response.sendRedirect("previewAdminsPage.jsp");
    }
  }
  //obrajuje stranu za promenu privilegija nastavnika
  //editTeacherProfilePage.jsp
  if (request.getParameter("changeTeacherPrivilegies") != null) {
    if (hasPrivilegies.equals("Full")){

    String teachId=request.getParameter("teacherId");
    Integer tId=new Integer(teachId);

    int teacherId=tId.intValue();

    if (request.getParameterValues("privilegie") != null) {
      String newPrivilegies[]=request.getParameterValues("privilegie");
      int privNumb=newPrivilegies.length;
      adminBeanId.removeAllTeacherPrivilegies(teacherId);
      adminBeanId.getPrivilegiesIds();
      for(int i=0;i<privNumb;i++){
        Integer pi=new Integer(newPrivilegies[i]);
        int privId=pi.intValue();
        adminBeanId.createNewTeacherPrivilegies(teacherId,privId);
      }
    }else{
    adminBeanId.removeAllTeacherPrivilegies(teacherId);
    }
      //adminBeanId.updateTeacherPrivilegie(teacherId,newPrivilegie);
      response.sendRedirect("previewTeachersPage.jsp");
    }else{
      response.sendRedirect("previewTeachersPage.jsp");
    }
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
