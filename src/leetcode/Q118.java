package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q118 {

    public static void main(String[] args) throws IOException {

        // 118. Pascal's Triangle

        // Given an integer numRows, return the first numRows of Pascal's triangle.
        //
        // In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numRows = Integer.parseInt(br.readLine());

        System.out.println(generate(numRows));

    }

    private static List<List<Integer>> generate(int numRows) {

        if(numRows == 0) return new ArrayList<>();
        if(numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(List.of(1));
            return result;
        }

        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            newRow.add(1);
        }

        for(int i = 1; i < numRows - 1; i++) {
            newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
        }

        prevRows.add(newRow);

        return prevRows;
    }
}
