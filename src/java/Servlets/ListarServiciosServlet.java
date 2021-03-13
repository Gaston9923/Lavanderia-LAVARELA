
package Servlets;

import Controlador.GestorDBServicio;
import Modelo.Servicio;
import java.io.IOException;
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


@WebServlet(name = "ListarServiciosServlet", urlPatterns = {"/ListarServiciosServlet"})
public class ListarServiciosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            GestorDBServicio g = new GestorDBServicio();
        ArrayList<Servicio> lista = g.obtenerServicios();
        
        request.setAttribute("listadoServicios", lista);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoServicios.jsp");
        rd.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(ListarServiciosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
