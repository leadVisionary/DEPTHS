
<%
  if (request.getParameter("previewAssistantsButton") != null) {
    response.sendRedirect("previewAssistantsPage.jsp");
    }else
    if (request.getParameter("teachersWelcomeButton") != null) {
      response.sendRedirect("teacherWelcomeScreen.jsp");
    }
    %>
