package com.revature.data;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {
    private static DataSource ers;
    private static Properties environment;
    static {
        InputStream inStream = ServiceLocator.class.getClassLoader()
                .getResourceAsStream("database.properties");
        environment = new Properties();
        try {
            environment.load(inStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized static DataSource getErsDatabase() throws NamingException {
        if (ers == null) {
            ers = lookupErs();
        }
        return ers;
    }

    public static DataSource lookupErs() {
        // TODO Auto-generated method stub
        Context ctxt;
        try {
            ctxt = new InitialContext(environment);
            DataSource dataSource = (DataSource) ctxt.lookup(environment.getProperty("ers"));
            return dataSource;
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
