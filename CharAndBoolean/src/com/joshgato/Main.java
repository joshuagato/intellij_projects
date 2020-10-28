package com.joshgato;

public class Main {

    public static void main(String[] args) {
        //width of char is 16 (2 bytes)
        char myChar = 'A';
        char myUnicodeChar = '\u00A9';
        char myUnicodeChar2 = '\u00AE';

        boolean myBoolean = true;
        boolean myBoolean2 = false;

        System.out.println("The Character is: " + myChar);
        System.out.println("Unicode output was: " + myUnicodeChar);
        System.out.println("Unicode2 output was: " + myUnicodeChar2);
    }
}
