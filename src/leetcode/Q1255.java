package leetcode;

public class Q1255 {

    public static void main(String[] args) {

        // 1255. Maximum Score Words Formed by Letters
        // Given a list of words, list of  single letters (might be repeating) and score of every character.
        //
        // Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
        //
        // It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.

        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(maxScoreWords(words, letters, score));
    }

    private static int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] count = new int[26];
        int[] lettersCount = new int[26];

        for(char c : letters)
            count[c - 'a']++;

        int result = 0;
        result = backtracking(words, score, count, lettersCount, 0, 0, result);

        return result;
    }

    private static int backtracking(String[] words, int[] score, int[] count, int[] lettersCount, int pos, int temp, int result) {
        for(int i = 0; i < 26; i++) {
            if(lettersCount[i] > count[i]) return result;
        }

        result = Math.max(result, temp);

        for(int i = pos; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                lettersCount[c - 'a']++;
                temp += score[c - 'a'];
            }

            result = backtracking(words, score, count, lettersCount, i + 1, temp, result);

            for(char c : words[i].toCharArray()) {
                lettersCount[c - 'a']--;
                temp -= score[c - 'a'];
            }
        }

        return result;
    }

}
