package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Q234 {

    public static void main(String[] args) {

        ListNode head = ListNode.of(1, 2, 2, 1);
        System.out.println(isPalindrome(head));

    }

    private static boolean isPalindrome(ListNode head) {
        // 1. Stack을 사용
        ListNode node = head;
        Deque<Integer> stack = new LinkedList<>();

        while(node != null) {
            stack.add(node.val);
            node = node.next;
        }

        while(head != null) {
            if(head.val != stack.pollLast()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    private static boolean isPalindrome2(ListNode head) {
        // 2. Deque 사용
        Deque<Integer> deque = new LinkedList<>();

        ListNode node = head;
        while(node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while(!deque.isEmpty() && deque.size() > 1) {
            if(!Objects.equals(deque.pollFirst(), deque.pollLast())) {
                return false;
            }
        }

        return true;
    }

}
