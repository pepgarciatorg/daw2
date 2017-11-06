/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controlers;
import es.albarregas.beans.Aves;

import es.albarregas.pojo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "Realizar", urlPatterns = {"/Realizar"})
public class Realizar extends HttpServlet {
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
            out.println("<title>Servlet Realizar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Realizar at " + request.getContextPath() + "</h1>");
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
        
        // en el caso de insertar tendremos que abrir la base de datos y comprobar que la anilla no existe,
        // si existe volveremos a la pantalla anterior y volvemos a pedir los datos pero con ellos cargados, en el jsp
        // debemos controlar si nos ha llegado con error o no
            Connection conexion = new Conexion().getConnection();
            Statement sentencia = null;
            PreparedStatement preparada=null;
            ResultSet resultado = null;
        if (request.getParameter("origen") == "1"){ // 1 será que viene de añadir
            
            String anilla = request.getParameter("anilla");
            String especie = request.getParameter("especie");
            String lugar = request.getParameter("lugar");
            String fecha = request.getParameter("fecha");
            String url = null;
            String sql = null;
            Aves aves=new Aves(); // pasamos los datos introducido al beans
            aves.setAnilla(anilla);
            aves.setEspecie(especie);
            aves.setLugar(lugar);
            ParseFecha fechad=new ParseFecha();
            aves.setFecha(fechad.ParseFecha(fecha)); //transformamos el string a date;
            request.setAttribute("aves",aves); //guardamos para pasar por atributos el ave;
             if (anilla.equals("") || especie.equals("") || lugar.equals("") || fecha.equals("")){
                 // tendremos que volver para atrás
                 request.setAttribute("error","Existen datos vacíos....");
                 
                 url="/JSP/INSERTAR/insertar.jsp";
             }
            //Ave ave = null;
            //List<Ave> aves = null;
            try { // cargamos el driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No existe el driver");
            ex.printStackTrace();
        }
        //String cadenaConexion = "jdbc:mysql://localhost:3306/pruebasjava";
        
        try {
           conexion = datasource.getConnection();
               if (anilla != null){
                    sql = "SELECT * FROM aves WHERE anilla=?";
                    preparada = conexion.prepareStatement(sql);
                    preparada.setString(1, anilla);
                    try{
                        resultado = preparada.executeQuery(); //no lo hace bien no devuelve resulset
                        resultado.next();//nos colocamos en el primer registro
                        String buscador;
                        while (resultado.next()){
                            buscador=resultado.getString("anilla"); // esto saldria por el catch
                            if (anilla.equals(buscador)){
                                request.setAttribute("error", "La anilla ya existe en la base de datos");
                                url="JSP/INSERTAR/inicioinsertar.jsp";
                                break;
                            }
                        }            
                        } catch (SQLException e){
                                url="JSP/INSERTAR/insertar.jsp";
                        }
                }
        }catch(SQLException e){
                request.setAttribute("Error","Error al abrir la base de datos");
                  url="JSP/INSERTAR/inicioinsertar.jsp";
                }
    }
        // en cualquiera de los otros casos tendremos que leer toda la base de datos y meter los registros en un arraylist
         if ((request.getParameter("origen") == "2") || (request.getParameter("origen")==  "3") || (request.getParameter("origen") == null)){ 
              Aves ave = null;
                List<Aves> aves = null;  
                String sql = "SELECT * FROM aves";
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
         } catch (SQLException e){
         }
                    
         }
         if (request.getParameter("origen") == "2"){ // si venimos de actualizar
             // 
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
