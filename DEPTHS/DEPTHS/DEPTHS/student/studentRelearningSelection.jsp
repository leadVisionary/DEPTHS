
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>

<%! String conceptId; %>

  <%conceptId=request.getParameter("conceptId"); %>
  <% registrationBeanId.selectParticularLearnedConcept(conceptId); %>

   <% registrationBeanId.saveStudentData(); %>

   <% registrationBeanId.readNext(); %>



<%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
