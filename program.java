//add 2 numbers in an array and find the second largest and second smallest element in the array
public class program {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int n = arr.length;

        int sS = Solution.secondSmallest(arr, n);
        int sL = Solution.secondLargest(arr, n);

        System.out.println("Second Smallest: " + sS);
        System.out.println("Second Largest: " + sL);
    }
}