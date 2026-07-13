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
}