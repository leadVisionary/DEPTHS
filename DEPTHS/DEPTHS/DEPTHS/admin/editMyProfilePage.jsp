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

<%!String userName;%>
<%!int adminId; %>
<%Integer x; %>
<%userName=adminBeanId.getUserName();
x=new Integer(userName.hashCode());
adminId=x.intValue();%>
<%!String hasPrivilegies; %>

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

  <div class="story">

  <h2>&nbsp;</h2>

	 <h1 style="margin:0">Administrator's account information </h1>
      <p style="margin:0">&nbsp;</p>
      <%if (hasPrivilegies.equals("Guest")) {        %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
     <%} %>
     <form action="editMyProfileAction.jsp" method="post" >
      <table width="625" height="357" border="0">
        <tr>
          <td colspan="4"><span class="style8">Member information:</span> </td>
        </tr>
        <tr>
          <td width="161">&nbsp;</td>
          <td ><div align="right"><strong>First name:</strong></div></td>

          <td colspan="2">&nbsp;
            <input type="text" size="20" name="firstName" value="<%=adminBeanId.getAdminsDataByAdminId("firstName",adminId)%>">
          </td>
          </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Last name: </strong></div></td>
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="lastName" value="<%=adminBeanId.getAdminsDataByAdminId("lastName",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Username:</strong></div></td>
          <td colspan="2">&nbsp;
            <%=adminBeanId.getAdminsDataByAdminId("userName",adminId)%></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Password</strong></div></td>
          <td colspan="2">&nbsp;
            <input type="password" size="20" name="password" value="<%=adminBeanId.getAdminsDataByAdminId("password",adminId)%>"></td>
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
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="email" value="<%=adminBeanId.getAdminsDataByAdminId("email",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Address:</strong></div></td>
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="address" value="<%=adminBeanId.getAdminsDataByAdminId("address",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>City:</strong></div></td>
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="city" value="<%=adminBeanId.getAdminsDataByAdminId("city",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Country:</strong></div></td>
          <td colspan="2">&nbsp;

            <%!String currAdminCountry; %>
            <%currAdminCountry=adminBeanId.getAdminsDataByAdminId("countryId",adminId);%>
              <%adminBeanId.getCountries(); %>
                    <%adminBeanId.getCountriesIds();  %>
                    <%!int numbOfCountries;  %>
                    <%!int countryId; %>
                    <%!String countryName; %>
                    <%numbOfCountries = adminBeanId.getNumbOfCountries();%>
                      <select name="selectedCountry">
                      <%for (int i = 0; i < numbOfCountries; i++) {%>
                        <%countryId=adminBeanId.getCountryId(i); %>
                        <%countryName=adminBeanId.getCountryName(i); %>
                        <%if (currAdminCountry.equals(countryName)){ %>
                        <OPTION value='<%=countryId%>' selected="selected"><%=countryName%> </OPTION>
                        <%}else{%>
                        <OPTION value='<%=countryId%>'><%=countryName%> </OPTION> %>
                       <%} %>
                      <%}%>
                      </select>
            </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Organisation:</strong></div></td>
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="organisation" value="<%=adminBeanId.getAdminsDataByAdminId("organisation",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Web site:</strong></div></td>
          <td colspan="2">&nbsp;
            <input type="text" size="20" name="webSite" value="<%=adminBeanId.getAdminsDataByAdminId("webSite",adminId)%>"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><div align="right"><strong>Language:</strong></div></td>
          <td colspan="2">&nbsp;
            <%!String currAdminLanguage; %>
            <%currAdminLanguage=adminBeanId.getAdminsDataByAdminId("languageId",adminId);%>
              <%adminBeanId.getLanguages(); %>
                    <%adminBeanId.getLanguagesIds();  %>
                    <%!int numbOfLanguages;  %>
                    <%!int languageId; %>
                    <%!String languageName; %>
                    <%numbOfLanguages = adminBeanId.getNumbOfLanguages();%>
                      <select name="language">
                      <%for (int i = 0; i < numbOfLanguages; i++) {%>
                        <%languageId=adminBeanId.getLanguageId(i); %>
                        <%languageName=adminBeanId.getLanguageName(i);%>
                        <%if (currAdminLanguage.equals(languageName)){ %>
                        <OPTION value='<%=languageId%>' selected="selected"><%=languageName%> </OPTION>
                        <%}else{%>
                        <OPTION value='<%=languageId%>'><%=languageName%> </OPTION>
                       <%} %>
                      <%}%>
                      </select>
            </td>
        </tr>
        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="4"><span class="style8">Profile information: </span></td>
        </tr>
        <tr>
          <td height="25">&nbsp;</td>
          <td><div align="right"><strong>Privilegies:</strong></div></td>
          <td width="265">&nbsp;<%=adminBeanId.getAdminsDataByAdminId("privType",adminId)%></td>
          <td width="88">

            <a href="editProfilePage.jsp?adminId=<%=adminId%>" class="style8">Edit</a></td>
        </tr>
        <tr>
          <td height="25">&nbsp;</td>
          <td>&nbsp;</td>
          <td colspan="2">&nbsp;</td>
        </tr>
      </table>

	  <input type="submit" name="previewAdminsButton" value="Back" >
        <input type="submit" name="adminWelcomeButton" value="Main menu">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" name="updateButton" value="Update"/>
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
