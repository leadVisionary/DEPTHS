
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>


<% registrationBeanId.setParameters(); %>

<%if (registrationBeanId.getNewUser()){%>


  <% registrationBeanId.initializeUser();}%>

<% if (request.getParameter("exitButton")!=null){ %>


<% registrationBeanId.saveStudentData(); %>



<%response.sendRedirect(response.encodeURL("registration.jsp"));%>

  <% }else if (request.getParameter("exitSaveButton")!=null){%>


<% testBeanId.setConceptFinished(true);%>


<% registrationBeanId.finishNewConcept(); %>


<% registrationBeanId.saveStudentData(); %>

<%response.sendRedirect(response.encodeURL("registration.jsp"));%>



  <% }else if (request.getParameter("nextButton")!=null){ %>

  <%-- Slucaj kada je upravo zavrsen dodatni test i prelazi se na novi koncept --%>


  <% if (testBeanId.isInAddition()){%>

  <% testBeanId.setConceptFinished(true);%>



 <% registrationBeanId.saveStudentData(); %>



  <% registrationBeanId.readNext(); %>


  <% testBeanId.setInAddition(false);%>


  <% registrationBeanId.setInAdditionalLessonFlag(false);%>


   <% registrationBeanId.setInAdditionalTestFlag(false);%>



   <% registrationBeanId.setParameters();%>

  <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>

  <%}else {%>

  <% registrationBeanId.saveStudentData(); %>

  <% registrationBeanId.readNext(); %>

  <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>

  <%}%>

  <%}%>

  <% if (registrationBeanId.getNewUser()){ %>


  <% registrationBeanId.setNewUser(false);%>

  <%} %>

