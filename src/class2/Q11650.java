package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11650 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) 
                    return o1[1] - o2[1];
                else 
                    return o1[0] - o2[0];
            };
        });

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] xy = new int[] {x, y};
            pq.offer(xy);
        }

        while(!pq.isEmpty()) {
            int[] xy = pq.poll();
            sb.append(xy[0]).append(" ").append(xy[1]).append("\n");
        }

        System.out.println(sb);
    }
}
