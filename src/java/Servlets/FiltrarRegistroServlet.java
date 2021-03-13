
package Servlets;

import Controlador.GestorDBRegistro;
import Modelo.Registro;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FiltrarRegistroServlet", urlPatterns = {"/FiltrarRegistroServlet"})
public class FiltrarRegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            GestorDBRegistro g = new GestorDBRegistro();
   
            Date fechaDesde = Date.valueOf(request.getParameter("dtFechaDesde"));
            Date fechaHasta = Date.valueOf(request.getParameter("dtFechaHasta"));
            System.out.println("fechaDesde:"+fechaDesde);
            System.out.println("fechaHasta:"+fechaHasta);
            ArrayList<Registro> lista1 = g.obtenerRegistrosBusqueda(fechaDesde, fechaHasta); 
            request.setAttribute("listadoR", lista1);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoRegistros.jsp");
            rd.forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println(ex);
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
    }

}
