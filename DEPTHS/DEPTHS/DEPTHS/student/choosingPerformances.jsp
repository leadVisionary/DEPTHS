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
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session"></jsp:useBean>

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

	  <form name="form1" method="post" action="settingPerformances.jsp">
	  <table width="80%" align="center">
	  <tr>
	    <td colspan="4" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><strong>Choose your performances and display properties:</strong></td>
	    </tr>
	  <tr>
	    <td colspan="2" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;
          <p>Select your knowledge level:          </p>
          <p>
          <label>
          <input type="radio" name="knowledgeLevelRadioGroup" value="Begginer" checked="checked">
Begginer</label>
          <br>
          <label>
          <input type="radio" name="knowledgeLevelRadioGroup" value="Intermediate">
Intermediate</label>
          <br>
          <label>
<input type="radio" name="knowledgeLevelRadioGroup" value="Advanced">
Advanced</label>
        <br>
        </p>
        <p>Select your detail level: </p>
        <p>
          <label>
          <input type="radio" name="detailLevelRadioGroup" value="Low" checked="checked">
Low</label>
          <br>
          <label>
          <input type="radio" name="detailLevelRadioGroup" value="Middle">
Middle</label>
          <br>
          <label>
          <input type="radio" name="detailLevelRadioGroup" value="High">
High</label>
          <br>
        </p>



        <p>

</p>





		</td>
	    <td colspan="2" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><p>&nbsp;</p>
	      <p>Select programming language:</p>	      <p>
          <label>
          <input type="radio" name="programmingLanguageRadioGroup" value="Java" checked="checked">
Java</label>
          <br>
          <label>
          <input type="radio" name="programmingLanguageRadioGroup" value="CPP">
C++</label>
	      <p>&nbsp;</p>
	      <p>Select display form:  </p>
	      <p>
          <label>
          <input type="radio" name="formRadioGroup" value="GoF" checked="checked">
GoF Form</label>
          <br>
          <label>
          <input type="radio" name="formRadioGroup" value="coplienForm">
Coplien Form</label>
          <p>
          </td>
	  </tr>
	  <tr>
	    <td width="39%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;
	       </td>
	    <td width="17%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">
             </td>
	    <td width="44%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;</td>
	  </tr><tr>
	    <td width="39%" style="padding-top:4;padding-bottom:4">&nbsp;
	       </td>
	    <td width="17%" style="padding-top:4;padding-bottom:4">
              <input type="submit" name="Submit" value="Submit"></td>
	    <td width="44%" style="padding-top:4;padding-bottom:4">&nbsp;</td>
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
