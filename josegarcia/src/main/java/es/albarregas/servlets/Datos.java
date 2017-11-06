/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1 daw
 */
@WebServlet(name = "datos", urlPatterns = {"/datos"})

public class Datos extends HttpServlet {

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
        /**try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet datos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet datos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet datos</title>");  
            out.println("<link rel=\"stylesheet\" href=\"CSS/newcss.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<p>Esquema de autenticación: "+request.getAuthType()+"</p>");
            out.println("<p>Servlet datos at " + request.getContextPath() + "</p>");
            out.println("<p>Método HTTP: "+request.getMethod()+"</p");
            out.println("<p>Ruta asociada a la URL: "+request.getPathInfo()+"</p>");
            out.println("<p>Remote user: "+request.getRemoteUser()+"<p>");
            out.println("<p>Id de sesión: "+request.getRequestedSessionId()+"</p>");
            out.println("<p>URL de URI: "+request.getRequestURI()+"</p>");
            out.println("<p>URL para solicitud: "+request.getRequestURL().toString()+"</p>");
            out.println("<p>Sesión: "+request.getSession()+"<p>");
            long l=request.getDateHeader("If-Modified-Since");
            Date d= new Date(l);
            out.println("<p>Sin modificar desde: "+d+"</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
        
        
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
