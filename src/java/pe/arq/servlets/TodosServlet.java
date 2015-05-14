/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.servlets;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.arq.bean.LibroBean;
import pe.arq.clases.MongoUtil;
import pe.arq.clases.LibroDAO;

public class TodosServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initiate();

        HttpSession s = request.getSession(true);

        LibroDAO = new LibroDAO(mongo, morphia, dbname);

        List libros = LibroDAO.obtenerTodos();

        s.setAttribute("ListaLibros", libros);
        System.out.println("holi"+libros.toString());

        RequestDispatcher rd = request.getRequestDispatcher("ListaLibros.jsp");
        rd.forward(request, response);
    }

}
