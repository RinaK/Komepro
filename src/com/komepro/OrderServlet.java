/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komepro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.komepro.Login1;
import com.komepro.LoginLogic1;

/**
 *
 * @author 
 */

public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/Order.jsp");
        dispatcher.forward(request,response);
       
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
        
        Login1 login = new Login1(userId,pass);
        LoginLogic1 bo = new LoginLogic1();
        boolean result = bo.execute(login);
        
        if(result){
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId);
            
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward(request,response);
        }else{
            response.sendRedirect("/ad2719/LoginServlet1");
        }
       
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
