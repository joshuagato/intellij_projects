public class Test {

    public static void main(String[] args){

        Account bobsAccount = new Account();
        bobsAccount.withdrawal(100.0);

        System.out.println();

        bobsAccount.deposit(50.0);
        bobsAccount.withdrawal(100.0);

        System.out.println();

        bobsAccount.deposit(120.0);
        bobsAccount.withdrawal(50.0);
    }
}
