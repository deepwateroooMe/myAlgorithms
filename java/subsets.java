import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Collections;

public class subsets {
    public static class Solution {
        public List<List<Integer>> subsets(int[] s) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (s == null || s.length == 0) return res;
            List<Integer> one = new ArrayList<Integer>();
            int n = (int)Math.pow(2.0, s.length);
            int idx = 0;
            // sort array first so that in increasing order
            Arrays.sort(s);   // this one doesn't COMPLETELY work, because of int bitmaps Collections.sort(Intervals)
            for (int i = 0; i < n; i++) {
                int val = i;
                idx = 0;
                while (val > 0) {
                    if ((val & 1) == 1) 
                        one.add(s[idx]);
                    ++idx;
                    val = (val >>> 1);
                }
                res.add(one);
                one = new ArrayList<Integer>();
            }
        Collections.sort(res, new Comparator<List<Integer>>() {
                // 1 -1 0 : ???
                    @Override
                        public int compare(List<Integer> a, List<Integer> b) {
                        if (a.size() < b.size()) return -1;
                        else if (a.size() > b.size()) return 1;
                        else { // if (a.size() == b.size()) {
                            for (int i = 0; i < a.size(); i++) 
                                if (a.get(i) < b.get(i))
                                    return -1;
                                else continue;
                            return 1;
                        }
                    }
                });
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {4, 1, 0};
        List<List<Integer>> res = result.subsets(a);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
/*
Input:	[4,1,0]
Output:	[[],[0],[1],[4],[1,0],[4,0],[4,1],[4,1,0]]
Expected:	[[],[0],[1],[4],[0,1],[0,4],[1,4],[0,1,4]]

  Input:	[4,1,0]
Output:	[[],[4],[1],[4,1],[0],[4,0],[1,0],[4,1,0]]
Expected:	[[],[0],[1],[4],[0,1],[0,4],[1,4],[0,1,4]]
 */
