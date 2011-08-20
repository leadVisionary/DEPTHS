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
<jsp:useBean id="adminBeanId" class="depths.presentationModule.admin.AdminBean" scope="session">
</jsp:useBean>
<%!String teacherUserName; %>
<%teacherUserName=request.getParameter("teacherUserName"); %>


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
  <h1 id="pageName">Welcome to the DEPTHS administrator's page </h1>
  <div class="story">

 <h2>&nbsp;</h2>

	  <form name="form1" method="post" action="settingNewAdminPerformances.jsp?teacherUserName=<%=teacherUserName%>">
	  <table width="100%">
	  <tr>
	    <td colspan="3" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">
              <strong>Choose settings for new administrator:</strong></td>
	    </tr>
	  <tr>
	    <td height="179" colspan="2" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">
	     <p>Choose privilegies to allow for new administrator:</p>
        <p>
          <label>
          <input type="radio" name="privilegiesRadioGroup" value="Full" checked="checked">
          Full
</label>
          <br>
          <label>
          <input type="radio" name="privilegiesRadioGroup" value="Limited">
          Limited
</label>
          <br>
          <label>
          <input type="radio" name="privilegiesRadioGroup" value="Guest">
          Guest
</label>
          <br>
        </p>


          <p>

</p>





		</td>
	    <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><p>&nbsp;</p>
	      <p>&nbsp;</p>	      </td>
	  </tr>
	  <tr>
	    <td width="39%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;
	       </td>
	    <td width="17%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"> <input type="submit" name="Submit" value="Submit"></td>
	    <td width="44%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;</td>
	  </tr>


</table>
</form>






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
