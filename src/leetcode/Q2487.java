package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2487 {

    public static void main(String[] args) {
        ListNode head = ListNode.of(5, 2, 13, 3, 8);

        System.out.println(removeNodes(head));
    }

    public static ListNode removeNodes(ListNode head) {

        ListNode cur = head;

        Deque<ListNode> stack = new ArrayDeque<>();

        while(cur != null) {
            while(!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }

        ListNode next = null;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = next;
            next = cur;
        }

        return cur;
    }

}
