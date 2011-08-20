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
<%!Vector privilegies;%>
<%privilegies = teacherBeanId.getTeacherPrivilegies();%>

<%!String hasPrivilegies;%>
<%if (privilegies.isEmpty()){
  hasPrivilegies="Guest";
}else{
  hasPrivilegies="Limited";
  int privNumb=privilegies.size();
}%>

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
 <h1 style="margin:0">Welcome to the DEPTHS teacher's application</h1>

      <p>&nbsp;</p>
      <%if (hasPrivilegies.equals("Guest")) {        %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
     <%} %>
      <table width="616" border="2" bordercolor="#FFFFFF">
        <caption>
          Teacher's menu
          <br>
        </caption>
        <tr>
          <td width="144" height="26" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="assistantRegistrationForm.jsp">Add new assistant </a></td>
          <td width="138" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="studentRegistrationForm.jsp">Add new student </a></td>
          <td width="199" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewGroupStatisticPage.jsp">Preview  statistics  </a></td>
          <td width="105" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="groupRegistrationForm.jsp">Edit course  </a></td>
        </tr>
        <tr>
          <td height="24" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewAssistantsPage.jsp">Preview assistants </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewTeachersPage.jsp">Preview students </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewCoursesPage.jsp">Preview students' performance </a></td>
          <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"><a href="previewGroupsPage.jsp">Preview course </a></td>
        </tr>
      </table>

      <p>&nbsp;</p>
      <table width="588" border="0">
        <tr>
          <td width="582"><div align="center" class="style9">Assistants preview </div></td>
        </tr>
      </table>
      <%int teacherId=teacherBeanId.getTeacherId(); %>
      <%teacherBeanId.readAllAssistants(); %>
      <%int assistantsNumb=teacherBeanId.getAssistantsNumb(); %>
      <%!int i; %>
      <%for (i=0;i<assistantsNumb;i++){%>
        <%int assistId=teacherBeanId.getAssistantIdByOrdNum(i); %>

        <form name="form1" method="post" action="getPreviewAssistantsPageAction.jsp?assistantId=<%=assistId%>">

          <table width="596" border="2" bordercolor="#CCCCCC">



            <tr bordercolor="#FFFFFF">
              <td width="167" rowspan="4" bgcolor="#FFFFFF"><table width="200" border="0">
                <tr>

                  <td><strong>last name: </strong><%=teacherBeanId.getNewAssistantDataByType("lastName",assistId) %></td>
                </tr>
                <tr>
                  <td><strong>first name: </strong><%=teacherBeanId.getNewAssistantDataByType("firstName",assistId) %></td>
                </tr>
                <tr>
                  <td><strong>user name: </strong><%=teacherBeanId.getNewAssistantDataByType("userName",assistId) %></td>
                </tr>
                <%Vector assistPrivilegiesIds=teacherBeanId.getNewAssistantPrivilegies(assistId); %>
                <%int privNumb=assistPrivilegiesIds.size(); %>

                <tr>
                  <td><strong>privilegies:</strong>                  </td>
                </tr>
                <%for (int i=0;i<privNumb;i++){ %>

                  <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <%Integer pId=new Integer(assistPrivilegiesIds.get(i).toString()); %>
                      <%int privId=pId.intValue(); %>
                      <%String privName=teacherBeanId.getAssistantPrivilegieNameById(privId); %>
                      <%=privName %>  </td>
                  </tr>

                  <%} %>
				  <tr>
                    <td><strong>groups:                  </strong></td>
                  </tr>
				  <%Vector assistGroupsIds=teacherBeanId.getNewAssistantGroups(assistId); %>
                <%int groupsNumb=assistGroupsIds.size(); %>
				  <%for (int i=0;i<groupsNumb;i++){ %>
				  <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <%Integer gId=new Integer(assistGroupsIds.get(i).toString()); %>
                      <%int grId=gId.intValue(); %>
                      <%=teacherBeanId.getGroupNameById(grId) %>                  </td>
                  </tr>
				  <%}%>
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
