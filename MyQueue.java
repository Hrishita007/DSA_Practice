import java.util.Scanner;
class MyQueue {
    private int capacity;
    private int size;
    private int front;
    private int rear;
    private int[] arr;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int x) {
        // code here
        if(size==capacity){
          System.out.println("Queue is full");
          return;
        }
        rear=(rear+1)%capacity;
        arr[rear]=x;
        size++;
    }

    public void dequeue() {
        // code here
        if(size==0){
          System.out.println("Queue is empty");
          return;
        }
        System.out.println(arr[front]);
        front=(front+1)%capacity;
        size--;
    }

    public void front() {
        // code here
        if(size==0){
          System.out.println("Queue is empty");
          return;
        }
        else
          System.out.println(arr[front]);
        
    }

    public void isEmpty() {
        // code here
        if(size==0)
          System.out.println("true");
        else
          System.out.println("false");
    }

    public void isFull() {
        // code here
        if(size==capacity)
          System.out.println("true");
        else
          System.out.println("false");
    }
}

// ================= DRIVER CODE =================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        MyQueue q = new MyQueue(N);
        
        for (int i = 0; i < Q; i++) {
            String op = sc.next();
            if (op.equals("ENQUEUE")) {
                int x = sc.nextInt();
                q.enqueue(x);
            } else if (op.equals("DEQUEUE")) {
                q.dequeue();
            } else if (op.equals("FRONT")) {
                q.front();
            } else if (op.equals("IS_EMPTY")) {
                q.isEmpty();
            } else if (op.equals("IS_FULL")) {
                q.isFull();
            }
        }
        sc.close();
    }
}
