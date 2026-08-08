//Add two numbers represented by linked lists.
// Each node contains a single digit, and the digits are stored in reverse order. 
// The function returns the sum as a linked list in the same reverse order format.
//time complexity: O(max(m,n)) where m and n are the lengths of the two linked lists.
//space complexity: O(max(m,n)) for the new linked list that stores the result.
import java.util.*;


//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
 public class leetcode2{
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int carry = 0;

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null || l2 != null) {

        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;

        int sum = x + y + carry;

        int digit = sum % 10;
        carry = sum / 10;

        curr.next = new ListNode(digit);
        curr = curr.next;

        if (l1 != null)
            l1 = l1.next;

        if (l2 != null)
            l2 = l2.next;
    }

    if (carry > 0)
        curr.next = new ListNode(carry);

    return dummy.next;
}
public static void main(String[] args) {
    leetcode2 solution = new leetcode2();

    // Create first linked list: 2 -> 4 -> 3
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    // Create second linked list: 5 -> 6 -> 4
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    // Add the two numbers
    ListNode result = solution.addTwoNumbers(l1, l2);

    // Print the result
    System.out.print("Result: ");
    while (result != null) {
        System.out.print(result.val + " ");
        result = result.next;
    }
}