package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Item;
import model.GioHangModel;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GioHangModel giohang_model = new GioHangModel();
    public GioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public GioHangModel getGiohang_model() {
		return giohang_model;
	}

	public void setGiohang_model(GioHangModel giohang_model) {
		this.giohang_model = giohang_model;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String page ="";
		String message="";
		String yeucau =request.getParameter("yeucau");
		String maSP = request.getParameter("txtmasp");
		if(yeucau.equals("muaSP")) {
			giohang_model.addSP(maSP);
			ArrayList<Item> list = giohang_model.getListItem();
			request.setAttribute("giohang",list);
			request.setAttribute("link", null);
			page = "index2.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}else if(yeucau.equals("delete")) {
			giohang_model.deleteSP(maSP);
			ArrayList<Item> list = giohang_model.getListItem();
			request.setAttribute("giohang",list);
			page = "index2.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}else if(yeucau.equals("deleteAll")) {
			giohang_model.deleteAll();
			ArrayList<Item> list = giohang_model.getListItem();
			request.setAttribute("giohang",list);
			page = "index2.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}else if(yeucau.equals("tang")) {
			giohang_model.tang(maSP);
			ArrayList<Item> list = giohang_model.getListItem();
			request.setAttribute("giohang",list);
			page = "index2.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
		else if(yeucau.equals("giam")) {
			giohang_model.giam(maSP);
			ArrayList<Item> list = giohang_model.getListItem();
			request.setAttribute("giohang",list);
			page = "index2.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
    }
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
