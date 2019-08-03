package com.proyecto.britos.consultas;

import com.proyecto.britos.connections.ConectionPool;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;


public class Service {

    private static final Logger logger = Logger.getLogger(Service.class);

    public Service() {}

    public static String getRespuesta(int id) throws SQLException{

        String respuesta = "";

        DataSource dsDocAdmin = ConectionPool.getConexionDataSource();

        Connection connDocAdmin = null;
        PreparedStatement pstmListaDoc = null;
        ResultSet resultSet = null;
        String query = new String( );

       /*   JAVA 8
        String query = "SELECT * FROM xxx WHERE xxx=? and xxx=?";
        try (
                Connection connDocAdmin = dsDocAdmin.getConnection();
                PreparedStatement pstmListaDoc = connDocAdmin.prepareStatement(query);
        ){*/

        //query = "SELECT valor FROM tablaPrueba WHERE id = ?";

        connDocAdmin = dsDocAdmin.getConnection();

        pstmListaDoc = connDocAdmin.prepareStatement(query);
        pstmListaDoc.setInt(1, id);
        resultSet = pstmListaDoc.executeQuery();
        resultSet.setFetchSize(4000);

        while (resultSet.next()) {
            respuesta = resultSet.getString("valor");
        }

        if (pstmListaDoc != null) { pstmListaDoc.close(); }
        if (connDocAdmin != null) { connDocAdmin.close();}
        if (resultSet != null) { resultSet.close(); }

        return respuesta;
    }
}
