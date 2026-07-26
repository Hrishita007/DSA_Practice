//Copy list with random pointer
//time complexity: O(n)
//space complexity: O(1)
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class leetcode138 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        Node newHead=head.next;
        Node newcurr=newHead;
        while(curr!=null){
            curr.next=newcurr.next;
            curr=curr.next;
            if(curr!=null){
                newcurr.next=curr.next;
                newcurr=newcurr.next;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        leetcode138 obj = new leetcode138();
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.random = head;
        Node copiedList = obj.copyRandomList(head);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Copied List: ");
        printList(copiedList);
    }
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Node val: " + curr.val);
            if (curr.random != null) {
                System.out.print(", Random points to: " + curr.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            curr = curr.next;
        }
    }
}

// //hashmap solution
// //time complexity: O(n)
// //space complexity: O(n)
// import java.util.HashMap;

// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

// class leetcode138 {

//     public Node copyRandomList(Node head) {

//         if (head == null)
//             return null;

//         HashMap<Node, Node> map = new HashMap<>();

//         // Pass 1: Create copy of every node
//         Node curr = head;

//         while (curr != null) {

//             map.put(curr, new Node(curr.val));

//             curr = curr.next;
//         }

//         // Pass 2: Connect next and random pointers
//         curr = head;

//         while (curr != null) {

//             Node copy = map.get(curr);

//             copy.next = map.get(curr.next);

//             copy.random = map.get(curr.random);

//             curr = curr.next;
//         }

//         return map.get(head);
//     }

//     public static void printList(Node head) {

//         Node curr = head;

//         while (curr != null) {

//             System.out.print("Value: " + curr.val);

//             if (curr.random != null)
//                 System.out.print(" Random-> " + curr.random.val);
//             else
//                 System.out.print(" Random-> null");

//             System.out.println();

//             curr = curr.next;
//         }
//     }

//     public static void main(String[] args) {

//         leetcode138 obj = new leetcode138();

//         Node head = new Node(7);
//         head.next = new Node(13);
//         head.next.next = new Node(11);
//         head.next.next.next = new Node(10);
//         head.next.next.next.next = new Node(1);

//         head.random = null;
//         head.next.random = head;
//         head.next.next.random = head.next.next.next.next;
//         head.next.next.next.random = head.next.next;
//         head.next.next.next.next.random = head;

//         Node copied = obj.copyRandomList(head);

//         System.out.println("Original List:");
//         printList(head);

//         System.out.println();

//         System.out.println("Copied List:");
//         printList(copied);
//     }
// }