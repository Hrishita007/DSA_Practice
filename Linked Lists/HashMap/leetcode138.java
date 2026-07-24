import java.util.HashMap;
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

        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        // Pass 1: Create copy of every node
        Node curr = head;

        while (curr != null) {

            map.put(curr, new Node(curr.val));

            curr = curr.next;
        }

        // Pass 2: Connect next and random pointers
        curr = head;

        while (curr != null) {

            Node copy = map.get(curr);

            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
    public static void main(String[] args) {
        leetcode138 obj = new leetcode138();

        // Create a linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next; // 1's random points to 2
        head.next.random = head; // 2's random points to 1

        Node copiedList = obj.copyRandomList(head);

        // Print the copied list
        Node curr = copiedList;
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