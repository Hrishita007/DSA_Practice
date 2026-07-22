//remove duplicates from sorted linked list
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
class leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while (curr != null && curr.next != null) {

        if (curr.val == curr.next.val) {

            curr.next = curr.next.next;

        } else {

            curr = curr.next;

        }
        }
        return head;
        
    }
    public static void main(String[] args) {
        leetcode83 obj = new leetcode83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode updatedList = obj.deleteDuplicates(head);

        // Print the updated list
        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
        }
    }
}