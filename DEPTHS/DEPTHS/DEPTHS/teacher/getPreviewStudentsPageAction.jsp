<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session"></jsp:useBean>
<%@page import="java.util.Vector" %>
<%

Vector teacherPrivilegies=teacherBeanId.getTeacherPrivilegies();
String studId = request.getParameter("studentId");
Integer stId=new Integer(studId);
int studentId=stId.intValue();

boolean hasPrivilegies=false;
int teachPrivilegiesNumb=teacherPrivilegies.size();
for (int i=0;i<teachPrivilegiesNumb;i++){
String privName=teacherPrivilegies.get(i).toString();
if (privName.equals("create new student")){
hasPrivilegies=true;

}
}
  if (request.getParameter("Remove") != null) {
    if (hasPrivilegies==true) {

      teacherBeanId.removeStudentById(studentId);
      response.sendRedirect("previewStudentsPage.jsp");
    }
    else {
      response.sendRedirect("previewStudentsPage.jsp");
    }

} else if (request.getParameter("Edit") != null) {

response.sendRedirect("studentsProfile.jsp?studentId="+studentId);
}
%>
