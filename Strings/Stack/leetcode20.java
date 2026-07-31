//valid parentheses
//time complexity: O(n)
//space complexity: O(n)
import java.util.*;
class leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[')
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;
                else if(ch==')' && st.peek()=='(')
                    st.pop();
                else if(ch=='}' && st.peek()=='{')
                    st.pop();
                else if(ch==']' && st.peek()=='[')
                    st.pop();
                else 
                    return false;
            } 
        }
        return st.isEmpty();
        
    }
    public static void main(String[] args) {
        leetcode20 obj=new leetcode20();
        String s="()[]{}";
        System.out.println(obj.isValid(s));
    }
}

// //another way
// class leetcode20 {
// public boolean isValid(String s) {
//     Stack<Character> st = new Stack<>();

//     for (char c : s.toCharArray()) {
//         if (c == '(') {
//             st.push(')');
//         } else if (c == '{') {
//             st.push('}');
//         } else if (c == '[') {
//             st.push(']');
//         } else {
//             if (st.isEmpty() || st.pop() != c) {
//                 return false;
//             }
//         }
//     }

//     return st.isEmpty();
//     }
//     public static void main(String[] args){
//         leetcode20 obj=new leetcode20();
//         String s="()[]{}";
//         System.out.println(obj.isValid(s));
//     }
// } 
 