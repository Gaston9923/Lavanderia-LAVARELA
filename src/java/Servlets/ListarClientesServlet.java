
package Servlets;

import Controlador.GestorDBCliente;
import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListarClientesServlet", urlPatterns = {"/ListarClientesServlet"})
public class ListarClientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            GestorDBCliente g = new GestorDBCliente();
            ArrayList<Cliente> lista = g.obtenerClientes();
            
            request.setAttribute("listado", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoClientes.jsp");
            rd.forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ListarClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
