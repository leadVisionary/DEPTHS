<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>


<%! private boolean x=false; %>
<%x=adminBeanId.checkAdministratorData(); %>

<% if (x==true){%>
<%adminBeanId.adminRegistration();%>

<%adminBeanId.setAdminPrivilegies(); %>
 <%response.sendRedirect("adminWelcomeScreen.jsp");%>
 <%} else{%>
<%response.sendRedirect("existingAdminsForm.jsp"); %>
 <%}%>
