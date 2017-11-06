/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Contenido;
import beans.Edificio;
import beans.Eleccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author 1 daw
 */
@WebServlet(name = "Ccontenido", urlPatterns = {"/Ccontenido"})
public class Controlador extends HttpServlet {

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
        
        if (request.getParameter("contenido")=="false" && request.getParameter("continente")=="false"){
            // no hemos marcado nada volver a preguntar
        }
        else {
        if (request.getParameter("continente")=="true"){
            //cargamos el beans edificio y tiramos para alla
            request.getRequestDispatcher(request.getContextPath()+"/JSP/JSPLE/edificio.jsp").forward(request, response);
            String ctipoedificio=request.getParameter("tipoedificio");
            String chabitaciones=request.getParameter("habitaciones");
            String cfechacons=request.getParameter("fechacons");
            String ctipoconstruc=request.getParameter("tipoconstruc");
            String cvalor=request.getParameter("valor");
            Edificio e = new Edificio(ctipoedificio,chabitaciones,cfechacons,ctipoconstruc,cvalor);
            //sacar la vista
            //preguntar si hemos marcado tambien contenido
            //si lo hemos marcado cargar contenido y tirar para alla
            //sacar la vista
        }
        else {
            if (request.getParameter("contenido")=="true"){
                //cargamos el beans contenido y tiramos para alla
                boolean cdanos;
                request.getRequestDispatcher(request.getContextPath()+"/JSP/JSPLE/contenido.jsp").forward(request, response);
                if (request.getParameter("danos")=="true"){
                    cdanos=true;
                }
                else
                {
                    cdanos=false;
                }
                String ccantidad=request.getParameter("cantidad");
                String cfranquicia=request.getParameter("franquicia");
                Contenido c=new Contenido(cdanos,ccantidad,cfranquicia);
            }
            //sacar la vista ya que hemos marcado solo contenido
            
        }
        }
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ccontenido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ccontenido at " + request.getContextPath() + "</h1>");
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
