<!DOCTYPE html>
<%@page import="entities.Item"%>
<%@page import="controller.GioHangServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanphamModel"%>
<%@page import="model.SanphamModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">

	<div id="layoutSidenav_content">
		<main>
			<ol class="breadcrumb mb-4 mt-3">
				<li class="breadcrumb-item active "><i class="fas fa-bars"></i>
					Menu</li>
			</ol>
			<div class="row">
				<div class="col-xl-3 col-md-6">
					<div class="card bg-primary text-white mb-4">
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="insert2.jsp"><i
								class="far fa-plus-square"></i> Thêm Dữ Liệu</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>

				<div class="card mb-4">

					<div class="card-body table-responsive">
					
					<div class="card-header mb-1">
						<i class="fas fa-table "></i> Giỏ Hàng
					</div>
										<table class="table table-bordered table-dark " id="dataTable"
											width="100%" cellspacing="3" border="2">
											<thead>
												<tr class="text-center">
													<th>Mã SP</th>
													<th>Tên SP</th>
													<th>Giá</th>
													<th>Số Lượng</th>
													<th>Hình</th>
													<th>Total</th>
													<th><a class="btn btn-outline-danger mr-1" href="GioHangServlet?yeucau=deleteAll">Delete All</a></th>
												</tr>
											</thead>
											<c:forEach var="item" items="${giohang}">
												<tbody>
													<tr>
														<td class="text-center pt-5">${item.sanpham.maSP}</td>
														<td class="text-center pt-5">${item.sanpham.tenSP}</td>
														<td class="text-center pt-5">${item.sanpham.gia}</td>
														<td class="text-center pt-5">
														<a class="btn btn-outline-danger" href="GioHangServlet?yeucau=giam&txtmasp=${item.sanpham.maSP}">Giảm</a>
														${item.count}
														<a class="btn btn-outline-success" href="GioHangServlet?yeucau=tang&txtmasp=${item.sanpham.maSP}">Tăng</a></td>
														<td class="text-center " style="width: 10%"><img
															alt="" src="Images/${item.sanpham.hinh}" width="100%"></td>
														<td class="text-center pt-5">${item.gia()}</td>
														<td class="text-center pt-5"><a class="btn btn-outline-danger" href="GioHangServlet?yeucau=delete&txtmasp=${item.sanpham.maSP}">Delete</a>
														
														</td>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									
					</div>
					<div class="card-header">
						<i class="fas fa-table mr-1"></i>Danh Sách Sản Phẩm
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<form action="SanPhamServlet?yeucau=xoanhieu" method="post">
								<h1>${thongbao}</h1>
								<button type="submit" class="btn btn-outline-danger mb-3">Xóa
									Nhiều</button>
								<table class="table table-bordered table-dark" id="dataTable" width="100%"
									cellspacing="3" border="2">
									<thead>
										<tr class="text-center">
											<th></th>
											<th>Mã SP</th>
											<th>Tên SP</th>
											<th>Giá</th>
											<th>Số Lượng</th>
											<th>Hình</th>
											<th>Mã DM</th>
											<th></th>
											<th></th>
											<th></th>
										</tr>

									</thead>

									<%
										ArrayList sp_list = new SanphamModel().getList();
									%>
									<c:forEach var="p" items="<%=sp_list%>">
										<tbody>
											<tr>
												<td class="text-center pt-5"><input type="checkbox"
													name="chon" value="${p.maSP}"></td>
												<td class="text-center pt-5">${p.maSP}</td>
												<td class="text-center pt-5">${p.tenSP}</td>
												<td class="text-center pt-5">${p.gia}</td>
												<td class="text-center pt-5">${p.soLuong}
												<td class="text-center " style="width: 10%"><img alt=""
													src="Images/${p.hinh}" width="100%"></td>
												<td class="text-center pt-5">${p.maDM}</td>
												<td class="text-center pt-5"><a type="submit"
													class="btn btn-outline-danger "
													href="SanPhamServlet?yeucau=xoa&txtmasp=${p.maSP}">Xóa</a>
												<td class="text-center pt-5"><a
													class="btn btn-outline-success "
													href="update2.jsp">update</a></td>
												<td class="text-center pt-5"><a type="submit"
													class="btn btn-outline-danger "
													href="GioHangServlet?yeucau=muaSP&txtmasp=${p.maSP}">Thêm
														Vào Giỏ Hàng</a>
											</tr>
										</tbody>
									</c:forEach>
								</table>

							</form>
						</div>
					</div>
				</div>
			</div>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2019</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
			<script src="https://code.jquery.com/jquery-3.4.1.min.js"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
				crossorigin="anonymous"></script>
			<script src="js/scripts.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
				crossorigin="anonymous"></script>
			<script src="assets/demo/chart-area-demo.js"></script>
			<script src="assets/demo/chart-bar-demo.js"></script>
			<script
				src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
				crossorigin="anonymous"></script>
			<script src="assets/demo/datatables-demo.js"></script>
</body>
</html>
