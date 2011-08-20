<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>

<%if (!registrationBeanId.getAddedData("firstName")){%>
<jsp:setProperty name="registrationBeanId" property="firstName" value='<%=request.getParameter("firstName") %>'/>
   <%}%>
  <%if (!registrationBeanId.getAddedData("lastName")){%>
  <jsp:setProperty name="registrationBeanId" property="lastName" value='<%=request.getParameter("lastName") %>'/>
     <%}%>
<%if (!registrationBeanId.getAddedData("userName")){%>
<jsp:setProperty name="registrationBeanId" property="userName" value='<%=request.getParameter("userName") %>'/>
  <%}%>
  <%if (!registrationBeanId.getAddedData("email")){%>
  <jsp:setProperty name="registrationBeanId" property="email" value='<%=request.getParameter("email") %>'/>
     <%}%>
<%if (!registrationBeanId.getAddedData("password")){%>
    <jsp:setProperty name="registrationBeanId" property="password" value='<%=request.getParameter("password") %>'/>
       <%}%>
      <%if (!registrationBeanId.getAddedData("passwordConfirmation")){%>
  <jsp:setProperty name="registrationBeanId" property="passwordConfirmation" value='<%=request.getParameter("passwordConfirmation") %>'/>
     <%}%>
     <%if (!registrationBeanId.isFormRepeated()){%>
     <jsp:setProperty name="registrationBeanId" property="address" value='<%=request.getParameter("address") %>'/>
     <jsp:setProperty name="registrationBeanId" property="city" value='<%=request.getParameter("city") %>'/>

     <jsp:setProperty name="registrationBeanId" property="country" value='<%=request.getParameter("selectedCountry")%>'/>

     <jsp:setProperty name="registrationBeanId" property="organization" value='<%=request.getParameter("organization") %>'/>
     <jsp:setProperty name="registrationBeanId" property="webSite" value='<%=request.getParameter("webSite") %>'/>
     <jsp:setProperty name="registrationBeanId" property="selectedLanguage" value='<%=request.getParameter("language") %>'/>
           <%}%>


<% response.sendRedirect("checkingNewUserData.jsp");%>
