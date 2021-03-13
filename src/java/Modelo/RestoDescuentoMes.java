
package Modelo;

import java.math.BigDecimal;


public class RestoDescuentoMes {
    
    private int id;
    private BigDecimal resto;

    public RestoDescuentoMes(BigDecimal resto) {
        this.resto = resto;
    }

    @Override
    public String toString() {
        return "RestoDescuentoMes{" + "id=" + id + ", resto=" + resto + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getResto() {
        return resto;
    }

    public void setResto(BigDecimal resto) {
        this.resto = resto;
    }
    
    
    
}
