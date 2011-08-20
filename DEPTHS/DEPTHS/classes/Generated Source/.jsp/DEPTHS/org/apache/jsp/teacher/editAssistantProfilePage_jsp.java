package org.apache.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;

public final class editAssistantProfilePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Vector privilegies;
String hasPrivilegies;
String privilegieName;
int numbOfPrivilegies,privilegieId;
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<!-- DW6 -->\r\n<head>\r\n<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\r\n<title>DEPTHS</title>\r\n<link rel=\"stylesheet\" href=\"../css/unitTemplate.css\" type=\"text/css\"/>\r\n</style><style type=\"text/css\">\r\n  <!--\r\n    .copyrightStyle {\r\n    font-size: 12px;\r\n    color: #006699;\r\n    }\r\n  -->\r\n</style>\r\n\r\n<script language=\"javascript\" src=\"js/matching_columns.js\" type=\"text/javascript\"></script>\r\n<script language=\"javascript\" src=\"js/HTML_forms.js\" type=\"text/javascript\"></script>\r\n</head>\r\n<!-- JSP code -->\r\n");
      depths.presentationModule.teacher.TeacherBean teacherBeanId = null;
      synchronized (session) {
        teacherBeanId = (depths.presentationModule.teacher.TeacherBean) _jspx_page_context.getAttribute("teacherBeanId", PageContext.SESSION_SCOPE);
        if (teacherBeanId == null){
          teacherBeanId = new depths.presentationModule.teacher.TeacherBean();
          _jspx_page_context.setAttribute("teacherBeanId", teacherBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n");
String assistId=request.getParameter("assistantId"); 
      out.write('\r');
      out.write('\n');
Integer x=new Integer(assistId); 
      out.write('\r');
      out.write('\n');
int assistantId=x.intValue(); 
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
privilegies = teacherBeanId.getTeacherPrivilegies();
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
if (privilegies.isEmpty()){
  hasPrivilegies="Guest";
}else{
  hasPrivilegies="Limited";
  int privNumb=privilegies.size();
  for (int i=0;i<privNumb;i++){
String privName=  privilegies.get(i).toString();

if (privName.equals("create new assistant")){
hasPrivilegies="create new assistant";
}

  }


}
      out.write("\r\n<body>\r\n\r\n<div id=\"page\">\r\n<DIV id=masthead>\r\n<DIV id=globalNav><a href=\"#\">Performance</a> |\r\n<a href=\"#\">Statistic</a> |\r\n<a href=\"#\">Tools</a> |\r\n<a href=\"#\">Help</a>\r\n</DIV><!--globalNav-->\r\n</DIV><!--mastHead-->\r\n  <div id=\"navBar\" class=\"column\">\r\n  <div id=\"blank\">\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n    <p>&nbsp;</p>\r\n  </div> <!--blank-->\r\n  <div id=\"search\">\r\n    <label>Links</label>\r\n  </div><!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n    <a href=\"editMyProfilePage.jsp\" >Edit my profile</a>\r\n\r\n\t<br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"search\">\r\n    <br/>\r\n    <br/>\r\n    <label>Passed concepts</label>\r\n  </div> <!--search-->\r\n  <div id=\"sectionLinks\">\r\n\r\n\r\n\r\n\r\n  <a href=\"bla bla\" >bla bla\r\n    </a><br />\r\n\r\n\r\n  </div><!--sectionLinks-->\r\n  <div id=\"advert\">\r\n    <p>&nbsp;</p>\r\n  </div><!--adverts-->\r\n  <div id=\"headlines\">\r\n  </div><!--headlines-->\r\n</div><!--navBar-->\r\n<div id=\"content\" class=\"column\">\r\n\r\n  <div id=\"previousNextLinks\">\r\n    <div id=\"breadCrumb\">\r\n\r\n\r\n    </div><!--breadCrumb-->\r\n");
      out.write("    <div id=\"breadCrumb2\">\r\n\r\n\r\n    </div>\r\n  </div><!--previousNextLinks-->\r\n  <br/>\r\n  <br/>\r\n\r\n  <div class=\"story\">\r\n\r\n  ");
if (!hasPrivilegies.equals("Limited")){ 
      out.write("\r\n       <h1 style=\"margin:0\">Edit assistant's privilegies  </h1>\r\n       <p>&nbsp;</p>\r\n       <strong>Assistant's name:\r\n       </strong> ");
      out.print(teacherBeanId.getNewAssistantDataByType("firstName",assistantId) );
      out.write(" &nbsp;");
      out.print(teacherBeanId.getNewAssistantDataByType("lastName",assistantId) );
      out.write("\r\n        <br />\r\n       <strong>Current privilegies: </strong>\r\n       ");
Vector assistPrivilegies=teacherBeanId.getNewAssistantPrivilegies(assistantId); 
      out.write("\r\n       ");
int assistantPrivNumb=assistPrivilegies.size(); 
      out.write("\r\n       ");
for (int i=0;i<assistantPrivNumb;i++){
      out.write("\r\n         ");
Integer privId=new Integer(assistPrivilegies.get(i).toString()); 
      out.write("\r\n         ");
int privilegieId=privId.intValue(); 
      out.write("\r\n         ");
      out.print(teacherBeanId.getAssistantPrivilegieNameById(privilegieId));
      out.write(",&nbsp;\r\n         ");
} 
      out.write("\r\n         <br />\r\n         <strong>Current groups: </strong>\r\n       ");
Vector assistGroups=teacherBeanId.getNewAssistantGroups(assistantId); 
      out.write("\r\n       ");
int assistantGroupsNumb=assistGroups.size(); 
      out.write("\r\n       ");
for (int i=0;i<assistantGroupsNumb;i++){
      out.write("\r\n         ");
Integer grId=new Integer(assistGroups.get(i).toString()); 
      out.write("\r\n         ");
int groupId=grId.intValue(); 
      out.write("\r\n         ");
      out.print(teacherBeanId.getGroupNameById(groupId));
      out.write(",&nbsp;\r\n         ");
} 
      out.write("\r\n         ");
if (hasPrivilegies.equals("Guest")){ 
      out.write("\r\n         <p>You are running in a guest mode. No change will take effects.</p>\r\n         ");
} 
      out.write("\r\n        <p>&nbsp;  </p>\r\n       <p>Please edit a assistant's privilegies in the form bellow:</p>\r\n       <p>&nbsp;  </p>\r\n\r\n\r\n\t  <form name=\"form1\" method=\"post\" action=\"formsAction.jsp?assistantId=");
      out.print(assistantId);
      out.write("\">\r\n\t  <table width=\"82%\">\r\n\t  <tr>\r\n\t    <td colspan=\"2\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">\r\n              <strong>Choose privilegies for new assistant:</strong></td>\r\n\t    <td colspan=\"3\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\"><strong>Choose the assistant's groups: </strong></td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t    <td height=\"179\" colspan=\"2\" rowspan=\"4\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">\r\n\r\n\r\n          ");
      out.write("\r\n          ");
      out.write("\r\n          ");
teacherBeanId.getAssistantPrivilegies(); 
      out.write("\r\n          ");
numbOfPrivilegies=teacherBeanId.getNumberOfAssistantsPrivilegies(); 
      out.write("\r\n\r\n          ");
for (int i=0;i<numbOfPrivilegies;i++){ 
      out.write("\r\n            ");
boolean assistantHasThatPriv=false; 
      out.write("\r\n            ");
privilegieId=teacherBeanId.getAssistantPrivilegieIdByOrdNumb(i); 
      out.write("\r\n            ");
privilegieName=teacherBeanId.getAssistantPrivilegieNameById(privilegieId); 
      out.write("\r\n\r\n            <p>\r\n              ");
      out.write("\r\n              ");
for (int s=0;s<assistantPrivNumb;s++){ 
      out.write("\r\n                ");
String gotPrivId=assistPrivilegies.get(s).toString(); 
      out.write("\r\n                ");
Integer prId=new Integer(gotPrivId); 
      out.write("\r\n                ");
int gotPrivilegieId=prId.intValue(); 
      out.write("\r\n\r\n                ");
if (privilegieId==gotPrivilegieId){ 
      out.write("\r\n\r\n                ");
assistantHasThatPriv=true; 
      out.write("\r\n              </p>\r\n              ");
} 
      out.write("\r\n              ");
} 
      out.write("\r\n\r\n             ");
if (!assistantHasThatPriv){ 
      out.write("\r\n              <input type=\"checkbox\" name=\"privilegie\" value=\"");
      out.print(privilegieId);
      out.write('"');
      out.write('>');
      out.print(privilegieName );
      out.write("\r\n\r\n              ");
}else{ 
      out.write("\r\n               <input type=\"checkbox\" name=\"privilegie\" checked=\"checked\" value=\"");
      out.print(privilegieId);
      out.write('"');
      out.write('>');
      out.print(privilegieName );
      out.write("\r\n\r\n              ");
} 
      out.write("\r\n\r\n              ");
} 
      out.write("\r\n\r\n\r\n          <br>\r\n        </p>\r\n        <p></p>\t\t</td>\r\n\r\n\r\n\t    <td width=\"14%\" rowspan=\"4\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\" align=\"center\">\r\n              <div align=\"left\">Available:\r\n              ");
int teacherId=teacherBeanId.getTeacherId(); 
      out.write("\r\n        ");
Vector teacherGroupsIds=teacherBeanId.getTeacherGroupsIds(teacherId); 
      out.write("\r\n        ");
int teacherGroupsNumb=teacherGroupsIds.size(); 
      out.write("\r\n\r\n                <SELECT SIZE=\"8\" MULTIPLE id=i_12 name=groups style=\"width:100px;\" >\r\n                  ");
for (int i=0;i<teacherGroupsNumb;i++){ 
      out.write("\r\n                  ");
Integer id=new Integer(teacherGroupsIds.get(i).toString()); 
      out.write("\r\n                  ");
int gId=id.intValue(); 
      out.write("\r\n                    ");
boolean assistantHasThatGroup=false; 
      out.write("\r\n\r\n                  ");
for (int s=0;s<assistantGroupsNumb;s++){ 
      out.write("\r\n                    ");
Integer agId=new Integer(assistGroups.get(s).toString()); 
      out.write("\r\n                    ");
int assGrId=agId.intValue(); 
      out.write("\r\n                   ");
if (gId==assGrId){ 
      out.write("\r\n                   ");
assistantHasThatGroup=true; 
      out.write("\r\n                   ");
} 
      out.write("\r\n                    ");
} 
      out.write("\r\n                   ");
if (!assistantHasThatGroup){ 
      out.write("\r\n                  <OPTION value=\"");
      out.print(gId);
      out.write('"');
      out.write('>');
      out.print(teacherBeanId.getGroupNameById(gId) );
      out.write("</OPTION>\r\n                  ");
}else{ 
      out.write("\r\n\r\n                 ");
} 
      out.write("\r\n                  ");
} 
      out.write("\r\n                </SELECT>\r\n\r\n\r\n            </div></td>\r\n\t    <td width=\"7%\" height=\"36\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;</td>\r\n\t    <td width=\"15%\" rowspan=\"4\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4; padding-bottom:4\" align=\"center\">\r\n              <div align=\"left\">Selected:\r\n                <select multiple size=\"8\" id=selectedGroups name=selectedGroups style=\"width:100px;\" >\r\n                  ");
for (int i=0;i<assistantGroupsNumb;i++){ 
      out.write("\r\n                  ");
Integer assId=new Integer(assistGroups.get(i).toString()); 
      out.write("\r\n                  ");
int assistGrId=assId.intValue(); 
      out.write("\r\n                  <OPTION value=\"");
      out.print(assistGrId);
      out.write('"');
      out.write('>');
      out.print(teacherBeanId.getGroupNameById(assistGrId) );
      out.write("</OPTION>\r\n                  ");
} 
      out.write("\r\n\r\n                </select>\r\n              </div></td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t    <td height=\"24\"  padding-top:4;padding-bottom:4\"><div align=\"center\">\r\n\t      <INPUT type = button width=\"60px\" name = xAdd id = i_13  onClick=\"return go_update_box('groups','selectedGroups')\" value = \" > \" >\r\n\t      </div></td>\r\n\t    </tr>\r\n\t  <tr>\r\n\t    <td height=\"25\" padding-top:4;padding-bottom:4\"><div align=\"center\">\r\n\t      <INPUT type = button  name = xRemove id = i_14 value = \" < \" onClick=\"return go_update_box('selectedGroups','groups')\">\r\n\t      </div></td>\r\n\t    </tr>\r\n\t  <tr>\r\n\t    <td padding-top:4;padding-bottom:4\">&nbsp;</td>\r\n\t    </tr>\r\n\t  <tr>\r\n\t    <td width=\"40%\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;\t       </td>\r\n\t    <td width=\"25%\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">\r\n            <input type=\"submit\" name=\"Submit\" value=\"Submit\" onClick=\"submitListValues();\"></td>\r\n\t    <td colspan=\"3\" style=\"border-top: 1px dotted #A6BDF2;padding-top:4;padding-bottom:4\">&nbsp;</td>\r\n");
      out.write("\t  </tr>\r\n</table>\r\n</form>\r\n             <p>&nbsp; </p>\r\n\r\n             ");
}else if (hasPrivilegies.equals("Limited")){ 
      out.write("\r\n             <h1>Sorry, you don't have enough privilegies for this.</h1>\r\n            ");
}
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n  </div><!--story-->\r\n</div><!--content-->\r\n<!--end content -->\r\n\r\n<!--end navbar -->\r\n<div id=\"siteInfo\" align=\"center\">\r\n  <a href=\"#\">About Us</a>\r\n  |\r\n  <a href=\"#\">Site Map</a>\r\n  |\r\n  <a href=\"#\">Privacy Policy</a>\r\n  |\r\n  <a href=\"mailto:jeremycod@yahoo.com\">Contact Us</a>\r\n  <br/>\r\n  <span class=\"copyrightStyle\">    &copy;\r\n    2006 FON - School of Business Administration, University of Belgrade\r\n</span>\r\n</div><!-siteInfo-->\r\n<br/>\r\n</div>\r\n</body>\r\n\r\n</html>\r\n");
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
