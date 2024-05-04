package leetcode;

import java.util.List;

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode of(Integer... integers) {
            if(integers == null || integers.length == 0) throw new IllegalArgumentException();

            ListNode head = new ListNode(0);
            ListNode last = head;
            ListNode p;

            for(Integer integer : integers) {
                p = new ListNode(integer);
                last.next = p;
                last = last.next;
            }

            return head.next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val = " + val +
                    ", next = " + next + "}";
        }
    }
}
