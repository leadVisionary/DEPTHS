<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>


<% if (request.getParameter("exitButton")!=null){ %>
<% testBeanId.setConceptFinished(true);%>
<% registrationBeanId.finishNewConcept(); %>

<% registrationBeanId.saveStudentData(); %>


<% }else if (request.getParameter("nextButton")!=null){ %>

<% testBeanId.setConceptFinished(true);%>
<% registrationBeanId.setParameters();%>

<% registrationBeanId.saveStudentData(); %>
<%registrationBeanId.setInLessonFlag(true); %>
 <% registrationBeanId.readNext(); %>


  <%-- registrationBeanId.readNext(); --%>

  <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>

<% } %>
