package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q937 {

    public static void main(String[] args) {

        // 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
        // 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
        // 3. 문자가 동일할 경우에는 식별자순으로 한다.
        // 4. 숫자 로그는 입력 순서대로 한다.

        // String[] logs = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};
        String[] logs = {"zoey i love you","lucas i love you","rong i love you"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    private static String[] reorderLogFiles(String[] logs) {

        List<String> stringList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        // 1. 문자/숫자 로그 분리
        for(String log : logs) {
            if(log.split(" ")[1].matches("^[0-9]+$")) {
                digitList.add(log);
            } else {
                stringList.add(log);
            }
        }

        // 2. 문자 재정렬 처리
        List<String> list = new ArrayList<>(stringList.stream().sorted((o1, o2) -> {
            String[] o1x = o1.split(" ", 2);
            String[] o2x = o2.split(" ", 2);

            if (o1x[1].compareTo(o2x[1]) == 0) {
                return o1x[0].compareTo(o2x[0]);
            } else {
                return o1x[1].compareTo(o2x[1]);
            }
        }).toList());

        list.addAll(digitList);

        return list.toArray(String[]::new);
    }

}
