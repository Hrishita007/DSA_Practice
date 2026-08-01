//fibonacci series using recursion
// import java.util.Scanner;

// public class Fibonacci {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the number of terms: ");
//         int n = sc.nextInt();
//         System.out.println("Fibonacci series:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(fibonacci(i) + " ");
//         }
//         //System.out.println(fibonacci(63));
//         //print the nth fibonacci number
//         System.out.print("\nEnter the position of the Fibonacci number to find: ");
//         int p = sc.nextInt();
//         System.out.println("The Fibonacci number at position " + p + " is: " + fibonacci(p));

        

//     }

//     public static int fibonacci(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         return fibonacci(n - 1) + fibonacci(n - 2);
//     }
// }

//fibonacci series using dynamic programming
//time complexity: O(n)
//space complexity: O(n)
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.print("\nEnter the position of the Fibonacci number to find: ");
        int p = sc.nextInt();

        System.out.println("The Fibonacci number at position " + p + " is: " + fibonacci(p));

        sc.close();
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}

