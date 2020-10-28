package com.joshgato;

public class Main {

    public static void main(String[] args) {
        //width of int = 32 (4 bytes)
        int myIntValue = 5;

        //width of float = 32 (4 bytes)
        float myFloatValue = 5f / 3f;     //float myFloatValue = 5.25f;

        //width of double = 64 (8 bytes)
        double myDoubleValue = 5d / 3d;     //double myDoubleValue = 5.25d;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);
    }
}
