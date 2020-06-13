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
        <h1 style="color:red">
            <!--Xuat ra gia tri attribute ra-->
            <%= request.getAttribute("thongbao")%>
        </h1>
        <form action="AccountServlet2?yeucau=search" method="post">
        	<h3>Search</h3>
        	Username <input type="text" name="txtname">
        	<input type="submit" value="Search">
        </form>
        <hr>
        <h1>DANH SÁCH TÀI KHOẢN</h1>
        <form action="AccountServlet2?yeucau=xoanhieu" method="post">
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
                	<td><input type="checkbox" name="chon" value="<%=a.getUsername()%>"></td>
                    <td><%=a.getUsername()%></td>
                    <td><%=a.getPassword()%></td>
                    <td><a href="AccountServlet2?yeucau=delete&txtUsername=<%=a.getUsername()%>">Detele</a></td>
                    <td><a href="AccountServlet2?yeucau=laythongtin&txtUsername=<%=a.getUsername()%>&txtPassword=<%=a.getPassword()%>">update</a></td>
                </tr>
            <%
                }
            %>    
            <h3><a href="insert.jsp">Insert</a></h3>
            </tbody>
        </table>
        <input type="submit" value="Xóa nhiều">
</form>
    </center>
</body>
</html>
