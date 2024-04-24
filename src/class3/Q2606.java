package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {

    static int n, m, count = 0;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // 바이러스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y]++;
        }

        dfs(1);

        System.out.println(count);
    }

    public static void dfs(int v) {
        visited[v] = true;

        for(int i = 1; i <= n; i++) {
            if(!visited[i] && (arr[v][i] == 1 || arr[i][v] == 1)) {
                count++;
                dfs(i);
            }
        }
    }
}
