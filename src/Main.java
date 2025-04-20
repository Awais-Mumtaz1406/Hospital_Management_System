package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner abc = new Scanner(System.in);

        while (true){
            System.out.println("=======Hospital Management System========");
            System.out.println("1. Add Patient ");
            System.out.println("2. Add Doctor ");
            System.out.println("3. Book Appointment ");
            System.out.println("4. View All Apointment ");
            System.out.println("5. Exit");


            int choice = abc.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Good Bye");
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
