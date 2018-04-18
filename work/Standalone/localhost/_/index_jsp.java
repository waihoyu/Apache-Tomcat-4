package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

public class index_jsp extends HttpJspBase {


  private static java.util.Vector _jspx_includes;

  public java.util.List getIncludes() {
    return _jspx_includes;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    javax.servlet.jsp.PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\r\n");
      out.write("<html>\r\n    ");
      out.write("<head>\r\n    ");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n    ");
      out.write("<title>");
      out.print( application.getServerInfo() );
      out.write("</title>\r\n    ");
      out.write("<style type=\"text/css\">\r\n      ");
      out.write("<!--\r\n        body {\r\n            color: #000000;\r\n            background-color: #FFFFFF;\r\n            font-family: Arial, \"Times New Roman\", Times;\r\n            font-size: 16px;\r\n        }\r\n\r\n        A:link {\r\n            color: blue\r\n        }\r\n\r\n        A:visited {\r\n            color: blue\r\n        }\r\n\r\n        td {\r\n            color: #000000;\r\n            font-family: Arial, \"Times New Roman\", Times;\r\n            font-size: 16px;\r\n        }\r\n\r\n        .code {\r\n            color: #000000;\r\n            font-family: \"Courier New\", Courier;\r\n            font-size: 16px;\r\n        }\r\n      -->\r\n    ");
      out.write("</style>\r\n");
      out.write("</head>\r\n\r\n");
      out.write("<body>\r\n\r\n");
      out.write("<!-- Header -->\r\n");
      out.write("<table width=\"100%\">\r\n    ");
      out.write("<tr>\r\n        ");
      out.write("<td align=\"left\" width=\"130\">");
      out.write("<a href=\"http://jakarta.apache.org/tomcat/index.html\">");
      out.write("<img src=\"tomcat.gif\" height=\"92\" width=\"130\" border=\"0\" alt=\"The Mighty Tomcat - MEOW!\">");
      out.write("</td>\r\n        ");
      out.write("<td align=\"left\" valign=\"top\">\r\n            ");
      out.write("<table>\r\n                ");
      out.write("<tr>");
      out.write("<td align=\"left\" valign=\"top\">");
      out.write("<b>");
      out.print( application.getServerInfo() );
      out.write("</b>");
      out.write("</td>");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n        ");
      out.write("</td>\r\n        ");
      out.write("<td align=\"right\">");
      out.write("<a href=\"http://jakarta.apache.org/\">");
      out.write("<img src=\"jakarta-banner.gif\" height=\"100\" width=\"350\" border=\"0\" alt=\"The Jakarta Project\">");
      out.write("</a>");
      out.write("</td>\r\n    ");
      out.write("</tr>\r\n");
      out.write("</table>\r\n\r\n");
      out.write("<br>\r\n\r\n");
      out.write("<table>\r\n    ");
      out.write("<tr>\r\n\r\n        ");
      out.write("<!-- Table of Contents -->\r\n        ");
      out.write("<td valign=\"top\">\r\n            ");
      out.write("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bordercolor=\"#000000\">\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#D2A41C\" bordercolor=\"#000000\" align=\"left\" nowrap>\r\n                        ");
      out.write("<font face=\"Verdana\" size=\"+1\">");
      out.write("<i>Administration");
      out.write("</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</font>\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#FFDC75\" bordercolor=\"#000000\" nowrap>\r\n                        ");
      out.write("<a href=\"admin\">Tomcat Administration");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"manager/html\">Tomcat Manager");
      out.write("</a>");
      out.write("<br>\r\n                        &nbsp;\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n            ");
      out.write("<br>\r\n            ");
      out.write("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bordercolor=\"#000000\">\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#D2A41C\" bordercolor=\"#000000\" align=\"left\" nowrap>\r\n                        ");
      out.write("<font face=\"Verdana\" size=\"+1\">");
      out.write("<i>Documentation");
      out.write("</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</font>\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#FFDC75\" bordercolor=\"#000000\" nowrap>\r\n                        ");
      out.write("<a href=\"tomcat-docs\">Tomcat Documentation");
      out.write("</a>");
      out.write("<br>\r\n                        &nbsp;\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n            ");
      out.write("<br>\r\n            ");
      out.write("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bordercolor=\"#000000\">\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#D2A41C\" bordercolor=\"#000000\" align=\"left\" nowrap>\r\n                        ");
      out.write("<font face=\"Verdana\" size=\"+1\">");
      out.write("<i>Tomcat Online");
      out.write("</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</font>\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#FFDC75\" bordercolor=\"#000000\" nowrap>\r\n                        ");
      out.write("<a href=\"http://jakarta.apache.org/tomcat/\">Home Page");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"http://jakarta.apache.org/tomcat/bugreport.html\">Bug Database");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"http://www.mail-archive.com/tomcat-user%40jakarta.apache.org/\">Users Mailing List");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"http://www.mail-archive.com/tomcat-dev%40jakarta.apache.org/\">Developers Mailing List");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"irc://irc.us.openprojects.net/tomcat\">IRC");
      out.write("</a>");
      out.write("<br>\r\n                        &nbsp;\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n            ");
      out.write("<br>\r\n            ");
      out.write("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bordercolor=\"#000000\">\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#D2A41C\" bordercolor=\"#000000\" align=\"left\" nowrap>\r\n                        ");
      out.write("<font face=\"Verdana\" size=\"+1\">");
      out.write("<i>Examples");
      out.write("</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</font>\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#FFDC75\" bordercolor=\"#000000\" nowrap>\r\n                        ");
      out.write("<a href=\"examples/jsp/\">JSP Examples");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"examples/servlets/\">Servlet Examples");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"webdav/\">WebDAV capabilities");
      out.write("</a>");
      out.write("<br>\r\n                        &nbsp;\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n            ");
      out.write("<br>\r\n            ");
      out.write("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bordercolor=\"#000000\">\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#D2A41C\" bordercolor=\"#000000\" align=\"left\" nowrap>\r\n                        ");
      out.write("<font face=\"Verdana\" size=\"+1\">");
      out.write("<i>Miscellaneous");
      out.write("</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</font>\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n                ");
      out.write("<tr>\r\n                    ");
      out.write("<td bgcolor=\"#FFDC75\" bordercolor=\"#000000\" nowrap>\r\n                        ");
      out.write("<a href=\"http://java.sun.com/products/jsp\">Sun's Java Server Pages Site");
      out.write("</a>");
      out.write("<br>\r\n                        ");
      out.write("<a href=\"http://java.sun.com/products/servlet\">Sun's Servlet Site");
      out.write("</a>");
      out.write("<br>\r\n                        &nbsp;\r\n                    ");
      out.write("</td>\r\n                ");
      out.write("</tr>\r\n            ");
      out.write("</table>\r\n        ");
      out.write("</td>\r\n\r\n        ");
      out.write("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("</td>\r\n\r\n        ");
      out.write("<!-- Body -->\r\n        ");
      out.write("<td align=\"left\" valign=\"top\">\r\n            ");
      out.write("<p>");
      out.write("<center>");
      out.write("<b>If you're seeing this page via a web browser, it means you've setup Tomcat successfully. Congratulations!");
      out.write("</b>");
      out.write("</center>");
      out.write("</p>\r\n\r\n            ");
      out.write("<p>As you may have guessed by now, this is the default Tomcat home page. It can be found on the local filesystem at:\r\n            ");
      out.write("<blockquote>\r\n                ");
      out.write("<p class=\"code\">$CATALINA_HOME/webapps/ROOT/index.html");
      out.write("</p>\r\n            ");
      out.write("</blockquote>\r\n            ");
      out.write("</p>\r\n\r\n            ");
      out.write("<p>where \"$CATALINA_HOME\" is the root of the Tomcat installation directory. If you're seeing this page, and you don't think you should be, then either you're either a user who has arrived at new installation of Tomcat, or you're an administrator who hasn't got his/her setup quite right. Providing the latter is the case, please refer to the ");
      out.write("<a href=\"tomcat-docs\">Tomcat Documentation");
      out.write("</a> for more detailed setup and administration information than is found in the INSTALL file.");
      out.write("</p>\r\n\r\n            ");
      out.write("<p>");
      out.write("<b>NOTE: For security reasons, using the administration webapp \r\n            is restricted to users with role \"admin\". The manager webapp \r\n            is restricted to users with role \"manager\".");
      out.write("</b>\r\n            Users are defined in ");
      out.write("<code>$CATALINA_HOME/conf/tomcat-users.xml");
      out.write("</code>.");
      out.write("</p>\r\n\r\n            ");
      out.write("<p>Included with this release are a host of sample Servlets and JSPs (with associated source code), extensive documentation (including the Servlet 2.3 and JSP 1.2 API JavaDoc), and an introductory guide to developing web applications.");
      out.write("</p>\r\n\r\n            ");
      out.write("<p>Tomcat mailing lists are available at the Jakarta project web site:");
      out.write("</p>\r\n\r\n           ");
      out.write("<ul>\r\n               ");
      out.write("<li>");
      out.write("<b>");
      out.write("<a href=\"mailto:tomcat-user-subscribe@jakarta.apache.org\">tomcat-user@jakarta.apache.org");
      out.write("</a>");
      out.write("</b> for general questions related to configuring and using Tomcat");
      out.write("</li>\r\n               ");
      out.write("<li>");
      out.write("<b>");
      out.write("<a href=\"mailto:tomcat-dev-subscribe@jakarta.apache.org\">tomcat-dev@jakarta.apache.org");
      out.write("</a>");
      out.write("</b> for developers working on Tomcat");
      out.write("</li>\r\n           ");
      out.write("</ul>\r\n\r\n            ");
      out.write("<p>Thanks for using Tomcat!");
      out.write("</p>\r\n\r\n            ");
      out.write("<p align=\"right\">");
      out.write("<font size=-1>");
      out.write("<img src=\"tomcat-power.gif\" width=\"77\" height=\"80\">");
      out.write("</font>");
      out.write("<br>\r\n            &nbsp;\r\n            ");
      out.write("<font size=-1>Copyright &copy; 1999-2002 Apache Software Foundation");
      out.write("</font>");
      out.write("<br>\r\n            ");
      out.write("<font size=-1>All Rights Reserved");
      out.write("</font> ");
      out.write("<br>\r\n            &nbsp;");
      out.write("</p>\r\n            ");
      out.write("<p align=\"right\">&nbsp;");
      out.write("</p>\r\n\r\n        ");
      out.write("</td>\r\n\r\n    ");
      out.write("</tr>\r\n");
      out.write("</table>\r\n\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      out = _jspx_out;
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
}
