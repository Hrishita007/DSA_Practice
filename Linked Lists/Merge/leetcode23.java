//Merge k sorted lists
//time complexity: O(nlogk) where n is the total number of nodes in all lists and k is the number of lists
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
class leetcode23{

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }


    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {

        if (start == end)
            return lists[start];


        int mid = start + (end - start) / 2;


        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);


        return merge2Lists(left, right);
    }


    private ListNode merge2Lists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;


        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {

                curr.next = l1;
                l1 = l1.next;

            } else {

                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }


        if (l1 != null)
            curr.next = l1;
        else
            curr.next = l2;


        return dummy.next;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {list1, list2, list3};

        leetcode23 solution = new leetcode23();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged linked list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}



// ///Brute force
// class leetcode23 {
//     public ListNode mergeKLists(ListNode[] lists) {

//         ArrayList<Integer> values = new ArrayList<>();

//         // Step 1: Store all values
//         for (ListNode list : lists) {

//             while (list != null) {

//                 values.add(list.val);
//                 list = list.next;
//             }
//         }

//         // Step 2: Sort values
//         Collections.sort(values);


//         // Step 3: Create linked list
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;

//         for (int val : values) {

//             curr.next = new ListNode(val);
//             curr = curr.next;
//         }

//         return dummy.next;
//     }
// }

// //Better
// class Solution {

//     public ListNode mergeKLists(ListNode[] lists) {

//         if (lists.length == 0)
//             return null;


//         ListNode result = null;


//         for (int i = 0; i < lists.length; i++) {

//             result = mergeTwoLists(result, lists[i]);

//         }

//         return result;
//     }


//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;


//         while(l1 != null && l2 != null) {

//             if(l1.val <= l2.val) {

//                 curr.next = l1;
//                 l1 = l1.next;

//             } else {

//                 curr.next = l2;
//                 l2 = l2.next;
//             }

//             curr = curr.next;
//         }


//         if(l1 != null)
//             curr.next = l1;

//         else
//             curr.next = l2;


//         return dummy.next;
//     }
// }
// | Approach                     | Time           | Space        | Interview Level |
// | ---------------------------- | -------------- | ------------ | --------------- |
// | Array + Sort                 | O(N log N)     | O(N)         | Brute force     |
// | Sequential LC21 Merge        | O(kN)          | O(1)         | Better          |
// | Divide & Conquer (your code) | **O(N log k)** | **O(log k)** | Optimal         |
