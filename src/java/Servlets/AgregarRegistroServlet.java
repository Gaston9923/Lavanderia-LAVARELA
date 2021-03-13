
package Servlets;

import Controlador.GestorDBCliente;
import Controlador.GestorDBImporte;
import Controlador.GestorDBRegistro;
import Controlador.GestorDBServicio;
import Modelo.Cliente;
import Modelo.EstadoPago;
import Modelo.Registro;
import Modelo.Servicio;
import Modelo.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgregarRegistroServlet", urlPatterns = {"/AgregarRegistroServlet"})
public class AgregarRegistroServlet extends HttpServlet {

    public static Date fechaActual(){
        Calendar c1 = Calendar.getInstance();
        int dia = c1.get(Calendar.DATE);
        int mes = c1.get(Calendar.MONTH);
        int anio = c1.get(Calendar.YEAR);
        Date fechaSistema = new Date(anio-1900, mes, dia);
        System.out.println(fechaSistema);
        return fechaSistema;
    }
    GestorDBRegistro g = new GestorDBRegistro();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
        GestorDBCliente gc = new GestorDBCliente();
        GestorDBServicio gs = new GestorDBServicio();
        GestorDBImporte i = new GestorDBImporte();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
                    
        try {
            ArrayList<Usuario> lista = g.obtenerUsuarios();
            request.setAttribute("ListadoUsuarios", lista);
            ArrayList<Cliente> listaC = gc.obtenerClientes();
            request.setAttribute("ListadoClientes", listaC);
            ArrayList<Servicio> listaS = gs.obtenerServicios();
            request.setAttribute("ListadoServicios", listaS);
            ArrayList<EstadoPago> listaE = i.obtenerEstadosPagos();
            request.setAttribute("ListadoEstadosPagos", listaE);
            
            if (request.getParameter("idRegistro") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaRegistro.jsp");
            rd.forward(request, response);
        }else{
            int id = Integer.parseInt(request.getParameter("idRegistro"));
            
            GestorDBRegistro g = new GestorDBRegistro();
            Registro r = g.obtenerRegistro(id);
            request.setAttribute("idRegistro", r.getIdRegistro());
            request.setAttribute("idUsuario", r.getIdUsuario());
            request.setAttribute("nombreUsuario", r.getNombreUsuario());
            request.setAttribute("idCliente", r.getIdCliente());
            request.setAttribute("nombre", r.getCliente());
            request.setAttribute("cantidadServ", r.getCantidadServ());
            request.setAttribute("idEstadoPago", r.getIdEstadoPago());
            request.setAttribute("estadoServ", r.getEstadoServ());
            request.setAttribute("fecha", r.getFecha());
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaRegistro.jsp");
            rd.forward(request, response);       
            }
        } catch (Exception e) {
            System.out.println(""+e);
            response.sendRedirect("/LAVARELA.110534/listadoRegistros.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try { 
                GestorDBRegistro g = new GestorDBRegistro();
                int id;
                if (request.getParameter("txtIdRegistro").equals("")) {
                    id = -1;
                }else{
                    id = Integer.parseInt(request.getParameter("txtIdRegistro"));
                }
//                int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario")); 
                int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario")); 
                int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));

                int idEstadoPago = Integer.parseInt(request.getParameter("cboEstadoPago"));
                String estadoServ = request.getParameter("txtEstadoServ");
                Date fecha = fechaActual();
                Registro r = new Registro(id,idUsuario, idCliente, 0, idEstadoPago, estadoServ, fecha);   
            
                boolean exito;
                if (id == -1) {
                    exito = g.agregarRegistro(r);                  
                    System.out.println("El Registro fue cargado correctamente");
                }else{
                    exito = g.modificarRegistro(r);
                    response.sendRedirect("/LAVARELA.110534/ListarRegistrosServlet");
                }
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
