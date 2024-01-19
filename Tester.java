/**
 * Tester:
 * A Class to show the interface and react to the user's choice.
 */

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Tester tester = new Tester();
        boolean backToMenu = true;
        while (backToMenu) {
            tester.processChoice();
            switch (tester.ifBackToMenu()) {
                case "n", "N" -> {
                    backToMenu = false;
                }
            }
        }

    }

    /**
     * A method to display the menu.
     */

    public static void displayMenu() {

        System.out.println("----------------------------");
        System.out.println("          Welcome!          ");
        System.out.println("----------------------------");
        System.out.println("I. Introduction.");
        System.out.println("C. Calculator.");
        System.out.println("E. Exit.");
        System.out.println("Please choose an option");
    }


    /**
     * A method to let user input a choice and process the input.
     * If there is invalid input, the system will show the warning and let user enter again.
     */
    public void processChoice() {
        String choice;
        Scanner sc = new Scanner(System.in);
        boolean ifValid = false;
        while (!ifValid) {
            displayMenu();
            System.out.print(">> ");
            choice = sc.next();
            switch (choice) {
                case "I", "i" -> {
                    introduction();
                    ifValid = true;
                }
                case "C", "c" -> {
                    calculate();
                    ifValid = true;
                }
                case "E", "e" -> {
                    System.exit(0);
                    ifValid = true;
                }default -> {
                    System.out.println("Invalid Input!");
                    System.out.println("Please try again!");
                }
            }
        }
    }


    /**
     * A method to show the introduction about this RPN calculator.
     */
    public void introduction() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("                                         Introduction                                         ");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("It is an Reverse Polish Notation(RPN) calculator.");
        System.out.println("User can enter a reverse polish notation expression, using the following operators:");
        System.out.println("+ (addition), - (subtraction), * (multiplication), / (division)");
        System.out.println("The expression should be an RPN expression, e.g. \"2,4,+\".");
        System.out.println("If the user give invalid form of input, system will give warning and ask for input again.");
        System.out.println("In the end, the result and the readable equation can be display.");
        System.out.println();
    }

    /**
     * A method to do the calculation by calling the processInput() method in the RPNCalculator Class.
     * The result and the infix equation will be displayed.
     * User can choose if they want to do another calculation.
     */

    public void calculate() {
        boolean ifAnother = true;
        String choice = "";
        Scanner sc = new Scanner(System.in);
        while (ifAnother) {
            boolean ifValid = false;
            RPNCalculator calculator = new RPNCalculator();
            String result = calculator.processInput();
            String[] spilt = result.split(",");
            String equation = spilt[0];
            String num = spilt[1];
            System.out.println("Equation: " + equation);
            System.out.println("Result: " + num);
            System.out.println();
            System.out.println("Do you want to have another calculation? Yes(y) / No(n)");
            while(!ifValid){
                System.out.print(">> ");
                choice = sc.nextLine();
                switch (choice) {
                    case "y", "Y", "n", "N" -> {
                        ifValid = true;
                    }
                    default -> {
                        System.out.println("Invalid Input!");
                        System.out.println("Please try again!");
                    }
                }
            }switch (choice) {
                case "n", "N" -> {
                    ifAnother = false;
                }
            }

        }
    }


    /**
     * A method to process the user's choice about if they want to go back to the menu.
     * If the input is not one of those four valid input ("y", "Y", "n", "N"), the system will give the warning and let user enter again.
     * @return choice A String contain the user's choice.
     */

    public String ifBackToMenu() {
        boolean ifValid = false;
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!ifValid) {
            System.out.println("Do you want to go back to the menu?");
            System.out.println("Choice Yes(y) / No (n)");
            System.out.print(">> ");
            choice = sc.next();
            switch (choice) {
                case "y", "Y", "n", "N" -> {
                    ifValid = true;
                }
                default -> {
                    System.out.println("Invalid Input!");
                    System.out.println("Please try again!");
                }
            }
        }
        return choice;
    }
}
