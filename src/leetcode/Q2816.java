package leetcode;

import leetcode.common.ListNode;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2816 {

    // 1 -> 8 -> 9 가 주어져 있으면 189 * 2 = 378
    // 출력값을 3 -> 7 -> 8
    // 9 -> 9 -> 9 가 주어져 있으면 999 * 2 = 1998
    // 출력값을 1 -> 9 -> 9 -> 8

    public static void main(String[] args) {
        // ListNode head = ListNode.of(1, 8, 9);
        ListNode head = ListNode.of(9,1,9,5,0,5,1,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9);

        System.out.println(doubleInt2(head));
    }

    public static ListNode doubleInt(ListNode head) {

        // 1. BigInteger로 계산하는 방식
        ListNode result = new ListNode(0);
        ListNode last = result;
        ListNode p;

        StringBuilder sb = new StringBuilder();

        while(head != null) {
            sb.append(head.val);
            head = head.next;
        }

        BigInteger big1 = new BigInteger(sb.toString());

        big1 = big1.multiply(new BigInteger("2"));

        String value = String.valueOf(big1);

        for(int i = 0; i < value.length(); i++) {
            p = new ListNode(value.charAt(i) - '0');
            last.next = p;
            last = last.next;
        }

        return result.next;
    }

    public static ListNode doubleInt2(ListNode head) {

        // 2. 각 노드 값에서 계산하는 방식?
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode left = result;
        ListNode right = head;

        while(right != null) {
            // System.out.println("1 -> " + left + " | \n" + right);
            if(right.val * 2 >= 10) {
                left.val += 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
            // System.out.println("2 -> " + left + " | \n" + right);
        }

        return result.val > 0 ? result : head;
    }

    public static ListNode doubleInt3(ListNode head) {
        
        // 3. stack 사용
        Deque<Integer> stack = new ArrayDeque<>();
        int val = 0;

        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode result = null;
        while(!stack.isEmpty() || val != 0) {
            result = new ListNode(0, result);

            if(!stack.isEmpty()) {
                val += stack.pop() * 2;
            }
            result.val = val % 10;
            val = val / 10;
        }

        return result;
    }

}
