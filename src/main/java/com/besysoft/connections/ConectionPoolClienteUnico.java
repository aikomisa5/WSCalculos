package com.besysoft.connections;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConectionPoolClienteUnico
{
    //static Logger log = Logger.getLogger(ConectionPoolClienteUnico.class);

    private static final Logger log = Logger.getLogger("WSCalculos");

    public static DataSource getConexionClienteUnico()
    {
        Context c;
        try
        {
            log.info("Obteniendo el Data Source de Datos Cliente Único..");
            c = new InitialContext();
            return (DataSource) c.lookup("java:comp/env/jdbc/ClienteUnico");
        }
        catch (NamingException e)
        {
            e.printStackTrace();
            log.error("Error al intentar obtener el dataSource ClienteUnico" ,e);
        }

        log.info("Data Source de Datos Cliente Único obtenido con éxito..");
        return null;

    }
}