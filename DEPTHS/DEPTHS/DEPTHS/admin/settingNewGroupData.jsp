<%@page import="depths.adminModule.DatabaseManager" %>

<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<jsp:useBean id="groupBeanId" class="depths.presentationModule.admin.GroupBean" scope="session">
</jsp:useBean>

<%if (request.getParameter("backButton")!=null){
response.sendRedirect("adminWelcomeScreen.jsp");
}else{
if (adminBeanId.getPrivilegies().equals("Guest")){

}else{
  String groupName=request.getParameter("groupName");
  int groupId=groupName.hashCode();
  DatabaseManager dbManager=adminBeanId.getManagerReference();
  groupBeanId.setDbManagerRef(dbManager);
  if (groupBeanId.groupExists(request.getParameter("groupName"))==false){

    String[] admins;
    String[] teachers;
    String[] courses;
    String langId;
    admins=request.getParameterValues("administrators");
    teachers=request.getParameterValues("teachers");
    courses=request.getParameterValues("courses");
    langId=request.getParameter("language");
    Integer l=new Integer(langId);
    int languageId=l.intValue();
    int adminsNumb=admins.length;
    int teachersNumb=teachers.length;
    int coursesNumb=courses.length;
    String description=request.getParameter("description");
    groupBeanId.setGroupData(groupId,groupName,languageId,description);
    for (int i=0;i<adminsNumb;i++){
      String a=admins[i];
      Integer ai=new Integer(a);
      groupBeanId.setGroupAdministrator(groupId,ai.intValue());

    }
    for (int i=0;i<teachersNumb;i++){
      String t=teachers[i];
      Integer ti=new Integer(t);
      groupBeanId.setGroupTeacher(groupId,ti.intValue());
    }
    for (int i=0;i<coursesNumb;i++){
      String c=courses[i];

      groupBeanId.setGroupCourse(groupId,c);
    }
    %>
    <% response.sendRedirect("newGroupCreatedWelcomeScreen.jsp?groupId="+groupId);%>

    <%}else{
    System.out.println("This username already exists");
  } %>
  <%} %>
  <%} %>
