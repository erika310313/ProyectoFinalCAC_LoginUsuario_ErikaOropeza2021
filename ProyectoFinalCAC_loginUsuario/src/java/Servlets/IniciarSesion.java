/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class IniciarSesion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession sesion = request.getSession();
            
            MetodosSQL metodos = new MetodosSQL();
            String txtUsuario = request.getParameter("txtUsuario");
            String txtContrasenia = request.getParameter("txtContrasenia");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            out.println("<script type=\"text/javascript\">");
            
                boolean iniciarSesion = metodos.buscarUsuarioInicioSesion(txtUsuario, txtContrasenia);

                if(iniciarSesion == true) {//El usuario puede iniciar sesion porque esta registrado
                    out.println("alert('¡Bienvenido! \\nIniciaste sesion como: " + txtUsuario + "')");
                    out.println("location = 'paginaInicio.jsp'");
                    
                    String nombre = metodos.buscarNombre(txtUsuario);
                    //System.out.println("El valor del nombre en el servlet es: " + nombre);
                    
                    sesion.setAttribute("nombre", nombre);
                    sesion.setAttribute("txtUsuario", out);
                    
                }else{
                    out.println("alert('¡Datos Incorrectos! verifica tu información o registrate')");
                    out.println("location = 'index.html'");
                }

                System.out.println("El valos de iniciarSesion dentro del servlet es: " + iniciarSesion);
            
            out.println("</script>");
            
            out.println("</body>");
            out.println("</html>");
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
