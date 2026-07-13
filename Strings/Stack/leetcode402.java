//remove k digits from the number to make it the smallest possible
//time complexity: O(n)
//space complexity: O(n)
import java.util.*;
class leetcode402 {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {

            while (!stack.isEmpty() &&
                   k > 0 &&
                   ch < stack.peek()) {

                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the answer
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Edge case: everything removed
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        leetcode402 obj=new leetcode402();
        String num="1432219";
        int k=3;
        System.out.println(obj.removeKdigits(num,k));
    }
}

// Example usage
// Input: num = "1432219", k = 3    
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Input: num = "10200", k = 1
// Output: "200"