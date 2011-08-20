

<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>


<%testBeanId.setFinished(new java.util.Date()); %>

<% if (request.getParameter("exitButton")!=null){ %>


<% registrationBeanId.saveStudentData(); %>

<%response.sendRedirect(response.encodeURL("existingUsersForm.jsp"));%>
  <% }else{%>

<%@ page import="depths.coordinator.Tutor" %>
<%! Tutor tutor; %>

<% tutor= registrationBeanId.getRefTutor(); %>

<% testBeanId.setTutorRef(tutor); %>

<%! String studAnswerIndex; %>

<% testBeanId.cleanStudAnswVector(); %>

<%! int numbOfQuestions; %>

<% numbOfQuestions=registrationBeanId.getNumOfQuestionsInPlan(); %>

<% if ((numbOfQuestions==0)||(numbOfQuestions>0)){%>

<% try { %>
<%System.out.println("getTestAction.jsp KT-1");%>
<% for (int i=0;i<numbOfQuestions;i++){ %>
<%System.out.println("getTestAction.jsp KT-2");%>

  <% studAnswerIndex=request.getParameter(String.valueOf(i)); %>
<%System.out.println("getTestAction.jsp KT-3");%>

  <% int sai=Integer.parseInt(studAnswerIndex); %>
<%System.out.println("getTestAction.jsp KT-4");%>

  <% testBeanId.checkStudAnswer(i,sai); %>
  <%System.out.println("getTestAction.jsp KT-5");%>
  <% }%>
  <% testBeanId.signalEndOfSendingStudentAnswers(); %>
  <%System.out.println("getTestAction.jsp KT-6");%>
 <%response.sendRedirect(response.encodeURL("testAssessment.jsp"));%>
 <% } catch (Exception e){ %>
<%System.out.println("Exception ="+e.getMessage()); %>
<script type="text/javascript">
var name = confirm("ERROR: You have to answer all questions !")
if (name == true)
{
location="testTemplate.jsp"
}else{
  history.go(-1);
}
</script>


 <% }%>
 <% } else { %>
 <%System.out.println("***WARNING getTestAction numberOfQuestion==0 NIJE OBRADJENO"); %>

  <% }%>
 <% testBeanId.restartCounter(); %>


 <% }%>

