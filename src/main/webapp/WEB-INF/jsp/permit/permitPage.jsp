<%--
  Created by IntelliJ IDEA.
  User: Nastuki
  Date: 2016/10/13
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/meta.jsp"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<html>
<head>
</head>
<body>
<div class="row">
    <div class="col-md-12 s-detail" id="ap_mainframe">
        <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-target="#ap_emp" style="cursor:pointer">
                <p id="titleName">权限管理</p>

                <button type="button" class="close">
                    <span class="caret"></span>
                </button>
            </div>
            <div class="panel-body niceform">
                <table class="table table-hover">
                    <tbody>
                    <c:forEach var="permit" items="${permits}" varStatus="st">
                        <tr>
                            <input name="chkItem${st.count}" type="checkbox" class="niceform" value="${permit.moduleValue}" />
                        </tr>
                        <c:forEach var="value" items="${permit.valueVos}">
                            <tr>
                                <input name="chkItems${st.count}" type="checkbox" class="niceform" value="${value.permitValue}"
                                        ${value.flag==1?"checked":""}/>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script>
    $.NFInit();
    $.NFFix();
</script>
