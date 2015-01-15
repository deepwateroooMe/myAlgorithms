import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class combinationSum {
    public static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            List<Integer> one = new ArrayList<Integer>();
            Map<List<Integer>, Integer> hash = new HashMap<List<Integer>, Integer>();

            for(int i : candidates)
                map.put(i, 1);

            if (map.containsKey(target))
                //list.add(new ArrayList<Integer>(Arrays.asList(target)));
                hash.put(new ArrayList<Integer>(Arrays.asList(target)), 1);
            
            for(int i : candidates) {
                //System.out.println("i: " + i);
                
                for (int j = 1; j <= target/i; j++) { // j = 0, j = 1
                    if ((target - i * j == 0) || map.containsKey(target - i * j)) {
                        int cnt = j;
                        while (cnt > 0) {
                            one.add(i);
                            cnt--;
                        }
                        if (target - i * j != 0)
                            one.add(target - i * j);
                        Collections.sort(one);
                        //System.out.println("one: " + one);
                        hash.put(one, 1);
                        //list.add(one);
                        one = new ArrayList<Integer>();
                    }
                }
            }
            for(List<Integer> key : hash.keySet())
                list.add(key);
            return list;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {7, 2, 3};
        List<List<Integer>> res = result.combinationSum(a, 18);

        System.out.println(res);
    }
}
