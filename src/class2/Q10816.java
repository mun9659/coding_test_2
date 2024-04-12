package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        // 숫자 카드 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 배열의 증감을 이용한 방식
        //  - 메모리를 많이 잡아 먹음
        // int[] arr = new int[20000001];

        // int n = Integer.parseInt(br.readLine());
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // for(int i = 0; i < n; i++) 
        //     arr[Integer.parseInt(st.nextToken()) + 10000000]++;

        // int m = Integer.parseInt(br.readLine());

        // st = new StringTokenizer(br.readLine(), " ");
        // for(int i = 0; i < m; i++)
        //     sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");

        // System.out.println(sb);

        // 2. 이분 탐색을 이용한 방식
        //  - 하한선(Lower Bound), 상한선(Upper Bound)을 이용.
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upper_bound(arr, num) - lower_bound(arr, num)).append(" ");
        }

        System.out.println(sb);
    }

    public static int upper_bound(int[] arr, int num) {
        // 찾고자 하는 값 '초과의 값'이 처음으로 나타나는 위치.
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(num < arr[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static int lower_bound(int[] arr, int num) {
        // 찾고자 하는 값 '이상의 값'이 처음으로 나타나는 위치. 
        int left = 0;
        int right = arr.length;   

        while(left < right) {
            int mid = (left + right) / 2;

            if(num <= arr[mid]) 
                right = mid;
            else 
                left = mid + 1;
        }

        return left;
    }
}
