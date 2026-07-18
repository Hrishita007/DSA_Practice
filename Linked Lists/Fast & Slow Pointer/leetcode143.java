//Reorder List
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
class leetcode143 {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge the two halves
        ListNode first = head;

        while (second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;        // put second node after first
            second.next = firstNext;    // reconnect remaining first list

            first = firstNext;          // move first pointer
            second = secondNext;        // move second pointer
        }
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        leetcode143 obj = new leetcode143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        obj.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        System.out.print("Reordered List: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}