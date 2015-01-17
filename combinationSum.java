import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class combinationSum {
    public static class Solution {
        // forgot what I wrote here, believe I missed some situations
        public List<List<Integer>> combinationSum0(int[] candidates, int target) {
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

        // follow my c++ example
        /*
          dfs to find all combination
          var candidates: candidates
          var size: candidate's length
          var start: because I sort candidates first, dfs() just need to start permutate from "start"
          don't need to start from every element. Then prevent duplicate combinations.
          var now: sum of present numbers
          var target: target
          var save: to save the combination of candidates
          var vvi: the final return vector
        */
        public void dfs(int [] candidates, int size, int bgn, int val, int target,
                        List<Integer> one, List<List<Integer>> res) {
            List<Integer> two = new ArrayList<Integer>(one);
            boolean haveit = false;
            if (val == target) {
                for (int i = 0; i < res.size(); i++) { // check if exist already
                    if (res.get(i).size() != two.size()) continue;
                    if (res.get(i).equals(one)) return;
                }
                res.add(two);
                two = new ArrayList<Integer>();
                return;
            }
            for (int i = bgn; i < size; i++) {
                if (val + candidates[i] > target) return;
                two.add(candidates[i]);
                dfs(candidates, size, bgn, val + candidates[i], target, two, res); // use lots of times
                int n = two.size() - 1;
                two.remove(n);
            }
            return;
        }
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> one = new ArrayList<Integer>();
            Arrays.sort(candidates); // to prevent potential duplicates
            dfs(candidates, candidates.length, 0, 0, target, one, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {6, 4, 3, 10, 12};
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");

        List<List<Integer>> res = result.combinationSum(a, 28);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}

/*
Time Limit ExceededMore Details // don't know how to make it faster
Last executed input:	[6,4,3,10,12], 28

 */
