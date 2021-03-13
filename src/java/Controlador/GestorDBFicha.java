
package Controlador;

import Modelo.Ficha;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GestorDBFicha {
    
    GestorDBConexion gc = new GestorDBConexion();
    
        public int obtenerCantidadFichas() throws SQLException {
        int cFichas = 0;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select sum(cantidadServ)'Cantidad de Fichas por Día' \n" +
                                                                "From Registros \n" +
                                                                "Where day(fecha) = day(GETDATE())and\n" +
                                                                "	MONTH(fecha) = MONTH(GETDATE())and\n" +
                                                                "	YEAR(fecha) = YEAR(GETDATE()) and\n" +
                                                                "	estadoServ = 'Completado'");
        ResultSet rs = ps.executeQuery();
        rs.next();
        cFichas = rs.getInt(1);
        System.out.println("Fichas de Hoy: "+cFichas);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return cFichas;           
        }
        
        public boolean actualizarFichas(Ficha f) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Fichas set fichas=? Where fecha=?");
        ps.setInt(1, f.getFichas());
        ps.setDate(2, f.getFecha());
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
        
        public boolean guardarFichas(Ficha f) throws SQLException {
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql = "Insert into Fichas values (?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setInt(1, f.getFichas());
        ps.setDate(2, f.getFecha());
        
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
        
        public boolean verificarFecha(Ficha f) throws SQLException{
            gc.abrirConexion();
            String sql ="Select fecha\n" +
                        "From Fichas\n" +
                        "Where fecha = ?";
            PreparedStatement ps = gc.getConexion().prepareStatement(sql);
            ps.setDate(1, f.getFecha());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }else{
                return false;
            }

        }
    
    
}
