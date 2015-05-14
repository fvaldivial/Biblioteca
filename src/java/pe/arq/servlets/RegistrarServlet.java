/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.arq.bean.UsuarioBean;
import pe.arq.clases.UsuarioDAO;

public class RegistrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //el que viene de inscripcion
    //1. Envia a pagina de felicilitacion y pasa al index
    //2. Envia a pagina de error y regreso     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        UsuarioBean u = new UsuarioBean();

        u.setDni(request.getParameter("DNI"));
        u.setNombre(request.getParameter("nombre"));
        u.setTipo(request.getParameter("tipo"));

        String pass = request.getParameter("password");
        String passc = request.getParameter("password1");

        UsuarioDAO ui = new UsuarioDAO();

        if (pass.equals(passc) && ui.getInfo(u.getDni()) == null) {

            ui.registrar(u, pass);

            s.setAttribute("tipo", "OK");
            s.setAttribute("mensaje", "Usuario creado satisfactoriamente");
            s.setAttribute("direccion", "index.jsp");

            RequestDispatcher rd = request.getRequestDispatcher("ok.jsp");
            rd.forward(request, response);

        } else {
            s.setAttribute("tipo", "error");
            s.setAttribute("mensaje", "Contraseñas no coinciden o usuario ya existe");
            s.setAttribute("direccion", "registro.html");

            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }

    }

}
