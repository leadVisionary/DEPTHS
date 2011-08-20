<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%if (request.getParameter("backButton")!=null){ %>
<%response.sendRedirect("teacherWelcomeScreen.jsp"); %>
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

<%uNameExist=teacherBeanId.checkNewAssistantUserName(uName);%>
<%if (!uNameExist){%>

<%passwOK=teacherBeanId.checkPasswords(passw,passwConf); %>
<%if (passwOK==true){ %>
<%Integer cId=new Integer(country);%>
<%int countryId=cId.intValue(); %>
<%Integer lId=new Integer(lang); %>
<%int langId=lId.intValue(); %>
<%teacherBeanId.createNewAssistant(fName,lName,uName,email,passw,address,city,countryId,organisation,webS,langId);%>
<%response.sendRedirect("choosingAssistantPrivilegies.jsp?assistantUserName="+uName); %>
<%}else{ %>

<%} %>

  <%}else{%>

  <%} %>
<%} %>
<%-- response.sendRedirect("checkingNewAdminData.jsp");--%>

