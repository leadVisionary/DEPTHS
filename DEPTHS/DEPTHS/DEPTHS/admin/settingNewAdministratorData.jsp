<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%if (request.getParameter("backButton")!=null){ %>
<%response.sendRedirect("adminWelcomeScreen.jsp"); %>
<%}else{ %>

<%if (!adminBeanId.getAddedData("firstName")){%>
<jsp:setProperty name="adminBeanId" property="newFirstName" value='<%=request.getParameter("firstName") %>'/>
   <%}%>
  <%if (!adminBeanId.getAddedData("lastName")){%>
  <jsp:setProperty name="adminBeanId" property="newLastName" value='<%=request.getParameter("lastName") %>'/>
     <%}%>
<%if (!adminBeanId.getAddedData("userName")){%>

<jsp:setProperty name="adminBeanId" property="newUserName" value='<%=request.getParameter("userName") %>'/>
  <%}%>
  <%if (!adminBeanId.getAddedData("email")){%>
  <jsp:setProperty name="adminBeanId" property="newEmail" value='<%=request.getParameter("email") %>'/>
     <%}%>
<%if (!adminBeanId.getAddedData("password")){%>
    <jsp:setProperty name="adminBeanId" property="newPassword" value='<%=request.getParameter("password") %>'/>
       <%}%>
      <%if (!adminBeanId.getAddedData("passwordConfirmation")){%>
  <jsp:setProperty name="adminBeanId" property="newPasswordConfirmation" value='<%=request.getParameter("passwordConfirmation") %>'/>
     <%}%>
     <%if (!adminBeanId.isFormRepeated()){%>
     <jsp:setProperty name="adminBeanId" property="newAddress" value='<%=request.getParameter("address") %>'/>
     <jsp:setProperty name="adminBeanId" property="newCity" value='<%=request.getParameter("city") %>'/>
     <jsp:setProperty name="adminBeanId" property="newCountry" value='<%=request.getParameter("selectedCountry") %>'/>
     <jsp:setProperty name="adminBeanId" property="newOrganisation" value='<%=request.getParameter("organization") %>'/>
     <jsp:setProperty name="adminBeanId" property="newWebSite" value='<%=request.getParameter("webSite") %>'/>
     <jsp:setProperty name="adminBeanId" property="newSelectedLanguage" value='<%=request.getParameter("language") %>'/>
           <%}%>


<% response.sendRedirect("checkingNewAdminData.jsp");%>
<%} %>
