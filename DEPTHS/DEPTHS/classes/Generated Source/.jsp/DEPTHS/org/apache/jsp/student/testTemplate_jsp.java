package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int numOfConceptsToLearn, numOfUnits; 
 String currConcId; 
 String concId; 
String unitTitle, unitId;  
 int i; 
 int numOfQuestions; 
 int numOfAnswers; 
 String n; 
  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n<script language=\"javascript\" src=\"js/popupWindowFunctions.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
      depths.presentationModule.RegistrationBean registrationBeanId = null;
      synchronized (session) {
        registrationBeanId = (depths.presentationModule.RegistrationBean) _jspx_page_context.getAttribute("registrationBeanId", PageContext.SESSION_SCOPE);
        if (registrationBeanId == null){
          registrationBeanId = new depths.presentationModule.RegistrationBean();
          _jspx_page_context.setAttribute("registrationBeanId", registrationBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      depths.presentationModule.TestBean testBeanId = null;
      synchronized (session) {
        testBeanId = (depths.presentationModule.TestBean) _jspx_page_context.getAttribute("testBeanId", PageContext.SESSION_SCOPE);
        if (testBeanId == null){
          testBeanId = new depths.presentationModule.TestBean();
          _jspx_page_context.setAttribute("testBeanId", testBeanId, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n\r\n");
testBeanId.setStarted(new java.util.Date()); 
      out.write('\r');
      out.write('\n');
      out.write(' ');
      out.write("\r\n        ");
      out.write("\r\n         ");
      out.write("\r\n          ");
currConcId=registrationBeanId.readCurrConcID(); 
      out.write("\r\n           ");
 numOfConceptsToLearn=registrationBeanId.getNumOfConceptsToLearn();
      out.write("\r\n        ");
 numOfUnits=registrationBeanId.getNumOfUnitsToLearni();
      out.write("\r\n\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav>\r\n<a href=\"#\" onclick=\"popupSmallWindow('changePerformancePage.jsp')\">Performance</a> |\r\n<a href=\"#\" onclick=\"popupWindow('conceptStatisticPage.jsp')\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Curriculum</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n  ");
for (int i = 0; i < numOfConceptsToLearn ; i++) {  
      out.write("\r\n    ");
concId = registrationBeanId.getConceptIdByOrdNum(i);  
      out.write("\r\n    <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentSelection.jsp?conceptId=");
      out.print(concId);
      out.write("\">\r\n      ");
if (concId == currConcId) {    
      out.write("\r\n      <strong>");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</strong>\r\n    </a>\r\n    ");
} else {  
      out.write("\r\n\r\n    ");
      out.print( registrationBeanId.getConceptByOrdNum(i) );
      out.write("</a>\r\n\t");
}  
      out.write("\r\n\t<br />\r\n    ");
if (concId.equals(currConcId)) {  
      out.write("\r\n\t<div style=\"margin-left:15px; padding-left:0px;\">\r\n    ");
for (int si = 0; si < numOfUnits; si++) {  
      out.write("\r\n      ");
      out.write("\r\n      ");
unitTitle = registrationBeanId.getUnitTitleByOrdNum(si + 1);  
      out.write("\r\n      ");
unitId = registrationBeanId.getUnitIdByOrdNum(si + 1);  
      out.write("\r\n      <a href=\"#\">\r\n\r\n        ");
      out.print( unitTitle );
      out.write("</a>\r\n\t\t<br />\r\n\r\n        ");
}  
      out.write("\r\n\t<strong><a href=\"#\">Questionnaire</a></strong><br/>\r\n        </div><!--style-->\r\n        ");
} 
      out.write("\r\n\r\n\r\n        ");
} 
      out.write("\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n    ");

  int numOfPassedConcepts;
  double passConcDegree;
  String rating;
  numOfPassedConcepts = registrationBeanId.getNumberOfPassedConcepts();


      out.write('\r');
      out.write('\n');
for (int i = 0; i < numOfPassedConcepts; i++) {
      out.write("\r\n\r\n  ");

  passConcDegree = registrationBeanId.getPassedConceptDegreeOfMastByOrdNum(i);
  rating = registrationBeanId.getPassedConceptRating(passConcDegree);
  
      out.write("\r\n  <a href=\"");
      out.print(request.getContextPath());
      out.write("/student/studentRelearningSelection.jsp?conceptId=");
      out.print(registrationBeanId.getPassedConceptIdByOrdNum(i));
      out.write("\" >\r\n    ");
      out.print(registrationBeanId.getPassedConceptTitleByOrdNum(i));
      out.write("</a><br />\r\n    <img alt=\"\" src=\"images/");
      out.print(rating);
      out.write("\"/><br />\r\n     ");
}
      out.write("\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n      <a href=\"#\">        &lt;&lt;\r\n        Previous\r\n</a>\r\n    </div><!--breadCrumb-->\r\n    <div id=\"breadCrumb2\">\r\n\r\n      <a href=\"getNext.jsp?nextButton=next\">        Next\r\n        &gt;&gt;\r\n</a>\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n  <h1 id=\"pageName\">");
      out.print( registrationBeanId.getCurrConceptTitle());
      out.write("</h1>\r\n  <div class=\"story\">\r\n\r\n     <h2>Answer the following questions by selecting correct answer. </h2>\r\n        ");
      out.write("\r\n        ");
      out.write("\r\n        ");
      out.write("\r\n        ");
      out.write("\r\n        ");
 registrationBeanId.startTestInSM();
      out.write("\r\n        ");
 numOfQuestions = registrationBeanId.getNumOfQuestionsInPlan(); 
      out.write("\r\n        ");
 if ((numOfQuestions==0)||(numOfQuestions>0)){ 
      out.write("\r\n     <form id=\"form1\" name=\"form1\" method=\"post\" action=\"getTestAction.jsp\">\r\n        <!--form name=\"form1\" method=\"post\" action=\"getTestAction.jsp\"-->\r\n\r\n\r\n           ");
 for (i=0;i<numOfQuestions;i++){
      out.write("\r\n             ");
 registrationBeanId.getQuestionByOrdNum(i); 
      out.write("\r\n             ");
  n=String.valueOf(i);
      out.write("\r\n             <p> </p>\r\n             <label> ");
      out.print(i+1);
      out.write('.');
      out.write(' ');
      out.print(registrationBeanId.getQuestionContent() );
      out.write(" </label>\r\n             ");
 numOfAnswers = registrationBeanId.getNumbOfAnswers(); 
      out.write("\r\n           <br/>\r\n        <table width=\"578\" height=\"94\" border=\"1\" cellpadding=\"2\" bordercolor=\"#FFFFFF\">\r\n\r\n               ");
 for (int s=0;s<numOfAnswers;s++){ 
      out.write("\r\n<tr>\r\n<td height=\"28\" width=\"15\"><div align=\"center\">\r\n\r\n  <input name=");
      out.print(n);
      out.write(" type=\"radio\" class=\"style3\" value=");
      out.print(s);
      out.write(" >\r\n    </div></td>\r\n  <td><label><span class=\"\"style5\">");
      out.print(registrationBeanId.getAnswerContent(s) );
      out.write("\r\n  </span></label>\r\n  <span class=\"style5\"></span></td>\r\n  </tr>\r\n\r\n\t");
}
      out.write("\r\n</table>\r\n   ");
}
      out.write("\r\n   <p>&nbsp;</p>\r\n    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n       <input name=\"exitButton\" type=\"submit\" value=\"Save & Exit\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"nextButton\" type=\"submit\" value=\"Next >\" />\r\n      </form>\r\n      ");
} else { 
      out.write("\r\n           <p>&nbsp;</p>\r\n\r\n      <form name=\"form1\" method=\"post\" action=\"exceptionPage.jsp\">\r\n      We are sorry, but there is no more questions in our knowledge base.\r\n      <p> </p>\r\n      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n      <input name=\"exitButton\" type=\"submit\" value=\"Save & Exit\"/>\r\n        &nbsp;&nbsp;\r\n        <input name=\"nextButton\" type=\"submit\" value=\"Next >\" />\r\n      </form>\r\n\r\n    ");
} 
      out.write("\r\n\r\n      <p>&nbsp;</p>\r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
