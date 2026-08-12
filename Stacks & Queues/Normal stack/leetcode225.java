//Implement Stack using Queue
//time complexity: O(n) for push, O(1) for pop, top and empty
//space complexity: O(n)
import java.util.LinkedList;
import java.util.Queue;
class MyStack {
    Queue<Integer> q=new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        int size=q.size();
        q.add(x);
        for(int i=0;i<size;i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top()); // returns 2
        System.out.println(obj.pop()); // returns 2
        System.out.println(obj.empty()); // returns false
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */