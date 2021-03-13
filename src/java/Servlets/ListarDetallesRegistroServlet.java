
package Servlets;

import Controlador.GestorDBRegistro;
import Modelo.DetalleRegistro;
import Modelo.Importe;
import Modelo.Registro;
import Modelo.RestoDescuento10;
import Modelo.RestoDescuentoMes;
import Modelo.Seña;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListarDetallesRegistroServlet", urlPatterns = {"/ListarDetallesRegistroServlet"})
public class ListarDetallesRegistroServlet extends HttpServlet {


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
            //Obtiene el idRegistro al presionar el botón
            int idRegistro = Integer.parseInt(request.getParameter("idRegistro"));
            
            //Listar el Registro
            Registro r = g.obtenerRegistro(idRegistro); 
            ArrayList<Object> lista1 = new ArrayList<>();
            lista1.add(r);
            request.setAttribute("listadoRegistro", lista1);
            
            //Listar los Detalles del Registro
            ArrayList<Object> lista2 = g.obtenerDetalles(idRegistro);
            request.setAttribute("listadoDetalles", lista2);
            System.out.println("Lista de Registro: "+lista1);
            System.out.println("Lista de Detalles: "+lista2);
            
            //Actualizar cantidad de Servicios
//            int cantidad = g.obtenerCantidad(idRegistro);
//            g.actualizarCantidad(cantidad, idRegistro);
            
            //Listar el importe total
            BigDecimal importeTotal = g.obtenerImporteTotal(idRegistro);
            ArrayList<Object> listaImporte = new ArrayList<>();  
            
                //Importe cuando es señado al 50%
                ArrayList<Seña> listaSeña = new ArrayList<>();
                BigDecimal dos = new BigDecimal(2);
                Registro rg = g.obtenerRegistro(idRegistro);
                if (rg.getEstadoPago().equalsIgnoreCase("Seña 50%") ) {
                    importeTotal = importeTotal.divide(dos,2, RoundingMode.HALF_UP);
                    BigDecimal seña = importeTotal;
                    Seña s = new Seña(seña);
                    listaSeña.add(s);      
                }
                //Promo si el cliente tiene mas de 10 registros por mes
                int idCliente = rg.getIdCliente();
                int registrosXCliente = g.registrosCliente(idCliente);
                BigDecimal descuento10 = new BigDecimal(0.85);
                BigDecimal descuento10Resto = new BigDecimal(0.15);
                ArrayList<RestoDescuentoMes> listaRestoDescuentoMeses = new ArrayList<>();
                ArrayList<RestoDescuento10> listaRestoDescuento10 = new ArrayList<>();
                if (registrosXCliente>10) {
                    MathContext returnRules = new MathContext(2, RoundingMode.HALF_UP);
                    BigDecimal resto10 = importeTotal.multiply(descuento10Resto, returnRules);
                    
                    importeTotal = importeTotal.multiply(descuento10, returnRules);
                    System.out.println("Se aplicó el descuento al cliente con más de 10 registros en el mes! ");
                    
                    RestoDescuento10 dr = new RestoDescuento10(resto10);
                    listaRestoDescuento10.add(dr);
                    
                    
                }else{
                    //Promo para fin de mes             
                    int dia = g.obtenerDia(idRegistro);
                    BigDecimal descuentoDia = new BigDecimal(0.85);
                    BigDecimal descuentoDiaResto = new BigDecimal(0.15);
                    
                    if (dia > 24) {
                    MathContext returnRules = new MathContext(4, RoundingMode.HALF_DOWN);
                    
                    BigDecimal restoMes = importeTotal.multiply(descuentoDiaResto, returnRules);
                    
                    importeTotal = importeTotal.multiply(descuentoDia, returnRules);
                    System.out.println("Se aplicó el descuento al registro por ser fin de mes!");
                    
                    RestoDescuentoMes d = new RestoDescuentoMes(restoMes);
                    listaRestoDescuentoMeses.add(d);
                    }
                }
            request.setAttribute("listadoDescuentoMes", listaRestoDescuentoMeses);
            System.out.println("listaRestoDescuentoMeses: "+listaRestoDescuentoMeses);    
               
            request.setAttribute("listadoDescuento10", listaRestoDescuento10);
            System.out.println("listaRestoDescuento10: "+listaRestoDescuento10);  
            
            request.setAttribute("listadoSeña", listaSeña);
            System.out.println("listaSeña: "+listaSeña);
            
            Importe i = new Importe(idRegistro, importeTotal);
            listaImporte.add(i); 
            System.out.println("listaImporte: "+listaImporte);
            
            
            request.setAttribute("listadoImporte", listaImporte);
            System.out.println("importeTotal: "+importeTotal);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoDetallesRegistros.jsp");
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
    }// </editor-fold>

}
