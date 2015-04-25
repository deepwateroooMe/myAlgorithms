import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class productExcludeItself {
    public static class Solution {
        /**
         * @param A: Given an integers array A
         * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
         */
        public ArrayList<Long> productExcludeItself(ArrayList<Integer> a) {
            int n = a.size();
            ArrayList<Long> res = new ArrayList<Long>(n);
            if (n == 1) return res;
            long bgn = 1, end = 1;
            for (int i = 0; i < n; i++) {
                bgn = 1; end = 1;
                for (int j = 0; j < i; j++) 
                    bgn *= a.get(j);
                for (int k = i + 1; k < n; k++) 
                    end *= a.get(k);
                res.add(bgn * end);
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {1, 2,3};
        ArrayList<Long> res = result.productExcludeItself(new ArrayList<Integer>(Arrays.asList(a)));
        System.out.println(res);
    }
}
