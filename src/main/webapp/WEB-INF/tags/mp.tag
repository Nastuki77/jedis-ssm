<%@ tag import="org.jedis.web.vo.LoginInfo" %>
<%@ tag import="org.jedis.entity.Allows" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute rtexprvalue="true" required="true" name="module"%>
<%@ attribute rtexprvalue="true" required="true" name="value"%>
<%@ tag body-content="scriptless"%>
<%
    LoginInfo login = (LoginInfo) request.getSession().getAttribute(
            "current_ssologin_user");
    if (login != null) {
        if (login.getAllows().contains(new Allows(module, value))) {
%>
<jsp:doBody />
<%
        }
    }
%>
