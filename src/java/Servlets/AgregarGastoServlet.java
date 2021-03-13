
package Servlets;

import Controlador.GestorDBGasto;
import Modelo.FormaPago;
import Modelo.Gasto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AgregarGastoServlet", urlPatterns = {"/AgregarGastoServlet"})
public class AgregarGastoServlet extends HttpServlet {

    GestorDBGasto gg = new GestorDBGasto();
    public static Date fechaActual(){
        Calendar c1 = Calendar.getInstance();
        int dia = c1.get(Calendar.DATE);
        int mes = c1.get(Calendar.MONTH);
        int anio = c1.get(Calendar.YEAR);
        Date fechaSistema = new Date(anio-1900, mes, dia);
        System.out.println(fechaSistema);
        return fechaSistema;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
        ArrayList<FormaPago> lista = gg.obtenerFormasPago();
        request.setAttribute("Listado", lista);
        
        try {
            if (request.getParameter("idGasto") == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaGasto.jsp");
                rd.forward(request, response);
            }else{
                int id = Integer.parseInt(request.getParameter("idGasto"));
                
                Gasto g = gg.obtenerGasto(id);
                request.setAttribute("idGasto", g.getIdGasto());
                request.setAttribute("descripcion", g.getDescripcion());
                request.setAttribute("importe", g.getImporte());
                request.setAttribute("idFormaPago", g.getIdFormaPago());
                request.setAttribute("fechaGasto", g.getFechaGasto());
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaGasto.jsp");
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
        
        try {
            int id;
            if (request.getParameter("txtIdGasto").equals("")) {
                id = -1;
            }else{
                id = Integer.parseInt(request.getParameter("txtIdGasto"));
            }
            String descripcion = request.getParameter("txtDescripcion");
            BigDecimal importe = BigDecimal.valueOf(Double.valueOf(request.getParameter("txtImporte")));
            int idFormaPago = Integer.parseInt(request.getParameter("idFormaPago"));
            Date fechaGasto= fechaActual();
            
            Gasto g = new Gasto(id, descripcion, importe, idFormaPago, fechaGasto);
            boolean exito;
            if (id == -1) {
                exito = gg.agregarGasto(g);
                System.out.println("El gasto se cargo correctamente!");
            }else{
                exito = gg.modificarGasto(g);
            }
            if (exito) {
                response.sendRedirect("/LAVARELA.110534/ListarGastosServlet");
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
