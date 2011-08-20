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
</head>
<!-- JSP code -->
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session"></jsp:useBean>
<jsp:useBean id="statisticBeanId" class="depths.presentationModule.StatisticBean" scope="session">
</jsp:useBean>
<%@ page import="depths.coordinator.Tutor" %>
<body>
<%! Tutor ref;%>
<%! int numOfPassedConcepts=0; %>
<%! String concId=""; %>
<%! double degreeOfMastery=0; %>
<%! int hours=0, min=0, sec=0; %>
<%! String actualSkillLevelText=new String(); %>
<%! String title=new String(); %>
<%! String slider=new String(); %>
<%! String slider2; %>
<%! String markText=new String(); %>
<% ref=registrationBeanId.sendTutorRefToStatBean(); %>
<% statisticBeanId.setTutorRef(ref); %>
<% statisticBeanId.getNumOfPassedConcFromSM();%>
<% numOfPassedConcepts=statisticBeanId.getNumberOfPassedConcepts(); %>

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
  <a href="concepts_chart.jsp" >Concept's statistic charts </a>
  <br />
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
    <h2>Concepts' statistics: </h2>
<% if (numOfPassedConcepts==0){ %>
      There is no passed concepts.
      <%}else{%>
      <% for (int i=0;i<numOfPassedConcepts;i++){%>

        <% statisticBeanId.addPassedConceptFromSM(i); %>
        <% concId=statisticBeanId.getConcId(); %>
 <% title=statisticBeanId.getConcTitle(); %>
        <% hours=statisticBeanId.getHours(); %>
        <% min=statisticBeanId.getMin(); %>
        <% sec=statisticBeanId.getSec(); %>

		 <% degreeOfMastery=statisticBeanId.getConcDegreeOfMastery(); %>
        <% actualSkillLevelText=statisticBeanId.getActualSkillLevelText(); %>
        <% slider2=statisticBeanId.getSlider2Val(); %>

      <table width="576" border="1" cellpadding="2" bordercolor="#FFFFFF">
        <tr>
          <td colspan="3" bordercolor="#FFFFFF"><div align="center">
            <p class="style3"><strong><%=title %></strong> </p>
          </div></td>
        </tr>
        <tr>
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
          <% }else if (degreeOfMastery<5.0){%>
            <% slider="slider_4.jpg";%>
            <% markText="Excellent";%>
            <% }else {%>
            <% slider="slider_5.jpg";%>
            <% markText="Expert";}%>
          <td colspan="2"><%= markText %> </td>
        </tr>
        <tr>
          <td bordercolor="#FFFFFF">Duration: </td>
          <td colspan="2"><strong><%=hours%>&nbsp;hr&nbsp;&nbsp;<%=min%>&nbsp;min&nbsp;&nbsp;<%=sec%>&nbsp;sec&nbsp;&nbsp;</strong></td>
        </tr>

        <tr>

          <td bordercolor="#FFFFFF">Degree of mastery: </td>

          <td width="140"><img src="images/<%=slider%>" width="141" height="14"></td>

          <td width="202"><strong><%= markText %></strong></td>
        </tr>

        <tr>
          <td bordercolor="#FFFFFF">Actual knowledge level:</td>
           <td width="140"><img src="images/<%=slider2%>" width="141" height="14"></td>
          <td colspan="2"><strong><%=actualSkillLevelText%></strong></td>
        </tr>
        <tr>
          <td bordercolor="#FFFFFF">&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="lessonsStatisticPage.jsp?conceptId=<%=concId%>">More details >></a></td>
        </tr>
      </table>

	 <p style="margin:0">&nbsp; </p>
      <%}%>
      <p style="margin:0">&nbsp;</p>
      <%}%>
      <p style="margin:0">&nbsp;</p>
      <p style="margin:0">&nbsp;</p>      <blockquote>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <p align="center"><a href="closeThisWindow" class="style3" onClick="window.close();">Close</a></p>
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
