<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<title>DEPTHS</title>
<link rel="stylesheet" href="../css/unitTemplate.css" type="text/css"/>
</style><style type="text/css">
  <!--
    .copyrightStyle {
    font-size: 12px;
    color: #006699;
    }
  -->
</style>
<script language="javascript" src="js/matching_columns.js" type="text/javascript"></script>
<script language="javascript" src="js/popupWindowFunctions.js" type="text/javascript"></script>
</head>
<!-- JSP code -->
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session"></jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session"></jsp:useBean>

<%!String svgUri;%>
<%svgUri = registrationBeanId.getSVG_uri();%>

<%if (registrationBeanId.getInTestFlag()) {%>
<%response.sendRedirect("getNext.jsp");%>
<%} else {%>
<%!String currUnitId; %>
<%currUnitId=registrationBeanId.getCurrUnitId(); %>

<body>
<%registrationBeanId.putNumOfConceptsToLearn();%>
<%registrationBeanId.putNumOfUnitsToLearn();%>
<%!int numOfConceptsToLearn, numOfUnits;%>
<%!String currConcId;%>
<%!String concId;%>
<%currConcId = registrationBeanId.readCurrConcID();%>
<%numOfConceptsToLearn = registrationBeanId.getNumOfConceptsToLearn();%>
<%numOfUnits = registrationBeanId.getNumOfUnitsToLearni();%>
<div id="page">
<DIV id=masthead>
<DIV id=globalNav>
<a href="#" onclick="popupSmallWindow('changePerformancePage.jsp')">Performance</a> |
<a href="#" onclick="popupWindow('conceptStatisticPage.jsp')">Statistic</a> |
<a href="#">Tools</a> |
<a href="#">Help</a>
</DIV><!--globalNav-->
</DIV><!--mastHead-->
  <div id="navBar" class="column">
  <div id="blank">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  </div> <!--blank-->
  <div id="search">
    <label>Curriculum</label>
  </div><!--search-->
  <div id="sectionLinks">
  <%for (int i = 0; i < numOfConceptsToLearn ; i++) {  %>
    <%concId = registrationBeanId.getConceptIdByOrdNum(i);  %>
    <a href="<%=request.getContextPath()%>/student/studentSelection.jsp?conceptId=<%=concId%>">
      <%if (concId == currConcId) {    %>

      <strong><%= registrationBeanId.getConceptByOrdNum(i) %></strong>
    </a>
    <%} else {  %>

    <%= registrationBeanId.getConceptByOrdNum(i) %></a>
	<%}  %>
	<br />
    <%if (concId.equals(currConcId)) {  %>
	<div style="margin-left:15px; padding-left:0px;">
    <%for (int si = 0; si < numOfUnits; si++) {  %>
      <%!String unitTitle, unitId;  %>
      <%unitTitle = registrationBeanId.getUnitTitleByOrdNum(si+1);  %>
      <%unitId = registrationBeanId.getUnitIdByOrdNum(si+1);  %>
      <a href="<%=request.getContextPath()%>/student/studentLessonSelection.jsp?conceptId=<%=concId%>&lessonId=<%=unitId %>">
        <%if ((registrationBeanId.getUnitTitle()).equals(unitTitle)) {    %>
        <strong><%= unitTitle %></strong> </a>
		<%} else {  %>
        <%= unitTitle %></a>
		<%}  %><br />

        <%}  %>
	<a href="#">Questionnaire</a><br/>
        </div><!--style-->
        <%} %>


        <%} %>
  </div><!--sectionLinks-->
  <div id="search">
    <br/>
    <br/>
    <label>Passed concepts</label>
  </div> <!--search-->
  <div id="sectionLinks">
    <%
  int numOfPassedConcepts;
  double passConcDegree;
  String rating;
  numOfPassedConcepts = registrationBeanId.getNumberOfPassedConcepts();

%>
<%for (int i = 0; i < numOfPassedConcepts; i++) {%>

  <%
  passConcDegree = registrationBeanId.getPassedConceptDegreeOfMastByOrdNum(i);
  rating = registrationBeanId.getPassedConceptRating(passConcDegree);
  %>
  <a href="<%=request.getContextPath()%>/student/studentRelearningSelection.jsp?conceptId=<%=registrationBeanId.getPassedConceptIdByOrdNum(i)%>" >
    <%=registrationBeanId.getPassedConceptTitleByOrdNum(i)%></a><br />
    <img alt="" src="images/<%=rating%>"/><br />
     <%}%>

  </div><!--sectionLinks-->
  <div id="advert">
    <p>&nbsp;</p>
  </div><!--adverts-->
 </div><!--navBar-->
<div id="content" class="column">

  <div id="previousNextLinks">
    <div id="breadCrumb">

      <a href="<%=request.getContextPath()%>/student/studentLessonSelection.jsp?conceptId=<%=currConcId%>&findPrevious=<%=currUnitId %>">        &lt;&lt;
        Previous
</a>
    </div><!--breadCrumb-->
    <div id="breadCrumb2">

      <a href="getNext.jsp?nextButton=next">        Next
        &gt;&gt;
</a>
    </div>
  </div><!--previousNextLinks-->
  <br/>
  <br/>
  <h1 id="pageName"><%= registrationBeanId.getCurrConceptTitle()%></h1>
  <div class="story">
    <h2><%= registrationBeanId.getUnitTitle()%></h2>

    <%!int numOfFragm;%>
<%numOfFragm = registrationBeanId.getNumberOfFragmentsInUnit();%>
<%for (int i = 0; i < numOfFragm ; i++) {%>
<%registrationBeanId.getFragmentByOrdNumber(i);%>
<%!String type;%>
<%type = registrationBeanId.getFragmentType();%>
<%if (type.equals("whole")) {%>
  <h3><%= registrationBeanId.getFragmentTitle() %>  </h3>

<%= registrationBeanId.getFragmentContent() %>
<%}else if (type.equals("part-of")) {%>
<%= registrationBeanId.getFragmentContent() %>
<%} else if (type.equals("first")) {%>
  <h3><%= registrationBeanId.getFragmentTitle() %>  </h3>

<%= registrationBeanId.getFragmentContent() %>
<%} else if (type.equals("picture_big")) {%>
  <embed src="<%=svgUri %><%= registrationBeanId.getFragmentContent() %>.svg" height="550" width="820" type="image/svg+xml" align="center"/>

<%} else if (type.equals("picture_middle")) {%>
  <embed src="<%=svgUri %><%= registrationBeanId.getFragmentContent() %>.svg" height="350" width="620" type="image/svg+xml" align="center"/>

<%} else if (type.equals("picture_small")) {%>

  <embed src="<%=svgUri %><%= registrationBeanId.getFragmentContent() %>.svg" height="300" width="520" type="image/svg+xml" align="center"/>
<%} else if (type.equals("list")) {%>
  <img src="images/BD21435_.GIF" alt="" width="11" height="11" border="0">
</a>  &nbsp;&nbsp;
<%= registrationBeanId.getFragmentContent() %>
<%} else if (type.equals("list2")) {%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  -
  &nbsp;&nbsp;
<%= registrationBeanId.getFragmentContent() %><%} else if (type.equals("code")) {%>
  <blockquote style="margin-left:30; margin-right:170; background-color:#ECECEC;"><%= registrationBeanId.getFragmentContent() %>  </blockquote>
<%}%>
<br />
<br />
<%}%>



       <p>&nbsp;</p>




      <form id="form1" name="form1" method="post" action="getNext.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
          </form>



  </div><!--story-->
</div><!--content-->
<div id="siteInfo" align="center">
  <a href="#">About Us</a>
  |
  <a href="#">Site Map</a>
  |
  <a href="#">Privacy Policy</a>
  |
  <a href="mailto:jeremycod@yahoo.com">Contact Us</a>
  <br/>
  <span class="copyrightStyle">    &copy;
    2006 FON - School of Business Administration, University of Belgrade
</span>
</div><!-siteInfo-->
<br/>
</div>
</body>
<%}%>
</html>
