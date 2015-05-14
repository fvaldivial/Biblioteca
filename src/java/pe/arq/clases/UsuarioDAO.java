/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.arq.clases;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.arq.bean.UsuarioBean;


public class UsuarioDAO {
  MongoClient mc = null;
    DB DB = null;
    DBCollection usuarios = null;

    private void inicializar() throws UnknownHostException {

        mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("biblioteca");
        usuarios = DB.getCollection("users");
    }

    public void registrar(UsuarioBean u, String pass) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Random randito = new SecureRandom();
        String passwordHash = Utilitarios.makePasswordHash(pass, Integer.toString(randito.nextInt()));

        BasicDBObject user = new BasicDBObject();

        user.append("_id", u.getDni()).append("password", passwordHash).append("nombre", u.getNombre())
                .append("tipo", u.getTipo());

        usuarios.insert(user);

    }

    public DBObject getInfo(String usuario) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        DBObject d = usuarios.findOne(new BasicDBObject("_id", usuario));

        return d;
    }

    public DBObject login(UsuarioBean u) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
