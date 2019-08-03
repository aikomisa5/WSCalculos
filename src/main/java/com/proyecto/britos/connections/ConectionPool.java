package com.proyecto.britos.connections;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConectionPool
{
    private static Logger log = Logger.getLogger(ConectionPool.class);

    public static DataSource getConexionDataSource()
    {
        Context c;
        try
        {
            //El data source debe estar definido en el context.mxl del tomcat
            c = new InitialContext();
            return (DataSource) c.lookup("java:comp/env/jdbc/dataSource");
        }
        catch (NamingException e)
        {
            e.printStackTrace();
            log.error("Error al intentar obtener el dataSource" ,e);
        }

        log.info("Data Source obtenido con éxito..");
        return null;

    }
}