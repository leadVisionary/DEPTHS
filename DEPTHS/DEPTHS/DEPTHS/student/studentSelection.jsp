
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>
<%! String conceptId; %>

  <%conceptId=request.getParameter("conceptId"); %>
  <% registrationBeanId.selectParticularConcept(conceptId); %>

   <% registrationBeanId.saveStudentData(); %>

   <% registrationBeanId.readNext(); %>



<%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
