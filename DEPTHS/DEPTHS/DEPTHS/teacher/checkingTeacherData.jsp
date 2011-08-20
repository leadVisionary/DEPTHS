<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>


<%! private boolean x=false; %>
<%x=teacherBeanId.checkTeacherData(); %>

<% if (x==true){%>
<%teacherBeanId.teacherRegistration();%>

<%teacherBeanId.setTeacherPrivilegies(); %>
 <%response.sendRedirect("teacherWelcomeScreen.jsp");%>
 <%} else{%>

<%response.sendRedirect("existingTeachersForm.jsp"); %>
<%}%>
