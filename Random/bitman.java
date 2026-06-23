import java.util.Scanner;

public class bitman {

    // // Write a program to find if a number is a power of 2 or not
    // public static boolean isPowerOfTwo(int n) {
    //     if (n <= 0) {
    //         return false;
    //     }
    //     return (n & (n - 1)) == 0;
    // }

    // public static void main(String[] args) {
    //     int num = 8;
    //     if (isPowerOfTwo(num)) {
    //         System.out.println(num + " is a power of 2");
    //     } else {
    //         System.out.println(num + " is not a power of 2");
    //     }
    // }

    // 
    
    // //Write a program to count the number of 1’s in a binary representation of the number
    // public static int countOnes(int n) {
    //     int count = 0;
    //     while (n != 0) {
    //         count += n & 1;
    //         n >>= 1;
    //     }
    //     return count;
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter a number: ");
    //     int num = sc.nextInt();
    //     System.out.println("Number of 1's in binary representation of " + num + ": " + countOnes(num));
    //     sc.close();
    // }

    //Write 2 functions => decimalToBinary() & binaryToDecimal() to convert a number from one number system to another.
     // Decimal → Binary
    public static String decimalToBinary(int n) {
        if (n == 0) return "0";

        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            binary.insert(0, n % 2); // prepend remainder
            n = n / 2;
        }

        return binary.toString();
    }

    // Binary → Decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal * 2 + (binary.charAt(i) - '0');
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter decimal number: ");
        int n = sc.nextInt();
        System.out.println("Binary: " + decimalToBinary(n));

        System.out.print("Enter binary number: ");
        String b = sc.next();
        System.out.println("Decimal: " + binaryToDecimal(b));

        sc.close();
    }
}