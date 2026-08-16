//Daily Temperatures
//time complexity: O(n)
//space complexity: O(n)
import java.util.Stack;
class leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); 
        int[] ans=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            while (!st.isEmpty() &&
                temperatures[i] > temperatures[st.peek()]) {

                int previousIndex = st.pop();
                ans[previousIndex] = i - previousIndex;
            }

            st.push(i);a
        }
        return ans;
    }
}