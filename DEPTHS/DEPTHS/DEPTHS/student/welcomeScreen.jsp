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

    <a href="bla bla">bla bla

    </a>

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
  <h1 id="pageName">Welcome to the DEPTHS learning system </h1>
  <div class="story">
<div style="margin-left:80px;">
<h2>Your current performances : </h2>

      <p>Your username: <strong><%=registrationBeanId.getUserName()%></strong></p>
      <p>Your current skill level:<strong><jsp:getProperty name="registrationBeanId" property="knowledgeLevel"/></strong></p>
      <p>Your detail level:<strong> <jsp:getProperty name="registrationBeanId" property="detailLevel"/></strong> </p>
      <p>Your programming language:<strong> <jsp:getProperty name="registrationBeanId" property="programmingLanguage"/></strong> </p>
      <p>&nbsp;</p>
	  </div>
      <%registrationBeanId.setCourseData(); %>






      <form id="form1" name="form1" method="post" action="getAction.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="exitButton" type="submit" value="Save & Exit"/>
        &nbsp;&nbsp;
        <input name="nextButton" type="submit" value="Next >" />
      </form>

    <div id="bellowForm">
      <p>&nbsp;</p>
    </div><!--bellowForm-->
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
