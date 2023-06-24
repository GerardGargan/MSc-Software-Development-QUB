package exceptions;

import java.util.Scanner;



public class LoopingIntInput {



   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age=0;
        boolean valid = false;
        
        do {
        System.out.println("Enter your age");
        try {
        	
            age = sc.nextInt();
            valid = true;
        }catch(Exception e) {
            System.out.println("Did you type a number (no fractions)");
            System.out.println("Try again");
            sc.nextLine();//clear the scanner
        }
        } while (!valid);
System.out.println("Thanks you are "+age+" years old");
    }



}