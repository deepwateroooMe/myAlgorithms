import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class threeSum {
    public static class Solution {
        public List<List<Integer>> threeSum(int[] num) {
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            int target = 0;
            
            int sum, j, k;
            for (int i = 0; i < num.length-2; i++) {
                if (i > 0 && num[i] == num[i-1]) continue;
                j = i + 1;
                k = num.length - 1;
                while (j < k) {
                    while (k > num.length - 1 && num[k] == num[k+1]) k--;
                    sum = num[i] + num[j] + num[k];
                    if (sum > 0) k--;
                    else if (sum < 0) j++;
                    else {
                        one.add(num[i]);
                        one.add(num[j]);
                        one.add(num[k]);
                        if (!hash.containsKey(one))
                            hash.put(one, 1);
                        one = new ArrayList<Integer>();
                        j++;
                        k--;
                    }
                }
            }
            for(List<Integer> key : hash.keySet()) 
                result.add(key);
            return result;
        }

        public List<List<Integer>> threeSum0(int[] num) {
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(num);  
            List<Integer> one = new ArrayList<Integer>();
            Map<List<Integer>, Integer> hash = new HashMap<List<Integer>, Integer>();
            int sum, j, k;
            for (int i = 0; i < num.length-2; i++) {
                if (i > 0 && num[i] == num[i-1]) continue;
                j = i + 1;
                k = num.length - 1;
                while (j < k) {
                    while (k > num.length - 1 && num[k] == num[k+1]) k--;
                    sum = num[i] + num[j] + num[k];
                    if (sum > 0) k--;
                    else if (sum < 0) j++;
                    else {
                        one.add(num[i]);
                        one.add(num[j]);
                        one.add(num[k]);
                        if (!hash.containsKey(one))
                            hash.put(one, 1);
                        one = new ArrayList<Integer>();
                        j++;
                        k--;
                    }
                }
            }
            for(List<Integer> key : hash.keySet()) 
                result.add(key);
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-2, 0, 0, 2, 2};
        List<List<Integer>> res;
        res = result.threeSum(a);
        
        System.out.println(res);
    }
}
