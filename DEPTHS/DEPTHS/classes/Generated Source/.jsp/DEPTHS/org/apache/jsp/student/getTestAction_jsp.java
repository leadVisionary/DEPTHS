package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import depths.coordinator.Tutor;

public final class getTestAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Tutor tutor; 
 String studAnswerIndex; 
 int numbOfQuestions; 
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
      depths.presentationModule.TestBean testBeanId = null;
      synchronized (session) {
        testBeanId = (depths.presentationModule.TestBean) _jspx_page_context.getAttribute("testBeanId", PageContext.SESSION_SCOPE);
        if (testBeanId == null){
          testBeanId = new depths.presentationModule.TestBean();
          _jspx_page_context.setAttribute("testBeanId", testBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n\r\n");
testBeanId.setFinished(new java.util.Date()); 
      out.write("\r\n\r\n");
 if (request.getParameter("exitButton")!=null){ 
      out.write("\r\n\r\n\r\n");
 registrationBeanId.saveStudentData(); 
      out.write("\r\n\r\n");
response.sendRedirect(response.encodeURL("existingUsersForm.jsp"));
      out.write("\r\n  ");
 }else{
      out.write("\r\n\r\n\r\n");
      out.write("\r\n\r\n");
 tutor= registrationBeanId.getRefTutor(); 
      out.write("\r\n\r\n");
 testBeanId.setTutorRef(tutor); 
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
 testBeanId.cleanStudAnswVector(); 
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
 numbOfQuestions=registrationBeanId.getNumOfQuestionsInPlan(); 
      out.write("\r\n\r\n");
 if ((numbOfQuestions==0)||(numbOfQuestions>0)){
      out.write("\r\n\r\n");
 try { 
      out.write('\r');
      out.write('\n');
System.out.println("getTestAction.jsp KT-1");
      out.write('\r');
      out.write('\n');
 for (int i=0;i<numbOfQuestions;i++){ 
      out.write('\r');
      out.write('\n');
System.out.println("getTestAction.jsp KT-2");
      out.write("\r\n\r\n  ");
 studAnswerIndex=request.getParameter(String.valueOf(i)); 
      out.write('\r');
      out.write('\n');
System.out.println("getTestAction.jsp KT-3");
      out.write("\r\n\r\n  ");
 int sai=Integer.parseInt(studAnswerIndex); 
      out.write('\r');
      out.write('\n');
System.out.println("getTestAction.jsp KT-4");
      out.write("\r\n\r\n  ");
 testBeanId.checkStudAnswer(i,sai); 
      out.write("\r\n  ");
System.out.println("getTestAction.jsp KT-5");
      out.write("\r\n  ");
 }
      out.write("\r\n  ");
 testBeanId.signalEndOfSendingStudentAnswers(); 
      out.write("\r\n  ");
System.out.println("getTestAction.jsp KT-6");
      out.write('\r');
      out.write('\n');
      out.write(' ');
response.sendRedirect(response.encodeURL("testAssessment.jsp"));
      out.write('\r');
      out.write('\n');
      out.write(' ');
 } catch (Exception e){ 
      out.write('\r');
      out.write('\n');
System.out.println("Exception ="+e.getMessage()); 
      out.write("\r\n<script type=\"text/javascript\">\r\nvar name = confirm(\"ERROR: You have to answer all questions !\")\r\nif (name == true)\r\n{\r\nlocation=\"testTemplate.jsp\"\r\n}else{\r\n  history.go(-1);\r\n}\r\n</script>\r\n\r\n\r\n ");
 }
      out.write('\r');
      out.write('\n');
      out.write(' ');
 } else { 
      out.write('\r');
      out.write('\n');
      out.write(' ');
System.out.println("***WARNING getTestAction numberOfQuestion==0 NIJE OBRADJENO"); 
      out.write("\r\n\r\n  ");
 }
      out.write('\r');
      out.write('\n');
      out.write(' ');
 testBeanId.restartCounter(); 
      out.write("\r\n\r\n\r\n ");
 }
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
