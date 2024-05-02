package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    static int m, n;

    static int[] dirX = {-1, 1, 0, 0}, dirY = {0, 0, -1, 1};
    static int[][] miro, count;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        count = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            miro[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(0, 0);

        System.out.println(count[n - 1][m - 1]);
    }

    public static void bfs(int y, int x) {
        visited[y][x] = true;
        count[y][x] = 1;
        int[] start = {y, x};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int i = 0; i < 4; i++) {
                int dy = poll[0] + dirY[i];
                int dx = poll[1] + dirX[i];

                if(rangeCheck(dy, dx) && !visited[dy][dx] && miro[dy][dx] == 1) {
                    queue.offer(new int[] {dy, dx});
                    visited[dy][dx] = true;
                    count[dy][dx] = count[poll[0]][poll[1]] + 1;
                }

                if(dy == n - 1 && dx == m - 1) break;
            }
        }
    }

    public static boolean rangeCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

}
