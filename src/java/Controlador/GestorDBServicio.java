
package Controlador;

import Modelo.Servicio;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorDBServicio {

    GestorDBConexion gc = new GestorDBConexion();
    
    public Servicio obtenerServicio(int id) throws SQLException {
        Servicio t = null;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select * From Servicios Where idServicio =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String servicio = rs.getString("servicio");
            BigDecimal precio = rs.getBigDecimal("precio");

            t = new Servicio(id, servicio, precio);
        }
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return t;
    }

    public boolean agregarServicio(Servicio t) throws SQLException {      
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql ="Insert into Servicios values (?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setString(1, t.getServicio());
        ps.setBigDecimal(2, t.getPrecio() );
        
        filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            exito = true;
        }else{
            exito = false;
        }
        return exito;
    }
    
    public boolean modificarServicio(Servicio s) throws SQLException{
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Servicios set servicio=?, precio=? Where idServicio=?");      
        ps.setString(1, s.getServicio());
        ps.setBigDecimal(2, s.getPrecio());
        ps.setInt(3, s.getIdServicio());
        
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Servicio> obtenerServicios() throws SQLException {  
        ArrayList<Servicio> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select * From Servicios");
        
        while (rs.next()) {
            int idServicio = rs.getInt("idServicio");
            String servicio = rs.getString("servicio");
            BigDecimal precio = rs.getBigDecimal("precio");

            Servicio g = new Servicio(idServicio, servicio, precio); 
            lista.add(g);
            
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
        
    }

    public boolean eliminarServicio(int id) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Delete from Servicios Where idServicio = ?");
        ps.setInt(1, id);
        int resultado = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        if (resultado > 0) {
            return true;
        }else{
            return false;
        }
    }
      
    
}
