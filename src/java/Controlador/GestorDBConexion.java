
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GestorDBConexion {
    
    private Connection conexion;
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void abrirConexion() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-UDRJE1U\\SQLEXPRESS:1433;databaseName=LAVARELA1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conexion = DriverManager.getConnection(url, "sa", "sa");
            System.out.println("Se conectó a la BD");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error en la conexión");
        }
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Conexión cerrada");

        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión");
        }
    }
    
}
