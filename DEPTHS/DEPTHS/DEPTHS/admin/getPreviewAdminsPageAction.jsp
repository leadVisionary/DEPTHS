<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session"></jsp:useBean>
<%!String adminId;%>
<%!String hasPrivilegies;%>
<%hasPrivilegies = adminBeanId.getPrivilegies();%>
<%adminId = request.getParameter("adminId");%>
<%
  if (request.getParameter("Remove") != null) {
    if (hasPrivilegies.equals("Full")) {
      Integer x = new Integer(adminId);
      adminBeanId.removeAdminById(x.intValue());
      response.sendRedirect("previewAdminsPage.jsp");
    }
    else {
      response.sendRedirect("previewAdminsPage.jsp");
    }
     %>
<%} else if (request.getParameter("Edit") != null) {%>
<%response.sendRedirect("membersProfile.jsp?adminId=" + adminId);%>
<%}%>
