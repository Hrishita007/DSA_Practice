//Reverse Linked List II
//Time Complexity: O(n) 
//Space Complexity: O(1)
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
class leetcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev=null;
        ListNode cur=head;
        int pos=1;
        if (left == right)
            return head;
        while (pos < left) {
            prev = cur;
            cur = cur.next;
            pos++;
        }
        ListNode leftPrev=prev;
        ListNode revstart=cur;
        while (pos <= right) {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            pos++;
        }
        if (leftPrev != null)
            leftPrev.next = prev;
        else
            head = prev;
        revstart.next=cur;
        return head;
    }
}