<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<jsp:setProperty name="registrationBeanId" property="knowledgeLevel" value='<%=request.getParameter("knowledgeLevelRadioGroup")%>'/>
<jsp:setProperty name="registrationBeanId" property="detailLevel" value='<%=request.getParameter("detailLevelRadioGroup")%>'/>
  <jsp:setProperty name="registrationBeanId" property="programmingLanguage" value='<%=request.getParameter("programmingLanguageRadioGroup")%>'/>

<%registrationBeanId.sendPerformanceToTutor();%>

 <%response.sendRedirect("welcomeScreen.jsp");%>
