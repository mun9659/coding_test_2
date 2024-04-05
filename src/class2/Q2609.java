package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Integer[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        int max = Math.max(arr[0], arr[1]);
        int min = Math.min(arr[0], arr[1]);

        int gcd = getGCD(max, min);

        sb.append(gcd).append("\n").append(max * min / gcd);

        System.out.println(sb);

    }

    public static int getGCD(int max, int min) {

        if(max % min == 0) return min;

        return getGCD(min, max % min);
    }

}
