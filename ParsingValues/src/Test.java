public class Test {

    public static void main(String[] args){
        String numberAsString = "2018";
        String numberAsString2 = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        double number2 = Double.parseDouble(numberAsString2);
        System.out.println("number = " + number);
        System.out.println("number2 = " + number2);

        numberAsString += 1;
        number += 1;
        number2 += 1;

        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);
        System.out.println("number2 = " + number2);
    }
}
