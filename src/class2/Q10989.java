package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {

    // 카운팅 정렬(Counting Sort)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1 ~ 10000까지의 자연수 배열
        int[] nums = new int[10001];

        for(int i = 0; i < n; i++)
            nums[Integer.parseInt(br.readLine())]++;

        for(int i = 1; i < nums.length; i++)
            for(int j = 0; j < nums[i]; j++)
                sb.append(i).append("\n");

        System.out.print(sb);

    }

}
