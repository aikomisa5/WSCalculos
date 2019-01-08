package com.besysoft.consultas;

import com.besysoft.connections.ConectionPoolClienteUnico;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CalculosService {

    // Variables
    private static final Logger logger = Logger.getLogger("WSCalculos");

    // Constructor
    public CalculosService() {}

    //Metodos
    public static int getMontoPrestable(int edadCliente, String producto, String proceso) throws SQLException{

        int montoPrestable = 0;

        logger.info("Entrando a getMontoPrestable para obtener el monto prestable para el préstamo a través de Datos Cliente Único..");

        DataSource dsDocAdmin = ConectionPoolClienteUnico.getConexionClienteUnico();

        Connection connDocAdmin = null;
        PreparedStatement pstmListaDoc = null;
        ResultSet rsMontoPrestable = null;
        String query = new String( );


         logger.info("A punto de realizar la consulta a la base..");
         logger.info("edadCliente: " + edadCliente);
         logger.info("proceso: " + proceso);


       /*   JAVA 8
        String query = "SELECT * FROM xxx WHERE xxx=? and xxx=?";
        try (
                Connection connDocAdmin = dsDocAdmin.getConnection();
                PreparedStatement pstmListaDoc = connDocAdmin.prepareStatement(query);
        ){*/

        query = "SELECT lm.montoPrestable FROM LimitesMontosPrestables lm INNER JOIN ProductosMontosPrestables pm ON lm.id = pm.id WHERE edadDesde <= ? AND edadHasta >= ? AND pm.producto = ? AND lm.proceso = ?";
        //query = "SELECT montoPrestable FROM LimitesMontosPrestables WHERE edadDesde <= ? AND edadHasta >= ? AND proceso = ?";

        connDocAdmin = dsDocAdmin.getConnection();

        pstmListaDoc = connDocAdmin.prepareStatement(query);
        pstmListaDoc.setInt(1, edadCliente);
        pstmListaDoc.setInt(2, edadCliente);
        pstmListaDoc.setString(3, producto);
        pstmListaDoc.setString(4, proceso);

        rsMontoPrestable = pstmListaDoc.executeQuery();
        rsMontoPrestable.setFetchSize(4000);

        while (rsMontoPrestable.next()) {
            montoPrestable = rsMontoPrestable.getInt("montoPrestable");
        }

        if (pstmListaDoc != null) { pstmListaDoc.close(); }
        if (connDocAdmin != null) { connDocAdmin.close();}
        if (rsMontoPrestable != null) { rsMontoPrestable.close(); }

        logger.info("El monto prestable obtenido es: " + montoPrestable);

        return montoPrestable;
    }

    public static double getCoeficienteLimiteDeCompra(int edadCliente, BigDecimal ingresoNeto, String proceso) throws SQLException{

        double coeficiente = 0;

        logger.info("Entrando a getCoeficienteLimiteDeCompra para obtener el coeficiente para el préstamo a través de Datos Cliente Único..");

        DataSource dsDocAdmin = ConectionPoolClienteUnico.getConexionClienteUnico();

        Connection connDocAdmin = null;
        PreparedStatement pstmListaDoc = null;
        ResultSet rsMontoPrestable = null;
        String query = new String( );


        logger.info("A punto de realizar la consulta a la base..");
        logger.info("edadCliente: " + edadCliente);
        logger.info("ingresoNeto: " + ingresoNeto);
        logger.info("proceso: " + proceso);


       /*   JAVA 8
        String query = "SELECT * FROM xxx WHERE xxx=? and xxx=?";
        try (
                Connection connDocAdmin = dsDocAdmin.getConnection();
                PreparedStatement pstmListaDoc = connDocAdmin.prepareStatement(query);
        ){*/

        query = "SELECT coeficiente FROM CoeficientesLimitesDeCompraTarjetas WHERE ingresoDesde <= ? AND ingresoHasta >= ? AND edadDesde <= ? AND edadHasta >= ? AND proceso = ?";

        connDocAdmin = dsDocAdmin.getConnection();

        pstmListaDoc = connDocAdmin.prepareStatement(query);
        pstmListaDoc.setBigDecimal(1, ingresoNeto);
        pstmListaDoc.setBigDecimal(2, ingresoNeto);
        pstmListaDoc.setInt(3, edadCliente);
        pstmListaDoc.setInt(4, edadCliente);
        pstmListaDoc.setString(5, proceso);

        rsMontoPrestable = pstmListaDoc.executeQuery();
        rsMontoPrestable.setFetchSize(4000);

        while (rsMontoPrestable.next()) {
            coeficiente = rsMontoPrestable.getDouble("coeficiente");
        }


        if (pstmListaDoc != null) { pstmListaDoc.close(); }
        if (connDocAdmin != null) { connDocAdmin.close();}
        if (rsMontoPrestable != null) { rsMontoPrestable.close(); }


        logger.info("El coeficiente obtenido es: " + coeficiente);

        return coeficiente;
    }


}
