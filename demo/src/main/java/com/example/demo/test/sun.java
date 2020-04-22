package com.example.demo.test;

public class sun  extends  father {


    @Override
    public void fatherTest() {
        System.out.println("33333");
        super.fatherTest();
    }

    public sun() {

        super();  System.out.println("4444444");

    }


    public static void main(String args[]){
        father  f = new father();
        sun   sun = new sun();

    }
}
