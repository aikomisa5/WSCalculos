package com.besysoft.exceptions;

/**
 * Created by mbritos on 04/01/2019.
 */
public class CalculosException extends Exception {

    public CalculosException(String msj){
        super(msj);
    }

    public CalculosException(String msj, Throwable e){
        super(msj,e);
    }

}
