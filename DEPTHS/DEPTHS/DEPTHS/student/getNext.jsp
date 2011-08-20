<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session">
</jsp:useBean>




<% if (request.getParameter("exitButton")!=null){ %>


<% registrationBeanId.saveStudentData(); %>

<%response.sendRedirect(response.encodeURL("existingUsersForm.jsp"));%>
  <% }else if (request.getParameter("nextButton")!=null){ %>

  <% if (registrationBeanId.getInLessonFlag()){%>


  <% if (registrationBeanId.isFinishLessonsFlag()){ %>


  <%   registrationBeanId.setInLessonFlag(false);%>

   <%  registrationBeanId.setInTestFlag(true);%>

   <% if (testBeanId.isInAddition()==true){ %>



       <% registrationBeanId.setInAdditionalLessonFlag(false);%>

      <% registrationBeanId.setInAdditionalTestFlag(true);%>

   <% }%>

   <% registrationBeanId.setFinishLessonsFlag(false); %>


   <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
   <%}else {%>

  <% registrationBeanId.readNext(); %>

  <%response.sendRedirect(response.encodeURL("unitTemplate.jsp"));%>
  <% }%>
  <% }else if (registrationBeanId.getInTestFlag()==true){%>

  <% if (testBeanId.isInAddition()==true){ %>


  <% if (registrationBeanId.isFinishLessonsFlag()){ %>


  <%   registrationBeanId.setInLessonFlag(false);%>
   <%  registrationBeanId.setInTestFlag(true);%>
   <% registrationBeanId.setInAdditionalLessonFlag(false);%>
      <% registrationBeanId.setInAdditionalTestFlag(true);%>

   <% registrationBeanId.setFinishLessonsFlag(false); %>

   <% registrationBeanId.readNext(); %>
  <%response.sendRedirect(response.encodeURL("testTemplate.jsp"));%>
   <%} else {%>

   <% registrationBeanId.readNext(); %>
  <%response.sendRedirect(response.encodeURL("testTemplate.jsp"));%>
   <% } %>
  <% } %>


  <% }else {%>

  <%}%>
  <%}else {%>

  <% if (registrationBeanId.getInTestFlag()==true){%>

  <% registrationBeanId.readNext(); %>
  <%response.sendRedirect(response.encodeURL("testTemplate.jsp"));%>
  <% }else {%>

  <%}%>
  <%}%>


