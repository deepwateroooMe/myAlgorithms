import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProfitII {
    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;  
            int result = 0;
            for (int i = 0; i < prices.length-1; i++) 
                result += (prices[i] < prices[i+1]) ? prices[i+1]-prices[i] : 0;
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        int res = result.maxProfit(a);
        
        System.out.println(res);
    }
}
