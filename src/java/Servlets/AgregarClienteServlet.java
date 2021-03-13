
package Servlets;

import Controlador.GestorDBCliente;
import Modelo.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;


@WebServlet(name = "AgregarClienteServlet", urlPatterns = {"/AgregarClienteServlet"})
public class AgregarClienteServlet extends HttpServlet {

    public static Date fechaActual(){
        Calendar c1 = Calendar.getInstance();
        int dia = c1.get(Calendar.DATE);
        int mes = c1.get(Calendar.MONTH);
        int anio = c1.get(Calendar.YEAR);
        Date fechaSistema = new Date(anio-1900, mes, dia);
        System.out.println(fechaSistema);
        return fechaSistema;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {          
            response.setContentType ("text/html;charset=utf-8");
        try {
            if (request.getParameter("idCliente") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaCliente.jsp");
            rd.forward(request, response);
        }else{      
            int id = Integer.parseInt(request.getParameter("idCliente"));
        
            GestorDBCliente g = new GestorDBCliente();
            Cliente c = g.obtenerCliente(id);
            request.setAttribute("idCliente", c.getIdCliente());
            request.setAttribute("nombre", c.getNombre());
            request.setAttribute("apellido", c.getApellido());
            request.setAttribute("direccion", c.getDireccion());
            request.setAttribute("barrio", c.getBarrio());
            request.setAttribute("telefono", c.getTelefono());
            request.setAttribute("notas", c.getNotas());
            request.setAttribute("fecha_alta", c.getFecha_alta());
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaCliente.jsp");
            rd.forward(request, response);    
        }           
        } catch (SQLException ex) {
            System.out.println(""+ex);
            response.sendRedirect("/LAVARELA.110534/listadoClientes.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        try{
        GestorDBCliente g = new GestorDBCliente();
        int id;
        if (request.getParameter("txtIdCliente").equals("")) {
            id = -1;
        }else{
            id = Integer.parseInt(request.getParameter("txtIdCliente"));
        }
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String barrio = request.getParameter("txtBarrio");
        String telefono = request.getParameter("txtTelefono");
        String notas = request.getParameter("txtNotas");
        Date fecha_alta = fechaActual();

        Cliente c = new Cliente(id,nombre,apellido,direccion,barrio,telefono,notas,fecha_alta);
            
        boolean exito;
        
        if (id == -1) {
            exito = g.agregarCliente(c);
            System.out.println("El cliente se cargo correctamente"+c);
        }else{
            exito = g.modificarCliente(c);  
        }
        if (exito) {
            response.sendRedirect("/LAVARELA.110534/ListarClientesServlet");
        }
    }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}