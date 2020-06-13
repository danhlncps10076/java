<%-- 
    Document   : insert
    Created on : May 26, 2020, 10:43:33 AM
    Author     : home
--%>

<%@page import="entities.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SỬA TÀI KHOẢN</h1>
        <% Account account = (Account) session.getAttribute("acc");%>
        <form action="AccountServlet2?yeucau=update" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>UserName : </td>
                        <td><input type="text" name="txtUsername" value="<%=account.getUsername() %>" /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input type="password" name="txtPassword" value="<%=account.getPassword() %>" /></td>
                    </tr>
                    <tr>
                        <td>Password new: </td>
                        <td><input type="password" name="txtPassword2" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update" name="Action" /></td>
                    </tr>
                </tbody>
            </table>

    </body>
</html>
