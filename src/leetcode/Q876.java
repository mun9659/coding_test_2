package leetcode;

import leetcode.common.ListNode;

public class Q876 {

    public static void main(String[] args) {

        ListNode head = ListNode.of(1,2,3,4,5);

        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
