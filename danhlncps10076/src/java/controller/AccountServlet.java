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
@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
            //1. láº¥y giÃ¡ trá»‹ user vÃ  pass tá»« form
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String page = ""; // biáº¿n trang cáº§n chuyá»ƒn Ä‘áº¿n
            String thongbao = ""; // bien thongbao
            
            // khai bÃ¡o biáº¿n session
            HttpSession session = request.getSession();
            
            //2. tao 1 doi tuong Account
            Account acc = new Account(username, password);
            //3. tao 1 doi tuong cua lop AccountModel
            AccountModel acc_model = new AccountModel();
            //4. goi ham checkLogin
            int kq = acc_model.checkLogin(acc);
            
            
            if (kq == -1)
            {
                page = "login.jsp";
                thongbao = "Không thể kết nối server!";
            }
            else if (kq == 1){
                //2. chuyá»ƒn Ä‘áº¿n trang view.jsp
                page = "index.jsp";
                thongbao = "Đăng nhập thành công!";
                session.removeAttribute(getServletInfo());
                //3. gá»�i hÃ m getList lay ra danh sÃ¡ch tÃ i khoáº£n bá»� vÃ o session
                session.setAttribute("accountList", new AccountModel().getList());
                session.setAttribute("link", "index2.jsp");
                
                request.setAttribute("username", username);
            }
            else{
                //2. chuyá»ƒn Ä‘áº¿n trang error.jsp
                page = "login.jsp";
                thongbao= "Sai thông tin tài khoản!";
            }
            // gan gia tri cho attribute thongbao
            request.setAttribute("thongbao", thongbao);
            //3. chuyá»ƒn Ä‘áº¿n trang page
            request.getRequestDispatcher(page).forward(request, response);
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
