package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lessonStatisticSettingParameters_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int passedConceptOrdNum; 
 String passedConceptId; 
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

      depths.presentationModule.StatisticBean statisticBeanId = null;
      synchronized (session) {
        statisticBeanId = (depths.presentationModule.StatisticBean) _jspx_page_context.getAttribute("statisticBeanId", PageContext.SESSION_SCOPE);
        if (statisticBeanId == null){
          statisticBeanId = new depths.presentationModule.StatisticBean();
          _jspx_page_context.setAttribute("statisticBeanId", statisticBeanId, PageContext.SESSION_SCOPE);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n  ");
passedConceptOrdNum=Integer.parseInt(request.getParameter("PassedConceptOrdNum")); 
      out.write("\r\n  ");
 passedConceptId=statisticBeanId.getPassedConceptIdByOrdNum(passedConceptOrdNum); 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
response.sendRedirect(response.encodeURL("lessonsStatisticPage.jsp?conceptId="+passedConceptId));
      out.write("\r\n\r\n");
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
