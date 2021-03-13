
package Modelo;

import java.math.BigDecimal;


public class Seña {
    private int idSeña;
    private BigDecimal seña;

    public Seña(BigDecimal seña) {
        this.seña = seña;
    }
    
    public int getIdSeña() {
        return idSeña;
    }

    public void setIdSeña(int idSeña) {
        this.idSeña = idSeña;
    }

    public BigDecimal getSeña() {
        return seña;
    }

    public void setSeña(BigDecimal seña) {
        this.seña = seña;
    }

    @Override
    public String toString() {
        return "Se\u00f1a{" + "idSe\u00f1a=" + idSeña + ", se\u00f1a=" + seña + '}';
    } 
    
}
