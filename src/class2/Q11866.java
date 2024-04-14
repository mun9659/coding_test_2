package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11866 {
    
    public static void main(String[] args) throws IOException {
        // 요세푸스 문제 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1. 단순히 한개씩 따라하기
        // Deque<Integer> deque = new LinkedList<>();

        // for(int i = 1; i <= n; i++)
        //     deque.offer(i);

        // sb.append("<");
        // while(deque.size() != 1) {

        //     // 1-1. k-1만큼 뒤로 돌리기
        //     for(int i = 0; i < k - 1; i++) {
        //         int num = deque.poll();
        //         deque.offer(num);
        //     }

        //     // 1-2. k번째 숫자는 넣기
        //     sb.append(deque.poll()).append(", ");
        // }

        // // 2. 마지막 남은 숫자로 StringBuilder 마무리 짓기
        // sb.append(deque.poll()).append(">");

        // 2. 수학으로 계산하기
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= n; i++)
            list.add(i);

        int index = 0;
        sb.append("<");
        while(list.size() > 1) {
            index = (index + (k - 1)) % list.size();
            sb.append(list.remove(index)).append(", ");
        }
        sb.append(list.remove(0)).append(">");

        System.out.println(sb);
    }
}
