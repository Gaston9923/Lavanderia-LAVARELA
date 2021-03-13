
package Modelo;

import java.sql.Date;


public class Ficha {
    
    private int idFicha;
    private int fichas;
    private Date fecha;

    public Ficha(int idFicha, int fichas, Date fecha) {
        this.idFicha = idFicha;
        this.fichas = fichas;
        this.fecha = fecha;
    }

    public Ficha(int fichas, Date fecha) {
        this.fichas = fichas;
        this.fecha = fecha;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ficha{" + "idFicha=" + idFicha + ", fichas=" + fichas + ", fecha=" + fecha + '}';
    }          
            
}
