
<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<jsp:setProperty name="adminBeanId" property="userName" value='<%=request.getParameter("textField") %>'/>
  <jsp:setProperty name="adminBeanId" property="adminPassword" value='<%=request.getParameter("passwordField") %>'/>

<% response.sendRedirect("checkingAdministratorData.jsp");%>
