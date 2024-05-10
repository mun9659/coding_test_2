package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2000 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String word = st.nextToken();
        char ch = st.nextToken().charAt(0);

        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        if(!word.contains(String.valueOf(ch))) {
            return word;
        }
        
        int index = word.indexOf(String.valueOf(ch));

        String value1 = word.substring(0, index + 1);
        String value2 = word.substring(index + 1, word.length());

        StringBuilder sb = new StringBuilder(value1);

        return sb.reverse().toString() + value2;
    }
}
