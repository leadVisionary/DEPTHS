<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page import = "depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart" %>
<%// page import = "PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import="depths.coordinator.Tutor" %>

<jsp:useBean id="conceptHitChart" class="depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart" scope="session"/>
<%--//jsp:useBean id="conceptChartDataSet" class="PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" scope="session"/--%>
<jsp:useBean id="statisticBeanId" class="depths.presentationModule.StatisticBean" scope="session">
</jsp:useBean>
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session">
</jsp:useBean>
<%! Tutor ref;%>
<% ref=registrationBeanId.sendTutorRefToStatBean(); %>
<% statisticBeanId.setTutorRef(ref); %>
<%ref.setChartsRef(conceptHitChart); %>
<%
//conceptHitChart.sendReference(conceptChartData);
	String section = request.getParameter("section");

        session=request.getSession();

        if (section == null)
       // ? false : section.equals("All"))
       {

         section = "Progress";}
	// if (section == null ? false : section.equals("All")) section = null;
        String filename=""; //ConceptHitChart.generateXYChart(section, session, new PrintWriter(out));

       // if (section!=null){
          if (section.equals("Concepts")){

            filename = conceptHitChart.generateBarChart(section, session, new PrintWriter(out));

          }else if (section.equals("Progress")){

            filename = conceptHitChart.generateXYChart(section, session, new PrintWriter(out));
          }
       // }

	String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;


	ArrayList sectionList = new ArrayList();
	  sectionList.add("Concepts");
        sectionList.add("Progress");//conceptChartDataSet.getSectionList();

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
<%! int numOfPassedConcepts=0; %>
<%! String concId=""; %>
<%! double degreeOfMastery=0; %>
<%! int hours=0, min=0, sec=0; %>
<%! String actualSkillLevelText=new String(); %>
<%! String title=new String(); %>
<%! String slider=new String(); %>
<%! String slider2; %>
<%! String markText=new String(); %>

<% statisticBeanId.getNumOfPassedConcFromSM();%>
<% numOfPassedConcepts=statisticBeanId.getNumberOfPassedConcepts(); %>

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
  <a href="conceptStatisticPage.jsp" >Concept's statistics </a><br />
  <br />
	<br />

  </div><!--sectionLinks-->
  <div id="search">
    <br/>
    <br/>
    <label>Passed concepts</label>
  </div> <!--search-->
   <div id="sectionLinks">
    <%
  int numOfPassedConcepts;
  double passConcDegree;
  String rating;
  numOfPassedConcepts = registrationBeanId.getNumberOfPassedConcepts();

%>
<%for (int i = 0; i < numOfPassedConcepts; i++) {%>

  <%
  passConcDegree = registrationBeanId.getPassedConceptDegreeOfMastByOrdNum(i);
  rating = registrationBeanId.getPassedConceptRating(passConcDegree);
  %>

  <a href="lessonsStatisticPage.jsp?conceptId=<%=registrationBeanId.getPassedConceptIdByOrdNum(i)%>" >
    <%=registrationBeanId.getPassedConceptTitleByOrdNum(i)%></a><br />
    <img alt="" src="images/<%=rating%>"/><br />
     <%}%>

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
  <h1 id="pageName">Concept statistic's chart diagrams
    </h1>
  <div class="story">

  <div align="center">

            <%if (section.equals("Progress")){ %>
          </div>
          <h2 align="center">Student's progress throw the course</h2>
          <div align="center">
            <%}else if(section.equals("Concepts")){ %>
          </div>
          <h2 align="center">Knowledge level for each learned concept</h2>
          <div align="center">
            <%} %>


            <br>
			  <img src="<%= graphURL %>" width=600 height=400 border=0 usemap="#<%= filename %>">                </div>
          <p align="center">The chart shown above has tooltips and drilldown enabled.</p>

	      <div align="center">
	        <table bordercolordark="FFFFFF" bordercolorlight="000000" width="400" cellpadding="20" cellspacing="0" border="1" class="panel">
	          <tr><td>
	            <table border=0 cellpadding=2 width=100%>
	              <form method=POST action="concepts_chart.jsp">
	                <tr valign=top>
	                  <td><b>Section</b></td>
			  <td>
			    <select name=section class=pullDown>

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
			  <td>
			    <input type=image src="images/button_refresh.png" width=80 height=22 name=refresh>			</td>
		  </tr>
	                </form>
		  </table>

	</td></tr>
                  </table>

	 </div>
	      <p align="center" style="margin:0">&nbsp; </p>

      <p align="center" style="margin:0">&nbsp;</p>

      <p align="center" style="margin:0">&nbsp;</p>
      <p align="center" style="margin:0">&nbsp;</p>
      <div align="center">
        <blockquote> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   </blockquote>
      </div>
      <blockquote><p align="center"><a href="closeThisWindow" class="style3" onClick="window.close();">Close</a></p>
      </blockquote>
              <p align="center">&nbsp;</p>



              <p>&nbsp;</p>

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
