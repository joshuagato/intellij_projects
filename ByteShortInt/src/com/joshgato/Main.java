package com.joshgato;

public class Main {

    public static void main(String[] args) {
        //integer has a width of 32
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myNewIntValue = (myMinValue/2);
        System.out.println("myNewIntValue = " + myNewIntValue);

        //byte gas a width of 8
        byte myMinByteValue = -128;
        byte myMaxByteValye = 127;
        byte myNewByteValue = (byte) (myMinByteValue/2);
        System.out.println("myNewByteValue = " + myNewByteValue);

        //short has a width of 16
        short myMinShortValue = -32768;
        short myMaxShortValue = 32767;
        short myNewShortValue = (short) (myMinShortValue/2);
        System.out.println("myNewShortValue = " + myNewShortValue);

        //long gas a width of 64
        long myMinLongValue = 100L;
        long myMinLongValue2 = -9_223_372_036_854_775_808L;
        long myMaxLongValue = 100L;
        long myMaxLongValue2 = 9_223_372_036_854_775_807L;


    }
}
