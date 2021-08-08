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

/**
 *
 * @author David
 */
public class Guardar extends HttpServlet {

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

        MetodosSQL metodos = new MetodosSQL();
        String txtUsuario = request.getParameter("txtUsuario");
        String txtNombre = request.getParameter("txtNombre");
        String txtApellido = request.getParameter("txtApellido");
        String txtDocumento = request.getParameter("txtDocumento");
        String txtEmail = request.getParameter("txtEmail");
        String txtContrasenia = request.getParameter("txtContrasenia");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");

        boolean usuarioRepetido = metodos.buscarUsuarioRepetidoBD(txtUsuario);

        if (usuarioRepetido == true) {
            out.println("alert('!Atención!, El nombre de usuario " + txtUsuario + " ya está registrado')");
            out.println("location = 'index.html'");
        } else {

            boolean registro = metodos.registrarUsuario(txtUsuario, txtNombre, txtApellido, txtDocumento, txtEmail, txtContrasenia);

            if (registro == true) {//El usuario se ha registrado
                out.println("alert('El usuario ha sido registrado con exito')");
                out.println("location = 'index.html'");
            } else {
                out.println("alert('ERROR el usuario no ha sido registrado con exito')");
                out.println("location = 'index.html'");
            }

            //System.out.println("El valor de registro en SERVLET es: " + registro);
        }

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
