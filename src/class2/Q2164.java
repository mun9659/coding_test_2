package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {

    public static void main(String[] args) throws IOException {

        // 카드2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++)
            queue.offer(i);

        while(queue.size() != 1) {
            // 1. 제일 위의 있는 카드를 버린다.
            queue.poll();

            // 2. 그 뒤의 제일 위의 있는 카드를 맨 밑으로 옮긴다.
            Integer poll = queue.poll();
            queue.offer(poll);
        }
        System.out.println(queue.poll());
    }
}
