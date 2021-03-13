
package Servlets;

import Controlador.GestorDBLogin;
import Modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType ("text/html;charset=utf-8");
            
            String nombreUsuario = request.getParameter("txtUsuario");
            String contraseña = request.getParameter("txtPass");
            
            GestorDBLogin g = new GestorDBLogin();
            Usuario usuario = new Usuario(nombreUsuario, contraseña);
            
            
            g.NuevoUsuario(usuario);
            
            
            request.getSession().setAttribute("usuario", usuario);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioRegistrado.jsp");
            rd.forward(request, response);  
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
