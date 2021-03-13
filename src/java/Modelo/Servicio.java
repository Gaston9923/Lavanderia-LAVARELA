
package Modelo;

import java.math.BigDecimal;


public class Servicio {
    
    private int idServicio;
    private String servicio;
    private BigDecimal precio;

    public Servicio(int idServicio, String servicio, BigDecimal precio) {
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", servicio=" + servicio + ", precio=" + precio + '}';
    }

    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
}
