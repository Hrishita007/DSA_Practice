import java.util.Scanner;

public class pgm1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
// class Prime {
//     public static void main(String[] args) {
//         int num = 7;   // change the number here
//         int count = 0;

//         for (int i = 1; i <= num; i++) {
//             if (num % i == 0) {
//                 count++;
//             }
//         }

//         if (count == 2) {
//             System.out.println("Prime number");
//         } else {
//             System.out.println("Not a prime number");
//         }
//     }
// }

// import java.util.Scanner;

// public class PowerFunction {

//     static int power(int x, int n) {
//         int result = 1;

//         for (int i = 1; i <= n; i++) {
//             result = result * x;
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter x: ");
//         int x = sc.nextInt();

//         System.out.print("Enter n: ");
//         int n = sc.nextInt();

//         int value = power(x, n);

//         System.out.println(x + " raised to the power " + n + " is: " + value);

//         sc.close();
//     }
// }
