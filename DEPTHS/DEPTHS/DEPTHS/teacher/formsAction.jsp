<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%

if (request.getParameter("Submit")!=null){

  String assId=request.getParameter("assistantId");

  Integer x=new Integer(assId);
  int assistantId=x.intValue();



  if (request.getParameterValues("privilegie")!=null){

    String[] privilegiesIds=request.getParameterValues("privilegie");
    int privilegiesNumb=privilegiesIds.length;
    teacherBeanId.removeAllAssistantPrivilegies(assistantId);
    for (int i=0;i<privilegiesNumb;i++){

      Integer pId=new Integer(privilegiesIds[i]);
      int privilegieId=pId.intValue();
      teacherBeanId.setAssistantPrivilegie(assistantId,privilegieId);
    }
  }else{
     teacherBeanId.removeAllAssistantPrivilegies(assistantId);
  }

  if (request.getParameterValues("selectedGroups")!=null){

    String[] groups=request.getParameterValues("selectedGroups");
    int selectedGroupsNumb=groups.length;
    teacherBeanId.removeAllAssistantGroups(assistantId);
    for (int i=0;i<selectedGroupsNumb;i++){

      Integer grId=new Integer(groups[i]);
      int groupId=grId.intValue();
      teacherBeanId.setAssistantGroup(assistantId,groupId);
    }
  }else{
     teacherBeanId.removeAllAssistantGroups(assistantId);
  }
  response.sendRedirect("previewAssistantsPage.jsp");
}

    %>
