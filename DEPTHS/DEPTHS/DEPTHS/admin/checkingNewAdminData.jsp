<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>

<%! private boolean userNameExist=false; %>

<%! private boolean dataIsGood=false; %>

<% userNameExist=adminBeanId.checkNewUserName();%>

<% if (userNameExist){%>

<% response.sendRedirect("adminRegistrationForm.jsp");%>

<%}else{%>


<% dataIsGood=adminBeanId.checkNewAdminData();%>

<% if (dataIsGood==true){%>


<%--adminBeanId.newUserRegistration();--%>
<% response.sendRedirect("choosingAdminPrivilegies.jsp");%>

 <%} else{%>



 <% response.sendRedirect("optionalRegistrationForm.jsp");%>

 <%}%>
 <%}%>
