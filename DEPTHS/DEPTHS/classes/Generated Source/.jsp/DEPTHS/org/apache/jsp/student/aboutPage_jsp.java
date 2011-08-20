package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aboutPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String detailLevel; 
 String programmLang; 
 String displayForm="GoF"; 
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

      out.write("<!-- Provided by MyFreeTemplates.com -->\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<title>Design Patterns Teaching Help System</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n<meta name=\"keywords\" content=\"Keywords here\">\r\n<meta name=\"description\" content=\"Description here\">\r\n<meta name=\"Author\" content=\"MyFreeTemplates.com\">\r\n<META NAME=\"robots\" CONTENT=\"index, follow\">\r\n<!-- (Robot commands: All, None, Index, No Index, Follow, No Follow) -->\r\n<META NAME=\"revisit-after\" CONTENT=\"30 days\">\r\n<META NAME=\"distribution\" CONTENT=\"global\">\r\n<META NAME=\"rating\" CONTENT=\"general\">\r\n<META NAME=\"Content-Language\" CONTENT=\"english\"><script language=\"JavaScript\" type=\"text/JavaScript\" src=\"pages/images/myfreetemplates.js\"></script>\r\n<script language=\"JavaScript\" src=\"pages/images/menu.js\" type=\"text/JavaScript\"></script>\r\n<link href=\"pages/images/myfreetemplates.css\" rel=\"stylesheet\" type=\"text/css\">\r\n<script language=\"JavaScript\" src=\"pages/images/mm_menu.js\"></script>\r\n");
      out.write("\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n.style9 {font-size: 14px}\r\n-->\r\n</style>\r\n</head>\r\n\r\n");
      depths.presentationModule.RegistrationBean registrationBeanId = null;
      synchronized (session) {
        registrationBeanId = (depths.presentationModule.RegistrationBean) _jspx_page_context.getAttribute("registrationBeanId", PageContext.SESSION_SCOPE);
        if (registrationBeanId == null){
          registrationBeanId = new depths.presentationModule.RegistrationBean();
          _jspx_page_context.setAttribute("registrationBeanId", registrationBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write("\r\n\r\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onLoad=\"MM_preloadImages('pages/images/btn_location_dn.gif')\">\r\n<script language=\"JavaScript1.2\">mmLoadMenus();</script>\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
 detailLevel=registrationBeanId.getDetailLevel(); 
      out.write('\r');
      out.write('\n');
 programmLang=registrationBeanId.getProgrammingLanguage(); 
      out.write("\r\n<TABLE WIDTH=593 height=\"100%\" BORDER=0 align=\"center\" CELLPADDING=0 CELLSPACING=0>\r\n  <TR>\r\n    <TD width=\"593\" height=\"100\" colspan=\"2\" bgcolor=\"#BBCCF6\">\r\n     <TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>\r\n        <TR>\r\n          <TD width=\"590\" height=\"80\" valign=\"top\" bgcolor=\"#BBCCF6\">\r\n\r\n\t\t        <table width=\"97%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n\r\n\t\t\t   <td height=\"39\" style=\"padding-left:12;padding-top:11\" bgcolor=\"#BBCCF6\">&nbsp; </td>\r\n               <td style=\"padding-top:11; font-weight: bold; font-size: 18px; font-color=#000000\" class=\"newsarticle\"><div align=\"right\"><span class=\"style1 style2\">DEPTHS - DEsign Patterns Teaching Help System\r\n                  </span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"style4\">&nbsp;<span class=\"style9\">Version 1.1.0</span></span> </div></td>\r\n            </tr>\r\n            <tr>\r\n              <td height=\"39\" style=\"padding-left:12;padding-top:11\">&nbsp;</td>\r\n              <td style=\"padding-top:11\" class=\"newsarticle\">&nbsp;</td>\r\n            </tr>\r\n          </table></TD>\r\n        </TR>\r\n      </TABLE>    </TD>\r\n  </TR>\r\n  <TR valign=\"top\">\r\n    <TD height=\"315\" bordercolor=\"#FFFFFF\" style=\"padding-left:12;padding-top:7\">\r\n      <h1 style=\"margin:0\">&nbsp;</h1>\r\n              <form name=\"form1\" method=\"post\" action=\"window.close();\">\r\n                <table width=\"579\" height=\"194\" border=\"1\" bordercolor=\"#FFFFFF\">\r\n          <tr>\r\n            <td width=\"569\" height=\"188\" bordercolor=\"#FFFFFF\"><table width=\"569\" height=\"327\" border=\"1\" bordercolor=\"#FFFFFF\">\r\n              <tr>\r\n                <td height=\"37\" bordercolor=\"#000000\"><table width=\"559\" border=\"0\">\r\n                    <tr bordercolor=\"#FFFFFF\">\r\n");
      out.write("                      <td width=\"272\"><a href=\"homepage.htm\">Author...</a></td>\r\n                      <td width=\"271\"><div align=\"right\" class=\"style4\">Jeremic Zoran </div></td>\r\n                    </tr>\r\n                  </table></td>\r\n              </tr>\r\n              <tr>\r\n                <td height=\"134\" bordercolor=\"#000000\"><p><strong>DEsign Patterns Teaching Help System@</strong> is an intelligent tutoring system for learning Design Patterns. The basic idea of this system is a systematic introduction into the concept of most frequently used classes of patterns. An individual course is generated automatically for a given teaching goal and is dynamically adapted at run time to the student's individual progress and preferences according to the teaching expertise. The system provides explicit support for adaptive presentation constructs, and admits external navigation mechanisms and user model update strategies.</p>\r\n                  <p align=\"center\"><a href=\"index.html\">[Click here to go to the DEPTHS HomePage] </a></p></td>\r\n");
      out.write("              </tr>\r\n              <tr>\r\n                <td height=\"25\" bordercolor=\"#000000\">Email support: <a href=\"mailto:jeremycod@yahoo.com\">jeremycod@yahoo.com</a></td>\r\n              </tr>\r\n              <tr>\r\n                <td height=\"54\" bordercolor=\"#000000\">&nbsp;</td>\r\n              </tr>\r\n              <tr>\r\n                <td height=\"63\" bordercolor=\"#000000\"><table width=\"554\" border=\"1\" bordercolor=\"#FFFFFF\">\r\n                  <tr bordercolor=\"#FFFFFF\">\r\n                    <td width=\"461\">Copyright @ Jeremic Zoran 2004-2005\r\n                        <p>&nbsp;&nbsp;All Rights Reserved </p></td>\r\n                    <td width=\"77\"><input type=\"submit\" name=\"Submit\" value=\"Close\" onclick=\"window.close();\"></td>\r\n                  </tr>\r\n                </table></td>\r\n              </tr>\r\n            </table></td>\r\n          </tr>\r\n        </table>\r\n      </form>\r\n    <blockquote>&nbsp;</blockquote>    </TD>\r\n  </TR>\r\n</TABLE>\r\n</body>\r\n</html>\r\n");
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
