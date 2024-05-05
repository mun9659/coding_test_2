package leetcode.common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
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
