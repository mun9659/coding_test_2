package leetcode;

import java.util.*;

public class Q49 {

    public static void main(String[] args) {

        // 49. Group Anagrams

        String[] strs = {"eat", "tea", "tan", "ate", "ant", "cat"};

        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] s_arr = str.toCharArray();
            Arrays.sort(s_arr);

            String s = Arrays.toString(s_arr);

            List<String> list;
            if(map.containsKey(s)) {
                list = map.get(s);

            } else {
                list = new ArrayList<>();

            }
            list.add(str);
            map.put(s, list);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
            answer.add(entry.getValue());

        return answer;
    }

}
