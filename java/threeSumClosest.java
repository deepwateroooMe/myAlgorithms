import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class threeSumClosest {
    public static class Solution {
        public int threeSumClosest(int[] num, int target) {
            if (num == null || num.length < 3) return 0;
            if (num.length == 3) return num[0] + num[1] + num[2];
            
            int result = Integer.MAX_VALUE - 2;
            Arrays.sort(num);  // sort array
            int tmp, j, k;
            for (int i = 0; i < num.length-2; i++) {
                if (i > 0 && num[i] == num[i-1]) continue;
                j = i + 1;
                k = num.length - 1;
                while (j < k) {
                    tmp = num[i] + num[j] + num[k] - target;
                    if (Math.abs(tmp) < Math.abs(result - target)) 
                        result = tmp + target;

                    if (tmp > 0) k--;
                    else if (tmp < 0) j++;
                    else if (tmp == 0) {
                        return target;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-3, -2, -5, 3, -4};
        int res = result.threeSumClosest(a, -1);
        
        System.out.println(res);
    }
}
