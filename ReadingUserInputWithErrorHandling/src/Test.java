import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your year of birth: ");

        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt){
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your year name: ");
            String name = scanner.nextLine();

            int age = 2019 - yearOfBirth;
            if((age >= 0) && (age <= 120)){
                System.out.println("Your name is " + name + ", and you're " + age + " years old!");
            }
            else{
                System.out.println("Invalid year of birth");
            }
        }
        else{
            System.out.println("Unable to parse year of birth!");
        }

        scanner.close();
    }
}
