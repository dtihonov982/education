/* 
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise GradesStatistics (Method): Write a program called GradesStatistics, which reads in n grades (of int between 0 and 100, inclusive) and displays the average, minimum, maximum, median and standard deviation. Display the floating-point values upto 2 decimal places.  Your output shall look like:

Enter the number of students: 4
Enter the grade for student 1: 50
Enter the grade for student 2: 51
Enter the grade for student 3: 56
Enter the grade for student 4: 53
{50,51,56,53}
The average is: 52.50
The median is: 52.00
The minimum is: 50
The maximum is: 56
The standard deviation is: 2.29 
*/

import java.util.Scanner;
import java.util.Arrays;

class GradesStatistics {
    public static int[] grades;
    public static void readGrades() {
        System.out.print("Enter the number of students: ");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        grades = new int[count];
        int grade;
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.format("Enter the grade for student %d: ", i + 1);
                grade = in.nextInt();
                if (grade >= 0 && grade <= 100) {
                    grades[i] = grade;
                    break;
                } else {
                    System.out.println("Invalid grade, try again...");
                }
            }
        }    
    }
    public static double average(int[] array) {
        double sum = 0.0;
        for (int n: array) {
            sum += (double) n;
        }
        double length = (double) array.length;
        return sum / length;
    }
    public static double median(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        if (OddTest.isOdd(len)) {
            return (double) array[len / 2];
        } else {
            return (double) (array[len / 2] + array[len / 2 - 1]) / 2.0;
        }
    }
    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static double stdDev(int[] array) {
        double auxSum = 0;
        double average = average(array);
        for (int x: array) {
            auxSum += Math.pow((double) x - average, 2);
        }
        double N = (double) array.length;
        double result = Math.sqrt(auxSum / N);
        return result;
    }
    
    public static void main(String[] args) {
        readGrades();
        ArrayAndMethod.printArray(grades);
        System.out.println();
        System.out.format("The average is: %.2f%n", average(grades));
        System.out.format("The median is: %.2f%n", median(grades));
        System.out.format("The minimum is: %d%n", min(grades));
        System.out.format("The maximum is: %d%n", max(grades));
        System.out.format("The standart deviation is: %.2f%n", stdDev(grades));
    }
    
}