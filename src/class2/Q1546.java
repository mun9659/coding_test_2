package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        Integer[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        int max = Arrays.stream(arr).max(Integer::compareTo).orElseThrow();
        double result = 0;

        for(int i = 0; i < n; i++)
            result += (double) arr[i] / max * 100;

        System.out.println(result / n);
    }
}
