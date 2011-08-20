<jsp:useBean id="statisticBeanId" class="depths.presentationModule.StatisticBean" scope="session">
</jsp:useBean>
<%! int passedConceptOrdNum; %>
<%! String passedConceptId; %>

  <%passedConceptOrdNum=Integer.parseInt(request.getParameter("PassedConceptOrdNum")); %>
  <% passedConceptId=statisticBeanId.getPassedConceptIdByOrdNum(passedConceptOrdNum); %>





<%response.sendRedirect(response.encodeURL("lessonsStatisticPage.jsp?conceptId="+passedConceptId));%>

