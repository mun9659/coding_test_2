package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Integer[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, Comparator.naturalOrder());

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            // int num = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(nums, Integer.parseInt(st.nextToken()))).append("\n");

            // if(Arrays.binarySearch(nums, num) >= 0)
            //     sb.append(1).append("\n");
            // else
            //     sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(Integer[] nums, int n) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(n > nums[mid])
                left = mid + 1;
            else if(n < nums[mid])
                right = mid - 1;
            else
                return 1;
        }

        return 0;
    }
}
