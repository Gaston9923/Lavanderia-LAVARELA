
package Servlets;

import Controlador.GestorDBCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarClienteServlet", urlPatterns = {"/EliminarClienteServlet"})
public class EliminarClienteServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            int id = Integer.parseInt(request.getParameter("idCliente"));
            GestorDBCliente gc = new GestorDBCliente();
            boolean exito = gc.eliminarCliente(id);
            if (exito) {
                response.sendRedirect("/LAVARELA.110534/ListarClientesServlet");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
