
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
 
class leetcode237 {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
    public static void main(String[] args) {
        leetcode237 obj = new leetcode237();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Let's say we want to delete the node with value 5
        ListNode nodeToDelete = head.next; // Node with value 5
        obj.deleteNode(nodeToDelete);

        // Print the updated list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

//if head is given
// public ListNode deleteNode(ListNode head, ListNode node) {

//     if (head == node)
//         return head.next;

//     ListNode prev = head;
//     ListNode curr = head.next;

//     while (curr != null) {

//         if (curr == node) {
//             prev.next = curr.next;
//             break;
//         }

//         prev = curr;
//         curr = curr.next;
//     }

//     return head;
// }