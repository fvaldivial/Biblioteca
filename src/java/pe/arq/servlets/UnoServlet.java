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
import pe.arq.clases.LibroDAO;
import pe.arq.clases.MongoUtil;

/**
 *
 * @author Fabrizzio
 */
public class UnoServlet extends HttpServlet {
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

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initiate();
        LibroDAO = new LibroDAO(mongo, morphia, dbname);
        HttpSession s = request.getSession(true);
        
        LibroBean u = new LibroBean();

        String isbn = (String) request.getParameter("isbn");
        
        LibroBean lboriginal = LibroDAO.obtenerInfo(isbn);
        
        LibroDAO.modificarTodo(lboriginal); 
        
        

        s.setAttribute("tipo", "OK");
        s.setAttribute("mensaje", "Libro modificado satisfactoriamente");
        s.setAttribute("direccion", "admin.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("ok.jsp");
        rd.forward(request, response);
        
       

    }

  

}
