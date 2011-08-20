<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%if (request.getParameter("backButton")!=null){ %>
<%response.sendRedirect("adminWelcomeScreen.jsp"); %>
<%}else{ %>
<%!String fName, lName, uName, email, passw, passwConf, address, city, country, organisation,webS, lang; %>
<%!boolean uNameExist=false,passwOK=false; %>

<%fName=request.getParameter("firstName"); %>
<%lName=request.getParameter("lastName"); %>
<%uName=request.getParameter("userName"); %>
<%email=request.getParameter("email"); %>
<%passw=request.getParameter("password"); %>
<%passwConf=request.getParameter("passwordConfirmation"); %>
<%address=request.getParameter("address"); %>
<%city=request.getParameter("city"); %>
<%country=request.getParameter("selectedCountry"); %>
<%organisation=request.getParameter("organization"); %>
<%webS=request.getParameter("webSite"); %>
<%lang=request.getParameter("language"); %>

<%uNameExist=adminBeanId.checkTeacherUserName(uName);%>
<%if (!uNameExist){%>

<%passwOK=adminBeanId.checkPasswords(passw,passwConf); %>
<%if (passwOK==true){ %>

<%adminBeanId.createNewTeacher(fName,lName,uName,email,passw,address,city,country,organisation,webS,lang);%>
<%response.sendRedirect("choosingTeacherPrivilegies.jsp?teacherUserName="+uName); %>
<%}else{ %>

<%} %>

  <%}else{%>

  <%} %>
<%} %>
<%-- response.sendRedirect("checkingNewAdminData.jsp");--%>

