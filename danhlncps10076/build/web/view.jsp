<%-- 
    Document   : view
    Created on : May 21, 2020, 8:59:05 AM
    Author     : home
--%>

<%@page import="entities.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>
            <!--Xuat ra gia tri attribute ra-->
            <%= request.getAttribute("thongbao")%>
        </h1>
        <h1>DANH SÁCH TÀI KHOẢN</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                </tr>
            </thead>
            <tbody>
            <%
                //1. lấy lại biến session
                ArrayList list = (ArrayList)session.getAttribute("accountList");
                //2. dùng for xuất ra
                for(Object acc:list){
                    //3. doi tuong
                    Account a = (Account)acc;
                
            %>    
                
                <tr>
                    <td><%=a.getUsername()%></td>
                    <td><%=a.getPassword()%></td>
                </tr>

            <%
                }
            %>    
            </tbody>
        </table>

    </center>
</body>
</html>
