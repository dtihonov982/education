/*
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise GradesHistogram (Method): Write a program called GradesHistogram, 
which reads in n grades (as in the previous exercise), and displays the horizontal and vertical histograms. 
*/
import java.util.Random;

public class GradesHistogram {
    //Возвращает подпись для столбца гистограммы
    private static String getLabel(int binNum) {
        String format = "%2d -%3d";
        if (binNum == 9)
            return String.format(format, 90, 100);
        return String.format(format, binNum * 10, binNum * 10 + 9);
    }
    
    //Возвращает массив случайных чисел. Диапазон 0..100, количество count.
    public static int[] getRandomGrades(int count) {
        int[] grades = new int[count];
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            grades[i] = rand.nextInt(101);
        }
        return grades;
    }
    
    //Возвращает данные для построения гистограммы
    public static int[] getBins(int[] grades) {
        int binsCount = 10;
        int[] bins = new int[binsCount];
        for (int i = 0; i < binsCount; i++) {
            bins[i] = 0;
        }
        
        for (int grade: grades) {
            if (grade != 100) {
                bins[grade / binsCount] += 1;
            } else {
                bins[binsCount - 1] += 1;
            }
        }
        
        return bins;
    }
    //Выводит горизонтальную гистограмму
    public static void printHorizontalHistogram(int[] bins) {
        for (int binNum = 0; binNum < bins.length; binNum++) {
            System.out.print(getLabel(binNum) + ": ");
            for (int starNum = 0; starNum < bins[binNum]; starNum++) {
                System.out.print("*");
            }
            System.out.println();
        }
    } 
    //Выводит вертикальную гистограмму
    public static void printVerticalHistogram(int[] bins) {
        String star = "   *    ";
        String blank = "        ";
        for (int level = GradesStatistics.max(bins); level >= 1; level--) {
            for (int binNum = 0; binNum < bins.length; binNum++) {
                if (bins[binNum] >= level) {
                    System.out.print(star);
                } else {
                    System.out.print(blank);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < bins.length; i++) {
            System.out.print(getLabel(i) + " ");
        }
    }
                
        
    public static void main(String[] args) {
        int[] grades = getRandomGrades(50);
        ArrayAndMethod.printArray(grades);
        System.out.println();
        int[] bins = getBins(grades);
        ArrayAndMethod.printArray(bins);
        System.out.println();
        printHorizontalHistogram(bins);
        printVerticalHistogram(bins);
    }
}
                
                