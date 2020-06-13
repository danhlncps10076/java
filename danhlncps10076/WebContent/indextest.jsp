<%@page import="model.SanphamModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="Container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="navbar-brand" href="#">Trang Chủ</a>
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="#">Thêm
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Cập Nhập
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#"></a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true"></a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</div>
	<div class="row mx-3 my-3">
		<div class="col-md-3">
			<div class="list-group">
				<a href="#" class="list-group-item list-group-item-action">Dapibus
					ac facilisis in</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-primary">A
					simple primary list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-secondary">A
					simple secondary list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-success">A
					simple success list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-danger">A
					simple danger list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-warning">A
					simple warning list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-info">A
					simple info list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-light">A
					simple light list group item</a> <a href="#"
					class="list-group-item list-group-item-action list-group-item-dark">A
					simple dark list group item</a>
			</div>
		</div>
		<div class="col-md-9">
			<form action="SanPhamServlet?yeucau=xoanhieu" method="post">
				<table id="example"
					class="table table-striped table-bordered table-dark "
					cellspacing="0" width="100%">
					<thead>
						<tr><th></th>
							<th class="col px-5">Mã Sản Phẩm</th>
							<th class="col px-5">Tên Sản Phẩm</th>
							<th class="col px-5">Giá</th>
							<th class="col px-5">Số Lượng</th>
							<th class="col px-5">Hình</th>
							<th class="col px-5">Mã Danh Mục</th>
							<th><a href="insert2.jsp">insert</a></th>
						</tr>

					</thead>

					<%
						ArrayList sp_list = new SanphamModel().getList();
					%>
					<c:forEach var="p" items="<%=sp_list%>">
						<tbody>
							<tr>
							<td><input type="checkbox" name="chon" value="${p.maSP}"></td>
								<td>${p.maSP}</td>
								<td>${p.tenSP}</td>
								<td>${p.gia}</td>
								<td>${p.soLuong}
								<td><img alt="" src="Images/${p.hinh}" width="100%"></td>
								<td>${p.maDM}</td>
								<td><button type="submit">xóa</button>
								<td><a href="update2.jsp">update</a></button>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>

</body>

</html>