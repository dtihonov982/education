/* 
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise (Method): Write a boolean method called isOdd() in a class called OddTest,
 which takes an int as input and returns true if the it is odd. The signature of the method is as follows:

public static boolean isOdd(int number)

Also write the main() method that prompts user for a number, 
and prints "ODD" or "EVEN". You should test for negative input. 
*/

import java.util.Scanner;

class OddTest {
    public static boolean isOdd(int number) {
        if (number % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        
        if (number < 0) {
            System.out.println("Number must be positive");
            System.exit(1);
        }
        
        if (isOdd(number)) {
            System.out.println("ODD");
        } else {
            System.out.println("EVEN");
        }
    }
}