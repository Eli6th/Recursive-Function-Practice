/*
Heading:

Name: Eli Olcott
Title: Recurisve Function Practice
Purpose: Create methods which result in the outputs wanted by using recursive functions.

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class recurisveFunctionPractice {

  public recurisveFunctionPractice() {
    menu();
  }

  public void menu() {
    Scanner input = new Scanner(System.in);
    int choice = 0;

    do {
      System.out.println("\nWelcome to Eli's Task Program: please select a task or type '-1' to quit:");
      System.out.println("0. Run programming reading data from text filePrint");
      System.out.println("1. Twos");
      System.out.println("2. Power of 3");
      System.out.println("3. Reverse");
      System.out.println("4. Base 5");
      System.out.println("5. Print with commas");
      choice = input.nextInt();
      int num;
      
      if (choice == 0) {
        fileMethod();
      } else if (choice == 1) {
        num = chosenNum(1);
        System.out.print("There is/are " + twos(num) + " factor(s) of 2 in " + num);
      } else if (choice == 2) {
        num = chosenNum(1);
        if (powerOf3(num)) {
          System.out.print(num + " is a power of 3.");
        } else {
          System.out.print(num + " is not a power of 3.");
        }
      } else if (choice == 3) {
        num = chosenNum(1);
        reverse(num);
      } else if (choice == 4) {
        num = chosenNum(2);
        base5(num);
      } else if (choice == 5) {
        num = chosenNum(2);
        printWithCommas(num);
      }
    } while (choice != -1);
    System.out.println("Thank You for using my program.");
  }

  public int chosenNum (int type) {
    Scanner input = new Scanner(System.in);
    int num = 1;
    if (type == 1) {
      do {
        if (num < 1) {
          System.out.println("\nNot within valid range.");
        }
        System.out.print("\nWhat would you like your single positive integer to be? ");
        num = input.nextInt();
      } while (num < 1);
    } else {
      do {
        if (num < 0) {
          System.out.println("\nNot within valid range.");
        }
        System.out.print("\nWhat would you like your single non-negative integer to be? ");
        num = input.nextInt();
      } while (num < 0);
    }
    return num;
  }

  public int twos (int n) {
    if (n % 2 == 1) {
      return 0;
    } else {
      return 1 + twos(n / 2);
    }
  }

  public boolean powerOf3 (int n) {
    if (n % 3 == 0) {
      return powerOf3(n/3);
    } else if (n == 1) {
      return true;
    } else {
      return false;
    }
  }

  public void reverse (int n) {
    if (n < 10) {
      System.out.print(n);
    } else {
      System.out.print(n%10);
      reverse(n / 10);
    }
  }

  public void base5 (int n) {
    if (n < 5) {
      System.out.print(n);
    } else {
      base5(n/5);
      System.out.print(n%5);
    }
  }

  public void printWithCommas (int n) {
    if (n < 1000) {
      System.out.print(n);
    } else {
      printWithCommas(n/1000);
      if (n % 1000 != 0 && n % 1000 >= 100)
        System.out.print("," + n % 1000);
      else if (n % 1000 != 0 && n % 1000 >= 10)
        System.out.print(",0" + n % 1000);
      else if (n % 1000 != 0 && n % 1000 >= 1)
        System.out.print(",00" + n % 1000);
      else
        System.out.print(",000");
    }
  }

  public void fileMethod() {
    String pathname = "Lab3TestData.txt";
    File file = new File(pathname);
    Scanner input = null;
    try 
    {
      input = new Scanner(file);
    } 
    catch (FileNotFoundException ex) 
    {
      System.out.println("*** Cannot open " + pathname + " ***");
      System.exit(1);
    }
    while (input.hasNextInt()) 			// Loop Menu
    {
      switch (input.nextInt()) 
      {
        case 1: 
        {
          System.out.println("Twos Methods " + twos(input.nextInt()));
        }
        break;
        case 2: 
        {
          int num = input.nextInt();
          if(powerOf3(num))
            System.out.print(num + " is a power of 3.\n");
          else
            System.out.print(num + " is not a power of 3.\n");
        }
        break;
        case 3: 
        {
          reverse(input.nextInt());
          System.out.println(" ");
        }
        break;
        case 4: 
        {
          base5(input.nextInt());
          System.out.println(" ");
        }
        break;
        case 5: 
        {
          printWithCommas(input.nextInt());
          System.out.println(" ");
        }
        break;
    
      }
    }
  }
}