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
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
 <%int teacherId=teacherBeanId.getTeacherId(); %>
<%!Vector privilegies;%>
<%privilegies = teacherBeanId.getTeacherPrivilegies();%>

<%!String hasPrivilegies;%>
<%if (privilegies.isEmpty()){
  hasPrivilegies="Guest";
}else{
  hasPrivilegies="Limited";
  int privNumb=privilegies.size();
}%>
<%String groupSection = request.getParameter("groupSection");

        session=request.getSession();

        if (groupSection == null){
       groupSection="All";
       }%>
<%ArrayList groupList = new ArrayList();%>
	  <%groupList.add("All");%>
          <%Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId); %>
          <%int groupsNumb=teacherGroupsIds.size();
          for (int g=0;g<groupsNumb;g++){
            String groupId=teacherGroupsIds.get(g).toString();
            int grId=(new Integer(groupId)).intValue();
            String grName=teacherBeanId.getGroupNameById(grId);
            groupList.add(grName);
          }
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
          <td colspan="4"><div align="center"><span class="style9">Students preview </span></div></td>
        </tr>
        <tr>
          <td colspan="4">&nbsp;</td>
        </tr>
        <tr>
           <form name="form2" method="post" action="previewStudentsPage.jsp">
          <td width="142"><div align="center" class="style9"></div></td>

          <td width="142">Select group: </td>
          <td width="135">
		  <select name=groupSection class=pullDown>

  <%			Iterator iter = groupList.listIterator();
				while (iter.hasNext()) {
					String optionGroup = (String)iter.next();
					if (optionGroup.equals(groupSection)) { %>
			      <option selected><%= optionGroup %></option>
  <%					} else { %>
			      <option><%= optionGroup %></option>
  <%					} %>
  <%				} %>
			      </select>		</td>
          <td width="151"><input type="submit" name="Refresh" value="Refresh" /></td>
        </form>
        </tr>
      </table>
      <%!Vector studentsIds;%>
     <%if (groupSection.equals("All")){ %>
     <%studentsIds=teacherBeanId.readAllStudents(teacherId); %>
     <%}else{ %>
     <%studentsIds=teacherBeanId.readAllStudentsInGroup(groupSection); %>
     <%} %>
      <%int studentsNumb=studentsIds.size(); %>
      <%!int i; %>
      <%for (i=0;i<studentsNumb;i++){%>
        <%String sId=studentsIds.get(i).toString(); %>
        <%Integer stId=new Integer(sId); %>
        <%int studentId=stId.intValue(); %>

        <form name="form1" method="post" action="getPreviewStudentsPageAction.jsp?studentId=<%=studentId%>">

          <table width="596" border="2" bordercolor="#CCCCCC">



            <tr bordercolor="#FFFFFF">
              <td width="167" rowspan="4" bgcolor="#FFFFFF"><table width="200" border="0">
                <tr>

                  <td><strong>last name: </strong><%=teacherBeanId.getStudentDataByType("lastName",studentId) %></td>
                </tr>
                <tr>
                  <td><strong>first name: </strong><%=teacherBeanId.getStudentDataByType("firstName",studentId) %></td>
                </tr>
                <tr>
                  <td><strong>user name: </strong><%=teacherBeanId.getStudentDataByType("userName",studentId) %></td>
                </tr>
               <%String gId=teacherBeanId.getStudentDataByType("groupId",studentId); %>
               <%Integer grId=new Integer(gId); %>
                <%int groupId=grId.intValue(); %>

                <tr>
                  <td><strong>group:</strong><%=teacherBeanId.getGroupNameById(groupId) %></td>
                </tr>

				  <tr>
                    <td><strong>xxx:                  </strong></td>
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
