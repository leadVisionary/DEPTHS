<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>

<% if (request.getParameter("exitButton")!=null){ %>

<% registrationBeanId.saveStudentData(); %>

<%response.sendRedirect(response.encodeURL("existingUsersForm.jsp"));%>

<% }else if (request.getParameter("declineButton")!=null){ %>

<% testBeanId.startConceptAssessment(); %>
<% testBeanId.setConceptFinished(true);%>
<% registrationBeanId.setInAdditionalLessonFlag(false); %>
<% registrationBeanId.setInAdditionalTestFlag(false); %>
<% testBeanId.setInAddition(false); %>
<% registrationBeanId.setInLessonFlag(false); %>
<% registrationBeanId.setInTestFlag(false);%>

<%--Ovde treba ubaciti procenu studenta za zavrseno poglavlje --%>

<% registrationBeanId.saveStudentData(); %>

 <% registrationBeanId.readNext(); %>

  <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>

<%}else if (request.getParameter("acceptButton")!=null){ %>
<% if (testBeanId.isInAddition()==false){%>

<% registrationBeanId.setParameters();%>
<% registrationBeanId.setAdditionalParameters(); %>
 <% registrationBeanId.readNext(); %>
 <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
 <% testBeanId.setInAddition(true);%>
 <% }else {%>



 <% testBeanId.setInAddition(false);%>
 <%}%>

<% } %>
