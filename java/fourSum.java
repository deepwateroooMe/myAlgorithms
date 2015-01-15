import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class fourSum {
    public static class Solution {
        
        // http://java2novice.com/java-collections-and-util/arraylist/sort-comparator/
        class MyComp implements Comparator<List<Integer>>{
             @Override
                public int compare(List<Integer> e1, List<Integer> e2) {
                 int i = 0;
                 while (i < 4) {
                     if (e1.get(i) > e2.get(i))
                         return -1;
                 }
                 return 1;
            }
        }

        public List<List<Integer>> fourSum(int[] num, int target) {
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); // initialize
            List<Integer> one = new ArrayList<Integer>();
            if (num == null || num.length < 4) return result;
            Arrays.sort(num);  // sort array

            for (int i = 0; i < num.length - 3; i++) {
                if (i > 0 && num[i] == num[i-1]) continue;
                
                for (int x = num.length - 1; x >= i + 3 ; x--) {
                    if (x < num.length - 1 && num[x] == num[x+1]) continue;
                    
                    int j = i + 1;
                    int k = x - 1;
                    int sum = target - num[i] - num[x];
                    while (j < k) {
                        if ( j > i + 1 && num[j] == num[j - 1]) {
                            j++;
                            continue;
                        }
                        if (k < x -1 && num[k] == num[k + 1]) {
                            k--;
                            continue;
                        }
                        if (num[j] + num[k] > sum) k--;
                        else if (num[j] + num[k] < sum) j++;
                        else 
                            result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j++], num[k--], num[x])));
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-3, -1, 0, 2, 4, 5};
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = result.fourSum(a, 0);
        
        System.out.println(res);
    }
}
