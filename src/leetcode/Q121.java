package leetcode;

public class Q121 {

    public static void main(String[] args) {

        // 121. Best Time to Buy and Sell Stock
        //  - 한 번의 거래로 낼수 있는 최대 이익을 산출하라.
        int[] prices = {8, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        // 1. 저점과 현재 값과의 차이 계산
        // 최대 이익은 0, 저점은 임시로 첫 번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];

        // 현재 값을 우측으로 차례대로 이동하면서 계산
        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            // 현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

}
