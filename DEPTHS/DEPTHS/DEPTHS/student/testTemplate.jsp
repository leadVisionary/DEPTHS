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

<%testBeanId.setStarted(new java.util.Date()); %>
 <%! int numOfConceptsToLearn, numOfUnits; %>
        <%! String currConcId; %>
         <%! String concId; %>
          <%currConcId=registrationBeanId.readCurrConcID(); %>
           <% numOfConceptsToLearn=registrationBeanId.getNumOfConceptsToLearn();%>
        <% numOfUnits=registrationBeanId.getNumOfUnitsToLearni();%>

<body>

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
      <a href="#">

        <%= unitTitle %></a>
		<br />

        <%}  %>
	<strong><a href="#">Questionnaire</a></strong><br/>
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
  <h1 id="pageName"><%= registrationBeanId.getCurrConceptTitle()%></h1>
  <div class="story">

     <h2>Answer the following questions by selecting correct answer. </h2>
        <%! int i; %>
        <%! int numOfQuestions; %>
        <%! int numOfAnswers; %>
        <%! String n; %>
        <% registrationBeanId.startTestInSM();%>
        <% numOfQuestions = registrationBeanId.getNumOfQuestionsInPlan(); %>
        <% if ((numOfQuestions==0)||(numOfQuestions>0)){ %>
     <form id="form1" name="form1" method="post" action="getTestAction.jsp">
        <!--form name="form1" method="post" action="getTestAction.jsp"-->


           <% for (i=0;i<numOfQuestions;i++){%>
             <% registrationBeanId.getQuestionByOrdNum(i); %>
             <%  n=String.valueOf(i);%>
             <p> </p>
             <label> <%=i+1%>. <%=registrationBeanId.getQuestionContent() %> </label>
             <% numOfAnswers = registrationBeanId.getNumbOfAnswers(); %>
           <br/>
        <table width="578" height="94" border="1" cellpadding="2" bordercolor="#FFFFFF">

               <% for (int s=0;s<numOfAnswers;s++){ %>
<tr>
<td height="28" width="15"><div align="center">

  <input name=<%=n%> type="radio" class="style3" value=<%=s%> >
    </div></td>
  <td><label><span class=""style5"><%=registrationBeanId.getAnswerContent(s) %>
  </span></label>
  <span class="style5"></span></td>
  </tr>

	<%}%>
</table>
   <%}%>
   <p>&nbsp;</p>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
      </form>
      <%} else { %>
           <p>&nbsp;</p>

      <form name="form1" method="post" action="exceptionPage.jsp">
      We are sorry, but there is no more questions in our knowledge base.
      <p> </p>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
      </form>

    <%} %>

      <p>&nbsp;</p>



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
