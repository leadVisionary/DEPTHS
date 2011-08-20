<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%!String teacherUserName; %>
<%!java.util.Vector privilegies;%>
<%privilegies=new java.util.Vector(); %>
<%!String[] values; %>

<%values=request.getParameterValues("privilegie");%>
<%String[] courses=request.getParameterValues("courses"); %>
<%int num=values.length; %>

<%for (int i=0;i<num;i++){
  privilegies.add(values[i]);
  }%>



<%teacherUserName=request.getParameter("teacherUserName"); %>

<%if (adminBeanId.getPrivilegies().equals("Guest")){ %>
<%System.out.println("ubaciti alternativnu stranu za guest mode"); %>
<%}else{ %>

<%adminBeanId.addNewTeacherData();%>
<%for (int i=0;i<num;i++){

  adminBeanId.createNewTeacherPrivilegies(teacherUserName,privilegies.get(i).toString());
  }

for (int x=0;x<courses.length;x++){
adminBeanId.setCourseForTeacher(courses[x],teacherUserName.hashCode());
}

response.sendRedirect("newTeacherCreatedWelcomeScreen.jsp?teacherUserName="+teacherUserName);
} %>

