
<%
  if (request.getParameter("previewAdminsButton") != null) {
    response.sendRedirect("previewAdminsPage.jsp");
    }else
    if (request.getParameter("adminWelcomeButton") != null) {
      response.sendRedirect("adminWelcomeScreen.jsp");
    }else
    if (request.getParameter("previewTeachersButton") != null) {
      response.sendRedirect("previewTeachersPage.jsp");
    }else
    if (request.getParameter("previewGroupsButton") != null) {
      response.sendRedirect("previewGroupsPage.jsp");
    }
    %>
