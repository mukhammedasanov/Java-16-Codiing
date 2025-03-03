package example;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String regexPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String email = null;

        do {
            if (email != null && !email.matches(regexPattern)){
                System.out.print("Invalid email. Please enter a valid email: ");
            }
            email = scanner.nextLine();
        }
        while (!email.matches(regexPattern));


        System.out.println(email);

        System.out.println("_________________________________");

        String text = "Rest is awesome!";
        String regex = "^Java.*";

        if (text.matches(regex)) {
            System.out.println("String starts with 'Java'");
        } else {
            System.out.println("String does not start with 'Java'");
        }

        System.out.println("_______________________________");
        String password = "M2+";
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";

        if (password.matches(regexPassword)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }

        System.out.println("_________________________");
        String date = "2024-11-29";
        String regexDate = "\\d{4}-\\d{2}-\\d{2}";

        if (date.matches(regexDate)) {
            System.out.println("Valid date format");
        } else {
            System.out.println("Invalid date format");
        }

        LocalDate parse = LocalDate.parse(date);
        System.out.println(parse);


    }
}
