<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<jsp:setProperty name="adminBeanId" property="newPrivilegies" value='<%=request.getParameter("privilegiesRadioGroup")%>'/>
<%if (adminBeanId.getPrivilegies().equals("Guest")){ %>
<%System.out.println("ubaciti alternativnu stranu za guest mode"); %>
<%}else{ %>

<%adminBeanId.newAdminRegistration();%>
<%response.sendRedirect("newAdminCreatedWelcomeScreen.jsp");%>
<%} %>

