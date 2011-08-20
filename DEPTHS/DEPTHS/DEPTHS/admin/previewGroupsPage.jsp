
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
<%@page import="depths.adminModule.DatabaseManager" %>
<%String hasPrivilegies=adminBeanId.getPrivilegies();
DatabaseManager dbManager=adminBeanId.getManagerReference();
  groupBeanId.setDbManagerRef(dbManager);%>
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
 <h1 style="margin:0">Welcome to the DEPTHS administrator's application</h1>

      <p>&nbsp;</p>
      <%if (hasPrivilegies.equals("Guest")) {        %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
     <%} %>
      <table width="596" border="2" bordercolor="#FFFFFF">
        <caption>
          Administrator's menu
          <br>
        </caption>
        <tr>
          <td width="166" height="26" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="adminRegistrationForm.jsp">Add new administrator </a></td>
          <td width="135" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="teacherRegistrationForm.jsp">Add new teacher </a></td>
          <td width="129" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="addNewCourse.jsp">Add new course </a></td>
          <td width="136" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="groupRegistrationForm.jsp">Add new class </a></td>
        </tr>
        <tr>
          <td height="24" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewAdminsPage.jsp">Preview administrators </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewTeachersPage.jsp">Preview teachers </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewCoursesPage.jsp">Preview courses </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewGroupsPage.jsp">Preview classes </a></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <table width="588" border="0">
        <tr>
          <td width="582"><div align="center" class="style9">Groups preview </div></td>
        </tr>
      </table>
      <%groupBeanId.readAllGroups(); %>
      <%int groupNumb=groupBeanId.getGroupsNumb(); %>
      <%!int i; %>
      <%for (i=0;i<groupNumb;i++){%>
        <%int id=groupBeanId.getGroupIdByOrdNum(i); %>
        <form name="form1" method="post" action="getPreviewGroupsPageAction.jsp?groupId=<%=id%>">
          <table width="596" border="2" bordercolor="#CCCCCC">
            <tr bordercolor="#FFFFFF">
              <td width="167" rowspan="4" bgcolor="#FFFFFF"><table width="200" border="0">
                <tr>
                  <td><strong>Group name: </strong><%=groupBeanId.getNewGroupDataByType("groupName",id) %></td>
                </tr>

                <%Vector administratorsIds=groupBeanId.getNewGroupVectorData("administrators",id); %>
                <%int adminNumb=administratorsIds.size(); %>
                <tr>
                  <td><strong>Group administrators:</strong>
                  </td>
                </tr>
                <%for (int i=0;i<adminNumb;i++){ %>
                  <%String admId=administratorsIds.get(i).toString(); %>
                  <tr>
                    <td>&nbsp;&nbsp; <%=adminBeanId.getAdminDataById("firstName",admId) %>
                      &nbsp;<%=adminBeanId.getAdminDataById("lastName",admId) %><br/>
                    </td>
                  </tr>
                  <%} %>
                    <%Vector teachersIds=groupBeanId.getNewGroupVectorData("teachers",id); %>
                <%int teachersNumb=teachersIds.size(); %>
                <tr>
                  <td><strong>Group teachers:</strong>
                  </td>
                </tr>
                <%for (int i=0;i<teachersNumb;i++){ %>
                  <%String teachId=teachersIds.get(i).toString(); %>
                  <tr>
                    <td>&nbsp;&nbsp;  <%=adminBeanId.getTeacherDataByTeacherId("firstName",teachId) %>
                      &nbsp;<%=adminBeanId.getTeacherDataByTeacherId("lastName",teachId) %><br />
                    </td>
                  </tr>
                  <%} %>
                  <tr>
                  <td><strong>Group language:</strong>
                  </td>
                </tr>
                  <tr>
                    <td>&nbsp;&nbsp;  <%=groupBeanId.getNewGroupLanguage(id) %>

                    </td>
                  </tr>
              </table></td>
              <td height="22" bgcolor="#FFFFFF">&nbsp;</td>
              <td bgcolor="#FFFFFF">&nbsp;</td>
              <td bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
            <tr bordercolor="#FF0000">
              <td height="57" rowspan="2" bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
              <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><p>
                <input name="Remove" type="submit" id="  Remove  " value="  Remove  ">
              </p>            </td>
                <td rowspan="2" bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
              <tr bordercolor="#FF0000">
                <td height="22" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
                  <input type="submit" name="Edit" value="Edit profile"></td>
            </tr>
                <tr bordercolor="#FF0000">
                  <td width="28" bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
                  <td width="83" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><label></label>              <label></label></td>
                  <td width="288" bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
                </tr>
          </table>
              <br/>



      </form>
            <%} %>

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
