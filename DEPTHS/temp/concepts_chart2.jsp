<!-- Provided by MyFreeTemplates.com -->

<%@ page import = "depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart" %>
<%// page import = "PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import="depths.coordinator.Tutor" %>

<jsp:useBean id="conceptHitChart" class="depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart" scope="session"/>
<%//jsp:useBean id="conceptChartDataSet" class="PedagogicalModule.StudentAssessment.charts.ConceptChartDataSet" scope="session"/%>
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Design Patterns Teaching Help System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="keywords" content="Keywords here">
<meta name="description" content="Description here">
<meta name="Author" content="MyFreeTemplates.com">
<META NAME="robots" CONTENT="index, follow">
<!-- (Robot commands: All, None, Index, No Index, Follow, No Follow) -->
<META NAME="revisit-after" CONTENT="30 days">
<META NAME="distribution" CONTENT="global">
<META NAME="rating" CONTENT="general">
<META NAME="Content-Language" CONTENT="english"><script language="JavaScript" type="text/JavaScript" src="pages/images/myfreetemplates.js"></script>
<script language="JavaScript" src="pages/images/menu.js" type="text/JavaScript"></script>
<link href="pages/images/myfreetemplates.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="pages/images/mm_menu.js"></script>


</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('pages/images/btn_location_dn.gif')">
<script language="JavaScript1.2">mmLoadMenus();</script>

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


<TABLE WIDTH=775 height="100%" BORDER=0 align="center" CELLPADDING=0 CELLSPACING=0>
  <TR>
    <TD width="194" height="100" bgcolor="#E0E9FE">&nbsp; </TD>
    <TD height="100" colspan="3" bgcolor="#BBCCF6">
     <TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>
        <TR>
          <TD width="590" height="80" valign="top" bgcolor="#BBCCF6">

		        <table width="104%" border="0" cellspacing="0" cellpadding="0">
            <tr>

			   <td height="39" style="padding-left:12;padding-top:11" bgcolor="#BBCCF6">&nbsp; </td>
               <td style="padding-top:11; font-weight: bold; font-size: 18px; font-color=#000000" class="newsarticle"><span class="style1">DEPTHS - DEsign Patterns Teaching Help System
                </span>

                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   	<font style="padding-top:11; font-weight: bold; font-size: 10px; font-color=#000000" class="newsarticle"><span class="style1">
	   	   by Jeremic Zoran </span></font></td>
            </tr>
            <tr>
              <td height="39" style="padding-left:12;padding-top:11">&nbsp;</td>
              <td style="padding-top:11" class="newsarticle">&nbsp;</td>
            </tr>
          </table></TD>
        </TR>
      </TABLE>    </TD>
  </TR>
  <TR valign="top">
    <TD width="194" bgcolor="#E0E9FE" style="border-right: 1px dotted;padding-left:19">
      <table width="136" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:14"><div align="center" class="style1">
            <div align="center" class="style2"><strong>Content</strong></div>
          </div></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"> <a href="conceptStatisticPage.jsp" class="sidetable">Concept's statistics </a></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"> <a href="concepts_chart.jsp" class="sidetable">Concept's statistic charts </a></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"> <a href="#" class="sidetable">Student performances </a></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><a href="index.html" class="sidetable">About this Tutor</a></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><a href="#" class="sidetable">Help</a></td>
        </tr>
        <tr>
          <td style="border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4"><a href="#" class="sidetable">FAQ</a></td>
        </tr>
      </table>    </TD>
    <TD COLSPAN=2 style="padding-left:12;padding-top:7">

      <table border=0>
	<tr>

	<td>
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

            <img src="<%= graphURL %>" width=500 height=300 border=0 usemap="#<%= filename %>">                </div>
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
              <p align="center">&nbsp;</p>    </TD>
  </TR>
  <TR>
    <TD height="27" COLSPAN=3 bgcolor="#E0E9FE"><div align="center"><img src="pages/images/base1.gif" width="658" height="27"></div></TD>
    </TR>
  <TR>
    <TD height="22" COLSPAN=3 background="pages/images/base2.gif">
      <div align="center">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="base">&nbsp;&nbsp;&copy; Copyright 2005. FON - School of Business Administration, University of Belgrade &nbsp;&nbsp; &nbsp;<a href="mailto:jeremycod@yahoo.com" target="_blank" class="baselink"><font size="1" face="Arial, Helvetica, sans-serif">Jeremic Zoran </font></a></td>
              <td align="right">

                <a href="http://www.goodoldai.org.yu" target="http://www.goodoldai.org.yu"><img src="pages/images/mftico.gif" alt="GOOD_OLD_AI" width="11" height="11" border="0"></a>&nbsp;&nbsp;</td>
            </tr>
        </table>
      </div></TD>
  </TR>
</TABLE>
</body>
</html>
