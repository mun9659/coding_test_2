package leetcode;

import leetcode.common.ListNode;

public class Q206 {

    public static void main(String[] args) {
        // 206. Reverse Linked List

        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);

        // System.out.println(reverseList1(head));
        System.out.println(reverseList2(head));
    }

    private static ListNode reverseList1(ListNode head) {
        // 1. 재귀 방법
        return reverse(head, null);
    }

    private static ListNode reverseList2(ListNode head) {
        // 2. 반복 방법
        ListNode prev = null, node = head;
        while(node != null) {

            ListNode next = node.next;

            node.next = prev;

            prev = node;

            node = next;

        }
        return prev;
    }

    private static ListNode reverse(ListNode node, ListNode prev) {
        if(node == null)
            return prev;

        ListNode next = node.next;

        node.next = prev;

        return reverse(next, node);
    }


}
