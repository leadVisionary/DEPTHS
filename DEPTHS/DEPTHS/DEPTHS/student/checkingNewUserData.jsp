<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>

<%! private boolean userNameExist=false; %>

<%! private boolean dataIsGood=false; %>

<% userNameExist=registrationBeanId.checkUserName();%>

<% if (userNameExist){%>

<% response.sendRedirect("registrationForm.jsp");%>

<%}else{%>


<% dataIsGood=registrationBeanId.checkNewUserData();%>

<% if (dataIsGood==true){%>


<%registrationBeanId.newUserRegistration();%>
<% response.sendRedirect("choosingPerformances.jsp");%>

 <%} else{%>



 <% response.sendRedirect("optionalRegistrationForm.jsp");%>

 <%}%>
 <%}%>
