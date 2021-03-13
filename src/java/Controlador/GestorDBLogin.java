
package Controlador;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GestorDBLogin {
    
    GestorDBConexion g = new GestorDBConexion();
    
    public boolean UsuarioExistente(Usuario usuario) {
        boolean existe = false;
        try {
            g.abrirConexion();
            String sql = "Select * from Usuarios WHERE nombreUsuario = ? AND contraseña = ?";
            PreparedStatement stmt = g.getConexion().prepareStatement(sql);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }
            rs.close();
        } catch (Exception exc) {
            System.out.println(exc);
        } finally {
            g.cerrarConexion();
        }
        return existe;
    }
    
    public boolean NuevoUsuario(Usuario usuario) throws SQLException {
        
            g.abrirConexion();

            String sql = "Insert into Usuarios (nombreUsuario, contraseña) values (?,?)";

            PreparedStatement stmt = g.getConexion().prepareStatement(sql);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                    return true;
                }else{
                    return false;
                }

    }
    
    public int traerIdUsuario(String nombreUsuario) throws SQLException{
        g.abrirConexion();
        int idUsuario = 0;
        PreparedStatement ps = g.getConexion().prepareStatement("Select idUsuario\n" +
                                                                "From Usuarios\n" +
                                                                "Where nombreUsuario = ?");
        ps.setString(1, nombreUsuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {//Si encuentra un nombreUsuario en la DB trae su idUsuario
            idUsuario = rs.getInt(1);
        }else{//Sino se le asigna el primer usuario
            idUsuario = 1;
        }
        
        ps.close();
        rs.close();
        g.cerrarConexion();
        return idUsuario;
    }
    
}
