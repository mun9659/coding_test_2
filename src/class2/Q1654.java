package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        
        // 랜선 자르기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long k = Long.parseLong(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        long n = Long.parseLong(st.nextToken()); // 필요로하는 랜선의 개수

        // 1. 처음엔 값들의 min 값으로 계산(오류)
        // 2. 상한선으로 n의 값을 넘는 최소값 - 1을 구하라!
        long max = 0;
        List<Long> list = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            long len = Long.parseLong(br.readLine());

            max = Math.max(len, max);
            list.add(len);
        }

        long left = 0;
        long right = max++;
        long result = 0;
        while(left < right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(long len : list)
                sum += len / mid;

            System.out.println(left + " | " + right + " | " + mid + " | " + sum);

            // 상한선으로 인한 제거 코드
            // if(sum == n)
            //     result = Math.max(result, mid);

            if(sum < n)
                right = mid;
            else
                left = mid + 1;
        }

        System.out.println(result - 1);
    }
}
