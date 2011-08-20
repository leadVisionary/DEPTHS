<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session"></jsp:useBean>
<%!String teacherId;%>
<%!String hasPrivilegies;%>
<%hasPrivilegies = adminBeanId.getPrivilegies();%>
<%teacherId = request.getParameter("teacherId");%>
<%
  if (request.getParameter("Remove") != null) {
    if (hasPrivilegies.equals("Full")) {
      Integer x = new Integer(teacherId);
      adminBeanId.removeTeacherById(x.intValue());
      response.sendRedirect("previewTeachersPage.jsp");
    }
    else {
      response.sendRedirect("previewTeachersPage.jsp");
    }
     %>
<%} else if (request.getParameter("Edit") != null) {%>
<%response.sendRedirect("teachersProfile.jsp?teacherId=" + teacherId);%>
<%}%>
