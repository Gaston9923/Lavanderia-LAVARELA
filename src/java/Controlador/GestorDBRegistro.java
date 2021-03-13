
package Controlador;

import Modelo.DetalleRegistro;
import Modelo.Importe;
import Modelo.Registro;
import Modelo.Usuario;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorDBRegistro {

    GestorDBConexion gc = new GestorDBConexion();
    //REGISTROS
    public Registro obtenerRegistro(int id) throws SQLException {
        Registro rr = null;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select idRegistro, u.idUsuario, u.nombreUsuario, c.idCliente, cantidadServ, e.idEstadoPago ,e.estadoPago, estadoServ, fecha, apellido+' '+nombre'ApellidoNombre'\n" +
                                                                "From Registros r, Clientes c, Usuarios u, EstadoPago e \n" +
                                                                "Where r.idCliente = c.idCliente \n" +
                                                                "      and r.idUsuario = u.idUsuario\n" +
                                                                "      and r.idEstadoPago = e.idEstadoPago\n" +
                                                                "      and idRegistro = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String nombreUsuario = rs.getString("nombreUsuario");
            int idCliente = rs.getInt("idCliente");
            String cliente = rs.getString("apellido"+"nombre");
            int cantidadServ = rs.getInt("cantidadServ");
            String estadoPago = rs.getString("estadoPago");
            String estadoServ = rs.getString("estadoServ");
            Date fecha = rs.getDate("fecha");
            rr = new Registro(id,idUsuario,nombreUsuario, idCliente, cliente, cantidadServ, estadoPago, estadoServ, fecha);
        }
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return rr;         
        }
    
    public boolean agregarRegistro(Registro r) throws SQLException {
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql = "Insert into Registros values (?,?,?,?,?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setInt(1, r.getIdUsuario());
        ps.setInt(2, r.getIdCliente());
        ps.setInt(3, r.getCantidadServ());   
        ps.setInt(4, r.getIdEstadoPago());    
        ps.setString(5, r.getEstadoServ());
        ps.setDate(6, r.getFecha());
        
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

    public boolean modificarRegistro(Registro r) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Registros set idUsuario=?, idCliente=?, cantidadServ=?, idEstadoPago=?, estadoServ=? Where idRegistro=?");
        ps.setInt(1, r.getIdUsuario());
        ps.setInt(2, r.getIdCliente());
        ps.setInt(3, r.getCantidadServ());
        ps.setInt(4, r.getIdEstadoPago());
        ps.setString(5, r.getEstadoServ());
        ps.setInt(6, r.getIdRegistro());
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public int obtenerUltimoRegistro() throws SQLException {
        int idRegistro = 0;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select MAX(idRegistro) From Registros");
        ResultSet rs = ps.executeQuery();
        rs.next();
        idRegistro = rs.getInt(1);
        System.out.println("Ultimo Registro: "+idRegistro);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return idRegistro;           
        }
    
    public ArrayList<Registro> obtenerRegistros() throws SQLException {
        ArrayList<Registro> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select idRegistro, u.idUsuario, u.nombreUsuario, c.idCliente, cantidadServ, e.estadoPago, estadoServ, fecha, apellido+' '+nombre'ApellidoNombre'\n" +
"                                        from Registros r, Clientes c, Usuarios u,EstadoPago e\n" +
"                                        Where r.idCliente = c.idCliente\n" +
"                                              and r.idUsuario = u.idUsuario \n" +
"                                              and r.idEstadoPago = e.idEstadoPago\n" +
"                                              and r.fecha = CONVERT(VARCHAR(10), GETDATE(), 103)\n" +
"                                              Order by idRegistro desc");
        while (rs.next()) {
            int idRegistro = rs.getInt("idRegistro");
            int idUsuario = rs.getInt("idUsuario");
            String nombreUsuario = rs.getString("nombreUsuario");
            int idCliente = rs.getInt("idCliente");
            String cliente = rs.getString("apellido"+"nombre");
            int cantidadServ = rs.getInt("cantidadServ");
            String estadoPago = rs.getString("estadoPago");
            String estadoServ = rs.getString("estadoServ");
            Date fecha = rs.getDate("fecha");
            

            Registro r = new Registro(idRegistro, idUsuario, nombreUsuario, idCliente, cliente, cantidadServ, estadoPago, estadoServ, fecha);
            lista.add(r);
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
    }
    
    public ArrayList<Registro> obtenerRegistrosBusqueda(Date fechaDesde,Date fechaHasta) throws SQLException {
        ArrayList<Registro> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select idRegistro, u.idUsuario, u.nombreUsuario, c.idCliente, cantidadServ, e.estadoPago, estadoServ, fecha, apellido+' '+nombre'ApellidoNombre'\n" +
"                                                                from Registros r, Clientes c, Usuarios u, EstadoPago e\n" +
"                                                                Where r.idCliente = c.idCliente \n" +
"                                                                   and r.idUsuario = u.idUsuario\n" +
"                                                                   and e.idEstadoPago = r.idEstadoPago\n" +
"                                                                  and fecha between ? and ? ");
        ps.setDate(1, fechaDesde);
        ps.setDate(2, fechaHasta);
        ResultSet rs = ps.executeQuery();  
        while (rs.next()) {
            int idRegistro = rs.getInt("idRegistro");
            int idUsuario = rs.getInt("idUsuario");
            String nombreUsuario = rs.getString("nombreUsuario");
            int idCliente = rs.getInt("idCliente");
            String cliente = rs.getString("apellido"+"nombre");
            int cantidadServ = rs.getInt("cantidadServ");
            String estadoPago = rs.getString("estadoPago");
            String estadoServ = rs.getString("estadoServ");
            Date fecha = rs.getDate("fecha");
            

            Registro r = new Registro(idRegistro, idUsuario, nombreUsuario, idCliente, cliente, cantidadServ, estadoPago, estadoServ, fecha);
            lista.add(r);
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
    }

    public boolean eliminarRegistro(int id) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Delete from Registros Where idRegistro = ?");
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
    
    public boolean eliminarDetallesRegistro(int id) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Delete from DetalleRegistro Where idRegistro = ?");
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
    
    //DETALLES REGISTROS
    public boolean agregarDetalle(DetalleRegistro d) throws SQLException {
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql = "Insert into DetalleRegistro values (?,?,?,?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setInt(1, d.getIdRegistro());
        ps.setInt(2, d.getIdServicio());
        ps.setInt(3, d.getCantidad());
        ps.setBigDecimal(4, d.getMonto());    
        ps.setBigDecimal(5, d.getImporteTotal());    
        
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

    public boolean modificarDetalleRegistro(DetalleRegistro d) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update DetalleRegistro set idRegistro=?, idServicio=?, cantidad=?, monto=? Where idDetalleRegistro=?");
        ps.setInt(1, d.getIdRegistro());
        ps.setInt(2, d.getIdServicio());
        ps.setInt(3, d.getCantidad());
        ps.setBigDecimal(4, d.getMonto());
        ps.setInt(5, d.getIdDetalleRegistro());
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public DetalleRegistro obtenerDetalle(int id) throws SQLException {
        DetalleRegistro d = null;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select * From DetalleRegistro Where idRegistro =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idDetalleRegistro = rs.getInt("idDetalleRegistro");
            int idServicio = rs.getInt("idServicio");
            int cantidad = rs.getInt("cantidad");
            BigDecimal monto = rs.getBigDecimal("monto");

            d = new DetalleRegistro(idDetalleRegistro, id,idServicio, cantidad, monto);
        }else{
             d = new DetalleRegistro(id);
        }
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return d; 
        }
    
    public ArrayList<Object> obtenerDetalles(int idRegistro) throws SQLException {
        ArrayList<Object> lista = new ArrayList<>();
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select idDetalleRegistro, s.idServicio, s.servicio, s.precio, cantidad, monto\n" +
                                                                 "From DetalleRegistro d, Servicios s\n" +
                                                                 "Where d.idServicio=s.idServicio and\n" +
                                                                 "d.idRegistro = ?");
        ps.setInt(1, idRegistro);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            int idDetalleRegistro = rs.getInt("idDetalleRegistro");
            int idServicio = rs.getInt("idServicio");
            String servicio = rs.getString("servicio");
            BigDecimal precio = rs.getBigDecimal("precio");
            int cantidad = rs.getInt("cantidad");
            BigDecimal monto = rs.getBigDecimal("monto");
                         
            DetalleRegistro d = new DetalleRegistro(idDetalleRegistro, idRegistro, idServicio, servicio, cantidad,precio, monto);
            lista.add(d); 
        }
     
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return lista; 
    }
    
    public int obtenerCantidadDetalles(int idRegistro) throws SQLException {
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select count(d.idDetalleRegistro)'Detalles'\n" +
                                                                 "From Registros r, DetalleRegistro d\n" +
                                                                 "Where r.idRegistro = d.idRegistro\n" +
                                                                 "and r.idRegistro = ?");
        ps.setInt(1, idRegistro);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int cantidadDetalles = rs.getInt(1);
        System.out.println("Cant.Detalles: "+cantidadDetalles);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return cantidadDetalles;           
        }
    
    //IMPORTES
    public boolean agregarImporte(Importe i) throws SQLException {
        boolean exito = false;
        int filasAfectadas = 0;
        gc.abrirConexion();
        String sql = "Insert into Importe values (?,?)";
        PreparedStatement ps = gc.getConexion().prepareStatement(sql);
        ps.setInt(1, i.getIdRegistro());
        ps.setBigDecimal(2, i.getImporteTotal());
        
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
    
    public BigDecimal obtenerImporteTotal(int id) throws SQLException {
        int idRegistro = 0;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select SUM(monto)\n" +
                                                                 "From DetalleRegistro\n" +
                                                                 "Where idRegistro = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        BigDecimal importeTotal = rs.getBigDecimal(1);
        System.out.println("Ultimo Registro: "+idRegistro);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return importeTotal;           
        }
    
    public int obtenerCantidad(int idRegistro) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select COUNT(idDetalleRegistro)\n" +
                                                                 "From DetalleRegistro d\n" +
                                                                 "Where idRegistro = ?");
        ps.setInt(1, idRegistro);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int cantidad = rs.getInt(1);
        ps.close();
        gc.cerrarConexion();
        
        return cantidad;
    }
    
    public boolean actualizarCantidad(int cantidad,int idRegistro) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Registros set cantidadServ=?\n" +
                                                                 "Where idRegistro = ?");
        ps.setInt(1, cantidad);
        ps.setInt(2, idRegistro);
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public int registrosCliente(int idCliente) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select count(idRegistro)\n" +
                                                                 "From Registros\n" +
                                                                 "Where idCliente = ? and\n" +
                                                                 "MONTH(fecha) = MONTH(GETDATE())");
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int cantidad = rs.getInt(1);
        ps.close();
        gc.cerrarConexion();
        
        return cantidad;
    }
    
    public BigDecimal obtenerImporteFinal() throws SQLException {
        BigDecimal importeFinal;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select SUM(monto)[Importe Total]\n" +
                                                                    "From Registros r, DetalleRegistro d,Clientes c\n" +
                                                                    "Where r.idRegistro = d.idRegistro and \n" +
                                                                    "c.idCliente = r.idCliente and \n" +
                                                                    "r.estadoPago = '3'");
        ResultSet rs = ps.executeQuery();
        rs.next();
        importeFinal = rs.getBigDecimal(1);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return importeFinal;           
        }
    
    //OTROS
    public ArrayList<Usuario> obtenerUsuarios() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        gc.abrirConexion();
        Statement st = gc.getConexion().createStatement();
        ResultSet rs = st.executeQuery("Select * From Usuarios");
        while (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String usuario = rs.getString("nombreUsuario");
            Usuario u = new Usuario(idUsuario, usuario);
            lista.add(u);
        }
        rs.close();
        st.close();
        gc.cerrarConexion();
        return lista;
    }
    
    public double obtenerPrecioServicio(int id) throws SQLException {
        double precio = 0;
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select precio\n" +
                                                                 "From Servicios\n" +
                                                                 "Where idServicio = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        precio = rs.getDouble("precio");
        System.out.println("Servicio Nro."+id+": "+precio);
        rs.close();
        ps.close();
        gc.cerrarConexion();
        return precio;           
    }
    
    public boolean actualizarEstadoCompletado(int idRegistro) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Registros set estadoServ = 'Completado' \n" +
                                                                 "Where idRegistro =?");
        ps.setInt(1, idRegistro);
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean actualizarEstadoIncompleto(int idRegistro) throws SQLException{
        gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Registros set estadoServ = 'Incompleto' \n" +
                                                                 "Where idRegistro =?")  ;
        ps.setInt(1, idRegistro);
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public int obtenerDia(int idRegistro) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Select DAY(fecha)\n" +
                                                                 "From Registros\n" +
                                                                 "where idRegistro = ?");
        ps.setInt(1, idRegistro);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int dia = rs.getInt(1);
        ps.close();
        gc.cerrarConexion();
        return dia;
    }
    
    public boolean suma1Cantidad(int idRegistro) throws SQLException {
       gc.abrirConexion();
        PreparedStatement ps = gc.getConexion().prepareStatement("Update Registros set cantidadServ=cantidadServ+1\n" +
                                                                 "Where idRegistro = ?");
        ps.setInt(1, idRegistro);
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        gc.cerrarConexion();
        
        if (filasAfectadas > 0) {
            return true;
        }else{
            return false;
        }
    }
    
}
    
    
    

