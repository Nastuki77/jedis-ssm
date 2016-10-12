<%@ taglib prefix="my" uri="http://my.fd.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nastuki
  Date: 2016/10/9
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ssh</h1>
<my:pem module="report" value="expensePurchaseReport">
    <li><a href="javascript:void(0)" onclick="asyncLoad('${baseUrl}report/expensePurchaseReportStartingPage');">PO报表</a></li>
</my:pem>
</body>
</html>
