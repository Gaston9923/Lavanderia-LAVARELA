
package Modelo;

import java.math.BigDecimal;

public class DetalleRegistro {
    
    private int idDetalleRegistro;
    private int idRegistro;
    private int idServicio;
    private String servicio;
    private int cantidad;
    private BigDecimal precio;
    private BigDecimal monto;
    private BigDecimal importeTotal;

    public DetalleRegistro(int idDetalleRegistro, int idRegistro, int idServicio, String servicio, int cantidad, BigDecimal monto) {
        this.idDetalleRegistro = idDetalleRegistro;
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public DetalleRegistro(int idDetalleRegistro, int idRegistro, int idServicio, String servicio, int cantidad, BigDecimal precio, BigDecimal monto) {
        this.idDetalleRegistro = idDetalleRegistro;
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.monto = monto;
    }

    public DetalleRegistro( int idRegistro, int idServicio, int cantidad, BigDecimal monto) {
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public DetalleRegistro(int idDetalleRegistro, int idRegistro, int idServicio, int cantidad, BigDecimal monto) {
        this.idDetalleRegistro = idDetalleRegistro;
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
        this.monto = monto;
    }
  
    public DetalleRegistro(int idRegistro, int idServicio, int cantidad, BigDecimal monto, BigDecimal importeTotal) {
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.importeTotal = importeTotal;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }
    
    
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    } 
    
    public DetalleRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public DetalleRegistro(int idDetalleRegistro, int idRegistro, int idServicio, int cantidad) {
        this.idDetalleRegistro = idDetalleRegistro;
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
    }

    public DetalleRegistro(int idRegistro, int idServicio, int cantidad) {
        this.idRegistro = idRegistro;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
    }

    public int getIdDetalleRegistro() {
        return idDetalleRegistro;
    }

    public void setIdDetalleRegistro(int idDetalleRegistro) {
        this.idDetalleRegistro = idDetalleRegistro;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleRegistro{" + "idDetalleRegistro=" + idDetalleRegistro + ", idRegistro=" + idRegistro + ", idServicio=" + idServicio + ", servicio=" + servicio + ", cantidad=" + cantidad + ", precio=" + precio + ", monto=" + monto + ", importeTotal=" + importeTotal + '}';
    }
    

}
