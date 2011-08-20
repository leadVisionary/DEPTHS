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
<jsp:useBean id="groupBeanId" class="depths.presentationModule.admin.GroupBean" scope="session">
</jsp:useBean>
<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%!String grId; %>

<%grId=request.getParameter("groupId"); %>

<%Integer x=new Integer(grId); %>

<%int groupId=x.intValue(); %>

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

      <a href="getNext.jsp?nextButton=next">        Next
        &gt;&gt;
</a>
    </div>
  </div><!--previousNextLinks-->
  <br/>
  <br/>

  <div class="story">

 <h1 style="margin:0">New group created successfully</h1>
      <h2>New group data : </h2>
      <p><br/>

        Group name: <strong><%=groupBeanId.getNewGroupDataByType("groupName",groupId) %></strong>
        <br/>
        <%!java.util.Vector administrators; %>

        <%administrators=groupBeanId.getNewGroupVectorData("administrators",groupId); %>

        Administrators:
        <%for (int i=0;i<administrators.size();i++){ %>
         <%String adminId=administrators.get(i).toString(); %>
        <strong><%=adminBeanId.getAdminDataById("firstName",adminId) %>&nbsp;
        <%=adminBeanId.getAdminDataById("lastName",adminId) %>,&nbsp;</strong>

         <%} %>

        <br/>
        <%!java.util.Vector teachers; %>
        <%teachers=groupBeanId.getNewGroupVectorData("teachers",groupId); %>

        Teachers:
        <%for (int i=0;i<teachers.size();i++){ %>
         <%String teachId=teachers.get(i).toString(); %>
        <strong><%=adminBeanId.getTeacherDataByTeacherId("firstName",teachId) %>&nbsp;
         <%=adminBeanId.getTeacherDataByTeacherId("lastName",teachId) %>,&nbsp;</strong>
        <%} %>
        <br/>
        <%!java.util.Vector courses; %>
        <%courses=groupBeanId.getNewGroupVectorData("courses",groupId); %>

        Courses:
        <%for (int i=0;i<courses.size();i++){ %>
         <%String courseId=courses.get(i).toString(); %>
        <strong><%=adminBeanId.getCourseName(courseId)%>,&nbsp;</strong>

         <%} %>
        <br />
		Language:

        <strong><%=groupBeanId.getNewGroupLanguage(groupId) %>&nbsp;</strong>


        <br />
		Description:

        <strong><%=groupBeanId.getNewGroupDataByType("description",groupId )%>&nbsp;</strong>


        <br />
      </p>
      <form name="form1" method="post" action="adminWelcomeScreen.jsp">
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
