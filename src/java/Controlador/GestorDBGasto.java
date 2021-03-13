
package Controlador;

import Modelo.Cliente;
import Modelo.FormaPago;
import Modelo.Gasto;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorDBGasto {
    
    GestorDBConexion gc = new GestorDBConexion();
    
    public ArrayList<FormaPago> obtenerFormasPago(){
        ArrayList<FormaPago> lista = new ArrayList<>();
        try {
            gc.abrirConexion();
                Statement st = gc.getConexion().createStatement();
                ResultSet rs = st.executeQuery("Select * From FormaPago");
                    while (rs.next()) {
                        int id = rs.getInt(1);                      
                        String descripcion = rs.getString(2);
                        
                        FormaPago f = new FormaPago(id, descripcion);
                        lista.add(f);
                    }
            rs.close();
            st.close();
            gc.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public Gasto obtenerGasto(int id) throws SQLException {
        Gasto g = null;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select idGasto,descripcion,importe,g.idFormaPago,formaPago,fechaGasto\n" +
                                                                 "From Gastos g,FormaPago f\n" +
                                                                 "Where g.idFormaPago = f.idFormaPago and idGasto =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String descripcion = rs.getString("descripcion");
            BigDecimal importe = rs.getBigDecimal("importe");
            int idFormaPago = rs.getInt("idFormaPago");
            String formaPago = rs.getString("formaPago");
            Date fechaGasto = rs.getDate("fechaGasto");
            g = new Gasto(id, descripcion, importe, idFormaPago,formaPago , fechaGasto);
        }
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return g;
    }

    public boolean agregarGasto(Gasto g) throws SQLException {
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql = "Insert into Gastos values (?,?,?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setString(1, g.getDescripcion());
        ps.setBigDecimal(2, g.getImporte());
        ps.setInt(3, g.getIdFormaPago());
        ps.setDate(4, g.getFechaGasto());
        
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

    public boolean modificarGasto(Gasto g) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Gastos set descripcion=?, importe=?, idFormaPago=? Where idGasto=?");
        ps.setString(1, g.getDescripcion());
        ps.setBigDecimal(2, g.getImporte());
        ps.setInt(3, g.getIdFormaPago());
        ps.setInt(4, g.getIdGasto());
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Gasto> obtenerGastos() throws SQLException{
        ArrayList<Gasto> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select idGasto,descripcion,importe,formaPago,fechaGasto\n" +
                                       "From Gastos g,FormaPago f\n" +
                                       "Where g.idFormaPago = f.idFormaPago");
        
        while (rs.next()) {
            int idGasto = rs.getInt("idGasto");
            String descripcion = rs.getString("descripcion");
            BigDecimal importe = rs.getBigDecimal("importe");
//            int idFormaPago = rs.getInt("idFormaPago");
            String formaPago = rs.getString("formaPago");
            Date fechaGasto = rs.getDate("fechaGasto");

            
            Gasto g = new Gasto(idGasto, descripcion, importe, formaPago, fechaGasto); 
            lista.add(g);
            
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
    }

    public boolean eliminarGasto(int id) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Delete from Gastos Where idGasto = ?");
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
