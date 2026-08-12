//Implement Queue using Stacks
//time complexity: O(n) for push, O(1) for pop, peek and empty
//space complexity: O(n)
import java.util.Stack;

class MyQueue {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> rev=new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {      
        while(!st.isEmpty()){
            rev.push(st.pop());
        }
        rev.push(x);
        while(!rev.isEmpty()){
            st.push(rev.pop());
        }       
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek()); // returns 1
        System.out.println(obj.pop()); // returns 1
        System.out.println(obj.empty()); // returns false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */