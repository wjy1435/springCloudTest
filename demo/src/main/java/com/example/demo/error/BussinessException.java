package com.example.demo.error;

public class BussinessException extends  RuntimeException {

    public BussinessException(){

    }
    public BussinessException(String message){
        super(message);
    }

}
