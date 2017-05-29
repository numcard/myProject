/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TRPDZadachi;
import entity.TUmkPredmetDocument;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.TRPDZadachiFacade;
import session.TUmkPredmetDocumentFacade;

/**
 *
 * @author Александр
 */
@WebServlet(name = "zadachi", urlPatterns = {"/zadachi", "/edit_zadachi"})
public class rpdZadachi extends HttpServlet 
{
    @EJB
    TUmkPredmetDocumentFacade TUmkPredmetDocumentFacade;
    
    @EJB
    TRPDZadachiFacade TRPDZadachiFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String userPath=request.getServletPath();
        
        if (userPath.equals("/zadachi"))
        {
            String idUmkPredmetDocument = request.getParameter("IDUmkPredmetDocument");
        
            TUmkPredmetDocument doc = TUmkPredmetDocumentFacade.findByID(idUmkPredmetDocument);

            getServletContext().setAttribute("TUmkPredmetDocument", doc);

            request.getRequestDispatcher("/WEB-INF/views/zadachi.jsp").forward(request, response);
        }
        else if(userPath.equals("/edit_zadachi"))
        {
            // get Parametrs
            String RPDZadacha;
            int idRPDZadachi;
            
            byte[] bytes = request.getParameter("RPDZadacha").getBytes(StandardCharsets.ISO_8859_1); 
            RPDZadacha = new String(bytes, StandardCharsets.UTF_8);
            
            idRPDZadachi = Integer.parseInt(request.getParameter("idRPDZadachi"));
            
            // find TRPDZadachi
            TRPDZadachi zadachi = TRPDZadachiFacade.find(idRPDZadachi);
            
            //replace
            zadachi.setRPDZadacha(RPDZadacha);
            
            //save
            TRPDZadachiFacade.edit(zadachi);
            
            //redirect back
            response.sendRedirect("/myProject/zadachi?IDUmkPredmetDocument=" + zadachi.getIdUmkPredmetDocument().getIdUmkPredmetDocument()); 
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