package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    static int n, m, v;
    static StringBuilder sb = new StringBuilder();
    
    static boolean[] visited;
    static int[][] nodes;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작의 정점 번호

        nodes = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[x][y]++;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int v) {
        if(visited[v]) return;

        visited[v] = true;

        sb.append(v).append(" ");

        for(int i = 1; i < nodes[v].length; i++) {
            if(!visited[i] && (nodes[v][i] == 1 || nodes[i][v] == 1)) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        queue.offer(v);
        visited[v] = true;

        sb.append(v).append(" ");

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int i = 1; i < nodes[num].length; i++) {
                if(!visited[i] && (nodes[num][i] == 1 || nodes[i][num] == 1)) {
                    visited[i] = true;
                    queue.offer(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}