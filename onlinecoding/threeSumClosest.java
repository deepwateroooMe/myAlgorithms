import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class threeSumClosest {
    public static class Solution {
        /**
         * @param numbers: Give an array numbers of n integer
         * @param target : An integer
         * @return : return the sum of the three integers, the sum closest target.
         */
        public int threeSumClosest(int[] numbers ,int target) {
            int n = numbers.length;
            int res = Integer.MAX_VALUE;
            int k = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    k = j + 1;
                    while (k <= n - 1) {
                        if (Math.abs(numbers[i] + numbers[j] + numbers[k] - target) < Math.abs(res - target))
                            res = numbers[i] + numbers[j] + numbers[k];
                        k++;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
        int b = 45;
        int res = result.threeSumClosest(a, b);
        System.out.println(res);
    }
}
