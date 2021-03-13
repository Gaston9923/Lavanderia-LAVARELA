
package Servlets;

import Controlador.GestorDBRegistro;
import Controlador.GestorDBServicio;
import Modelo.DetalleRegistro;
import Modelo.Servicio;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgregarDetalleRegistroServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
        
            GestorDBServicio gs = new GestorDBServicio();
            GestorDBRegistro g = new GestorDBRegistro();
        try {   
            ArrayList<Servicio> listaS = gs.obtenerServicios();
            request.setAttribute("ListadoServicios", listaS);
            

            int idRegistro = Integer.parseInt(request.getParameter("idRegistro"));
            
//                int id = Integer.parseInt(request.getParameter("idDetalleRegistro"));
            DetalleRegistro r = g.obtenerDetalle(idRegistro);
            request.setAttribute("idRegistro", r.getIdRegistro());
            request.setAttribute("idServicio", r.getIdServicio());
            request.setAttribute("cantidad", r.getCantidad());
            request.setAttribute("monto", r.getMonto());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaDetalleRegistro.jsp");
            rd.forward(request, response);
            
        } catch (Exception ex) {
            System.out.println(""+ex);            
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType ("text/html;charset=utf-8");
            try {
            GestorDBRegistro g = new GestorDBRegistro();

            int id = Integer.parseInt(request.getParameter("txtIdRegistro"));
            int idServicio = Integer.parseInt(request.getParameter("txtServicio"));
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            double precio = g.obtenerPrecioServicio(idServicio);

                //Promociones
                
                if (cantidad>5) {
                    precio = precio*0.90;
                }

                
            //CARGAR
            DecimalFormat df = new DecimalFormat("#0.00");
            BigDecimal importe = BigDecimal.valueOf((precio*cantidad));
            String importe1 =  df.format(importe);
                System.out.println("El importe del Detalle es: "+importe1);
            System.out.println("El importe del Detalle es: "+importe);

            DetalleRegistro d = new DetalleRegistro(id, idServicio, cantidad, importe);
            
            boolean exito;
                    exito = g.agregarDetalle(d);                  
                    g.suma1Cantidad(id);
                    System.out.println("El Servicio fue cargado correctamente al Registro:"+d);
                
                if (exito) {
                    response.sendRedirect("/LAVARELA.110534/ListarRegistrosServlet");
                }
                  
        } catch (Exception e) {
            System.out.println(e);
        }        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
