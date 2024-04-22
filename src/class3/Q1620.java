package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int m = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제의 개수

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String pokemon = br.readLine();

            map1.put(i, pokemon);
            map2.put(pokemon, i);
        }

        for(int i = 0; i < m; i++) {
            String question = br.readLine();

            if(question.chars().allMatch(Character::isDigit)) {
                sb.append(map1.get(Integer.parseInt(question))).append("\n");
            } else {
                sb.append(map2.get(question)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
