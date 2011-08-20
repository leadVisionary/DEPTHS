
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:setProperty name="registrationBeanId" property="userName" value='<%=request.getParameter("textField") %>'/>
  <jsp:setProperty name="registrationBeanId" property="userPassword" value='<%=request.getParameter("passwordField") %>'/>

<% response.sendRedirect("checkingExistingUserData.jsp");%>
