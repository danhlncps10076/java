<%@page import="entities.DanhMuc"%>
<%@page import="model.SanphamModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<form action="SanPhamServlet?yeucau=update"  method="POST" enctype='multipart/form-data' class="col-auto">
	
	<% 
		SanphamModel sp = new SanphamModel();%>
		<a class="btn btn-outline-success mt-1" href="index2.jsp">Trở về</a><h3 class="text-center ">Cập Nhật Sản Phẩm</h3>
		<table class="form-group" style="width: 100%;">	
			<tr >
				<select class="form-control" name="txtmasp">
					<c:forEach var="sp" items="<%=sp.getListMSP()%>">
						<option value="${sp}"  class="text-center ">${sp}</option>
					</c:forEach>
				</select>
			</tr>
			<tr>
				<td class="text-center "><input type="text" name="txttensp" class="form-control"placeholder="Tên Sản Phẩm">
			</tr>
			<tr>
				<td  class="text-center "><input type="text" name="txtgia" class="form-control"placeholder="Giá Sản Phẩm">
			</tr>
			<tr>
				<td  class="text-center "><input type="text" name="txtsoluong" class="form-control"placeholder="Số lượng">
			</tr>
			<tr>
			<td><select class="form-control" name="txtmadanhmuc">
				<c:forEach var="dm" items="<%=sp.danhMuc()%>">
					<option value="${dm.maDM}"  class="text-center ">${dm.tenDM} </option>
				</c:forEach>
				</select></td>
				
			</tr>
			
			<tr>
				<td  class="text-center "><input type="file" name="txthinh" class="form-control-file">
			</tr>
			<tr>
				<td class="text-center "><input type="submit" value="update" class="btn btn-outline-success mt-5 mb-4">
			</tr>
		</table>
	</form>
</body>
</html>