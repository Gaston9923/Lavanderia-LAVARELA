
package Modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Registro {
    
    private int idRegistro;
    private int idUsuario;
    private String nombreUsuario;
    private int idCliente;
    private String cliente;
    private int cantidadServ;
    private int idEstadoPago;
    private String estadoPago;
    private String estadoServ;
    private Date fecha;
    private ArrayList<DetalleRegistro> detallesRegistro;

    public Registro(int idUsuario, int idCliente, int cantidadServ, int idEstadoPago, String estadoServ, Date fecha) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.cantidadServ = cantidadServ;
        this.idEstadoPago = idEstadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
    }

    public Registro(String nombreUsuario, int idCliente, int cantidadServ, int idEstadoPago, String estadoServ, Date fecha) {
        this.nombreUsuario = nombreUsuario;
        this.idCliente = idCliente;
        this.cantidadServ = cantidadServ;
        this.idEstadoPago = idEstadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
    }
    
    public Registro(int idRegistro, int idUsuario, String nombreUsuario, int idCliente, String cliente, int cantidadServ, int idEstadoPago, String estadoServ, Date fecha, ArrayList<DetalleRegistro> detallesRegistro) {
        this.idRegistro = idRegistro;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.cantidadServ = cantidadServ;
        this.idEstadoPago = idEstadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
        this.detallesRegistro = new ArrayList<>();
    }

    public Registro(int idUsuario, int idCliente, int cantidadServ, int idEstadoPago, String estadoServ, Date fecha, ArrayList<DetalleRegistro> detallesRegistro) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.cantidadServ = cantidadServ;
        this.idEstadoPago = idEstadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
        this.detallesRegistro = new ArrayList<>();
    }

    public Registro(int idRegistro, int idUsuario, int idCliente, int cantidadServ, int idEstadoPago, String estadoServ, Date fecha) {
        this.idRegistro = idRegistro;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.cantidadServ = cantidadServ;
        this.idEstadoPago = idEstadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
    }

    public Registro(int idRegistro, int idUsuario, String nombreUsuario, int idCliente, String cliente, int cantidadServ, String estadoPago, String estadoServ, Date fecha) {
        this.idRegistro = idRegistro;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.cantidadServ = cantidadServ;
        this.estadoPago = estadoPago;
        this.estadoServ = estadoServ;
        this.fecha = fecha;
    }
  
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(int idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<DetalleRegistro> getDetallesRegistro() {
        return detallesRegistro;
    }

    public void setDetallesRegistro(ArrayList<DetalleRegistro> detallesRegistro) {
        this.detallesRegistro = detallesRegistro;
    }

    @Override
    public String toString() {
        return "Registro{" + "idRegistro=" + idRegistro + ", idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", idCliente=" + idCliente + ", cliente=" + cliente + ", cantidadServ=" + cantidadServ + ", idEstadoPago=" + idEstadoPago + ", estadoPago=" + estadoPago + ", estadoServ=" + estadoServ + ", fecha=" + fecha + ", detallesRegistro=" + detallesRegistro + '}';
    }
    
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidadServ() {
        return cantidadServ;
    }

    public void setCantidadServ(int cantidadServ) {
        this.cantidadServ = cantidadServ;
    }

    public String getEstadoServ() {
        return estadoServ;
    }

    public void setEstadoServ(String estadoServ) {
        this.estadoServ = estadoServ;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
