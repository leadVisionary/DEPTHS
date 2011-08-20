<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<title>DEPTHS</title>
<link rel="stylesheet" href="../css/unitTemplate.css" type="text/css"/>
<style type="text/css">
  <!--
    .copyrightStyle {
    font-size: 12px;
    color: #006699;
    }
  -->
</style>

<script language="javascript" src="js/matching_columns.js" type="text/javascript"></script>
<script language="javascript" src="js/HTML_forms.js" type="text/javascript"></script>
</head>
<!-- JSP code -->
<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%@page import="java.util.Vector" %>
<%!String assistantUserName; %>
<%assistantUserName=request.getParameter("assistantUserName"); %>



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

  <h2>&nbsp;</h2>

	  <form name="form1" method="post" action="settingNewAssistantPerformances.jsp?assistantUserName=<%=assistantUserName%>">
	  <table width="82%">
	  <tr>
	    <td colspan="2" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">
              <strong>Choose privilegies for new assistant:</strong></td>
	    <td colspan="3" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><strong>Choose the assistant's groups: </strong></td>
	  </tr>
	  <tr>
	    <td height="179" colspan="2" rowspan="4" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">


          <%!String privilegieName;%>
          <%!int numbOfPrivilegies,privilegieId;%>
          <%teacherBeanId.getAssistantPrivilegies(); %>
          <%numbOfPrivilegies=teacherBeanId.getNumberOfAssistantsPrivilegies(); %>
          <%for (int i=0;i<numbOfPrivilegies;i++){ %>
            <%privilegieId=teacherBeanId.getAssistantPrivilegieIdByOrdNumb(i); %>
            <%privilegieName=teacherBeanId.getAssistantPrivilegieNameById(privilegieId); %>
            <p>
              <%--=privilegieId--%>
              <input type="checkbox" name="privilegie" value="<%=privilegieId%>"><%=privilegieName %>              </p>
              <%} %>


          <br>
        <p/>
        <p></p>		</td>
        <%int teacherId=teacherBeanId.getTeacherId(); %>
        <%Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId); %>
        <%int teacherGroupsNumb=teacherGroupsIds.size(); %>
	    <td width="14%" rowspan="4" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4" align="center">
              <div align="left">
                Available:
                <SELECT SIZE="8" MULTIPLE id=i_12 name=groups style="width:100px;" >
                  <%for (int i=0;i<teacherGroupsNumb;i++){ %>
                  <%Integer id=new Integer(teacherGroupsIds.get(i).toString()); %>
                  <%int gId=id.intValue(); %>
                  <OPTION value="<%=gId%>"><%=teacherBeanId.getGroupNameById(gId) %></OPTION>
                  <%} %>
                            </SELECT>


              </div></td>
	    <td width="7%" height="36" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;</td>
	    <td width="15%" rowspan="4" style="border-top: 1px dotted #A6BDF2;padding-top:4; padding-bottom:4" align="center">
              <div align="left">
                Selected:
                <select multiple size="8" id=selectedGroups name=selectedGroups style="width:100px;" >
                    </select>
              </div></td>
	  </tr>
	  <tr>
	    <td height="24" style="padding-top:4;padding-bottom:4"><div align="center">
	      <INPUT type = button style="width:60px" name = xAdd id = i_13  onClick="return go_update_box('groups','selectedGroups')" value = " > " >
	      </div></td>
	    </tr>
	  <tr>
	    <td height="25" style="padding-top:4;padding-bottom:4"><div align="center">
	      <INPUT type = button  name = xRemove id = i_14 value = " <" onClick="return go_update_box('selectedGroups','groups')">
	      </div></td>
	    </tr>
	  <tr>
	    <td padding-top:4;padding-bottom:4">&nbsp;</td>
	    </tr>
	  <tr>
	    <td width="40%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;	       </td>
	    <td width="26%" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">
            <input type="submit" name="Submit" value="Submit" onClick="submitListValues();"></td>
	    <td colspan="3" style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4">&nbsp;</td>
	  </tr>
</table>
</form>


      <p>&nbsp;</p>

  </div>
</div>

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
</div>
<br/>
</div>
</body>

</html>
