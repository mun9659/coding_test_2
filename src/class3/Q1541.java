package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = Arrays.stream(st.nextToken().split("\\+")).mapToInt(Integer::parseInt).sum();

        while(st.hasMoreTokens()) {
            String s = st.nextToken();

            int num = Arrays.stream(s.split("\\+")).mapToInt(Integer::parseInt).sum();

            sum -= num;
        }
        System.out.println(sum);
    }
}
