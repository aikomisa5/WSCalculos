package com.proyecto.britos.exceptions;

public class MyException extends Exception {

    public MyException(String msj){
        super(msj);
    }

    public MyException(String msj, Throwable e){
        super(msj,e);
    }

}
