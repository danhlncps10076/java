/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountModel;

/**
 *
 * @author home
 */
@WebServlet(name = "AccountServlet2", urlPatterns = { "/AccountServlet2" })
public class AccountServlet2 extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */

	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */

			// 1. lấy giá trị user và pass từ form
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			// 2. lay lai gia tri cua biến yeucau
			String yeucau = request.getParameter("yeucau");

			// khai báo biến session

			HttpSession session = request.getSession();
			// 2. tao 1 doi tuong Account
			Account acc = new Account(username, password);
			// 3. tao 1 doi tuong cua lop AccountModel
			// 4.
			AccountModel acc_model = new AccountModel();
			String page = ""; // biến trang cần chuyển đến
			String thongbao = ""; // bien thongbao
			if (yeucau.equals("insert")) {

				int kq = acc_model.insertAccount(acc);

				if (kq == -1) {
					page = "error.jsp";
					thongbao = "khong ket noi duoc voi csdl";
				} else if (kq == 1) {
					// 2. chuyển đến trang view.jsp
					page = "view.jsp";
					thongbao = "thêm thanh cong.";
					// 3. gọi hàm getList lay ra danh sách tài khoản bỏ vào session
					session.setAttribute("accountList", new AccountModel().getList());
				} else {
					// 2. chuyển đến trang error.jsp
					page = "error.jsp";
					thongbao = "thêm that bai.";
				}
				

			} if (yeucau.equals("delete")) {
				int kq = acc_model.deleteAccount(acc);

				if (kq == -1) {
					page = "error.jsp";
					thongbao = "khong ket noi duoc voi csdl";
				} else if (kq == 1) {
					// 2. chuyển đến trang view.jsp
					page = "view.jsp";
					thongbao = "DELETE THÀNH CÔNG.";
					// 3. gọi hàm getList lay ra danh sách tài khoản bỏ vào session
					session.setAttribute("accountList", new AccountModel().getList());
				} else {
					// 2. chuyển đến trang error.jsp
					page = "error.jsp";
					thongbao = "DELETE THẤT BẠI.";
				}
			}if (yeucau.equals("laythongtin")) {
				session.setAttribute("acc", acc);
				page="update.jsp";
			}
			if (yeucau.equals("update")) {
				Account accNew = new Account(request.getParameter("txtUsername"),request.getParameter("txtPassword2"));
				int kq = acc_model.updateAccount(acc,accNew);

				if (kq == -1) {
					page = "error.jsp";
					thongbao = "khong ket noi duoc voi csdl";
				} else if (kq == 1) {
					// 2. chuyển đến trang view.jsp
					page = "view.jsp";
					thongbao = "UPDATE THÀNH CÔNG.";
					// 3. gọi hàm getList lay ra danh sách tài khoản bỏ vào session
					session.setAttribute("accountList", new AccountModel().getList());
				} else {
					// 2. chuyển đến trang error.jsp
					page = "error.jsp";
					thongbao = "UPDATE THẤT BẠI.";
				}
			}
			if(yeucau.equals("xoanhieu")) {
				String []listUsername = request.getParameterValues("chon");
				if(listUsername==null) {
					thongbao="Chưa chọn dữ liệu cần xóa";
					page="error.jsp";
				}else{
					int i = 0;
					for(String user :listUsername) {
						Account account=new Account(user,"");
						if(acc_model.deleteAccount(account)==0) {
							thongbao="Không xóa hết toàn bộ dữ liệu được chọn!";
							page="error.jsp";
							break;
						}
						i++;
						
					}
					session.setAttribute("accountList", new AccountModel().getList());
					page="view.jsp";
					thongbao="Xóa thành công "+i+" acc";
				}
			}
			// gan gia tri cho attribute thongbao
			request.setAttribute("thongbao", thongbao);
			// 3. chuyển đến trang page
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
