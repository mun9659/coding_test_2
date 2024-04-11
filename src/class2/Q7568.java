package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            int[] arr = new int[] {weight, height};
            list.add(arr);
        }

        // List<Integer> check = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            int weight1 = list.get(i)[0];
            int height1 = list.get(i)[1];
            int count = 1;

            for(int j = 0; j < list.size(); j++) {
                if(i == j) continue;

                int weight2 = list.get(j)[0];
                int height2 = list.get(j)[1];

                if(weight1 < weight2 && height1 < height2) {
                    count++;
                }

            }
            sb.append(count).append(" ");

            // check.add(count);
        }
        System.out.println(sb);
        // System.out.println(check);
    }
}
