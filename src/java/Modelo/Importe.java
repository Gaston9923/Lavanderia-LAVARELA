
package Modelo;

import java.math.BigDecimal;


public class Importe {
    
    private int idImporte;
    private int idRegistro;
    private BigDecimal importeTotal;

    @Override
    public String toString() {
        return "Importe{" + "idImporte=" + idImporte + ", idRegistro=" + idRegistro + ", importeTotal=" + importeTotal + '}';
    }

    public Importe(int idRegistro, BigDecimal importeTotal) {
        this.idRegistro = idRegistro;
        this.importeTotal = importeTotal;
    }

    public int getIdImporte() {
        return idImporte;
    }

    public void setIdImporte(int idImporte) {
        this.idImporte = idImporte;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    
    
    
}
