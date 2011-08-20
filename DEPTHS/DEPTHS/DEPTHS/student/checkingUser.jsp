<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>


<%! private boolean x=false; %>
<% x=registrationBeanId.getNewUser();%>
<% if (x==true){%>
 <%response.sendRedirect("choosingPerformances.jsp");%>
 <%} else{%>
 <% response.sendRedirect("welcomeScreen.jsp");%>
 <%}%>
