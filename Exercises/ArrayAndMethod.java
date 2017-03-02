/*
https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

Exercise (Array and Method)
*/

class ArrayAndMethod {
    
    /* Write a method called printArray(), which takes an int array and print its contents in the form of {a1, a2, ..., an}. Take note that there is no comma after the last element. The method's signature is as follows: 
    public static void printArray(int[] array)*/
    
    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length >= 1) {
            System.out.print(array[array.length - 1]);
        }
        System.out.print("}");
    }
    public static void printArray(double[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length >= 1) {
            System.out.print(array[array.length - 1]);
        }
        System.out.print("}");
    }        
    public static void printArray(float[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length >= 1) {
            System.out.print(array[array.length - 1]);
        }
        System.out.print("}");
    }        
    
    public static void testPrintArray() {
        int[] a1 = {};
        int[] a2 = {27};
        int[] a3 = {100, 101, 102, 103};
        printArray(a1);
        System.out.println();
        printArray(a2);
        System.out.println();
        printArray(a3);
        System.out.println();
        
        double[] ad1 = {};
        double[] ad2 = {3.14};
        double[] ad3 = {1.32, 54.10958, 123.0, 1.001};
        printArray(ad1);
        System.out.println();
        printArray(ad2);
        System.out.println();
        printArray(ad3);
        System.out.println(); 

        float[] af1 = {};
        float[] af2 = {1.3f};
        float[] af3 = {2007.98f, 67f};
        printArray(af1);
        System.out.println();
        printArray(af2);
        System.out.println();
        printArray(af3);
        System.out.println();       
    }
    
    public static String arrayToString(int[] array) {
        if (array == null) 
            return "null";
        
        StringBuilder b = new StringBuilder();
        b.append("{");
        for (int i = 0; i < array.length - 1; i++) {
            b.append(array[i] + ", ");
        }
        if (array.length >= 1) {
            b.append(array[array.length - 1]);
        }
        b.append("}");     
        return b.toString();
    }
    
    public static void testArrayToString() {
        int[] a0 = {};
        int[] a1 = {100};
        int[] a2 = {1, 2, 3, 4};
        System.out.println(arrayToString(a0));
        System.out.println(arrayToString(a1));
        System.out.println(arrayToString(a2));
    }
    
    public static boolean contains(int[] array, int key) {       
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }
    
    public static void testContains() {
        int[] a0 = {};
        int[] a1 = {7};
        int[] a2 = {1, 3, 5, 7, 11};
        boolean res1 = contains(a0, 3);
        boolean res2 = contains(a1, 3);
        boolean res3 = contains(a2, 3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
    
    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static void testSearch() {
        int[] a0 = {};
        int[] a1 = {7};
        int[] a2 = {1, 3, 5, 7, 11};
        int res1 = search(a0, 3);
        int res2 = search(a1, 3);
        int res3 = search(a2, 7);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);  
    }        
    
        
    public static int[] copyOf(int[] array) {
        if (array == null)
            return null;
        
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    
    public static int[] copyOf(int[] array, int newLength) {
        int[] newArray = new int[newLength];
        if (newLength <= array.length) {
            for (int i = 0; i < newLength; i++) {
                newArray[i] = array[i];
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            for (int i = array.length; i < newLength; i++) {
                newArray[i] = 0;
            }
        }
        return newArray;
    }
    
    public static void testCopyOf() {
        int[] a1 = {};
        int[] a2 = {67, 81, 85, 23};
        int[] b1 = copyOf(a2, 2);
        int[] b2 = copyOf(a2, 5);
        int[] b3 = copyOf(a2, 4);
        System.out.println(arrayToString(b1));
        System.out.println(arrayToString(b2));
        System.out.println(arrayToString(b3));
        
    }
    public static void reverse(int[] array) {
        int b;
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            b = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = b;
        }
    }
    private static void testReverseSupport(int[] a) {
        System.out.println(arrayToString(a));
        reverse(a);
        System.out.println(arrayToString(a));
    }
        
    public static void testReverse() {        
        int[] a2 = {};
        int[] a3 = {4};
        int[] a4 = {77,  69, 17, 20, 60};
        int[] a5 = {1, 2, 3, 4};
        testReverseSupport(a2);
        testReverseSupport(a3);
        testReverseSupport(a4);
        testReverseSupport(a5);
    }
        
        
    public static void main(String[] args) {
        testReverse();
    }
}
    
    