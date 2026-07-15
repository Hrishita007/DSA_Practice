//Reversed Linked list
//Time Complexity: O(n)
//Space Complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class leetcode206 {
public ListNode reverseList(ListNode head) {

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {

        ListNode next = curr.next; // Save next node

        curr.next = prev;          // Reverse link

        prev = curr;               // Move prev

        curr = next;               // Move curr
    }

    return prev;
    }
    public static void main(String[] args) {
        leetcode206 obj = new leetcode206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedHead = obj.reverseList(head);

        // Print reversed linked list
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}