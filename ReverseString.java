/* 
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise ReverseString: Write a program called ReverseString, which 
prompts user for a String, and prints the reverse of the String. The output shall look like:

Enter a String: abcdef
The reverse of the String "abcdef" is "fedcba". 
*/

import java.util.Scanner;

class ReverseString {
    public static String recReverse(String str) {
        int length = str.length();
        if (length < 2) {
            return str;
        } else {
            //Вернуть последний символ + остальные символы в обратном порядке
            return 
                str.charAt(length - 1) +
                recReverse(str.substring(0, length - 1));
        }
    }
    public static String reverse(String str) {
        //Создается массив размером равным строке и заполняется из строки в обратном порядке.
        char[] revChars = new char[str.length()];
        int j = 0;
        for (int i = str.length() - 1; i >= 0; --i) {
            revChars[j] = str.charAt(i);
            j++;
        }
        return new String(revChars);           
    }
    
    public static void main(String[] args) {
        System.out.print("Enter a String: ");
        Scanner s = new Scanner(System.in);
        String inStr = s.nextLine();

        System.out.format("The reverse of the String \"%s\" is \"%s\"%n", inStr, reverse(inStr));
        System.out.format("The recursive reverse of the String \"%s\" is \"%s\"%n", inStr, recReverse(inStr));
    }
}