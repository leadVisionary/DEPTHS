package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class settingNewAssistantPerformances_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      depths.presentationModule.teacher.TeacherBean teacherBeanId = null;
      synchronized (session) {
        teacherBeanId = (depths.presentationModule.teacher.TeacherBean) _jspx_page_context.getAttribute("teacherBeanId", PageContext.SESSION_SCOPE);
        if (teacherBeanId == null){
          teacherBeanId = new depths.presentationModule.teacher.TeacherBean();
          _jspx_page_context.setAttribute("teacherBeanId", teacherBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n");
if (request.getParameter("Submit")!=null){

String assistantUserName=request.getParameter("assistantUserName");

int assistantId=assistantUserName.hashCode();




if (request.getParameterValues("privilegie")!=null){
  String[] privilegiesIds=request.getParameterValues("privilegie");
  int privilegiesNumb=privilegiesIds.length;
  for (int i=0;i<privilegiesNumb;i++){

    Integer pId=new Integer(privilegiesIds[i]);
    int privilegieId=pId.intValue();
    teacherBeanId.setAssistantPrivilegie(assistantId,privilegieId);
  }
}

if (request.getParameterValues("selectedGroups")!=null){
  String[] groups=request.getParameterValues("selectedGroups");
  int selectedGroupsNumb=groups.length;
  for (int i=0;i<selectedGroupsNumb;i++){

    Integer grId=new Integer(groups[i]);
    int groupId=grId.intValue();
    teacherBeanId.setAssistantGroup(assistantId,groupId);
  }
}


      out.write('\r');
      out.write('\n');
response.sendRedirect("newAssistantCreatedWelcomeScreen.jsp?assistantId="+assistantId); 
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
