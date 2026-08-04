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

public class Main {
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
