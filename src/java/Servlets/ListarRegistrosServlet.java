
package Servlets;

import Controlador.GestorDBFicha;
import Controlador.GestorDBRegistro;
import Modelo.Ficha;
import Modelo.Registro;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarRegistrosServlet", urlPatterns = {"/ListarRegistrosServlet"})
public class ListarRegistrosServlet extends HttpServlet {

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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        
        try {
            GestorDBRegistro g = new GestorDBRegistro();
            GestorDBFicha gf = new GestorDBFicha();
            
            int fichasDeHoy = gf.obtenerCantidadFichas();
            request.setAttribute("fichas", fichasDeHoy);
            
            Ficha f = new Ficha(fichasDeHoy,fechaActual());
            if (gf.verificarFecha(f)==false) {
                gf.guardarFichas(f);
            }
            gf.actualizarFichas(f);
            
            ArrayList<Registro> lista1 = g.obtenerRegistros(); 
            request.setAttribute("listadoR", lista1);
            System.out.println(""+lista1);
            
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
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
