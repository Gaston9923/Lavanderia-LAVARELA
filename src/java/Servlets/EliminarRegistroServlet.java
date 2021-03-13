
package Servlets;

import Controlador.GestorDBRegistro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarRegistroServlet", urlPatterns = {"/EliminarRegistroServlet"})
public class EliminarRegistroServlet extends HttpServlet {


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
            int id = Integer.parseInt(request.getParameter("idRegistro"));
            GestorDBRegistro gg = new GestorDBRegistro();
            boolean exito1 = gg.eliminarDetallesRegistro(id);
            if (exito1) {
                 gg.eliminarRegistro(id);
                 response.sendRedirect("ListarRegistrosServlet");
            }else{
                gg.eliminarRegistro(id);
                response.sendRedirect("ListarRegistrosServlet");
            }
            

        } catch (Exception e) {
            System.out.println("Error al eliminar:"+e);
            response.sendRedirect("ListarRegistrosServlet");
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
