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
<jsp:useBean id="registrationBeanId" class="depths.presentationModule.RegistrationBean" scope="session"></jsp:useBean>
<jsp:useBean id="testBeanId" class="depths.presentationModule.TestBean" scope="session"></jsp:useBean>

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
  <h1 id="pageName">Welcome to the DEPTHS learning system </h1>
  <div class="story">

 <TABLE width=500 align=center >
      <FORM name=userRegisterForm method="POST" action="settingUserData.jsp">
        <TBODY>
        <%if (registrationBeanId.isUserNameExist()) {        %>
          <TR>
            <TD class=PageTitle colSpan=2>
              <FONT color=red>
                <B>
                  <BIG>You have selected username that is already in use.</BIG>
                </B>
              </FONT>
            </TD>
          </TR>
          <TR>
            <TD class=text vAlign=top align=left colSpan=2>              Please choose another one or go to the existing users page
              <a href="existingUsersForm.jsp">HERE</a>
            </TD>
          </TR>
        <%} else {        %>
          <TR>
            <TD class=PageTitle colSpan=2>
              <H2>New student registration</H2>
            </TD>
          </TR>
          <TR>
            <TD class=text vAlign=top align=left colSpan=2>Please register below to use DEPTHS system.</TD>
          </TR>
        <%}        %>
          <TR>
            <TD>&nbsp;</TD>
          </TR>
          <TR>
            <!--
              <TD class=title align=left colSpan=2>Account information / about
              you</TD>
            -->
          </TR>
          <TR>
            <TD class=text align=left colSpan=2>              All fields marked with an
              <FONT color=red>
                <B>
                  <BIG>*</BIG>
                </B>
              </FONT>
              are required.
</TD>
          </TR>
          <TR>
            <TD colSpan=2>
              <TABLE cellSpacing=1 cellPadding=2 width="95%" border=0>
                <TBODY>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;
                      <FONT color=red>*</FONT>
                      First name
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 name=firstName>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;
                      <FONT color=red>*</FONT>
                      Last name
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 name=lastName>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>
                      <FONT color=red>                        &nbsp;
                        *
</FONT>
                      Username
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 name=userName checked>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>
                      <FONT color=red>                        &nbsp;
                        *
</FONT>
                      Email address
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 name=email>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;
                      <FONT color=red>*</FONT>
                      Your Password
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT type=password size=30 name=password>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;
                      <FONT color=red>*</FONT>
                      Repeat password
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT type=password size=30 name=passwordConfirmation>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;
                      Address
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=30 name=address>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;
                      City
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=30 name=city>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;
                      &nbsp;&nbsp;
                      Country of residence
</TD>
                    <TD class=text noWrap align=left>
                    <%registrationBeanId.getCountries();                    %>
                    <%registrationBeanId.getCountriesIds();                    %>
                    <%!int numbOfCountries;                    %>
                    <%!int countryId; %>
                    <%numbOfCountries = registrationBeanId.getNumbOfCountries();%>

                      <select name=selectedCountry>
                      <%for (int i = 0; i < numbOfCountries; i++) {%>
                        <%countryId=registrationBeanId.getCountryId(i); %>
                        <OPTION value='<%=countryId%>'><%=registrationBeanId.getCountryName(i) %>                        </OPTION>
                      <%}%>
                      </select>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD class=text noWrap align=left>                      &nbsp;&nbsp;&nbsp;&nbsp;
                      Organization
</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 name=organization>
                    </TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD align=left noWrap bgcolor="#f0f0f0" class=text>                      &nbsp;&nbsp;&nbsp;&nbsp;
                      Web Site</TD>
                    <TD class=text noWrap align=left>
                      <INPUT size=50 value=http:// name=webSite>
                    </TD>
                  </TR>
                  <TR bgcolor="#f0f0f0">
                    <TD align=left noWrap class=title>                      &nbsp;&nbsp;&nbsp;&nbsp;

                      Your language
                      settings</TD>
                    <TD align=left noWrap class=text>&nbsp;</TD>
                  </TR>
                  <TR bgColor=#f0f0f0>
                    <TD align=left noWrap class=text>                      &nbsp;&nbsp;&nbsp;&nbsp;
                      <%registrationBeanId.getLanguages();                    %>
                    <%registrationBeanId.getLanguagesIds();                    %>
                    <%!int numbOfLanguages;                    %>
                    <%!int languageId; %>
                    <%numbOfLanguages = registrationBeanId.getNumbOfLanguages();%>

                      <select name=language>
                      <%for (int i = 0; i < numbOfLanguages; i++) {%>
                        <%languageId=registrationBeanId.getLanguageId(i); %>
                        <OPTION value='<%=languageId%>'><%=registrationBeanId.getLanguageName(i) %>                        </OPTION>
                      <%}%>
                      </select>
                    </TD>
                    <TD align=left noWrap class=text>&nbsp;</TD>
                  </TR>
                </TBODY>
              </TABLE>
            </TD>
<tr><td>&nbsp;</td>
</tr>
          <TR>
            <TD align=center colSpan=2>
              <INPUT type=submit value=Submit tabindex="0">
            </TD>
          </TR>

      </FORM>
</TBODY>      </TABLE>





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
