<%@ page import="com.swaruph.web.model.FileTransfer" %><%--
  Created by IntelliJ IDEA.
  User: zappp
  Date: 9/18/24
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Transfer Page</title>
</head>
<body bgcolor="cyan">
    <%
        FileTransfer f1 = (FileTransfer) session.getAttribute("fileTransfer");
        out.println(f1);
    %>
</body>
</html>
