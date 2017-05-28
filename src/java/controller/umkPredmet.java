/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TUmkTPredmet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.TUmkTPredmetFacade;

/**
 *
 * @author Александр
 */
@WebServlet(name = "umkPredmet", urlPatterns = {"/umkPredmet"})
public class umkPredmet extends HttpServlet {

    @EJB
    TUmkTPredmetFacade TUmkTPredmetFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String numNapravl = request.getParameter("shifrNapravl");
        byte[] bytes = numNapravl.getBytes(StandardCharsets.ISO_8859_1);
        numNapravl = new String(bytes, StandardCharsets.UTF_8);

        List<TUmkTPredmet> TUmkTPredmetList = TUmkTPredmetFacade.findAllByNumNapravl(numNapravl);
        getServletContext().setAttribute("TUmkTPredmet", TUmkTPredmetList);
        
        request.getRequestDispatcher("/WEB-INF/views" + request.getServletPath() + ".jsp").forward(request, response);
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
