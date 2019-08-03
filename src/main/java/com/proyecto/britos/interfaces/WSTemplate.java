package com.proyecto.britos.interfaces;

import com.proyecto.britos.exceptions.MyException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WSTemplate {

    @WebMethod
    String getRespuesta(@WebParam(name = "id")int id) throws MyException;

}
