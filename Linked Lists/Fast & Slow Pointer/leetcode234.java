//Palindrome Linked List
//time complexity: O(n) 
//space complexity: O(1)
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
class leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode secondHalf = reverse(slow);
        ListNode first = head;
        ListNode second = secondHalf;
        while(second != null){

            if(first.val != second.val)
                return false;

        first = first.next;
        second = second.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
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
        leetcode234 obj = new leetcode234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean isPalindrome = obj.isPalindrome(head);

        // Print the result
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}

//edge case: 1->2->3->2->1
// class Solution {
//     public boolean isPalindrome(ListNode head) {

//         if (head == null || head.next == null)
//             return true;

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast.next != null && fast.next.next != null) {

//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode secondHalf = reverse(slow.next);

//         ListNode first = head;
//         ListNode second = secondHalf;

//         while (second != null) {

//             if (first.val != second.val)
//                 return false;

//             first = first.next;
//             second = second.next;
//         }

//         return true;
//     }


//     private ListNode reverse(ListNode head) {

//         ListNode prev = null;
//         ListNode curr = head;

//         while (curr != null) {

//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev;
//     }
// }