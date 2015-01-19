import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class permuteUnique {
    public static class Solution {
        public void helper(int [] num, boolean [] used, List<Integer> one,
                           List<List<Integer>> res, int cnt) {
            if (one.size() == num.length) {
                res.add(new ArrayList<Integer>(one));
                return;
            }
            for (int i = 0; i < num.length; i++) {
                // !used[i - 1] marks the completion of first 0 done, so ignore second 0
                if (i > 0 && !used[i - 1] && num[i] == num[i - 1]) continue;
                if (!used[i]) {
                    used[i] = true;
                    one.add(num[i]);
                    helper(num, used, one, res, ++cnt);
                    one.remove(one.size() - 1);
                    used[i] = false;
                }
            }
            return;
        }
        
        public List<List<Integer>> permuteUnique(int[] num) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (num == null || num.length == 0) return res;
            boolean [] used = new boolean[num.length];
            //HashSet<List<Integer>> set = new HashSet<List<Integer>>(res);
            //helper(num, used, new ArrayList<Integer>(), set);
            Arrays.sort(num);
            helper(num, used, new ArrayList<Integer>(), res, 1);
            //res.addAll(set);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {1, 1, 2};
        int [] a = {3, 3, 0, 0, 2, 3, 2};
        List<List<Integer>> res = result.permuteUnique(a);
        
        System.out.println(res);
    }
}
/*
  Time Limit ExceededMore Details 
Last executed input:	[3,3,0,0,2,3,2]
*/
