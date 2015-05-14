
package pe.arq.clases;

import com.mongodb.*;



public class MongoUtil {

    private static final int port = 27017;

    private static final String host = "localhost";

    private static Mongo mongo = null;

    public static Mongo getMongo() {
        if (mongo == null) {
            try {

                mongo = new Mongo(host, port);

            } catch (MongoException e) {

            }

        }

        return mongo;

    }

}


