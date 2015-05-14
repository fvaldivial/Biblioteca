/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.servlets;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.arq.bean.LibroBean;
import pe.arq.bean.UsuarioBean;
import pe.arq.clases.MongoUtil;
import pe.arq.clases.LibroDAO;
import pe.arq.clases.UsuarioDAO;

public class Registro extends HttpServlet {

    private Mongo mongo;
    private Morphia morphia;
    private final String dbname = "biblioteca";
    private LibroDAO LibroDAO;

    public void initiate() {
        mongo = MongoUtil.getMongo();
        morphia = new Morphia();
        morphia.map(LibroBean.class);
        LibroDAO = new LibroDAO(mongo, morphia, dbname);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initiate();
        HttpSession s = request.getSession(true);

        LibroBean lb = new LibroBean();

        lb.setIsbn(request.getParameter("isbn"));
        lb.setAutor(request.getParameter("autor"));
        lb.setEstado("disponible"); 
        lb.setPaginas(request.getParameter("paginas"));
        lb.setTitulo(request.getParameter("titulo"));

        LibroDAO.registrar(lb);
        
        s.setAttribute("tipo", "OK");
        s.setAttribute("mensaje", "Libro registrado satisfactoriamente");
        s.setAttribute("direccion", "admin.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("ok.jsp");
        rd.forward(request, response);

    }
}
