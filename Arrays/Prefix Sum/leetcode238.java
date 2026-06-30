//product of array except self
class leetcode238 {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        leetcode238 p = new leetcode238();
        int[] input = {1, 2, 3, 4};

        int[] result = p.productExceptSelf(input);

        System.out.print("Product except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}