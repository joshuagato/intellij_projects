import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your year of birth: ");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your year name: ");
        String name = scanner.nextLine();

        int age = 2019 - yearOfBirth;
        System.out.println("Your name is " + name + ", and you're " + age + "years old!");

        scanner.close();
    }
}
