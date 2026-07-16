//Reverse k nodes in a linked list
//Time Complexity: O(n)
//Space Complexity: O(1)---O(n/k) for recursive stack spacep
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
class leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if k nodes exist
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return head;
            temp = temp.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect recursively
        head.next = reverseKGroup(curr, k);

        return prev;
    }
    public static void main(String[] args) {
        leetcode25 obj = new leetcode25();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode reversedHead = obj.reverseKGroup(head, k);

        // Print reversed linked list
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}