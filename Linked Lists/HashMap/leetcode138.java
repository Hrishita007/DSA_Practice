//Copy list with random pointer
//time complexity: O(n)
//space complexity: O(1)
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class leetcode138 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        Node newHead=head.next;
        Node newcurr=newHead;
        while(curr!=null){
            curr.next=newcurr.next;
            curr=curr.next;
            if(curr!=null){
                newcurr.next=curr.next;
                newcurr=newcurr.next;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        leetcode138 obj = new leetcode138();
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.random = head;
        Node copiedList = obj.copyRandomList(head);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Copied List: ");
        printList(copiedList);
    }
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Node val: " + curr.val);
            if (curr.random != null) {
                System.out.print(", Random points to: " + curr.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            curr = curr.next;
        }
    }
}