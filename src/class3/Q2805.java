package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        long max = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            max = Math.max(max, num);
        }

        long left = 0;
        long right = max;

        while(left < right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int tree : list)
                sum += Math.max(tree - mid, 0);

            if(sum >= m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}
