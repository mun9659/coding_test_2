package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11651 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(new Comparator<Coordinate>() {
            
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.getY() == o2.getY()) 
                    return o1.getX() - o2.getX();
                else
                    return o1.getY() - o2.getY();
            };
        });

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Coordinate xy = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            pq.offer(xy);
        }

        while(!pq.isEmpty()) {
            Coordinate xy = pq.poll();

            sb.append(xy.getX()).append(" ").append(xy.getY()).append("\n");
        }

        System.out.println(sb);
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        
    }

}
