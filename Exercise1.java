// Exercises 1-11

public class main {
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        long num = 5;
        String sentence = "I am here to learn algorithms";
        String word = "mood";
        
        // 1.
        checkIfEvenOrOdd(num);
        
        // 2.
        System.out.println(isPrime(num));
        // 3.
        String n = longToString(num);
        System.out.println("Is " + n + " a palindrome? " + isPalindrome(n));
        
        // 4.
        int number = 7;
        System.out.println("Fibonacci series up to "+ number);
        System.out.println(fibRecur(number));
        System.out.println(fibIter(number));
        
    
        // 5.
        System.out.println("Iterative of "+ num +"! is: " +iterFactorial(num));
        System.out.println("Recursive of "+ num +"! is: " +recursiveFactorial(num));
        
        // 6.
        System.out.println("Number of words in the string is " + countWords(sentence));
        
        // 7.
        int arr1 [] = {6, 1, 4, 2, 9, 5, 8, 7, 3};
        bubbleSort(arr1); 
        
        // 8.
        int arr2 [] = {6, 1, 4, 2, 9, 5, 8, 7, 3};
        insertionSort(arr2);
        
        // 9.
        int arr3 [] = {6, 1, 4, 2, 9, 5, 8, 7, 3};
        selectionSort(arr3);
        
        // 10.
        System.out.println("The reverse of " + word + " is " + reverseString(word));
        
        // 11.
        int num1 = -111, num2 = 222;    
        swap(num1, num2);
        
    }
    
// 1.Write a Java program to check if the number is even or odd?
    public static void checkIfEvenOrOdd(long n) {
        if (n%2 == 0)
            System.out.println(n + " is even!");
        else 
            System.out.println(n + " is odd!"); 
    }
    
// 2.Write a Java program to check if the number is prime or not?
    public static boolean isPrime(long n) {
        if(n%2 == 0) return false;
        
        for (int i = 3; i*i < n; i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    
// 3.Write a Java program to check if the number is palindrome or not? eg. 5885 191 313
    public static boolean isPalindrome(String n) {
       
       if(n.length() <= 1) {
           return true;
       }
       else {
            return n.charAt(0) == n.charAt(n.length()-1) && isPalindrome(n.substring(1, n.length()  - 1));
       }
        
    }
    
// 4.Write a Java program to print the Fibonacci series up to a given number? Both iterative and recursive version?
    public static int fibIter(int n){
        if (n <= 1){
            return n;
        }
        else {
            int fib = 1;
            int previous = 1;
            
            for(int i = 2; i < n; i++) {
                int temp = fib;
                fib = fib + previous;
                previous = temp;
            }
            return fib;
        }
    }
    
    public static int fibRecur(int n){
        if(n <= 1) {
            return n;
        }
        else {
            //System.out.printf("%d,",fibRecur(n-1) + fibRecur(n-2));
            return fibRecur(n-1) + fibRecur(n-2);
        }
    }
    
// 5.Write a Java program to find the factorial of a given number? Both iterative and recursive version?
    public static long iterFactorial(long n) {
        long fact = 1;
        for(; n >= 1; n--){
            fact = n * fact;
        }
        return fact;
    }
    
    public static long recursiveFactorial(long n) {       
        if(n == 1) 
            return n; 
        else 
            return n * recursiveFactorial(n-1); 
    }
    
// 6.Write a program in Java which counts the number of words in a given String?
    public static int countWords(String s){
        int wordCount = 0;
        boolean inWord = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') {
                if(inWord == false) {
                    inWord = true;
                    wordCount++;
                }
            }
            else {
                inWord = false;
            }
        }
        return wordCount;
    }

// 7.Write a program in Java to sort an array of integers using Bubble sort algorithm?
    public static void bubbleSort(int a []) {
        
        int j, temp;
        for(int i = a.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++){
                if(a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j +1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.print("The array after bubble sort: ");
        printArray(a);
    }
    
// 8.Write a program in Java to sort an array of integers using Insertion sort algorithm?
    public static void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for(j = i; j > 0 && temp < a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
        System.out.print("The array after insertion sort: ");
        printArray(a);
    }
    
// 9.Write a program in Java to sort an array of integers using Selection sort algorithm?
    public static void selectionSort(int a[]) {
        // {6, 1, 4, 2, 9, 5, 8, 7, 3};
        for(int i =0; i < a.length; i++) {
            int temp= a[i];
            int min = a[i];
            int location = i;
            for (int j = i; j < a.length; j++) { 
                if(a[j] < min) {
                    min = a[j];
                    location = j;
                }
            }
            a[i] = min;
            a[location] = temp;
        }
        
        System.out.print("The array after selection sort: ");
        printArray(a);
        
    }
    
// 10.Write a program in Java to reverse a String without using any API methods and without using String Builder/Buffer?
    public static String reverseString(String s) {
        String rev ="";
        for (int i = s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }
    
// 11.Write Java program to swap 2 numbers without using temporary variables
    public static void swap(int num1 , int num2) {
        
        System.out.println("num1 is "+ num1);
        System.out.println("num2 is "+ num2);
        
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        
        System.out.println("num1 is now "+ num1);
        System.out.println("num2 is now "+ num2);
    }
    

    // Auxillary functions: 
    // For printing arrays
    public static void printArray(int [] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("] \n");
    }
    
    public static void printCharArray(char [] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%c ", arr[i]);
        }
        System.out.print("] \n");
    }
    
    // For converting long to String
    public static String longToString(long n) {
       String original = String.valueOf(n);
       return original;
    }
}
