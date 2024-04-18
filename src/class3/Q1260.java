package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    static int n, m, v;
    static StringBuilder sb;

    static int[][] nodes;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        // DFS와 BFS
        // DFS: 깊이 우선 탐색
        // BFS: 너비 우선 탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점의 번호

        nodes = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[x][y]++;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1]; // 방문 숫자 초기화
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int v) {
        visited[v] = true;

        sb.append(v).append(" ");
        
        for(int i = 0; i < n + 1; i++) {
            if(!visited[i] && (nodes[v][i] == 1 || nodes[i][v] == 1)) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        queue.add(v);

        visited[v] = true;

        sb.append(v).append(" ");

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int i = 0; i < n + 1; i++) {
                if(!visited[i] && (nodes[num][i] == 1 || nodes[i][num] == 1)) {
                    visited[i] = true;
                    queue.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}