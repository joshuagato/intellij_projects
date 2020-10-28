public class Test {

    public static void main(String[] args){

        int switchValue = 4;

        switch (switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3, or 4, or 5");
                System.out.println("Actual value was " + switchValue);
                break;
            default:
                System.out.println("Value was not 1, 2, or 3, or 4, or 5");
                break;
        }

        System.out.println();
        System.out.println();


        char charValue = 'E';

        switch (charValue){
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C': case 'D': case 'E':
                System.out.println("C, or D,  or E was found");
                System.out.println("Actual value found was " + charValue);
                break;
            default:
                System.out.println("Could not find A, B, C, D, or E");
                break;
        }


        System.out.println();
        System.out.println();

        String month = "January";

        //switch (month.toUpperCase()){
        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure!");
        }


    }
}
