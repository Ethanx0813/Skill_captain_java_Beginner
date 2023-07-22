package FirstPackage;

import java.util.Scanner;

public class JavaArithmaticCalculator {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the first number: ");
      double num1 = sc.nextDouble();

      System.out.println("Enter the second number: ");
      double num2 = sc.nextDouble();

     char operation = sc.next().charAt(0);

      double result = 0.0;

      switch (operation) {
          case '+':
              result = num1 + num2;
              break;
          case '-':
              result = num1 - num2;
              break;
          case '*':
              result = num1 * num2;
              break;
          case '/':
              if (num2 != 0) {
                  result = num1 / num2;
              } else {
                  System.out.println("Error: Division by zero is not allowed.");
                  return;
              }
              break;
          default:
              System.out.println("Error: Invalid operation.");
              return;
      }

      System.out.println("The result is: " + result);

      sc.close();
  }
}

	
