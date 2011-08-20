<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>

<jsp:setProperty name="registrationBeanId" property="detailLevel" value='<%=request.getParameter("select")%>'/>
  <jsp:setProperty name="registrationBeanId" property="programmingLanguage" value='<%=request.getParameter("select2")%>'/>

<%registrationBeanId.sendPerformanceToTutor();%>


