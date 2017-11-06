/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controlers;
import es.albarregas.beans.Aves;
import es.albarregas.pojo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Papa
 */
@WebServlet(name = "Operar", urlPatterns = {"/Operar"})
public class Operar extends HttpServlet {
DataSource datasource;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public void init(ServletConfig config){ //hay que meter el parametro que se ejecuta la primera vez cunado se carga el servlet, si no ponemos nada lo estamos sobrecargando
       try {
            Context initialContext = new InitialContext();
            datasource =(DataSource)initialContext.lookup("java:comp/env/jdbc/Pool");
    } catch(NamingException ex) {
    System.out.println("Problemas en el acceso al recurso...");
    ex.printStackTrace();
    }

   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Operar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Operar at " + request.getContextPath() + "</h1>");
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
        Connection conexion = null;
        Statement sentencia = null;
        PreparedStatement preparada=null;
        ResultSet resultado = null;
        Aves ave = null;
        List<Aves> aves = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No existe el driver");
            ex.printStackTrace();
        }
        //String cadenaConexion = "jdbc:mysql://localhost:3306/pruebasjava";
       
        String url = null;
        String sql = null;
        try {
           conexion = datasource.getConnection();
            System.out.println("Estoy aqui haciendo la conexion");
            if (request.getParameter("insertar") != null){
                //pedir datos, para ello cargamos jsp y despues debemos controlarlo para que la anilla no esté repetida
                // si existe la anilla deberá ir a pedir los datos otra vez o al inicio.
                url="JSP/INSERTAR/reinicioinsertar.jpg";
            }
            else //en caso contrario tendremos que cargar los datos en un list con los objetos aves      
                    sql = "SELECT * FROM aves";
                    try{
                        aves=new ArrayList<Aves>();
                        sentencia = conexion.createStatement();
                        resultado = sentencia.executeQuery(sql);
                        while (resultado.next()){
                            ave = new Aves();
                            ave.setAnilla(resultado.getString("anilla"));
                            ave.setEspecie(resultado.getString(2));
                            ave.setLugar(resultado.getString("lugar"));
                            ave.setFecha(resultado.getDate("fecha"));
                            aves.add(ave);
                        }
                        request.setAttribute("listaves",aves);
                        // cerramos la conexion, ya la abriremos cuando tengamos que hacer alguna operación
                        // comprobar si lo que queremos hacer es actualizar o borrar o mostrar
                        if (request.getParameter("actualizar")!=null){
                            url="JSP/ACTUALIZAR/reinicioactualizar.jsp";
                        }
                        if (request.getParameter("eliminar")!=null){
                            url="JSP/ACTUALIZAR/reinicioeliminar.jsp";
                        }
                        if (request.getParameter("leer")!=null){
                            url="realizar";
                        }
                    } catch(SQLException e){
                        request.setAttribute("error","No existen datos en la base de datos");
                        url = "JSP/error.jsp";
                    }
                }
        catch(SQLException e){
            request.setAttribute("error","Error al abrir la base de datos");
            url = "JSP/error.jsp";
        }
         request.getRequestDispatcher(url).forward(request, response);
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
