import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class candy {
    public static class Solution {
        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            if (ratings.length == 1) return 1;
            int n = ratings.length;
            int [] res = new int[n];
            for (int i = 0; i < n; i++) 
                res[i] = 1;

            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    res[i] = res[i - 1] + 1;
            }
            for (int i = n - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i])
                    res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
            int result = 0;
            for (int i : res) 
                result += i;
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {1, 2, 3, 4, 5, 3, 2, 1, 2, 3, 5, 4, 3, 2, 1, 1, 1, 2, 1, 1};
        int [] a = {2, 3, 2};
        int res = result.candy(a);
        
        System.out.println(res);
    }
}
