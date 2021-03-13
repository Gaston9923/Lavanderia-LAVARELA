
package Servlets;

import Controlador.GestorDBGasto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarGastoServlet", urlPatterns = {"/EliminarGastoServlet"})
public class EliminarGastoServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idGasto"));
            GestorDBGasto gg = new GestorDBGasto();
            boolean exito = gg.eliminarGasto(id);
            if (exito) {
                response.sendRedirect("ListarGastosServlet");
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
    }// </editor-fold>

}
