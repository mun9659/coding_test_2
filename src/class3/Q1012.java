package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {

    static StringBuilder sb;

    static int m, n, k;
    static int[][] field;
    static boolean[][] visited;

    static int[] dirX = new int[] {-1, 1, 0, 0};
    static int[] dirY = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new boolean[n][m];

            // 배추 심기
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[y][x]++;
            }

            // DFS 실행
            int count = 0;
            for(int o = 0; o < n; o++) {
                for(int p = 0; p < m; p++) {
                    if(!visited[o][p] && field[o][p] == 1) {
                        dfs(o, p);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int dx = x + dirX[i];
            int dy = y + dirY[i];

            if(rangeCheck(dy, dx) && !visited[dy][dx] && field[dy][dx] == 1) {
                dfs(dy, dx);
            }
        }
    }

    public static boolean rangeCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
