//queue using linked list
import java.util.Scanner;

class QueueLL {
    // Internal class for linked list node
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Constructor
    public QueueLL() {
        front = null;
        rear = null;
    }

    // Enqueue element at rear
    public void enqueue(int x) {
        //code here
        Node n=new Node(x);
        if(this.rear==null){
          this.front=this.rear=n;
          return;
        }
        this.rear.next=n;
        this.rear=n;
    }

    // Display elements from front to rear
    public void display() {
        //code here
        if(this.front==null){
          System.out.println("Queue is empty");
          return;
        }
        Node temp=this.front;
        while(temp!=null){
          System.out.print(temp.data);
          if(temp.next!=null){
            System.out.print(" ");
          }
          temp=temp.next;
        }
        System.out.println();
    }
}

public class QueueLink{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        QueueLL q = new QueueLL();

        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            if (op[0].equals("ENQUEUE")) {
                int x = Integer.parseInt(op[1]);
                q.enqueue(x);
            } else if (op[0].equals("DISPLAY")) {
                q.display();
            }
        }

        sc.close();
    }
}


// Inferred Question

// Implement a Queue using a Linked List that supports the following operations:

// ENQUEUE x: Insert an element x at the rear of the queue.
// DISPLAY: Print all elements of the queue from front to rear separated by spaces. If the queue is empty, print "Queue is empty".
// Approach
// Create a Node class containing:
// data (stores the value)
// next (pointer to the next node)
// Maintain two pointers:
// front → points to the first element.
// rear → points to the last element.
// Enqueue
// Create a new node with the given value.
// If the queue is empty (rear == null):
// Set both front and rear to the new node.
// Otherwise:
// Link the current rear to the new node.
// Move rear to the new node.
// Display
// If front == null, print "Queue is empty".
// Otherwise, traverse the linked list from front to rear.
// Print each node's value separated by spaces.

// Overall Time Complexity: O(n)
// enqueue() is O(1).
// display() traverses all n elements, so it is O(n).
// Since the most expensive operation is display(), the overall time complexity is O(n).
// Overall Space Complexity: O(n)
// The queue stores n nodes in the linked list.
// Apart from these nodes, only a few pointers (front, rear, temp) are used, which take O(1) extra space.
// Therefore, the overall space complexity is O(n).


// Overall Time Complexity: O(n)
// Overall Space Complexity: O(n)