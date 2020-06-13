<%-- 
    Document   : insert
    Created on : May 26, 2020, 10:43:33 AM
    Author     : home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>THÊM TÀI KHOẢN</h1>
        <form action="AccountServlet2?yeucau=insert" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>UserName : </td>
                        <td><input type="text" name="txtUsername" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input type="password" name="txtPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Insert" name="Action" /></td>
                    </tr>
                </tbody>
            </table>

    </body>
</html>
