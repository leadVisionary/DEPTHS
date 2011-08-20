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
<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%@page import="java.util.Vector"%>
<%String studId=request.getParameter("studentId");%>
<%Integer stId=new Integer(studId);
int studentId=stId.intValue();
%>

<body>

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

     <a href="editMyProfilePage.jsp" >Edit my profile</a>

	<br />


  </div><!--sectionLinks-->
  <div id="search">
    <br/>
    <br/>
    <label>Passed concepts</label>
  </div> <!--search-->
  <div id="sectionLinks">




  <a href="bla bla" >bla bla
    </a><br />


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


    </div><!--breadCrumb-->
    <div id="breadCrumb2">


    </div>
  </div><!--previousNextLinks-->
  <br/>
  <br/>

  <div class="story">

 <h1 style="margin:0">New student created successfully</h1>
      <h2>New student performances : </h2>
      <p><br/>
        First name: <strong><%=teacherBeanId.getStudentDataByType("firstName",studentId) %></strong>
        <br/>
        Last name: <strong><%=teacherBeanId.getStudentDataByType("lastName",studentId) %></strong>
        <br/>
        User name: <strong><%=teacherBeanId.getStudentDataByType("userName",studentId)  %></strong>
        <%--Vector courses=teacherBeanId.getNewAssistantPrivilegies(studentId); --%>
        <br/>
        <%String gId=teacherBeanId.getStudentDataByType("groupId",studentId); %>
<%Integer grId=new Integer(gId); %>
<%int groupId=grId.intValue(); %>
       Group: <strong><%=teacherBeanId.getGroupNameById(groupId) %></strong>

      <br />



      <form name="form1" method="post" action="teacherWelcomeScreen.jsp">
        <input type="submit" name="nextButton" value="Back to the main menu">
      </form>

             <p>&nbsp; </p>








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
