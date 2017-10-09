/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpasecondarytable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author ilkinabdullayev
 */
@WebServlet(name = "HiyHoy", urlPatterns = {"/HiyHoy"})
public class HiyHoy extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Resource
    private UserTransaction ut;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HiyHoy</title>");
            out.println("</head>");
            out.println("<body>");

            try {
                ut.begin();

                Employee employee = new Employee();
                employee.setEmail("ilkinabdullayev6@gmail.com");
                employee.setEmployeeId(1);
                employee.setFirstname("Ilkin");
                employee.setLastname("Abdullayev");
                employee.setJoiningDate(new Date());
                employee.setSalary(10);

                em.persist(employee);

                ut.commit();
            } catch (Exception ex) {
                try {
                    ut.rollback();
                    Logger.getLogger(HiyHoy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex1) {
                    Logger.getLogger(HiyHoy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

            out.println("<h1>Servlet HiyHoy at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
