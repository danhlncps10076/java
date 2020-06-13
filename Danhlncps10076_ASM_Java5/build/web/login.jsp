<%-- 
    Document   : login
    Created on : May 21, 2020, 8:51:18 AM
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
        <h1>ĐĂNG NHẬP</h1>
        <form action="AccountServlet" method="POST">
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
                        <td><input type="submit" value="Login" name="Action" /></td>
                    </tr>
                </tbody>
            </table>

        </form> 
    </body>
</html>
