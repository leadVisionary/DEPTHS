<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session"></jsp:useBean>
<%@page import="java.util.Vector" %>
<%

Vector teacherPrivilegies=teacherBeanId.getTeacherPrivilegies();
String assistId = request.getParameter("assistantId");
Integer assId=new Integer(assistId);
int assistantId=assId.intValue();

boolean hasPrivilegies=false;
int teachPrivilegiesNumb=teacherPrivilegies.size();
for (int i=0;i<teachPrivilegiesNumb;i++){
String privName=teacherPrivilegies.get(i).toString();
if (privName.equals("create new assistant")){
hasPrivilegies=true;

}
}
  if (request.getParameter("Remove") != null) {
    if (hasPrivilegies==true) {
      Integer x = new Integer(assistantId);
      teacherBeanId.removeAssistantById(x.intValue());
      response.sendRedirect("previewAssistantsPage.jsp");
    }
    else {
      response.sendRedirect("previewAssistantsPage.jsp");
    }

} else if (request.getParameter("Edit") != null) {

response.sendRedirect("assistantsProfile.jsp?assistantId="+assistantId);
}
%>
