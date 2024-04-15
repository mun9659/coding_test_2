package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Queue<Print> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                Print print = new Print(j, num);

                pq.add(num);
                queue.add(print);
            }

            int count = 1;
            while(!queue.isEmpty()) {
                
                int max = pq.peek();
                Print p = queue.poll();
                
                if(max == p.getImportance()) {

                    if(m == p.getIndex()) {
                        sb.append(count).append("\n");
                        break;
                    }

                    pq.poll();
                    count++;
                } else {
                    queue.add(p);
                }
            }
        }

        System.out.println(sb);
    }

    public static class Print {
        int index;
        int importance;

        public Print(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }

        public int getIndex() {
            return index;
        }

        public int getImportance() {
            return importance;
        }

        @Override
        public String toString() {
            return index + " : " + importance;
        }
    }
}