package leetcode;


import leetcode.common.ListNode;

import java.math.BigInteger;

public class Q2 {

    public static void main(String[] args) {

        // 2. Add Two Numbers
        //  - 역순으로 저장된 열결 리스트의 숫자를 더하라.
        // ListNode l1 = ListNode.of(2, 4, 3);
        // ListNode l2 = ListNode.of(5, 6, 2);
        ListNode l1 = ListNode.of(9);
        ListNode l2 = ListNode.of(1,9,9,9,9,9,9,9,9,9);

        System.out.println(addTwoNumbers2(l1, l2));
    }

    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // ListNode의 최대 길이는 100까지, 즉 100자리가 넘는 숫자가 나오므로 자료형을 사용하기 어려움.
        // BigIntger를 사용하자.

        ListNode head1 = l1, head2 = l2;

        BigInteger b1 = new BigInteger("0");
        BigInteger b2 = new BigInteger("0");

        // l1 분해
        double count = 0;
        while(head1 != null) {
            ListNode next = head1.next;

            int v = head1.val * (int) Math.pow(10.0, count++);

            b1 = b1.add(new BigInteger(String.valueOf(v)));

            head1 = next;
        }

        count = 0;
        while(head2 != null) {
            ListNode next = head2.next;

            int v = head2.val * (int) Math.pow(10.0, count++);

            b2 = b2.add(new BigInteger(String.valueOf(v)));

            head2 = next;
        }

        b1 = b1.add(b2);

        char[] chars = b1.toString().toCharArray();

        /* ★ 역순 리스트 만들기 기억 ★ */
        ListNode prev = null, node = null;
        for(char c : chars) {
            node = new ListNode(Character.getNumericValue(c));

            node.next = prev;
            prev = node;
        }

        return node;
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 전가산기 구현

        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 자릿수의 합(sum), 자리 올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry = 0, remainder;

        // 모든 연결 리스트를 끝까지 순회하고, 자리올림수도 0이 될 때까지 진행
        while(l1 != null || l2 != null || carry != 0) {
            sum = 0;

            // 첫 번째 연결 리스트 합산 및 진행
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // 두 번째 연결 리스트 합산 및 진행
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10;

            // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10;

            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(remainder);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }

        return root.next;
    }

}
