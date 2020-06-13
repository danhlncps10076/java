package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.SanPham;
import model.SanphamModel;

/**
 * Servlet implementation class SanPhamServlet
 */
@WebServlet("/SanPhamServlet")
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String yeucau = request.getParameter("yeucau");
		if(yeucau.equals("insertSP")) {
			SanPham sp = new SanPham();
			sp.setMaSP(Integer.parseInt(request.getParameter("txtmasp")));
			sp.setTenSP(request.getParameter("txttensp"));
			sp.setGia(Integer.parseInt(request.getParameter("txtgia")));
			sp.setSoLuong(Integer.parseInt(request.getParameter("txtsoluong")));
			Part fileHinh=request.getPart("txthinh");
			sp.setHinh(fileHinh.getSubmittedFileName());
			sp.setMaDM(Integer.parseInt(request.getParameter("txtmadanhmuc")));
			if(new SanphamModel().insertSanPham(sp)==1){
				request.setAttribute("thongbao", "Thêm Thành Công");
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}else {
				request.setAttribute("thongbao", "Không thể thêm");
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}
		}else if(yeucau.equals("xoa")) {
			
				if(new SanphamModel().deleteSanPham(request.getParameter("txtmasp"))==1) {

					request.setAttribute("thongbao", "Đã Xóa Thành Công! ");
					request.getRequestDispatcher("index2.jsp").forward(request, response);
				}else {
					request.setAttribute("thongbao", "Có lỗi xảy ra! ");
					request.getRequestDispatcher("index2.jsp").forward(request, response);
				}
			
		}else if(yeucau.equals("xoanhieu")) {
			String[] list = request.getParameterValues("chon");
			int count=0;
			for (String string : list) {
				if(new SanphamModel().deleteSanPham(string)==1) {
					count+=1;
				}else {
					request.setAttribute("thongbao", "Đã xóa được "+count);
					request.getRequestDispatcher("index2.jsp").forward(request, response);
				}
			}
			request.setAttribute("thongbao", "Đã xóa được "+count);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else {
			SanPham sp = new SanPham();
			sp.setMaSP(Integer.parseInt(request.getParameter("txtmasp")));
			sp.setTenSP(request.getParameter("txttensp"));
			sp.setGia(Integer.parseInt(request.getParameter("txtgia")));
			sp.setSoLuong(Integer.parseInt(request.getParameter("txtsoluong")));
			Part fileHinh=request.getPart("txthinh");
			sp.setHinh(fileHinh.getSubmittedFileName());
			sp.setMaDM(Integer.parseInt(request.getParameter("txtmadanhmuc")));
			if(new SanphamModel().updateSanPham(sp)==1){
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}else {
				request.setAttribute("thongbao", "Không thể cập nhật");
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
