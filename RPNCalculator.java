/**
 * RPNCalculator:
 * A class to process the input and return the result of calculation.
 * This class has two different stack to process Double type data and String type data respectively.
 * This class has methods to process input, check the data type and do the calculation.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RPNCalculator {
    private final Stack<Double> stack;
    private final Stack<String> equation;

    /**
     * Constructor method.
     */
    public RPNCalculator() {
        stack = new Stack<>();
        equation = new Stack<>();
    }

    /**
     * A method to process the user's input.
     * If there is a number, the number will be push into the stack.
     * If there is an operator, there will be two number pop from the stack and do the calculation.
     * Meanwhile, the infix version of the equation will be recorded in the Stack equation.
     *
     * @return A String contains the infix version of the equation and the result of the calculation.
     */

    public String processInput() {
        boolean ifValid;
        boolean ifValidInput = false;
        while (!ifValidInput) {
            stack.clean();
            equation.clean();
            String input = null;
            String infix = null;
            Scanner sc = new Scanner(System.in);
            ifValid = false;
            while (!ifValid) {
                System.out.println("Enter an RPN expression, using commas to separate the values and operators: ");
                System.out.println("Your input should be an RPN expression, e.g. \"2,4,+\". ");
                System.out.print(">> ");
                input = sc.nextLine();
                String[] split = input.split(",");
                if (split.length < 3) {
                    System.out.println("Invalid input!");
                    System.out.println("Please try again");
                } else {
                    ifValid = true;
                    for (String s : split) {
                        if (isDouble(s)) {
                            stack.push(Double.valueOf(s));
                            if (Double.parseDouble(s) < 0) {
                                s = "(" + s + ")";
                            }
                            equation.push(s);
                        } else if (s.equals("+")) {
                            if (stack.size() < 2) {
                                ifValid = false;
                                System.out.println("Invalid input!");
                                System.out.println("Please try again");
                                break;
                            }
                            double firstNum = stack.pop();
                            double secondNum = stack.pop();
                            String firstEqu = equation.pop();
                            String secondEqu = equation.pop();
                            double result = add(firstNum, secondNum);
                            infix = "(" + secondEqu + "+" + firstEqu + ")";
                            equation.push(infix);
                            stack.push(result);
                        } else if (s.equals("-")) {
                            if (stack.size() < 2) {
                                ifValid = false;
                                System.out.println("Invalid input!");
                                System.out.println("Please try again");
                                break;
                            }
                            double firstNum = stack.pop();
                            double secondNum = stack.pop();
                            String firstEqu = equation.pop();
                            String secondEqu = equation.pop();
                            double result = sub(secondNum, firstNum);
                            infix = "(" + secondEqu + "-" + firstEqu + ")";
                            equation.push(infix);
                            stack.push(result);
                        } else if (s.equals("*")) {
                            if (stack.size() < 2) {
                                ifValid = false;
                                System.out.println("Invalid input!");
                                System.out.println("Please try again");
                                break;
                            }
                            double firstNum = stack.pop();
                            double secondNum = stack.pop();
                            String firstEqu = equation.pop();
                            String secondEqu = equation.pop();
                            double result = mul(firstNum, secondNum);
                            infix = "(" + secondEqu + "*" + firstEqu + ")";
                            equation.push(infix);
                            stack.push(result);
                        } else if (s.equals("/")) {
                            if (stack.size() < 2) {
                                ifValid = false;
                                System.out.println("Invalid input!");
                                System.out.println("Please try again");
                                break;
                            }
                            double firstNum = stack.pop();
                            double secondNum = stack.pop();
                            String firstEqu = equation.pop();
                            String secondEqu = equation.pop();
                            if (firstNum == 0) {
                                System.out.println("The divisor cannot be 0!");
                                System.out.println("Please try again!");
                                ifValid = false;
                                break;
                            } else {
                                double result = div(secondNum, firstNum);
                                infix = "(" + secondEqu + "/" + firstEqu + ")";
                                equation.push(infix);
                                stack.push(result);
                            }
                        }
                    }
                }
            }
            if (stack.size() != 1) {
                System.out.println("Invalid input!");
                System.out.println("Please try again!");
            } else {
                ifValidInput = true;
            }
        }
        double result = stack.pop();
        String equ = equation.pop();
        return equ + "=" + result + "," + result;
    }

    /**
     * A method to check if the received String is a double number.
     *
     * @param str The split number.
     * @return A boolean to show if the String is a double number.
     */
    static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * A method to add two decimal numbers and returns the result as a value.
     * Using BigDecimal to avoid inaccurate calculation due to the Java itself.
     *
     * @param d1 The first decimal number to be added.
     * @param d2 The second decimal number to be added.
     * @return The result of the calculation.
     */

    public Double add(double d1, double d2) {
        BigDecimal value1 = new BigDecimal(Double.toString(d1));
        BigDecimal value2 = new BigDecimal(Double.toString(d2));
        return value1.add(value2).doubleValue();
    }

    /**
     * A method to subtract two decimal numbers and returns the result as a value.
     * Using BigDecimal to avoid inaccurate calculation due to the Java itself.
     *
     * @param d1 The first decimal number to be subtracted.
     * @param d2 The second decimal number to be subtracted.
     * @return The result of the calculation.
     */

    public Double sub(double d1, double d2) {
        BigDecimal value1 = new BigDecimal(Double.toString(d1));
        BigDecimal value2 = new BigDecimal(Double.toString(d2));
        return value1.subtract(value2).doubleValue();
    }

    /**
     * A method to multiply two decimal numbers and returns the result as a value.
     * Using BigDecimal to avoid inaccurate calculation due to the Java itself.
     *
     * @param d1 The first decimal number to be multiplied.
     * @param d2 The second decimal number to be multiplied.
     * @return The result of the calculation.
     */

    public Double mul(double d1, double d2) {
        BigDecimal value1 = new BigDecimal(Double.toString(d1));
        BigDecimal value2 = new BigDecimal(Double.toString(d2));
        return value1.multiply(value2).doubleValue();
    }

    /**
     * A method to divide two decimal numbers and returns the result as a value.
     * Using BigDecimal to avoid inaccurate calculation due to the Java itself.
     *
     * @param d1 The first decimal number to be divided.
     * @param d2 The second decimal number to be divided.
     * @return The result of the calculation.
     */

    public Double div(double d1, double d2) {
        BigDecimal value1 = new BigDecimal(Double.toString(d1));
        BigDecimal value2 = new BigDecimal(Double.toString(d2));
        return value1.divide(value2, 2, RoundingMode.HALF_UP).doubleValue();
    }

}

