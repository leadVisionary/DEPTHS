<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%
String hasPrivilegies=adminBeanId.getPrivilegies();

//obrajuje stranu za promenu privilegija administratora
//editProfilePage.jsp
  if (request.getParameter("changePrivilegie") != null) {
    String admId=request.getParameter("adminId");
    String newPrivilegie=request.getParameter("privilegie");
    if (hasPrivilegies.equals("Full")){
      adminBeanId.changePrivilegie(admId,newPrivilegie);
      response.sendRedirect("previewAdminsPage.jsp");
    }else{
      response.sendRedirect("previewAdminsPage.jsp");
    }
  }
  //obrajuje stranu za promenu privilegija nastavnika
  //editTeacherProfilePage.jsp
  if (request.getParameter("changeTeacherPrivilegies") != null) {
    if (hasPrivilegies.equals("Full")){

    String teachId=request.getParameter("teacherId");
    Integer tId=new Integer(teachId);

    int teacherId=tId.intValue();

    if (request.getParameterValues("privilegie") != null) {
      String newPrivilegies[]=request.getParameterValues("privilegie");
      int privNumb=newPrivilegies.length;
      adminBeanId.removeAllTeacherPrivilegies(teacherId);
      adminBeanId.getPrivilegiesIds();
      for(int i=0;i<privNumb;i++){
        Integer pi=new Integer(newPrivilegies[i]);
        int privId=pi.intValue();
        adminBeanId.createNewTeacherPrivilegies(teacherId,privId);
      }
    }else{
    adminBeanId.removeAllTeacherPrivilegies(teacherId);
    }
      //adminBeanId.updateTeacherPrivilegie(teacherId,newPrivilegie);
      response.sendRedirect("previewTeachersPage.jsp");
    }else{
      response.sendRedirect("previewTeachersPage.jsp");
    }
  }
    %>
