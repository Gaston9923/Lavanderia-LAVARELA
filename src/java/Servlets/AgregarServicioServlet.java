
package Servlets;

import Controlador.GestorDBServicio;
import Modelo.Servicio;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AgregarServicioServlet", urlPatterns = {"/AgregarServicioServlet"})
public class AgregarServicioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        try {
            if (request.getParameter("idServicio") == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
                rd.forward(request, response);
            }else{
                int id = Integer.parseInt(request.getParameter("idServicio"));
                GestorDBServicio gg = new GestorDBServicio();
                Servicio g = gg.obtenerServicio(id);
                request.setAttribute("idServicio", g.getIdServicio());
                request.setAttribute("servicio", g.getServicio());
                request.setAttribute("precio", g.getPrecio());
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(""+e);      
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        GestorDBServicio g = new GestorDBServicio();
        try {
            int id;
            if (request.getParameter("txtIdServicio").equals("")) {
                id = -1;
            }else{
                id = Integer.parseInt(request.getParameter("txtIdServicio"));
            }
            String servicio = request.getParameter("txtServicio");
            double preci = Double.parseDouble(request.getParameter("txtPrecio"));
            BigDecimal precio = BigDecimal.valueOf(preci);
            
            Servicio s = new Servicio(id, servicio, precio);
            
            boolean exito;
                if (id == -1) {
                    exito = g.agregarServicio(s);                  
                    System.out.println("El Servicio se cargó correctamente!");
                }else{
                    exito = g.modificarServicio(s);
                    response.sendRedirect("/LAVARELA.110534/ListarServiciosServlet");
                }
                if (exito) {
                    response.sendRedirect("/LAVARELA.110534/ListarServiciosServlet");
                }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
