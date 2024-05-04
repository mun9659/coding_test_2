package leetcode;

import java.util.Arrays;

public class Q881 {

    public static void main(String[] args) {

        // Boats to Save People
        // 투 포인터
        // 최대 두 사람을 태울 수 있는 보트에 최소 보트 수를 구하라.

        // int[] people = {1, 2};
        // int limit = 3;
        int[] people = {1, 1, 2, 3, 4};
        int limit = 4;

        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
}
