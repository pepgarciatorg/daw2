/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletConfig;
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
@WebServlet(name = "config", urlPatterns = {"/config"}, initParams = {
    @WebInitParam(name = "primero", value = "hola")
    , @WebInitParam(name = "segundo", value = "adios")})

public class Config extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
   HashMap <String,String> parametros=new HashMap <String,String>();

  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet config</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Los parámetros que tiene el config son </h1>");
            Set s = parametros.keySet();                                //** Se añaden los nombres(keys) a un set para ir recorriendo el mapa **//
            Iterator it = s.iterator();
            while(it.hasNext()){                              //** mientras que existan nombres se hara el bucle **//
                String nombre= (String) it.next();        //** guardamos cada nombre en la variable nombre para su uso **//
                String values=parametros.get(nombre);         //** array de String para obtener la coleccion de values por cada nombre **//
                                                                //** recorremos todos los value para ser mostrados con cada nombre o key **//
                   out.println("<p><strong>"+nombre+": "+values+"</strong></p>"); 
                
            }
            out.println("<p><a href=\"index.html\">volver al inicio!</a></p>");
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
    }

// </editor-fold>
   @Override
   public void init(ServletConfig config) throws ServletException {
    super.init(config);
 
    Enumeration <String> lista=config.getInitParameterNames();
 
    while (lista.hasMoreElements()){
      String siguiente= lista.nextElement();
      parametros.put(siguiente,config.getInitParameter(siguiente));
      
    }
   
    System.out.println(parametros);
}    
    
}


