
package Modelo;

import java.math.BigDecimal;
import java.sql.Date;


public class Gasto {
    
    private int idGasto;
    private String descripcion;
    private BigDecimal importe;
    private int idFormaPago;
    private String formaPago;
    private Date fechaGasto;

    public Gasto(int idGasto, String descripcion, BigDecimal importe, String formaPago, Date fechaGasto) {
        this.idGasto = idGasto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.formaPago = formaPago;
        this.fechaGasto = fechaGasto;
    }
    
    public Gasto(int idGasto, String descripcion, BigDecimal importe, int idFormaPago, Date fechaGasto) {
        this.idGasto = idGasto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.idFormaPago = idFormaPago;
        this.fechaGasto = fechaGasto;
    }
    
    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Gasto(int idGasto, String descripcion, BigDecimal importe, int idFormaPago, String formaPago, Date fechaGasto) {
        this.idGasto = idGasto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.idFormaPago = idFormaPago;
        this.formaPago = formaPago;
        this.fechaGasto = fechaGasto;
    }

    @Override
    public String toString() {
        return "Gasto{" + "idGasto=" + idGasto + ", descripcion=" + descripcion + ", importe=" + importe + ", idFormaPago=" + idFormaPago + ", formaPago=" + formaPago + ", fechaGasto=" + fechaGasto + '}';
    }
    
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        this.fechaGasto = fechaGasto;
    }
    
}
