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
import pe.arq.clases.LibroDAO;
import pe.arq.clases.MongoUtil;

public class ModificarServlet extends HttpServlet {

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
        
        LibroBean u = new LibroBean();

        String isbn = (String) request.getParameter("isbn");
        
        LibroDAO = new LibroDAO(mongo, morphia, dbname);
        
        LibroBean lb = LibroDAO.obtenerInfo(isbn); 
        
        s.setAttribute("libro", lb);
        System.out.println("holi"+lb.toString());

        RequestDispatcher rd = request.getRequestDispatcher("mostraruno.jsp");
        rd.forward(request, response);

    }
}
