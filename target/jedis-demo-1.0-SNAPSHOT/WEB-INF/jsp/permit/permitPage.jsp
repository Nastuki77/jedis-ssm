<%--
  Created by IntelliJ IDEA.
  User: Nastuki
  Date: 2016/10/13
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/meta.jsp" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<html>
<head>
</head>
<body>
<div class="row">
    <div class="col-md-12 s-detail" id="ap_mainframe">
        <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-target="#ap_emp" style="cursor:pointer">
                <p id="titleName"><h3>权限管理</h3></p>

                <button type="button" class="close">
                    <span class="caret"></span>
                </button>
            </div>
            <div class="panel-body niceform">
                <table class="table table-striped table-bordered table-condensed">
                    <tbody>
                    <c:forEach var="permit" items="${permits}" varStatus="st">
                        <tr>
                            <td>
                                <input name="chkItem${st.count}" type="checkbox" class="niceform"
                                       style="margin-left: 20px"/>${permit.moduleName}
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <c:forEach var="vo" items="${permitVos}">
                                <c:if test="${vo.moduleValue==permit.moduleValue}">
                                    <input name="chkItems${st.count}" type="checkbox" class="niceform"
                                           style="margin-left: 40px"
                                        ${vo.flag==1?"checked":""}/>${vo.permitName}
                                </c:if>
                            </c:forEach>
                            </td>
                        </tr>
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
