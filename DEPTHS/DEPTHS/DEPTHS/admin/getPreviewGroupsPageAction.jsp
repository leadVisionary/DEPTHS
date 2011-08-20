<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session"></jsp:useBean>
<jsp:useBean id="groupBeanId" class="depths.presentationModule.admin.GroupBean" scope="session"></jsp:useBean>
<%!String groupId;%>
<%!String hasPrivilegies;%>
<%hasPrivilegies = adminBeanId.getPrivilegies();%>
<%groupId = request.getParameter("groupId");%>
<%
  if (request.getParameter("Remove") != null) {
    if (hasPrivilegies.equals("Full")) {
      Integer x = new Integer(groupId);
      groupBeanId.removeGroupById(x.intValue());
      response.sendRedirect("previewGroupsPage.jsp");
    }
    else {
      response.sendRedirect("previewGroupsPage.jsp");
    }
     %>
<%} else if (request.getParameter("Edit") != null) {%>
<%response.sendRedirect("groupProfile.jsp?groupId=" + groupId);%>
<%}%>
