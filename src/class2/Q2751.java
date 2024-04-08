package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(!pq.isEmpty())
            sb.append(pq.poll()).append("\n");

        System.out.println(sb);
    }
}
