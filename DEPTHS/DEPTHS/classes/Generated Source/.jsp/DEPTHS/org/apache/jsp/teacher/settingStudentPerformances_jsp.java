package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.Vector;

public final class settingStudentPerformances_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n\r\n\r\n\r\n");
String studId=request.getParameter("studentId"); 
      out.write("\r\n\r\n");
Integer stId=new Integer(studId); 
      out.write('\r');
      out.write('\n');
int studentId=stId.intValue(); 
      out.write('\r');
      out.write('\n');
String knowLevel=request.getParameter("knowledgeLevelRadioGroup"); 
      out.write('\r');
      out.write('\n');
String detailLevel=request.getParameter("detailLevelRadioGroup"); 
      out.write('\r');
      out.write('\n');
String programmingLanguage=request.getParameter("programmingLanguageRadioGroup"); 
      out.write('\r');
      out.write('\n');
String displayForm=request.getParameter("formRadioGroup"); 
      out.write('\r');
      out.write('\n');
String grId=request.getParameter("selectedGroup"); 
      out.write('\r');
      out.write('\n');
Integer gId=new Integer(grId); 
      out.write('\r');
      out.write('\n');
int groupId=gId.intValue(); 
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
teacherBeanId.settingStudentPerformances(studentId,knowLevel,detailLevel,programmingLanguage,displayForm); 
      out.write("\r\n\r\n");
teacherBeanId.settingStudentGroup(studentId,groupId); 
      out.write('\r');
      out.write('\n');
Date date=new Date(); 
      out.write("\r\n\r\n");
Vector groupCoursesIds=teacherBeanId.getCoursesForGroup(groupId); 
      out.write('\r');
      out.write('\n');
int coursesNumb=groupCoursesIds.size();

for (int i=0;i<coursesNumb;i++){
  String courseId=groupCoursesIds.get(i).toString();
  teacherBeanId.setCourseData(studentId,courseId,date,groupId);

}


      out.write('\r');
      out.write('\n');
      out.write(' ');
response.sendRedirect("newStudentCreatedWelcomeScreen.jsp?studentId="+studentId);
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
