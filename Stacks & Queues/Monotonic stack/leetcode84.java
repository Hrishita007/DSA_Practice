// Largest Rectangle in Histogram
// Time: O(n) — each index is pushed and popped at most once.
// Space: O(n) — stack can hold up to n indices.

import java.util.Stack;

class leetcode84 {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && currentHeight < heights[st.peek()]) {

                int height = heights[st.pop()];

                int width;

                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            if (i < heights.length) {
                st.push(i);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        leetcode84 obj = new leetcode84();

        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(obj.largestRectangleArea(heights));
    }
}

