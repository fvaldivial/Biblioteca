/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.servlets;

import com.mongodb.DBObject;
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
import pe.arq.clases.Utilitarios;

/**
 *
 * @author Fabrizzio
 */
public class LoginServlet extends HttpServlet {

    //Este sirve para salir de todo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        //Paso 3: logica
        s.setAttribute("sesion", null);

        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);

    }

    //Viene de login.jsp
    //el if verifica i devolvio algo el id de usuario y si es que la contrasena corresponde a la guardada
    //1. Envia a usuario.jsp
    //2. Envia a pagina de error y luego de regreso.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        UsuarioBean u = new UsuarioBean();
        String pass = request.getParameter("password");

        //Paso 3: logica
        UsuarioDAO ui = new UsuarioDAO();
        DBObject d = ui.getInfo(request.getParameter("usuario"));

        if (d != null && Utilitarios.password(pass, u, d)) {

            u = Utilitarios.rellenarUsuario(d);

            s.setAttribute("sesion", "escribi algo");
            s.setAttribute("usuario", u);
            

            if ("0".equals(u.getTipo())) {
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
                System.out.println("admin");

            } else if ("1".equals(u.getTipo())) {

                RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
                rd.forward(request, response);
                System.out.println("usuario");
            }
        } else {

        s.setAttribute("tipo", "error");
        s.setAttribute("mensaje", "Error en el logueo");
        s.setAttribute("direccion", "index.html");

        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request, response);

        }

    }
}
