//Intersection of Two Linked Lists
//time complexity: O(n) where n is the length of the longer list
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

public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Step 1: Find lengths
        int lenA = 0;
        int lenB = 0;

        ListNode p1 = headA;
        ListNode p2 = headB;


        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }


        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }


        // Step 2: Reset pointers
        p1 = headA;
        p2 = headB;


        // Step 3: Move longer list ahead
        if (lenA > lenB) {

            int diff = lenA - lenB;

            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }

        } else {

            int diff = lenB - lenA;

            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }


        // Step 4: Move together until intersection
        while (p1 != p2) {

            p1 = p1.next;
            p2 = p2.next;
        }


        return p1;
    }
}

// //pointer switching method

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         ListNode p1 = headA;
//         ListNode p2 = headB;


//         while (p1 != p2) {

//             if (p1 == null)
//                 p1 = headB;
//             else
//                 p1 = p1.next;


//             if (p2 == null)
//                 p2 = headA;
//             else
//                 p2 = p2.next;
//         }


//         return p1;
//     }
//     public static void main(String[] args) {
//         Solution obj = new Solution();
//         ListNode headA = new ListNode(4);
//         headA.next = new ListNode(1);
//         ListNode intersection = new ListNode(8);
//         intersection.next = new ListNode(4);
//         intersection.next.next = new ListNode(5);
//         headA.next.next = intersection;

//         ListNode headB = new ListNode(5);
//         headB.next = new ListNode(6);
//         headB.next.next = new ListNode(1);
//         headB.next.next.next = intersection;

//         ListNode result = obj.getIntersectionNode(headA, headB);

//         if (result != null) {
//             System.out.println("Intersection at node with value: " + result.val);
//         } else {
//             System.out.println("No intersection.");
//         }
//     }
// }