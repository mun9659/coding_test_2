package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Q1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(br.readLine(), 1);

        for(int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.replace(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        List<String> results = new ArrayList<>();
        for(Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1)
                results.add(entry.getKey());
        }

        results.sort(Comparator.naturalOrder());

        sb.append(results.size()).append("\n");

        for(String result : results) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
