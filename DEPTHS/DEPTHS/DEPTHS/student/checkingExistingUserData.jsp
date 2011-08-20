<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>


<%! private boolean x=false; %>
<%x=registrationBeanId.checkExistingUserData(); %>

<% if (x==true){%>

<%registrationBeanId.userRegistration();%>
 <%response.sendRedirect("welcomeScreen.jsp");%>
 <%} else{%>
 <% response.sendRedirect("existingUsersForm.jsp");%>
 <%}%>
