package leetcode;

import leetcode.common.ListNode;

public class Q237 {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);

        deleteNode(node);
    }

    public static void deleteNode(ListNode node) {
        ListNode head = ListNode.of(4, 5, 1, 9);

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
