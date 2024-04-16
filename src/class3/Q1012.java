package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {

    public static int n, m, k;
    
    public static int[][] field;
    public static boolean[][] check;
    public static int[] dirX = {-1, 1, 0, 0};
    public static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 갯수

            field = new int[n][m];
            check = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[y][x] = 1;
            }

            int result = 0;
            for(int o = 0; o < n; o++) {
                for(int p = 0; p < m; p++) {
                    if(!check[o][p] && field[o][p] == 1) {
                        dfs(o, p);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int y, int x) {
        check[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int dx = x + dirX[i];
            int dy = y + dirY[i];

            if(rangeCheck(dy, dx) && !check[dy][dx] && field[dy][dx] == 1) 
                dfs(dy, dx);
        }
    }

    public static boolean rangeCheck(int y, int x) {
        return (y >= 0 && y < n && x >= 0 && x < m);
    }
}
