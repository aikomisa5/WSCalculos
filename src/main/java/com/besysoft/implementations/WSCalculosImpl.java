package com.besysoft.implementations;

import com.besysoft.consultas.CalculosService;
import com.besysoft.exceptions.CalculosException;
import com.besysoft.interfaces.WSCalculos;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebService(endpointInterface = "com.besysoft.interfaces.WSCalculos")
public class WSCalculosImpl implements WSCalculos {

    private static final Logger logger = Logger.getLogger("WSCalculos");

     public int getMontoPrestable(int edad, String producto, String proceso) throws CalculosException {
        int montoPrestable = 0;

         try {

             montoPrestable = CalculosService.getMontoPrestable(edad, producto, proceso);

         }

         catch (SQLException e){

             logger.error("ERROR en getMontoPrestable(): " ,e);
             throw new CalculosException("ERROR en getMontoPrestable(): " + e.getMessage(),e);

         }

         catch (Exception e){

             logger.error("ERROR en getMontoPrestable(): " ,e);
             throw new CalculosException("ERROR en getMontoPrestable(): " + e.getMessage(),e);

         }

        return montoPrestable;
    }

    public double getCoeficienteLimiteDeCompra(int edadCliente, BigDecimal ingresoNeto, String proceso) throws CalculosException {
        double coeficiente = 0;

        try{
            coeficiente = CalculosService.getCoeficienteLimiteDeCompra(edadCliente,ingresoNeto,proceso);
        }
        catch (SQLException e){

            logger.error("ERROR en getCoeficienteLimiteDeCompra(): " ,e);
            throw new CalculosException("ERROR en getCoeficienteLimiteDeCompra(): " ,e);
        }

        return coeficiente;
    }


}
