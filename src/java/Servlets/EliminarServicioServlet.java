
package Servlets;

import Controlador.GestorDBServicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarServicioServlet", urlPatterns = {"/EliminarServicioServlet"})
public class EliminarServicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            int id = Integer.parseInt(request.getParameter("idServicio"));
            GestorDBServicio gg = new GestorDBServicio();
            boolean exito = gg.eliminarServicio(id);
            if (exito) {
                response.sendRedirect("ListarServiciosServlet");
            }
        } catch (Exception e) {
            System.out.println(e);
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
    }

}
