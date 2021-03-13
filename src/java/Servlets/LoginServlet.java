
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=utf-8");
        
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("cerrar")) {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("usuario");

            sesion.invalidate();

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        if (accion != null && accion.equals("ingresar")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType ("text/html;charset=utf-8");
            
            String nombreUsuario = request.getParameter("txtUsuario");
            String contraseña = request.getParameter("txtPass");
            
            GestorDBLogin g = new GestorDBLogin();
            int idUsuario = g.traerIdUsuario(nombreUsuario);
            
            
            Usuario usuario = new Usuario(idUsuario,nombreUsuario, contraseña);
            //Buscar la forma de obtener el idUsuario aparte del nombreUsuario
            
            
            
            boolean existe = g.UsuarioExistente(usuario);
            
            if (existe) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                
                request.setAttribute("usuario", usuario);

                sesion.setMaxInactiveInterval(600*60);
                
                if (usuario.getIdUsuario() == 1) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioAdministrador.jsp");   
                    rd.forward(request, response);  
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicio.jsp");   
                    rd.forward(request, response);
                }

            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErrorLogin.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("Error:"+ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
