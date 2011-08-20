<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<title>DEPTHS</title>
<link rel="stylesheet" href="../css/unitTemplate.css" type="text/css"/>
<script language="JavaScript" src="js/overlib_mini.js" type="text/javascript"></script>
<style type="text/css">
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

<% registrationBeanId.setLessonsFinished(false); %>





<body>
   <div id="overDiv" style="position:absolute; visibility:hidden; z-index:1000;"></div>
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
      <%unitTitle = registrationBeanId.getUnitTitleByOrdNum(si + 1);  %>
      <%unitId = registrationBeanId.getUnitIdByOrdNum(si + 1);  %>
      <a href="<%=request.getContextPath()%>/student/studentLessonSelection.jsp?conceptId=<%=concId%>&lessonId=<%=unitId %>">

        <%= unitTitle %></a>
		<br />

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
  <div id="headlines">
  </div><!--headlines-->
</div><!--navBar-->
<div id="content" class="column">

  <div id="previousNextLinks">
    <div id="breadCrumb">

      <a href="#">        &lt;&lt;
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

  <div class="story">
    <h2><font color="#0000FF"> <%=testBeanId.getMainTestMessage()%></font></h2>
      <p class=cp10><strong>Your knowledge level on this test is: <i><%=testBeanId.getTestKnowledgeLevel()%></i></strong>
        <a class="tiny" href="#" onmouseover="return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Student knowledge level', HAUTO, TIMEOUT, 10000);" onmouseout="return nd();"> (0-6) </a></p>
 <br />

      You have finish this test with: <strong><i><%=testBeanId.getTestPointsNumber()%></i></strong> points.
      <a class="tiny" href="#" onmouseover="return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Number of points on test', HAUTO, TIMEOUT, 10000);" onmouseout="return nd();">(0-100)</a><br />
      Maximum number of points on this test is: <strong><i><%=testBeanId.getTestDifficultyFactor()%></i></strong>.
      <a class="tiny" href="#" onmouseover="return overlib('This value depends on the difficulty of each question in the test', CAPTION, 'Maximum number of points', HAUTO, TIMEOUT, 10000);" onmouseout="return nd();">(0-100)</a><br />
      Your success on this test is: <strong><i><%=testBeanId.getTestSuccess()%> %</i></strong>.
      <a class="tiny" href="#" onmouseover="return overlib('This value shows your success on the test based on the number of solved questions', CAPTION, 'Test success', HAUTO, TIMEOUT, 10000);" onmouseout="return nd();">(0-100%)</a><br />
      You spent: <strong><i><%=testBeanId.getTestDuration()%> seconds </i></strong>to solve this test.
      <%! int numOfWrongAnsw; %>

      <%if (testBeanId.isInAddition()==false){%>

      <% if (testBeanId.getNumOfWrongAnsw()>0){%>

      <% numOfWrongAnsw = testBeanId.getNumOfWrongAnsw(); %>
      <p>&nbsp;</p>
      <p><em><strong>You didn't answer the following question(s):</strong> </em></p>
      <fieldset>

        <%for (int i=0;i<numOfWrongAnsw;i++){%>

          <p><%=(i+1)%>. <%= testBeanId.getWrongQuestContent(i+1)%></p>
          <p class="style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#0000FF">Correct answer:</font> <span class="style4"><%=  testBeanId.getWrongQuestTruthAnswer(i+1)%></span></p>




          <%}%>

        </fieldset>
        <p class="style3">&nbsp;</p>
        <p class="style4"><em><strong>Tutor recommends you to read again following lessons to reach better results:</strong> </em></p>
        <fieldset>
          <%for (int i=0;i<numOfWrongAnsw;i++){%>

            <p><%=(i+1)%>. <%= testBeanId.getTitleOfLessonToReLearn(i) %> </p>
            <% } %>
          </fieldset>
          <p>&nbsp;      </p>
          <p>To accept Tutor recommendation click &quot;Accept&quot;, other way click &quot;Decline&quot;. To save session and stop the Tutor click &quot;Exit &amp; Save&quot;. </p>
          <p>&nbsp;</p>

       <p>&nbsp;</p>
      <form id="form1" name="form1" method="post" action="assessmentHandler.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="declineButton" type="submit" value="Decline"/>
        &nbsp;&nbsp;
        <input name="acceptButton" type="submit" value="Accept" />
      </form>


      <p>&nbsp;</p>



      <%}else{%>
      <h2><font color="#000066;">
      Congratulations, you have answered all questions on this test!
      </font>

      </h2>

      <% testBeanId.startConceptAssessment(); %>
      <p>&nbsp;</p>
      <p>&nbsp;</p>

       <p>&nbsp;</p>

      <form id="form1" name="form1" method="post" action="excellentAnswersHandler.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
      </form>

      <p>&nbsp;</p>

      <%}%>
      <%}else if (testBeanId.isInAddition()){%>

       <% if (testBeanId.getNumOfWrongAnsw()>0){%>

        <% numOfWrongAnsw = testBeanId.getNumOfWrongAnsw(); %>


        <p>&nbsp;</p>
      <p><em><strong>You didn't answer the following question(s):</strong> </em></p>
      <fieldset>

      <%for (int i=0;i<numOfWrongAnsw;i++){%>

      <p><%=(i+1)%>. <%= testBeanId.getWrongQuestContent(i+1)%></p>
      <p class="style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#0000FF">Correct answer:</font> <span class="style4"><%=  testBeanId.getWrongQuestTruthAnswer(i+1)%></span></p>

      <%}%>
      </fieldset>
      <% }else {%>
      <h2><font color="#000066;">
      Congratulations, you have answered all questions this time!
      </font>

      </h2>
      <%}%>
       <% testBeanId.startConceptAssessment(); %>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
       <p>&nbsp;</p>

      <form id="form1" name="form1" method="post" action="getAction.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
      </form>
       <p>&nbsp;</p>





      <%}%>



  </div><!--story-->
</div><!--content-->
<!--end content -->

<!--end navbar -->
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

</html>
