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
<%@page import="java.util.Vector" %>
<%!Vector privilegies; %>
<%privilegies=teacherBeanId.getTeacherPrivilegies(); %>


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
  <h1 id="pageName">Welcome to the DEPTHS teacher's page </h1>
  <div class="story">


       <p>&nbsp;</p>
      <%if (privilegies.isEmpty()) {        %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
      <br />
     <%} %>

      <table width="616" border="2" bordercolor="#FFFFFF">
        <caption>
          Teacher's menu
          <br>
        </caption>
        <tr>
          <td width="144" height="26" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="assistantRegistrationForm.jsp">Add new assistant </a></td>
          <td width="138" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="studentRegistrationForm.jsp">Add new student </a></td>
          <td width="199" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewGroupStatisticPage.jsp">Preview groups' statistics  </a></td>
          <td width="105" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="groupRegistrationForm.jsp">Edit course  </a></td>
        </tr>
        <tr>
          <td height="24" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewAssistantsPage.jsp">Preview assistants </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewStudentsPage.jsp">Preview students </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="studentsConceptsStatisticPage.jsp">Preview students' performance </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewGroupsPage.jsp">Preview course </a></td>
        </tr>
      </table>







      <p>&nbsp;</p>
<p>&nbsp;</p>
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
