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
<jsp:useBean id="groupBeanId" class="depths.presentationModule.admin.GroupBean" scope="session">
</jsp:useBean>
<%@page import="java.util.Vector" %>
<%!String grId;%>
<%!int groupId; %>
<%!String hasPrivilegies; %>
<%grId = request.getParameter("groupId");%>
<%Integer x=new Integer(grId); %>
<%groupId=x.intValue(); %>
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

      <p>&nbsp;</p>
      <table width="625" height="357" border="0">
        <tr>
          <td colspan="4"><span class="style8">Group information:</span> </td>
        </tr>
        <tr>
          <td width="161">&nbsp;</td>
          <td ><div align="right"><strong>Group name:</strong></div></td>

          <td colspan="2">&nbsp;<%=groupBeanId.getNewGroupDataByType("groupName",groupId) %></td>

        </tr>

        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Description:</strong></div></td>
          <td colspan="2">&nbsp;<%=groupBeanId.getNewGroupDataByType("description",groupId) %></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Language:</strong></div></td>
          <td colspan="2">&nbsp;<%=groupBeanId.getNewGroupLanguage(groupId) %></td>
        </tr>
        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="4"><span class="style8">Administrators/Teachers information:</span> </td>
        </tr>
        <%Vector administratorsIds=groupBeanId.getNewGroupVectorData("administrators",groupId); %>
                <%int adminNumb=administratorsIds.size(); %>

        <tr>
          <td rowspan="<%=adminNumb+1%>">&nbsp;</td>
          <td rowspan="<%=adminNumb+1%>"><div align="right"><strong>Administrators: </strong></div></td>


          <%for (int i=0;i<adminNumb;i++){ %>
            <%String admId=administratorsIds.get(i).toString(); %>
             <tr>
               <td colspan="<%=adminNumb+1%>">
              &nbsp;<%=adminBeanId.getAdminDataById("firstName",admId) %>
              &nbsp;<%=adminBeanId.getAdminDataById("lastName",admId) %><br/>
              </td>
             </tr>
            <%} %>


        </tr>
        <%Vector teachersIds=groupBeanId.getNewGroupVectorData("teachers",groupId); %>
                <%int teachersNumb=teachersIds.size(); %>
        <p>&nbsp;</p>
        <tr>
          <td rowspan="<%=teachersNumb+1%>">&nbsp;</td>
          <td rowspan="<%=teachersNumb+1%>"><div align="right"><strong>Group teachers: </strong></div></td>
          <%for (int i=0;i<teachersNumb;i++){ %>
                  <%String teachId=teachersIds.get(i).toString(); %>
                  <tr>
          <td colspan="<%=teachersNumb+1%>">&nbsp;<%=adminBeanId.getTeacherDataByTeacherId("firstName",teachId) %>
          &nbsp;<%=adminBeanId.getTeacherDataByTeacherId("lastName",teachId) %><br/>
        </td>
        </tr>
        <%} %>
        </tr>

        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="4"><span class="style8">Courses information: </span></td>
        </tr>
<%Vector coursesIds=groupBeanId.getNewGroupVectorData("courses",groupId); %>
                <%int coursesNumb=coursesIds.size(); %>

        <tr>
          <td rowspan="<%=coursesNumb+1%>">&nbsp;</td>
          <td rowspan="<%=coursesNumb+1%>"><div align="right"><strong>Courses: </strong></div></td>


          <%for (int i=0;i<coursesNumb;i++){ %>
            <%String courseId=coursesIds.get(i).toString(); %>
             <tr>
               <td colspan="<%=coursesNumb+1%>">
              &nbsp;<%=adminBeanId.getCourseName(courseId) %>
              <br/>
              </td>
             </tr>
            <%} %>


        </tr>


                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td colspan="2">&nbsp;</td>
                    <td width="88"><a href="editGroupProfilePage.jsp?groupId=<%=groupId%>">Edit</a></td>

                  </tr>

        <tr>
          <td height="25">&nbsp;</td>
          <td>&nbsp;</td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
      <td align=center colSpan=4>
        <form action="buttonsAction.jsp" method="get" >

          <input type="submit" name="previewGroupsButton" value="Back" >
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
