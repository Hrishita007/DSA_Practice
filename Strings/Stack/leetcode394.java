//decode string
//time complexity: O(n)
//space complexity: O(n)
import java.util.*;
class leetcode394 {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);

                num = 0;
                current = new StringBuilder();
            }

            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }

            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
    public static void main(String[] args) {
        leetcode394 obj=new leetcode394();
        String s="3[a]2[bc]";
        System.out.println(obj.decodeString(s));
    }
}