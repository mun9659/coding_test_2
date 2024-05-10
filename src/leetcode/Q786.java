package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q786 {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;

        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        // PriorityQueue<Fraction> pq = new PriorityQueue<>(new Comparator<Fraction>() {
        //     @Override
        //     public int compare(Fraction o1, Fraction o2) {
        //         return o1.d.compareTo(o2.d);
        //     }
        // });

        // for(int i = 0; i < arr.length; i++) {
        //     for(int j = i + 1; j < arr.length; j++) {
        //         pq.add(new Fraction(arr[i] / (double) arr[j], new int[] {arr[i], arr[j]}));
        //     }
        // }

        // System.out.println(pq);

        // Fraction f = new Fraction();
        // while(k > 0) {
        //     f = pq.poll();
        //     k--;
        // }
        
        // return f.ij;
        
        PriorityQueue<Fraction> pq = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o2.d, o1.d);
        });

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int num = arr[i];
                int den = arr[j];
                double fraction = (double) arr[i] / arr[j];

                if (pq.size() < k) {
                    pq.offer(new Fraction(fraction, new int[] {num, den}));
                } else {
                    System.out.println(num + " | " + den + " | " + fraction + " | " + pq.peek().d);
                    System.out.println("=====================================================");

                    if (pq.peek().d > fraction) {
                        pq.poll();
                        pq.offer(new Fraction(fraction, new int[] {num, den}));
                    }
                }
            }
        }

        return pq.peek().ij;

    }

    public static class Fraction {
        Double d;
        int[] ij;

        public Fraction() {}
        
        public Fraction(Double d, int[] ij) {
            this.d = d;
            this.ij = ij;
        }

        @Override
        public String toString() {
            return d + " | " + Arrays.toString(ij);
        }
    }

}
