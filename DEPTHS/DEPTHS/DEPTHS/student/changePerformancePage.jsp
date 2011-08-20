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
<script language="javascript" src="js/matching_columns.js"></script>
</head>
<!-- JSP code -->
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session"></jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session"></jsp:useBean>

<body>

<%! String detailLevel; %>
<%! String programmLang; %>
<%! String displayForm="GoF"; %>

<% detailLevel=registrationBeanId.getDetailLevel(); %>
<% programmLang=registrationBeanId.getProgrammingLanguage(); %>
<div id="page">


<div id="content" class="column">





  <!--previousNextLinks-->
  <br/>
  <br/>
  <h1 id="pageName">Welcome to the DEPTHS learning system </h1>
  <div align=center>
  <h2 style="margin:0">Change your performance:</h2>
   <table width="416" height="118" border="1" bordercolor="#FFFFFF">
          <tr>
            <td width="169" height="26"><div align="left">Detail level: </div></td>
            <td width="231"><select name="select" size="1">
              <option value="Low" <% if (detailLevel.equals("Low")){%>selected <%}%> >Low</option>
              <option value="Middle" <% if (detailLevel.equals("Middle")){%>selected <%}%>>Middle</option>
              <option value="High" <% if (detailLevel.equals("High")){%>selected <%}%>>High</option>
            </select></td>
          </tr>
          <tr>
            <td height="28"><div align="left">Programming language :</div></td>
            <td><select name="select2" size="1">
              <option value="Java" <% if (programmLang.equals("Java")){%>selected <%}%>>Java</option>
              <option value="CPP" <% if (programmLang.equals("CPP")){%>selected <%}%>>C++</option>
            </select></td>
          </tr>
          <tr>
            <td height="26"><div align="left">Display form: </div></td>
            <td><select name="select3" size="1">
              <option value="GoF"<% if (displayForm.equals("GoF")){%>selected <%}%>>GoF form</option>
              <option value="CoplienForm" <% if (displayForm.equals("CoplienForm")){%>selected <%}%>>Coplien form</option>
            </select></td>
          </tr>
          <tr>
            <td height="26">&nbsp;</td>
            <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <p>              </p>

              </p>
            <input type="submit" name="Submit" value="Submit" onClick="window.close();"></td>
          </tr>
        </table>




    <div id="bellowForm">
      <p>&nbsp;</p>
    </div><!--bellowForm-->
  </div><!--story-->
</div><!--content-->
<!--end content -->

<!--end navbar -->
<div id="siteInfo" align="center" >
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
