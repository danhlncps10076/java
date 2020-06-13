<%-- 
    Document   : error
    Created on : May 21, 2020, 8:59:59 AM
    Author     : home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="color:red">
        <!--Xuat ra gia tri attribute ra-->
        <%= request.getAttribute("thongbao")%>
    </body>
</html>
