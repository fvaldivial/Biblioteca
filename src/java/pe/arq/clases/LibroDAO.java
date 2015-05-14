/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.clases;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import pe.arq.bean.LibroBean;

public class LibroDAO extends BasicDAO<LibroBean, ObjectId> {

    MongoClient mc = null;
    DB DB = null;
    DBCollection coll = null;

    public LibroDAO(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }

    public void registrar(LibroBean lb) {

        ds.save(lb);

    }

    public List obtenerTodos() {

        Query q = ds.createQuery(LibroBean.class).filter("estado =", "nodisponible");

        List<LibroBean> libros = q.asList();
        return libros;

    }

    public LibroBean obtenerInfo(String isbn) {

        Query<LibroBean> q = ds.createQuery(LibroBean.class).filter("isbn =", isbn);

        return q.get();

    }

    public void modificarTodo(LibroBean lb) {

        UpdateOperations<LibroBean> ops;
        Query<LibroBean> updateQuery = ds.createQuery(LibroBean.class).field("isbn").equal(lb.getIsbn());

        ops = ds.createUpdateOperations(LibroBean.class).set("isbn", lb.getIsbn()).set("titulo", lb.getTitulo()).
                set("autor", lb.getAutor()).
                set("paginas", lb.getPaginas()).
                set("estado", lb.getEstado());
        ds.update(updateQuery, ops);
    }
    
    
    public void modificarEstado(LibroBean lb) {

        UpdateOperations<LibroBean> ops;
        Query<LibroBean> updateQuery = ds.createQuery(LibroBean.class).field("isbn").equal(lb.getIsbn());
        
        if ("disponible".equals(lb.getEstado())){
            ops = ds.createUpdateOperations(LibroBean.class).set("estado", "disponible");
        } else {
            ops = ds.createUpdateOperations(LibroBean.class).set("estado", "disponible");
                }
        ops = ds.createUpdateOperations(LibroBean.class).set("isbn", lb.getIsbn());
                
        ds.update(updateQuery, ops);
    }
}





