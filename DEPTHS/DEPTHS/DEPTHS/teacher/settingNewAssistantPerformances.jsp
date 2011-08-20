<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%@page import="java.util.Enumeration" %>
<%if (request.getParameter("Submit")!=null){

String assistantUserName=request.getParameter("assistantUserName");

int assistantId=assistantUserName.hashCode();




if (request.getParameterValues("privilegie")!=null){
  String[] privilegiesIds=request.getParameterValues("privilegie");
  int privilegiesNumb=privilegiesIds.length;
  for (int i=0;i<privilegiesNumb;i++){

    Integer pId=new Integer(privilegiesIds[i]);
    int privilegieId=pId.intValue();
    teacherBeanId.setAssistantPrivilegie(assistantId,privilegieId);
  }
}

if (request.getParameterValues("selectedGroups")!=null){
  String[] groups=request.getParameterValues("selectedGroups");
  int selectedGroupsNumb=groups.length;
  for (int i=0;i<selectedGroupsNumb;i++){

    Integer grId=new Integer(groups[i]);
    int groupId=grId.intValue();
    teacherBeanId.setAssistantGroup(assistantId,groupId);
  }
}

%>
<%response.sendRedirect("newAssistantCreatedWelcomeScreen.jsp?assistantId="+assistantId); %>
<%}%>
