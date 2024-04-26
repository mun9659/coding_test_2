package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9375 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                String name = st.nextToken();
                String type=  st.nextToken();

                if(!map.containsKey(type)) {
                    map.putIfAbsent(type, 1);
                } else {
                    map.put(type, map.get(type) + 1);
                }
            }

            int result = 1;
            for(Integer value : map.values()) {
                result *= (value + 1);
            }

            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}
