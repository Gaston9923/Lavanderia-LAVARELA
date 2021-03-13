
package Controlador;

import Modelo.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class GestorDBCliente {
    
    GestorDBConexion gc = new GestorDBConexion();
            
    public boolean agregarCliente(Cliente c) throws SQLException{
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql ="Insert into Clientes values (?,?,?,?,?,?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getDireccion());
        ps.setString(4, c.getBarrio());
        ps.setString(5, c.getTelefono());
        ps.setString(6, c.getNotas());
        ps.setDate(7, c.getFecha_alta());
        
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
    
    public boolean eliminarCliente(int id) throws SQLException{
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Delete from Clientes Where idCliente = ?");
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
    
    public boolean modificarCliente(Cliente c) throws SQLException{
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Clientes set nombre=?, apellido=?, direccion=?, barrio=?, telefono=?, notas=?, fecha_alta=? Where idCliente=?");      
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getDireccion());
        ps.setString(4, c.getBarrio());
        ps.setString(5, c.getTelefono());
        ps.setString(6, c.getNotas());
        ps.setDate(7, (java.sql.Date) c.getFecha_alta());
        ps.setInt(8, c.getIdCliente());
        
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public Cliente obtenerCliente(int id) throws SQLException{
        Cliente c = null;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select * From Clientes Where idCliente =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String direccion = rs.getString("direccion");
            String barrio = rs.getString("barrio");
            String telefono = rs.getString("telefono");
            String notas = rs.getString("notas");
            Date fecha_alta = rs.getDate("fecha_alta");
            c = new Cliente(id,nombre,apellido,direccion,barrio,telefono,notas,fecha_alta);    
        }
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return c;  
    }
    
    public ArrayList<Cliente> obtenerClientes() throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select *\n" +
                                       "From Clientes\n" +
                                       "Order by apellido");
        
        while (rs.next()) {
            int idCliente = rs.getInt("idCliente");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String direccion = rs.getString("direccion");
            String barrio = rs.getString("barrio");
            String telefono = rs.getString("telefono");
            String notas = rs.getString("notas");
            Date fecha_alta = rs.getDate("fecha_alta");
            Cliente c = new Cliente(idCliente,nombre,apellido,direccion,barrio,telefono,notas,fecha_alta); 
            lista.add(c);
            
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
    }

}
