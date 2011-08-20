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
<%!String teacherId;%>
<%!int teachId; %>
<%!String hasPrivilegies; %>
<%teacherId = request.getParameter("teacherId");%>
<%Integer x=new Integer(teacherId); %>
<%teachId=x.intValue(); %>
<%hasPrivilegies=adminBeanId.getPrivilegies(); %>

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
<h1 style="margin:0">Teacher's account information </h1>
      <p style="margin:0">&nbsp;</p>
      <%if (hasPrivilegies.equals("Guest")) {        %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
     <%} %>
      <table width="625" height="357" border="0">
        <tr>
          <td colspan="4"><span class="style8">Member information:</span> </td>
        </tr>
        <tr>
          <td width="161">&nbsp;</td>
          <td ><div align="right"><strong>First name:</strong></div></td>

          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("firstName",teacherId)%></td>

        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Last name: </strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("lastName",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Username:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("userName",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Password</strong></div></td>
          <td colspan="2">&nbsp;*************</td>
        </tr>
        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="4"><span class="style8">Address/Contact information:</span> </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Email:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("email",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Address:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("address",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>City:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("city",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Country:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("countryId",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Organisation:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("organisation",teacherId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Language:</strong></div></td>
          <td colspan="2">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("languageId",teacherId)%></td>
        </tr>
        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="4"><span class="style8">Profile information: </span></td>
        </tr>

          <%adminBeanId.getTeacherPrivilegies(teachId); %>
          <%int privNumb=adminBeanId.getTeacherPrivilegiesNumb(); %>
          <tr>
            <td>&nbsp;</td>

                  <td><div align="right"><strong>privilegies:</strong> </div></td>
                </tr>
                <%for (int i=0;i<privNumb;i++){ %>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><div align="left">&nbsp;&nbsp;<%=adminBeanId.getTeachPrivByOrdNumb(i) %>
                    </div></td>
                  </tr>
                  <%} %>
        <tr>
          <td height="25">&nbsp;</td>
          <td>&nbsp;</td>
          <td colspan="2">&nbsp;</td>
          <td width="88"><a href="editTeacherProfilePage.jsp?teacherId=<%=teacherId%>">Edit</a></td>
        </tr>
        <tr>
      <td align=center colSpan=4><form action="buttonsAction.jsp" method="get" >
	  <input type="submit" name="previewTeachersButton" value="Back" >
        <input type="submit" name="adminWelcomeButton" value="Main menu">
	  </form>

      </td>
      </tr>
      </table>

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
