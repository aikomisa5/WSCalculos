package com.besysoft.interfaces;

import com.besysoft.exceptions.CalculosException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WSCalculos {

    @WebMethod
    int getMontoPrestable(@WebParam(name = "edad")int edadCliente,
                          @WebParam(name = "producto")String producto,
                          @WebParam(name = "proceso")String proceso) throws CalculosException;

    @WebMethod
    double getCoeficienteLimiteDeCompra(@WebParam(name = "edad") int edadCliente,
                                        @WebParam(name = "ingresoNeto") BigDecimal ingresoNeto,
                                        @WebParam(name = "proceso") String proceso) throws CalculosException;

}
