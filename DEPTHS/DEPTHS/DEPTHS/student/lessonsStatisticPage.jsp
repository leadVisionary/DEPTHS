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
<script language="javascript1.2" src="js/overlib_mini.js" type="text/javascript"></script>
<script language="javascript" src="js/matching_columns.js" type="text/javascript"></script>
</head>
<!-- JSP code -->
<jsp:useBean id="statisticBeanId" class="depths.presentationModule.StatisticBean" scope="session"></jsp:useBean>
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session"></jsp:useBean>
<body>
<div id="overDiv" style="position:absolute; visibility:hidden; z-index:1000;"></div>
<%! int numOfLessons,numOfTests; %>
<%! String conceptId; %>
 <%! int numOfQuest;%>
<%conceptId=request.getParameter("conceptId"); %>
<%! double degreeOfMastery=0.0,testDegreeOfMastery=0.0; %>
<%! int hours=0, min=0, sec=0; %>
<%! String actualSkillLevelText=new String(); %>
<%! String title=new String(); %>
<%! String slider=new String(); %>
<%! String markText=new String(); %>
<%! String testDegreeOfMarkText;%>
<%! String slider2; %>
<%! String slider3=new String(); %>

<div id="page">
<DIV id=masthead>
<DIV id=globalNav><a href="#">Performance</a> |
<a href="#">Statistic</a> |
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
    <label>Links</label>
  </div><!--search-->
  <div id="sectionLinks">
  <a href="conceptStatisticPage.jsp" >Concept's statistics </a><br />
  <a href="concepts_chart.jsp" >Concept's statistic charts </a><br />
	<br />

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

  <a href="lessonsStatisticPage.jsp?conceptId=<%=registrationBeanId.getPassedConceptIdByOrdNum(i)%>" >
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


  <br/>
  <br/>
  <h1 id="pageName">Concept statistic page </h1>

  <div class="story">
    <% statisticBeanId.getConceptById(conceptId); %>
    <h2 style="margin:0"><%=statisticBeanId.getConcTitle()%></h2>
      <p style="margin:0">&nbsp;</p>      <p style="margin:0">&nbsp;</p>
	  <table width="576" border="1" cellpadding="2" bordercolor="#FFFFFF">


        <tr>
          <td colspan="3" bordercolor="#FFFFFF"><div align="center">
            <p class="style3"> </p>
          </div></td>
        </tr>
        <tr>
            <% degreeOfMastery=statisticBeanId.getConcDegreeOfMastery();%>
          <td width="146" bordercolor="#FFFFFF">Feedback message: </td>
          <% if (degreeOfMastery<1.5){%>
          <%  slider="slider_1.jpg";%>
           <% markText="Bad";%>
          <% }else if(degreeOfMastery<2.5){%>
            <% slider="slider_2.jpg";%>
            <% markText="Not bad";%>
          <% }else if (degreeOfMastery<3.5){%>
            <% slider="slider_3.jpg";%>
            <%markText="Good";%>
          <% }else if (degreeOfMastery<4.5){%>
            <% slider="slider_4.jpg";%>
            <% markText="Very good";%>
          <% }else {%>
            <% slider="slider_5.jpg";%>
            <% markText="Excellent";}%>

          <td colspan="2"><%=markText%> </td>
        </tr>
        <tr>
          <td bordercolor="#FFFFFF">Duration: </td>
          <td colspan="2"><strong><%=statisticBeanId.getHours()%>&nbsp;hr&nbsp;<%=statisticBeanId.getMin()%>&nbsp;min&nbsp;<%=statisticBeanId.getSec()%>&nbsp;sec &nbsp; </strong> </td>
        </tr>
        <tr>
          <td bordercolor="#FFFFFF">Degree of mastery: </td>

          <% slider2=statisticBeanId.getSlider2Val(); %>
          <% actualSkillLevelText=statisticBeanId.getActualSkillLevelText(); %>

          <td width="200"><img src="images/<%=slider%>" width="141" height="14"></td>
          <td width="202"><strong><%=markText%></strong></td>
        </tr>
        <tr>
          <td bordercolor="#FFFFFF">Actual knowledge level: </td>
          <td width="140"><img src="images/<%=slider2%>" width="141" height="14"> </td>
          <td colspan="2"><strong><%=actualSkillLevelText%></strong></td>

        </tr>
        <tr>
          <td bordercolor="#FFFFFF">&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>      <p style="margin:0">&nbsp; </p>
      <p style="margin:0">&nbsp;</p>
      <p style="margin:0; font-weight: bold;">Passed lessons:</p>
       <%numOfLessons=statisticBeanId.getNumbOfLessons();%>

      <p style="margin:0; font-weight: bold;">&nbsp;</p>



      <table width="89%" height="0%" border="1" cellpadding="2" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
        <%!int numOfPass; %>
      <% for (int k=0;k<numOfLessons;k++){%>

        <tr>
         <td height="23%" width="8%"><div align="center"><%=(k+1)%>.</div> </td>
         <%numOfPass=statisticBeanId.getLessonNumberOfPassess(k);%>
          <td><%=statisticBeanId.getLessonTitle(k)%>
          <%if (numOfPass>1){ %>
          <a class="tiny" href="#" onMouseOver="return overlib('This value shows if lesson has been passed more than once.', CAPTION, 'Number of passess', HAUTO, TIMEOUT, 10000);" onMouseOut="return nd();">(<%=numOfPass%>)</a>
         <%} %>

          </td>

        </tr>

         <%}%>
      </table>
       <%numOfTests=statisticBeanId.getNumbOfTests();%>
      <%statisticBeanId.setConceptForStatPage(conceptId);%>
        <% for (int i=0;i<numOfTests;i++){%>
        <%statisticBeanId.setStatisticTest(i);%>

      <p style="margin:0; font-weight: bold;">&nbsp;</p>
      <p><strong>Test <%=(i+1)%>:</strong></p>
        <% numOfQuest=statisticBeanId.getNumbOfQuestions();%>

      <table width="89%" height="0%" border="1" cellpadding="2" bordercolor="#FFFFFF">
        <tr>
          <th width="7%" height="26%"><div align="center"></div></th>
          <th width="61%"><div align="left" class="style3">
            <font size="1">
            <div align="left">Question</div>
            </font>
          </div></th>
          <th width="32%"><div align="left" class="style3">
            <font size="1">
            <div align="center">Your answer was: </div>
            </font>
          </div></th>
        </tr>
         <% for (int q=0; q<numOfQuest; q++){%>
        <%statisticBeanId.getQuestionDataFromSM(q);%>

        <tr>
          <td height="23%"><div align="center"> <%=(q+1)%>.</div></td>
          <td><%=statisticBeanId.getQuestContent()%>  </td>
          <td><div align="center"><span class="style7"><font color="#006633"><%=statisticBeanId.isQuestTruth()%></font></span></div></td>
        </tr>
          <%}%>


        <tr>
          <td height="24">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="style7">&nbsp;</td>
        </tr>
      </table>
      <span class="style8"> </span>

<% testDegreeOfMastery=statisticBeanId.getTestDegreeOfMastery();%>

 <% if (testDegreeOfMastery<1.5){%>
          <%  slider3="slider_1.jpg";%>
           <% testDegreeOfMarkText="Bad";%>
          <% }else if(testDegreeOfMastery<2.5){%>
            <% slider3="slider_2.jpg";%>
            <% testDegreeOfMarkText="Not bad";%>
          <% }else if (testDegreeOfMastery<3.5){%>
            <% slider3="slider_3.jpg";%>
            <%testDegreeOfMarkText="Good";%>
          <% }else if (testDegreeOfMastery<4.5){%>
            <% slider3="slider_4.jpg";%>
            <% testDegreeOfMarkText="Very good";%>
          <% }else if (testDegreeOfMastery<5.0){%>
            <% slider3="slider_4.jpg";%>
            <% testDegreeOfMarkText="Excellent";%>
            <% }else {%>
            <% slider3="slider_5.jpg";%>
            <% testDegreeOfMarkText="Expert";}%>



      <table width="578" border="1" cellpadding="2" bordercolor="#FFFFFF">

        <tr>
          <td scope="row">Test degree of mastery: </td>

          <td width="47"><strong><%=testDegreeOfMarkText%></strong></td>
          <td width="218"><img src="images/<%=slider3%>" width="141" height="14"></td>
        </tr>
        <tr>
          <td scope="row">Your knowledge level on this test: </td>
          <td width="47" ><strong><%=statisticBeanId.getTestDegreeOfMastery() %></strong></td>
          <td width="218">
            <a class="tiny" href="#" onMouseOver="return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Student knowledge level', HAUTO, TIMEOUT, 10000);" onMouseOut="return nd();">(0-6)</a></strong></td>
        </tr>
        <tr>
          <td scope="row">You have finish this test with: </td>
          <td width="47" ><strong><%=statisticBeanId.getTestPointsNumber() %></strong></td>
          <td width="218">points. <a class="tiny" href="#" onMouseOver="return overlib('This value has been calculated using Fuzzy logic, based on the student success on the test, test difficulty and time spent for solving test', CAPTION, 'Number of points', HAUTO, TIMEOUT, 10000);" onMouseOut="return nd();">(0-100)</a></strong></td>
        </tr>
        <tr>
          <td scope="row">Maximum number of points on this test is: </td>
          <td width="47" ><strong><%=statisticBeanId.getTestDifficultyFactor() %></strong></td>
          <td width="218">points. <a class="tiny" href="#" onMouseOver="return overlib('This value depends on the difficulty of each question in the test', CAPTION, 'Maximum number of points', HAUTO, TIMEOUT, 10000);" onMouseOut="return nd();">(0-100)</a></strong></td>
        </tr>
        <tr>
          <td scope="row">Your success on this test is: </td>
          <td width="47" ><strong><%=statisticBeanId.getTestSuccess() %></strong></td>
          <td width="218">%. <a class="tiny" href="#" onMouseOver="return overlib('This value shows your success on the test based on the number of solved questions', CAPTION, 'Test success', HAUTO, TIMEOUT, 10000);" onMouseOut="return nd();">(0-100)</a></strong></td>
        </tr>
        <tr>
          <td width="165" scope="row"><p align="left">Test solving duration: </p></td>
          <td width="47" ><strong><%=statisticBeanId.getTestDuration()%></strong></td>
          <td width="218">seconds.</strong></td>
        </tr>
        <tr>
          <td scope="row">&nbsp;</td>
          <td colspan="2">&nbsp;</td>
        </tr>
      </table>
	  <%}%>
<p style="margin:0">&nbsp;</p>      <blockquote>
         <p align="center"><a href="conceptStatisticPage.jsp" class="style3">Back</a>
           &nbsp;&nbsp;&nbsp;<a href="" class="style3" onclick="window.close();">Close</a></p>
      </blockquote>
              <p>&nbsp;</p>



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
