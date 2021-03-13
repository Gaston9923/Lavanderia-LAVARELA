
package Modelo;


public class EstadoPago {
    private int idEstadoPago;
    private String estadoPago;    

    public EstadoPago(int idEstadoPago, String estadoPago) {
        this.idEstadoPago = idEstadoPago;
        this.estadoPago = estadoPago;
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

    @Override
    public String toString() {
        return "EstadoPago{" + "idEstadoPago=" + idEstadoPago + ", estadoPago=" + estadoPago + '}';
    }

}
