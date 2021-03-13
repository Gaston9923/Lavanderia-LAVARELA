
package Servlets;

import Controlador.GestorDBGasto;
import Modelo.Gasto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListarGastosServlet", urlPatterns = {"/ListarGastosServlet"})
public class ListarGastosServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            GestorDBGasto g = new GestorDBGasto();
            ArrayList<Gasto> lista = g.obtenerGastos();
            System.out.println("Lista Gastos: "+lista);
            
            request.setAttribute("listadoG", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoGastos.jsp");
            rd.forward(request, response);
            
            
        } catch (SQLException ex) {
            
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
