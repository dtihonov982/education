/* 
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise CheckVowelsDigits: Write a program called CheckVowelsDigits, which prompts the user for a String, counts the number of vowels (a, e, i, o, u, A, E, I, O, U) and digits (0-9) contained in the string, and prints the counts and the percentages (with 2 decimal digits).  For example,

Enter a String: testing12345
Number of vowels: 2 (16.67%)
Number of digits: 5 (41.67%) */

import java.util.Scanner;

class CheckVowelsDigits {
    public static void main(String[] args) {
        System.out.print("Enter a String: ");
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine().toLowerCase();
        int digits = 0;
        int vowels = 0;
        int length = inStr.length();
        char c;
        for (int i = 0; i < length; i++) {
            c = inStr.charAt(i);
            if (c >= '0' && c <= '9') {
                digits++;
            }
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            }
        }
        double vowelsPerc = ((double) vowels / (double) (length)) * 100.0;
        double digitsPerc = ((double) digits / (double) (length)) * 100.0;
        System.out.format("Number of vowels: %d (%.2f%%)%n", vowels, vowelsPerc);
        System.out.format("Number of digits: %d (%.2f%%)%n", digits, digitsPerc);
    }
}