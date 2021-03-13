
package Controlador;

import Modelo.EstadoPago;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorDBImporte {
    
    GestorDBConexion gc = new GestorDBConexion();
    
    public ArrayList<EstadoPago> obtenerEstadosPagos() throws SQLException {  
        ArrayList<EstadoPago> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select *\n" +
                                       "From EstadoPago");
        
        while (rs.next()) {
            int idEstadoPago = rs.getInt("idEstadoPago");
            String estadoPago = rs.getString("estadoPago");

            EstadoPago e = new EstadoPago(idEstadoPago, estadoPago);
            lista.add(e);
            
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;   
    }
    
    
}
