<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<jsp:setProperty name="teacherBeanId" property="teacherUserName" value='<%=request.getParameter("textField") %>'/>
  <jsp:setProperty name="teacherBeanId" property="teacherPassword" value='<%=request.getParameter("passwordField") %>'/>

<% response.sendRedirect("checkingTeacherData.jsp");%>
