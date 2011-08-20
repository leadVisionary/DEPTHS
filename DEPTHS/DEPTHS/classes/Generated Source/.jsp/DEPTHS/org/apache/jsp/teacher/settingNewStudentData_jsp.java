package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settingNewStudentData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
if (request.getParameter("backButton")!=null){ 
      out.write('\r');
      out.write('\n');
response.sendRedirect("teacherWelcomeScreen.jsp"); 
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
uNameExist=teacherBeanId.checkStudentUserName(uName);
      out.write('\r');
      out.write('\n');
if (!uNameExist){
      out.write("\r\n\r\n");
passwOK=teacherBeanId.checkPasswords(passw,passwConf); 
      out.write('\r');
      out.write('\n');
if (passwOK==true){ 
      out.write('\r');
      out.write('\n');
Integer cId=new Integer(country); 
      out.write('\r');
      out.write('\n');
int countryId=cId.intValue(); 
      out.write('\r');
      out.write('\n');
Integer lId=new Integer(lang); 
      out.write('\r');
      out.write('\n');
int langId=lId.intValue(); 
      out.write("\r\n\r\n");
teacherBeanId.createNewStudent(fName,lName,uName,email,passw,address,city,countryId,organisation,webS,langId);
      out.write("\r\n\r\n");
response.sendRedirect("choosingStudentPerformances.jsp?studentUserName="+uName); 
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
