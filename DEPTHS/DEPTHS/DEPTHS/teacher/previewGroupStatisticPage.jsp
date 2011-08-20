<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--@ page import = "depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart" --%>
<%// page import = "PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import="java.util.Vector"%>
<%@page import="depths.teacherModule.DatabaseManager" %>
<%--@ page import="depths.coordinator.Tutor" --%>

<jsp:useBean id="groupHitChart" class="depths.presentationModule.teacher.charts.GroupHitChart" scope="session"/>
<%--jsp:useBean id="studentsChartDataSet" class="PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" scope="session"/--%>
<jsp:useBean id="studentStatisticBeanId" class="depths.presentationModule.teacher.StudentsStatisticBean" scope="session">
</jsp:useBean>
<jsp:useBean id="teacherBeanId" class="depths.presentationModule.teacher.TeacherBean" scope="session">
</jsp:useBean>
<%groupHitChart.sendReference(studentStatisticBeanId); %>
<%DatabaseManager dbMan=teacherBeanId.getDatabaseManagerRef();%>
<%studentStatisticBeanId.setDbManagerReg(dbMan);%>
<%--! Tutor ref;--%>
<%-- ref=registrationBeanId.sendTutorRefToStatBean(); %>
<% statisticBeanId.setTutorRef(ref); --%>
<%--studentStatisticBeanId.setChartsRef(groupHitChart); --%>
<%
int teacherId=teacherBeanId.getTeacherId();
Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId);
//conceptHitChart.sendReference(conceptChartData);
	String section = request.getParameter("section");
String group = request.getParameter("group");
String course = request.getParameter("course");
String courseId=teacherBeanId.getCourseIdByName(course);
ArrayList courseList = new ArrayList();
Vector coursesIds=teacherBeanId.getTeacherCoursesIds(teacherId);

        session=request.getSession();
        if (course==null){
          courseId=coursesIds.get(0).toString();
        }
        if (section == null)
         {section = "Progress";}
         if (group == null)
         {group = "All";}
        String filename="";
              if (section.equals("Concepts")){
            filename = groupHitChart.generateBarChart(section, session, new PrintWriter(out),courseId,group);
          }else if (section.equals("Progress")){
            filename = groupHitChart.generateXYChart(section, session, new PrintWriter(out),courseId,group);
          }

       // }

	String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;


	ArrayList sectionList = new ArrayList();
	  sectionList.add("Concepts");
        sectionList.add("Progress");//conceptChartDataSet.getSectionList();

ArrayList groupList = new ArrayList();
groupList.add("All");
for (int i=0;i<teacherGroupsIds.size();i++){
Integer grId=new Integer(teacherGroupsIds.get(i).toString());
String groupName=teacherBeanId.getGroupNameById(grId.intValue());
groupList.add(groupName);
}


for (int i=0;i<coursesIds.size();i++){

String courseName=teacherBeanId.getCourseNameById(coursesIds.get(i).toString());
courseList.add(courseName);
}



%>

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
  <a href="#" >Group's statistics </a><br />
  <a href="compareGroupsStatisticPage.jsp#" >Compare groups </a><br />
  <br />
	<br />

  </div><!--sectionLinks-->
  <div id="search">
    <br/>
    <br/>
    <label>Passed concepts</label>
  </div> <!--search-->
   <div id="sectionLinks">


  </div><!--sectionLinks-->
  <div id="advert">
    <p>&nbsp;</p>
  </div><!--adverts-->
  <div id="headlines">
  </div><!--headlines-->
</div><!--navBar-->
<div id="content" class="column">


  <br/>
  <br/>
  <h1 id="pageName">Groups' statistic's chart diagrams
    </h1>
  <div class="story">

  <div align="center">

            <%if (section.equals("Progress")){ %>
      </div>
          <h2 align="center">Group's progress throw the course</h2>
          <div align="center">
            <%}else if(section.equals("Concepts")){ %>
          </div>
          <h2 align="center">Degree of mastery for each learned concept</h2>
          <div align="center">
            <%} %>


            <br>
			  <img src="<%= graphURL %>" width=600 height=400 border=0 usemap="#<%= filename %>">                </div>
          <p align="center">The chart shown above has tooltips and drilldown enabled.</p>

	      <div align="center">
	        <table bordercolordark="FFFFFF" bordercolorlight="000000" width="491" cellpadding="20" cellspacing="0" border="1" class="panel">
	          <tr>

			  <td width="653">
	            <table border=0 cellpadding=2 width=76%>
	              <form method=POST action="previewGroupStatisticPage.jsp">
				  <tr valign=top>
	                  <td width="33%"><div align="right" style="padding-right:10px"><b>Course</b></div></td>
			  <td width="20%" >
			    <select name=course class=pullDown style="width:150px">

                                         <%Iterator courseIter = courseList.listIterator();
				while (courseIter.hasNext()) {
					String optionCourse = (String)courseIter.next();
					if (optionCourse.equals(course)) { %>
			      <option selected><%= optionCourse %></option>
                              <%} else { %>
			      <option><%= optionCourse %></option>
  <%					} %>
  <%				} %>
 </select>			</td>
 <td width="42%" rowspan="3" style="vertical-align:middle"><input type=image src="images/button_refresh.png" width=80 height=22 name=refresh /></td>
	                <tr valign=top>
	                  <td width="33%"><div align="right" style="padding-right:10px"><b>Group</b></div></td>
			  <td width="20%" >
			    <select name=group class=pullDown style="width:150px">



  <%			Iterator groupIter = groupList.listIterator();
				while (groupIter.hasNext()) {
					String optionGroup = (String)groupIter.next();
					if (optionGroup.equals(group)) { %>
			      <option selected><%= optionGroup %></option>
  <%					} else { %>
			      <option><%= optionGroup %></option>
  <%					} %>
  <%				} %>
			      </select>			</td>

		  </tr>
                  <tr valign=top>
	                  <td><div align="right" style="padding-right:10px"><b>Section</b></div></td>
			  <td width="20%">
			    <select name=section class=pullDown style="width:150px">

  <%			Iterator iter = sectionList.listIterator();
				while (iter.hasNext()) {
					String optionSection = (String)iter.next();
					if (optionSection.equals(section)) { %>
			      <option selected><%= optionSection %></option>
  <%					} else { %>
			      <option><%= optionSection %></option>
  <%					} %>
  <%				} %>
			      </select>			</td>
			  </tr>
                  </form>
		  </table>

	</td>


			</tr>
            </table>

	 </div>
	      <p align="center" style="margin:0">&nbsp; </p>

	  <div align="center">
	  <form name=teacherWelcomeScreen method="POST" action="teacherWelcomeScreen.jsp">

	    <input type="submit" name="teachersWelcomeButton" value="Main menu" />
	  </form>
	  </div>

              <p align="center">&nbsp;</p>



             



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
