package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> list = new LinkedList<>();

        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < list.size() - 2; i++) {
            for(int j = i + 1; j < list.size() - 1; j++) {
                for(int k = j + 1; k < list.size(); k++) {
                    sum = list.get(i) + list.get(j) + list.get(k);

                    if(sum <= m) results.add(sum);
                }
            }
        }

        System.out.println(Collections.max(results));
    }

}
