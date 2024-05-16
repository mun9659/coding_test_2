package leetcode;

import leetcode.common.ListNode;

public class Q21 {
    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1,2,4);
        ListNode list2 = ListNode.of(1,2,3);

        System.out.println(mergeTwoLists(list1, list2));
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode last = head;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null || l2 != null) {
            if(l1 == null) {
                last.next = new ListNode(l2.val);
                last = last.next;
                l2 = l2.next;
            } else if(l2 == null) {
                last.next = new ListNode(l1.val);
                last = last.next;
                l1 = l1.next;
            } else {
                if(l1.val < l2.val) {
                    last.next = new ListNode(l1.val);
                    last = last.next;
                    l1 = l1.next;
                } else {
                    last.next = new ListNode(l2.val);
                    last = last.next;
                    l2 = l2.next;
                }
            }
        }

        return head.next;
    }
}
