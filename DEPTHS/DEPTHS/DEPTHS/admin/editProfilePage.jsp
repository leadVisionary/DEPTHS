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

<%String adminId; %>
<%adminId=request.getParameter("adminId"); %>
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

  <%if (hasPrivilegies.equals("Full")){ %>
       <h1 style="margin:0">Edit administrator privilegie  </h1>

       <strong>Administrator name:</strong> <%=adminBeanId.getAdminDataById("firstName",adminId) %> &nbsp;<%=adminBeanId.getAdminDataById("lastName",adminId) %>
        <br />
       <strong>Current privilegie: </strong> <%=adminBeanId.getAdminPrivilegieNameByAdminId(adminId) %>
       <p>Please enter a new privilegie  in the form bellow:</p>
       <p>&nbsp;  </p>
       <form method="POST" action="formsAction.jsp?adminId=<%=adminId%>">
         <%int numbOfPrivilegies; %>
         <%int privilegieId; %>
         <%adminBeanId.getPrivilegiesIds(); %>
         <%numbOfPrivilegies=adminBeanId.getNumbOfPrivilegies(); %>

         <p>New privilegie:&nbsp;
           <select name=privilegie>
             <%for (int i = 0; i < numbOfPrivilegies; i++) {%>

               <%privilegieId=adminBeanId.getPrivilegieIdByOrdNum(i); %>
               <option value='<%=privilegieId%>'><%=adminBeanId.getPrivilegieById(privilegieId) %>

               </option>
               <%}%>
           </select>
         <p>

         </p>
             <p>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="submit" value="Submit" name="changePrivilegie">
         </p>
      </form>
             <p>&nbsp; </p>

             <%}else if (hasPrivilegies.equals("Limited")){ %>
             <h1>Sorry, you don't have enough privilegies for this.</h1>
            <%}else if (hasPrivilegies.equals("Guest")){ %>
      You are running in a guest mode.<br/>
      No change will take effect in this mode.<br/>
            <p>&nbsp;</p>
            <h1 style="margin:0">Edit administrator privilegie  </h1>

       <strong>Administrator name:</strong> <%=adminBeanId.getAdminDataById("firstName",adminId) %> &nbsp;<%=adminBeanId.getAdminDataById("lastName",adminId) %>
       <br />

       <strong>Current privilegie: </strong> <%=adminBeanId.getAdminPrivilegieNameByAdminId(adminId) %>
       <p>Please enter a new privilegie  in the form bellow:</p>
       <p>&nbsp;  </p>
       <form method="POST" action="previewAdminsPage.jsp">
         <%int numbOfPrivilegies; %>
         <%int privilegieId; %>
         <%adminBeanId.getPrivilegiesIds(); %>
         <%numbOfPrivilegies=adminBeanId.getNumbOfPrivilegies(); %>

         <p>New privilegie:&nbsp;
           <select name=privilegie>
             <%for (int i = 0; i < numbOfPrivilegies; i++) {%>

               <%privilegieId=adminBeanId.getPrivilegieIdByOrdNum(i); %>
               <option value='<%=privilegieId%>'><%=adminBeanId.getPrivilegieById(privilegieId) %>

               </option>
               <%}%>
           </select>
         <p>

         </p>
             <p>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="submit" value="Submit" name="changePrivilegie">
         </p>
      </form>
             <p>&nbsp; </p>

<%}%>






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
