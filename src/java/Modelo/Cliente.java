
package Modelo;

import java.sql.Date;

public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String barrio;
    private String telefono;
    private String notas;
    private Date fecha_alta;

    public Cliente(int idCliente, String nombre, String apellido, String direccion, String barrio, String telefono, String notas, Date fecha_alta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.barrio = barrio;
        this.telefono = telefono;
        this.notas = notas;
        this.fecha_alta = fecha_alta;
    }

    public Cliente(String nombre, String apellido, String direccion, String barrio, String telefono, String notas, Date fecha_alta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.barrio = barrio;
        this.telefono = telefono;
        this.notas = notas;
        this.fecha_alta = fecha_alta;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", barrio=" + barrio + ", telefono=" + telefono + ", notas=" + notas + ", fecha_alta=" + fecha_alta + '}';
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
}