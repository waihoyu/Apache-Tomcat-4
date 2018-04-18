package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

public class login_jsp extends HttpJspBase {


  private static java.util.Vector _jspx_includes;

  static {
    _jspx_includes = new java.util.Vector(2);
    _jspx_includes.add("/header.jsp");
    _jspx_includes.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_html_locale;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_message_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_base;

  public login_jsp() {
    _jspx_tagPool_html_html_locale = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_bean_message_key = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_html_base = new org.apache.jasper.runtime.TagHandlerPool();
  }

  public java.util.List getIncludes() {
    return _jspx_includes;
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_html_locale.release();
    _jspx_tagPool_bean_message_key.release();
    _jspx_tagPool_html_base.release();
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- Standard Struts Entries -->\r\n\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n\r\n");
      /* ----  html:html ---- */
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_html_0 = (org.apache.struts.taglib.html.HtmlTag) _jspx_tagPool_html_html_locale.get(org.apache.struts.taglib.html.HtmlTag.class);
      _jspx_th_html_html_0.setPageContext(pageContext);
      _jspx_th_html_html_0.setParent(null);
      _jspx_th_html_html_0.setLocale(true);
      int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
      if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          out.write("<!-- Make sure window is not in a frame -->\r\n\r\n");
          out.write("<script language=\"JavaScript\" type=\"text/javascript\">\r\n\r\n  ");
          out.write("<!--\r\n    if (window.self != window.top) {\r\n      window.open(\".\", \"_top\");\r\n    }\r\n  // -->\r\n\r\n");
          out.write("</script>\r\n\r\n");
          out.write("<!-- Standard Content -->\r\n\r\n");
          out.write("<!--\r\n  Copyright (c) 1999-2001 The Apache Software Foundation.  All rights\r\n  reserved.\r\n-->\r\n\r\n");
          out.write("<head>\r\n  ");
          out.write("<title>");
          if (_jspx_meth_bean_message_0(_jspx_th_html_html_0, pageContext))
            return;
          out.write("</title>\r\n  ");
          if (_jspx_meth_html_base_0(_jspx_th_html_html_0, pageContext))
            return;
          out.write("\r\n  ");
          out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"tree-control-test.css\">\r\n  ");
          out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"admin.css\">\r\n");
          out.write("</head>\r\n");
          out.write("\r\n\r\n");
          out.write("<!-- Body -->\r\n\r\n");
          out.write("<body background=\"images/LoginBackgroundTile.gif\">\r\n\r\n");
          out.write("<center>\r\n\r\n");
          out.write("<!-- Login -->\r\n\r\n");
          out.write("<form method=\"POST\" action='");
          out.print( response.encodeURL("j_security_check") );
          out.write("'\r\n name=\"loginForm\">\r\n  ");
          out.write("<table border=\"0\" cellspacing=\"5\" background=\"images/LoginBackgroundTile.gif\">\r\n\r\n    ");
          out.write("<tr>\r\n    ");
          out.write("<!-- banner -->\r\n     ");
          out.write("<td height=\"183\">\r\n        ");
          out.write("<div align=\"center\">");
          out.write("<img src=\"images/Login.jpg\" alt=\"Tomcat Web Server Administration Tool\" width=\"490\" height=\"228\">");
          out.write("</div>\r\n      ");
          out.write("</td>\r\n    ");
          out.write("</tr>\r\n\r\n    ");
          out.write("<!-- username password prompts fields layout -->\r\n    ");
          out.write("<tr>\r\n    ");
          out.write("<td background=\"images/LoginBackgroundTile.gif\">\r\n     ");
          out.write("<table width=\"100%\" border=\"0\" cellspacing=\"2\" cellpadding=\"5\">\r\n     ");
          out.write("<tr>\r\n      ");
          out.write("<th align=\"right\">\r\n        ");
          out.write("<font color=\"#FFFFFF\">");
          out.write("<label for=\"username\">");
          if (_jspx_meth_bean_message_1(_jspx_th_html_html_0, pageContext))
            return;
          out.write("</label>");
          out.write("</font>\r\n      ");
          out.write("</th>\r\n      ");
          out.write("<td align=\"left\">\r\n        ");
          out.write("<input type=\"text\" name=\"j_username\" size=\"16\" maxlength=\"16\" id=\"username\"/>\r\n      ");
          out.write("</td>\r\n    ");
          out.write("</tr>\r\n    ");
          out.write("<p>\r\n    ");
          out.write("<tr>\r\n      ");
          out.write("<th align=\"right\">\r\n        ");
          out.write("<font color=\"#FFFFFF\">");
          out.write("<label for=\"password\">");
          if (_jspx_meth_bean_message_2(_jspx_th_html_html_0, pageContext))
            return;
          out.write("</label>");
          out.write("</font>\r\n      ");
          out.write("</th>\r\n      ");
          out.write("<td align=\"left\">\r\n        ");
          out.write("<input type=\"password\" name=\"j_password\" size=\"16\" maxlength=\"16\" id=\"password\"/>\r\n      ");
          out.write("</td>\r\n    ");
          out.write("</tr>\r\n\r\n    ");
          out.write("<tr>\r\n      ");
          out.write("<td width=\"50%\" valign=\"top\"> ");
          out.write("<div align=\"right\">");
          out.write("</div> ");
          out.write("</td>\r\n      ");
          out.write("<td width=\"55%\" valign=\"top\">&nbsp;");
          out.write("</td>\r\n     ");
          out.write("</tr>\r\n\r\n    ");
          out.write("<!-- login reset buttons layout -->\r\n    ");
          out.write("<tr>\r\n       ");
          out.write("<td width=\"50%\" valign=\"top\">\r\n            ");
          out.write("<div align=\"right\">\r\n               ");
          out.write("<input type=\"submit\" value='");
          if (_jspx_meth_bean_message_3(_jspx_th_html_html_0, pageContext))
            return;
          out.write("'>&nbsp;&nbsp;\r\n            ");
          out.write("</div>\r\n       ");
          out.write("</td>\r\n       ");
          out.write("<td width=\"55%\" valign=\"top\">\r\n          &nbsp;&nbsp;");
          out.write("<input type=\"reset\" value='");
          if (_jspx_meth_bean_message_4(_jspx_th_html_html_0, pageContext))
            return;
          out.write("'>\r\n       ");
          out.write("</td>\r\n     ");
          out.write("</tr>\r\n  ");
          out.write("</table>\r\n  ");
          out.write("<p> &nbsp;\r\n  ");
          out.write("</td>\r\n  ");
          out.write("</tr>\r\n ");
          out.write("</table>\r\n");
          out.write("</form>\r\n\r\n");
          out.write("<script language=\"JavaScript\" type=\"text/javascript\">\r\n  ");
          out.write("<!--\r\n    document.forms[\"loginForm\"].elements[\"j_username\"].focus()\r\n  // -->\r\n");
          out.write("</script>\r\n\r\n");
          out.write("</body>\r\n\r\n");
          out.write("<!-- Standard Footer -->\r\n\r\n");
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_html_html_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_html_locale.reuse(_jspx_th_html_html_0);
      out.write("\r\n");
    } catch (Throwable t) {
      out = _jspx_out;
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }

  private boolean _jspx_meth_bean_message_0(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:message ---- */
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_0.setPageContext(pageContext);
    _jspx_th_bean_message_0.setParent(_jspx_th_html_html_0);
    _jspx_th_bean_message_0.setKey("application.title");
    int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
    if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_0);
    return false;
  }

  private boolean _jspx_meth_html_base_0(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  html:base ---- */
    org.apache.struts.taglib.html.BaseTag _jspx_th_html_base_0 = (org.apache.struts.taglib.html.BaseTag) _jspx_tagPool_html_base.get(org.apache.struts.taglib.html.BaseTag.class);
    _jspx_th_html_base_0.setPageContext(pageContext);
    _jspx_th_html_base_0.setParent(_jspx_th_html_html_0);
    int _jspx_eval_html_base_0 = _jspx_th_html_base_0.doStartTag();
    if (_jspx_th_html_base_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_base.reuse(_jspx_th_html_base_0);
    return false;
  }

  private boolean _jspx_meth_bean_message_1(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:message ---- */
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_1.setPageContext(pageContext);
    _jspx_th_bean_message_1.setParent(_jspx_th_html_html_0);
    _jspx_th_bean_message_1.setKey("prompt.username");
    int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
    if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_1);
    return false;
  }

  private boolean _jspx_meth_bean_message_2(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:message ---- */
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_2.setPageContext(pageContext);
    _jspx_th_bean_message_2.setParent(_jspx_th_html_html_0);
    _jspx_th_bean_message_2.setKey("prompt.password");
    int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
    if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_2);
    return false;
  }

  private boolean _jspx_meth_bean_message_3(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:message ---- */
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_3.setPageContext(pageContext);
    _jspx_th_bean_message_3.setParent(_jspx_th_html_html_0);
    _jspx_th_bean_message_3.setKey("button.login");
    int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
    if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_3);
    return false;
  }

  private boolean _jspx_meth_bean_message_4(javax.servlet.jsp.tagext.Tag _jspx_th_html_html_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:message ---- */
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_4 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_4.setPageContext(pageContext);
    _jspx_th_bean_message_4.setParent(_jspx_th_html_html_0);
    _jspx_th_bean_message_4.setKey("button.reset");
    int _jspx_eval_bean_message_4 = _jspx_th_bean_message_4.doStartTag();
    if (_jspx_th_bean_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_4);
    return false;
  }
}
