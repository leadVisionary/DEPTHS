<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%!String fName="", lName="",uName="", email="", password="",address="",city="", country="", organisation="", webSite="",language="";%>
<%if (request.getParameter("updateButton")!=null){%>
<%fName=request.getParameter("firstName");%>
<%lName=request.getParameter("lastName");%>



  <%email=request.getParameter("email");%>
  <%password=request.getParameter("password");%>
  <%address=request.getParameter("address");%>
  <%city=request.getParameter("city");%>
  <%country=request.getParameter("selectedCountry");%>
  <%organisation=request.getParameter("organisation");%>
  <%webSite=request.getParameter("webSite");%>
  <%language=request.getParameter("language");%>

  <%adminBeanId.updateAdminData(fName,lName,email,password,address,city,country,organisation,webSite, language);%>

   <%response.sendRedirect("adminWelcomeScreen.jsp");%>
  <%}else if(request.getParameter("previewAdminsButton")!=null){%>
  <%response.sendRedirect("previewAdminsPage.jsp"); %>
  <%} else if (request.getParameter("adminWelcomeButton")!=null){%>
  <%response.sendRedirect("adminWelcomeScreen.jsp"); %>
  <%}%>


