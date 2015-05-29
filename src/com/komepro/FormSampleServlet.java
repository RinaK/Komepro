/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komepro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author 
 */

public class FormSampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/db2719";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        int phone;
        phone = Integer.parseInt(request.getParameter("phone"));
        String adress = request.getParameter("adress");
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        String errorMsg = "";
        if (name == null || name.length() == 0) {
            errorMsg += "名前が入力されていません<br>";
        } else {
            Connection conn = null;
            try {
                Class.forName(DRIVER_NAME);
                conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

                String sql = "INSERT INTO ACCOUNT(USER_ID,PASS,MAIL,NAME,ADRESS,PHONE) VALUES(?,?,?,?,?,?)";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, id);
                pStmt.setString(2, pass);
                pStmt.setString(3, mail);
                pStmt.setString(4, name);
                pStmt.setString(5, adress);
                pStmt.setInt(6, phone);
                int result = pStmt.executeUpdate();
            }       catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormSampleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException e) {
                e.printStackTrace();

            } finally {

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp");
            dispatcher.forward(request, response);
        }



    }
    

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP
 * <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
//@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
