package leetcode;

import java.util.*;

public class Q857 {

    public static void main(String[] args) {
        // int[] quality = {10, 20, 5};
        // int[] wage = {70, 50, 30};
        // int k = 2;
        int[] quality = {3, 1, 10, 10, 1};
        int[] wage = {4, 8, 2, 2, 7};
        int k = 3;

        System.out.println(mincostToHireWorkers(quality, wage, k));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        double qualityTillNow = 0;

        List<Worker> workers = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            workers.add(new Worker(wage[i] / (double) quality[i], quality[i]));
        }

        Collections.sort(workers);

        PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());

        for(Worker worker : workers) {
            double ratio = worker.ratio;
            int qual = worker.quality;

            qualityTillNow += qual;
            highQualityWorkers.add(qual);

            if(highQualityWorkers.size() > k) {
                qualityTillNow -= highQualityWorkers.poll();
            }

            if(highQualityWorkers.size() == k) {
                minCost = Math.min(minCost, qualityTillNow * ratio);
            }
        }

        return minCost;
    }

    private static class Worker implements Comparable<Worker> {
        double ratio;
        int quality;

        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }

        @Override
        public int compareTo(Worker other) {
            return Double.compare(this.ratio, other.ratio);
        }
    }

    // 1. 혼자 하려다가 도무지 생각 대로 안될거 같아서 포기
    // public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    //
    //     // 조건
    //     // 1. 모든 노동자는 wage 배열에 있는 정해진 월급보다 적게 받지 않는다.
    //     int n = quality.length;
    //
    //     double min = Double.MAX_VALUE;
    //     for(int i = 0; i < n; i++) {
    //         double[] wages = new double[n];
    //         boolean[] visited = new boolean[n];
    //
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (j == i) {
    //                 wages[j] = wage[i];
    //             } else {
    //                 double w = wage[i] * ((double) quality[j] / quality[i]);
    //
    //                 if (wage[j] <= w) {
    //                     wages[j] = w;
    //                 } else {
    //                     wages[j] = 99999.0;
    //                     count++;
    //                 }
    //             }
    //         }
    //
    //         if(n - count < k) continue;
    //         // System.out.println(Arrays.toString(wage));
    //         // System.out.println(Arrays.toString(wages));
    //         // System.out.println("===============================");
    //         // min = Math.min(combination(wages, visited, 0, n, k, 0.0), min);
    //
    //
    //     }
    //
    //     return 0.0;
    // }
    //
    // public static double combination(double[] wages, boolean[] visited, int start, int n, int k, double sum) {
    //     if(k == 0) {
    //         return sum;
    //     }
    //
    //     for(int i = start; i < n; i++) {
    //         visited[i] = true;
    //         combination(wages, visited, i + 1, n, k - 1, sum + wages[i]);
    //         visited[i] = false;
    //     }
    //
    //     return sum;
    // }

}
