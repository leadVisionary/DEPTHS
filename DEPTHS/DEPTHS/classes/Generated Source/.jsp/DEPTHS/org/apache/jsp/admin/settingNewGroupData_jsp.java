package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import depths.adminModule.DatabaseManager;

public final class settingNewGroupData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");
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
      depths.presentationModule.admin.GroupBean groupBeanId = null;
      synchronized (session) {
        groupBeanId = (depths.presentationModule.admin.GroupBean) _jspx_page_context.getAttribute("groupBeanId", PageContext.SESSION_SCOPE);
        if (groupBeanId == null){
          groupBeanId = new depths.presentationModule.admin.GroupBean();
          _jspx_page_context.setAttribute("groupBeanId", groupBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n");
if (request.getParameter("backButton")!=null){
response.sendRedirect("adminWelcomeScreen.jsp");
}else{
if (adminBeanId.getPrivilegies().equals("Guest")){

}else{
  String groupName=request.getParameter("groupName");
  int groupId=groupName.hashCode();
  DatabaseManager dbManager=adminBeanId.getManagerReference();
  groupBeanId.setDbManagerRef(dbManager);
  if (groupBeanId.groupExists(request.getParameter("groupName"))==false){

    String[] admins;
    String[] teachers;
    String[] courses;
    String langId;
    admins=request.getParameterValues("administrators");
    teachers=request.getParameterValues("teachers");
    courses=request.getParameterValues("courses");
    langId=request.getParameter("language");
    Integer l=new Integer(langId);
    int languageId=l.intValue();
    int adminsNumb=admins.length;
    int teachersNumb=teachers.length;
    int coursesNumb=courses.length;
    String description=request.getParameter("description");
    groupBeanId.setGroupData(groupId,groupName,languageId,description);
    for (int i=0;i<adminsNumb;i++){
      String a=admins[i];
      Integer ai=new Integer(a);
      groupBeanId.setGroupAdministrator(groupId,ai.intValue());

    }
    for (int i=0;i<teachersNumb;i++){
      String t=teachers[i];
      Integer ti=new Integer(t);
      groupBeanId.setGroupTeacher(groupId,ti.intValue());
    }
    for (int i=0;i<coursesNumb;i++){
      String c=courses[i];

      groupBeanId.setGroupCourse(groupId,c);
    }
    
      out.write("\r\n    ");
 response.sendRedirect("newGroupCreatedWelcomeScreen.jsp?groupId="+groupId);
      out.write("\r\n\r\n    ");
}else{
    System.out.println("This username already exists");
  } 
      out.write("\r\n  ");
} 
      out.write("\r\n  ");
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
