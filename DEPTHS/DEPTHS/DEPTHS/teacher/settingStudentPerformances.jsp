<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%@page import="java.util.Date" %>
<%@page import="java.util.Vector" %>

<%String studId=request.getParameter("studentId"); %>

<%Integer stId=new Integer(studId); %>
<%int studentId=stId.intValue(); %>
<%String knowLevel=request.getParameter("knowledgeLevelRadioGroup"); %>
<%String detailLevel=request.getParameter("detailLevelRadioGroup"); %>
<%String programmingLanguage=request.getParameter("programmingLanguageRadioGroup"); %>
<%String displayForm=request.getParameter("formRadioGroup"); %>
<%String grId=request.getParameter("selectedGroup"); %>
<%Integer gId=new Integer(grId); %>
<%int groupId=gId.intValue(); %>
<%--registrationBeanId.sendPerformanceToTutor();--%>

<%teacherBeanId.settingStudentPerformances(studentId,knowLevel,detailLevel,programmingLanguage,displayForm); %>

<%teacherBeanId.settingStudentGroup(studentId,groupId); %>
<%Date date=new Date(); %>

<%Vector groupCoursesIds=teacherBeanId.getCoursesForGroup(groupId); %>
<%int coursesNumb=groupCoursesIds.size();

for (int i=0;i<coursesNumb;i++){
  String courseId=groupCoursesIds.get(i).toString();
  teacherBeanId.setCourseData(studentId,courseId,date,groupId);

}

%>
 <%response.sendRedirect("newStudentCreatedWelcomeScreen.jsp?studentId="+studentId);%>
