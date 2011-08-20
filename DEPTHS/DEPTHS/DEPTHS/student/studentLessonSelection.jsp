
<jsp:useBean id="registrationBeanId" scope="session" class="depths.presentationModule.RegistrationBean" />
<jsp:setProperty name="registrationBeanId" property="*" />

<%! String conceptId, lessonId, currLessonId; %>
<%if (request.getParameter("lessonId")!=null){ %>
<%conceptId=request.getParameter("conceptId"); %>
<%lessonId=request.getParameter("lessonId"); %>
<%}else if(request.getParameter("findPrevious")!=null){ %>
<%conceptId=request.getParameter("conceptId"); %>
<%currLessonId=request.getParameter("findPrevious"); %>

<%lessonId=registrationBeanId.findPreviousLesson(currLessonId); %>


<%} %>

<%if (lessonId.equals("noPreviewLesson")){ %>
<%lessonId=currLessonId; %>
<%} %>

  <% registrationBeanId.selectParticularLesson(lessonId); %>

   <% //registrationBeanId.saveStudentData(); %>

   <% registrationBeanId.readNext(); %>



<%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
