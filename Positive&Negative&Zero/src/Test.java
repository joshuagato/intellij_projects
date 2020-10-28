public class Test {

    public static void main(String[] args){

        checkNumber(0);

    }

    public static void checkNumber(int param){
        if(param > 0){
            System.out.println(param + " is a positive integer!");
        }
        else if (param < 0){
            System.out.println(param + " is a negative integer!");
        }
        else{
            System.out.println(param + " is Zero!");
        }
    }
}
