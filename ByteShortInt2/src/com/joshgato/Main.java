package com.joshgato;

public class Main {

    public static void main(String[] args) {
	    byte byteValue = 10;
	    short shortValue = 20;
	    int intValue = 50;

	    long lonTotal = 50000L + 10L * (byteValue + shortValue + intValue);
	    short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));  //with short, you need to do casting

        System.out.println("longTotal = " + lonTotal);
        System.out.println("shortTotal = " + shortTotal);

    }
}
