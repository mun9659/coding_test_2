package leetcode;

public class Q5 {

    public static void main(String[] args) {

        // 5. Longest Palindrome Substring
        String s = "cbbd";

        System.out.println(longestPalindrome(s));
    }

    static int left, maxLen;

    private static String longestPalindrome(String s) {
        int len = s.length();

        // 길이가 1인 경우 예외 처리
        if(len < 2) return s;

        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for(int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i + 1); // 2칸짜리 투 포인터
            extendPalindrome(s, i, i + 2); // 3칸짜리 투 포인터
        }

        // 왼쪽과 최대 길이만큼 더한 오른쪽만큼의 문자를 정답으로 리턴
        return s.substring(left, left + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {

        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 펠린드롬인 경우 범위 확장
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if(maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }

    }

    // private static String longestPalindrome(String s) {
    //     // 시간 초과가 뜨는 브루트 포스 방법.
    //     String result = "";
    //
    //     for(int i = 0; i < s.length(); i++) {
    //         for(int j = i + 1; j <= s.length(); j++) {
    //             String ex = s.substring(i, j);
    //
    //             if(palindrome(ex)) {
    //                 result = result.length() < ex.length() ? ex : result;
    //             }
    //         }
    //     }
    //
    //     return result;
    // }
    //
    // private static boolean palindrome(String str) {
    //     StringBuilder sb = new StringBuilder();
    //
    //     String reverse = sb.append(str).reverse().toString();
    //
    //     return reverse.equals(str);
    // }

}
