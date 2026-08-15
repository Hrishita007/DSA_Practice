import java.util.*;

class leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for every element in nums2
        for (int num : nums2) {

            while (!st.isEmpty() && num > st.peek()) {
                map.put(st.pop(), num);
            }

            st.push(num);
        }

        // Remaining elements have no greater element
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        leetcode496 solution = new leetcode496();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}