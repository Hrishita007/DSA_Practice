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

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        // Pass 1: Create copy of every node
        Node curr = head;

        while (curr != null) {

            map.put(curr, new Node(curr.val));

            curr = curr.next;
        }

        // Pass 2: Connect next and random pointers
        curr = head;

        while (curr != null) {

            Node copy = map.get(curr);

            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}