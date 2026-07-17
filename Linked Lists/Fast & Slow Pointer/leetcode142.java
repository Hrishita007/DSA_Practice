//Linked List Cycle II
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
class leetcode142 {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find meeting point
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // No cycle
        if (fast == null || fast.next == null)
            return null;


        // Step 2: Find entrance
        slow = head;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        leetcode142 obj = new leetcode142();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle

        ListNode cycleStart = obj.detectCycle(head);

        // Print the result
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}