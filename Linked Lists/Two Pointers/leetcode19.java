//remove nth node from end of linked list
//time complexity: O(n) where n is the length of the linked list
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
class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        leetcode19 obj = new leetcode19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode updatedList = obj.removeNthFromEnd(head, n);

        // Print the updated list
        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
        }
    }
}


// //using one while loop
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {

//         ListNode dummy = new ListNode(0);
//         dummy.next = head;

//         ListNode slow = dummy;
//         ListNode fast = dummy;

//         int count = 0;

//         while (fast != null) {

//             fast = fast.next;
//             count++;

//             if (count > n + 1) {
//                 slow = slow.next;
//             }
//         }

//         slow.next = slow.next.next;

//         return dummy.next;
//     }
//     public static void main(String[] args) {
//         Solution obj = new Solution();
//         ListNode head = new ListNode(1);
//         head.next = new ListNode(2);
//         head.next.next = new ListNode(3);
//         head.next.next.next = new ListNode(4);
//         head.next.next.next.next = new ListNode(5);

//         int n = 2;
//         ListNode updatedList = obj.removeNthFromEnd(head, n);

//         // Print the updated list
//         while (updatedList != null) {
//             System.out.print(updatedList.val + " ");
//             updatedList = updatedList.next;
//         }
//     }
// }