
package Servlets;

import Controlador.GestorDBRegistro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActualizarEstadoIncompletoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        try {
            processRequest(request, response);
            
            GestorDBRegistro g = new GestorDBRegistro();
            int idRegistro = Integer.parseInt(request.getParameter("idRegistro"));
                      
            g.actualizarEstadoIncompleto(idRegistro);
            response.sendRedirect("/LAVARELA.110534/ListarRegistrosServlet");
            
        } catch (SQLException ex) {
            System.out.println("Error:"+ex);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
