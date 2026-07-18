//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//time complexity: O(n+m) where n and m are the lengths of the two lists
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
class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){

                curr.next = list1;
                list1 = list1.next;

            }else{

                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }
         if(list1 != null)
            curr.next = list1;

        else
            curr.next = list2;

        return dummy.next;
    }
    public static void main(String[] args) {
        leetcode21 obj = new leetcode21();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList = obj.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

// | Approach                     | Time           | Space        | Interview Level |
// | ---------------------------- | -------------- | ------------ | --------------- |
// | Array + Sort                 | O(N log N)     | O(N)         | Brute force     |
// | Sequential LC21 Merge        | O(kN)          | O(1)         | Better          |

