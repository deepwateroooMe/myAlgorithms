import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

public class threeSum {
    public static class Solution {
        /**
         * @param numbers : Give an array numbers of n integer
         * @return : Find all unique triplets in the array which gives the sum of zero.
         */
        public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
            int n = numbers.length;
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            HashSet<List<Integer>> set = new HashSet<List<Integer>>();
            Integer [] one = new Integer[3];
            int k = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    k = j + 1;
                    while (k < n - 1 && numbers[i] + numbers[j] + numbers[k] != 0) k++;
                    if (k <= n - 1 && numbers[i] + numbers[j] + numbers[k] == 0) {
                        one[0] = numbers[i];
                        one[1] = numbers[j];
                        one[2] = numbers[k];
                        Arrays.sort(one);
                        set.add(new ArrayList<Integer>(Arrays.asList(one)));
                        k++;
                    }
                }
            }
            for(List<Integer> i : set) 
                res.add(new ArrayList(i));
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> res = result.threeSum(a);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
