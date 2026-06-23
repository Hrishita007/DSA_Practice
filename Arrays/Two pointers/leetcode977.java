class leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int l = 0;
        int r = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[l] * nums[l];
            int rightSquare = nums[r] * nums[r];

            if (leftSquare > rightSquare) {
                res[i] = leftSquare;
                l++;
            } else {
                res[i] = rightSquare;
                r--;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        leetcode977 solution = new leetcode977();

        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = solution.sortedSquares(nums);

        System.out.print("Sorted Squares: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}