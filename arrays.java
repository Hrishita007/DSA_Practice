
import java.util.*;
public class arrays {
    public static void main(String[] args) {
        // Create an array of integers
        // int[] numbers = {10, 20, 30, 40, 50};

        // // Print the elements of the array
        // System.out.println("Array elements:");
        // for (int number : numbers) {
        //     System.out.println(number);
        // }

        // // Calculate the sum of the array elements
        // int sum = 0;
        // for (int number : numbers) {
        //     sum += number;
        // }
        // System.out.println("Sum of array elements: " + sum);

        // int[] numbers = new int[3];
        // numbers[0] = 5;
        // numbers[1] = 10;    
        // numbers[2] = 15;
        // for (int i = 0; i < 3; i++) {
        //     System.out.println(numbers[i]);
        // }
        // Scanner scanner = new Scanner(System.in);
        // int size=scanner.nextInt();
        // int[] numbers = new int[size];

        // for (int i = 0; i < size; i++) {
        //     System.out.println(numbers[i]);//auto initialized to 0
        // }

        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int[] numbers = new int[size];
        // for (int i = 0; i < size; i++) {
        //     numbers[i] = sc.nextInt();
        // }
        // int key=sc.nextInt();
        // for (int i = 0; i < size; i++) {
        //     if(numbers[i]==key){
        //         System.out.println(i); //display index if key found
        //     }
        // }



    //   Scanner sc = new Scanner(System.in);
    //   int size = sc.nextInt();
    //   int numbers[] = new int[size];


    //   //input
    //   for(int i=0; i<size; i++) {
    //       numbers[i] = sc.nextInt();
    //   }


    //   int max = Integer.MIN_VALUE;
    //   int min = Integer.MAX_VALUE;
     
    //    for(int i=0; i<numbers.length; i++) {
    //        if(numbers[i] < min) {
    //            min = numbers[i];
    //        }
    //        if(numbers[i] > max) {
    //            max = numbers[i];
    //        }
    //      }
    //        System.out.println("Min: " + min
    //           + " Max: " + max
    //        );

    //check if array is sorted in ascending order
    // Scanner sc = new Scanner(System.in);
    //   int size = sc.nextInt();
    //   int numbers[] = new int[size];


    //   //input
    //   for(int i=0; i<size; i++) {
    //       numbers[i] = sc.nextInt();
    //   }


    //   boolean isAscending = true;
     
    //    for(int i=0; i<numbers.length-1; i++) { // NOTICE numbers.length - 1 as termination condition
    //        if(numbers[i] > numbers[i+1]) { // This is the condition for descending order
    //            isAscending = false;
    //        }
    //    }


    //    if(isAscending) {
    //        System.out.println("The array is sorted in ascending order");
    //    } else {
    //        System.out.println("The array is not sorted in ascending order");
    //    }

    //2d array
    Scanner sc = new Scanner(System.in);    
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int numbers[][] = new int[rows][cols];
    //input
    for(int i=0; i<rows; i++) {
        for(int j=0; j<cols; j++) {
            numbers[i][j] = sc.nextInt();
        }
    }
    for(int i=0; i<rows; i++) {
        for(int j=0; j<cols; j++) {
            System.out.print(numbers[i][j] + " ");
        }
        System.out.println();
    }

    }
}



        
    