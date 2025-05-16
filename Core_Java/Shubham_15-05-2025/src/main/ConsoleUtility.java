package main;

import java.util.Scanner;

public class ConsoleUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Convert Temp");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter value_1");
                    int value1=sc.nextInt();
                    System.out.println("Enter value_2");
                    int value2=sc.nextInt();
                    int addition = value1 + value2;
                    System.out.println("Addition is: " +addition);
                    break;


                case 2:
                    System.out.println("Enter value_1");
                    int subvalue1=sc.nextInt();
                    System.out.println("Enter value_2");
                    int subvalue2=sc.nextInt();
                    int subtraction = subvalue1 - subvalue2;
                    System.out.println("Subtraction is: "+subtraction);
                    break;

                case 3:
                    System.out.println("Enter Temp in celcius");
                    int temperature=sc.nextInt();
                    ConsoleUtility.tempToFarenheit(temperature);
                    break;

                case 4:
                    System.out.println("Enter Principal Amount");
                    double principal = sc.nextDouble();
                    System.out.println("Enter Interest rate");
                    double interestRate = sc.nextDouble();
                    System.out.println("Enter Tenure");
                    int tenure = sc.nextInt();
                    ConsoleUtility.calculateInterest(principal, interestRate, tenure);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static void calculateInterest(double principal, double interestRate, int tenure) {
        double simpleInterest = (principal*interestRate*tenure)/100;
        System.out.println(simpleInterest);
    }

    public static void tempToFarenheit(int temp){
        double farenhiet = (temp*9/5) + 32;
        System.out.println("Temp in farenheit : "+farenhiet);
    }
}
