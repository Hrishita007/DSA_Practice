package ASSESSMENTS;

// DSA Question — Minimum Transformations for Maximum Subarray Sum

// Problem Statement

// You are given an array Arr of N integers. You are allowed to transform any element of the array by changing its sign in order to achieve the maximum possible sum of a subarray.

// Your task is to find the minimum number of such transformations required to achieve the maximum possible sum of any subarray of Arr.

// Note: The subarray can also be empty.

// Input Format

// First line contains a single integer N, where N is the length of the array Arr.

// Second line contains N space-separated integers representing the array Arr.


// Output Format

// Print the minimal number of transformations required to find the maximum possible sum of a subarray of Arr.

// Constraints

// 1 <= N <= 100
// -10^2 <= Arr[i] <= 10^2

// Example 1

// Input:

// 4
// -2 -5 -3 -4

// Output:

// 0

// Example 2

// Input:

// 3
// 8 -4 7

// Output:

// 1

// Java Answer

import java.util.*;

class Mintrans {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int trans = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                trans++;
            }
        }

        System.out.println(trans);
    }
}

//For 8 -4 7, only -4 needs to be transformed to 4, so the answer is 1.
