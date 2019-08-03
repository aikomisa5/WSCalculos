package com.proyecto.britos.implementations;

import com.proyecto.britos.consultas.Service;
import com.proyecto.britos.exceptions.MyException;
import com.proyecto.britos.interfaces.WSTemplate;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import java.sql.SQLException;

@WebService(endpointInterface = "com.proyecto.britos.interfaces.WSTemplate")
public class WSTemplateImpl implements WSTemplate {

    private static final Logger logger = Logger.getLogger("WSTemplate");

     public String getRespuesta(int id) throws MyException {
        String respuesta = "";

         try {
             respuesta = Service.getRespuesta(id);
         }

         catch (SQLException e){

             throw new MyException("ERROR: " + e.getMessage(),e);
         }

         catch (Exception e){
             throw new MyException("ERROR: " + e.getMessage(),e);
         }

        return respuesta;
    }

}
