import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class sortArray {
    public static class Solution {

        // public int[] sortArrayByParityII(int[] nums) { // time limit
        //     int n = nums.length;
        //     int i = 0;
        //     int j = n - 1;
        //     int tmp = 0;
        //     int p = 0;
        //     int q = 0;

        //     System.out.println("i: " + i);
        //     System.out.println("j: " + j);
            
        //     while (j >= 0 && i < n && i <= j - 1) {

        //          System.out.println("i: " + i);
        //          System.out.println("j: " + j);
                
        //         while (i < n && ((i % 2 == 0 && nums[i] % 2 == 0)
        //                          || (i % 2 == 1 && nums[i] % 2 == 1)))
        //         i++;
        //         if (i == n) return nums;
                
        //         while (j >= 0 && ((j % 2 == 0 && nums[j] % 2 == 0)
        //                           || (j % 2 == 1 && nums[j] % 2 == 1)))
        //         j--;
        //         if (j < 0) return nums;

        //         System.out.println("i 1:  " + i);
        //         System.out.println("j 1:  " + j);


        //         if (i < j && i % 2 != j % 2) {
        //             tmp = nums[i];
        //             nums[i++] = nums[j];
        //             nums[j--] = tmp;
        //         } else if (i <= j - 1) {
        //             p = i + 1;
        //             while (p < n && ((p % 2 == 0 && nums[p] % 2 == 0)
        //                              || (p % 2 == 1 && nums[p] % 2 == 1)))
        //             p++;
        //             if (p % 2 != i % 2) {
        //                 tmp = nums[i];
        //                 nums[i] = nums[p];
        //                 nums[p] = tmp;
        //                 i = p + 1;
        //             } else {
        //                 q = j - 1;
        //                 while (q >= 0 && ((q % 2 == 0 && nums[q] % 2 == 0)
        //                                   || (q % 2 == 1 && nums[q] % 2 == 1)))
        //                 q--;
        //                 if (q % 2 != j % 2) {
        //                     tmp = nums[j];
        //                     nums[j] = nums[q];
        //                     nums[q] = tmp;
        //                     j = q - 1;
        //                 }
        //             }
        //         }
        //          System.out.println("i 2:  " + i);
        //          System.out.println("j 2:  " + j);
        //     }
        //     return nums;
        // }

        public int[] frequencySort(int[] nums) {
            if (nums.length == 1) return nums;
            HashMap<Integer, Integer> m = new HashMap<>();
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!m.containsKey(nums[i])) {
                    m.put(nums[i], 1);
                } else {
                    tmp = m.get(nums[i]);
                    m.put(nums[i], tmp + 1);
                }
            }
            int [] res = new int [nums.length];
            int idx = 0;

            HashSet<Integer> ll = new HashSet<Integer>(m.values());
            Integer [] frequency = ll.toArray(new Integer[0]);
            Arrays.sort(frequency);
            int x = 0;
            idx = 0;
            int cnt = 0;
            List<Integer> l = new ArrayList<Integer>();

            while (x < ll.size()) {
                l = new ArrayList<Integer>();
                for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                    cnt = 0;
                    if (entry.getValue() == frequency[x]) {
                        l.add(entry.getKey());
                    }
                }
                if (l.size() == 1) {
                    if (frequency[x] > 1) {
                        while (idx < nums.length && cnt < frequency[x]) {
                            res[idx++] = l.get(0);
                            ++cnt;
                        }
                    } else res[idx++] = l.get(0);
                } else {
                    Collections.sort(l, Collections.reverseOrder());
                    for (int j = 0; j < l.size(); j++) {
                        cnt = 0;
                        if (frequency[x] > 1) {
                            while (idx < nums.length && cnt < frequency[x]) {
                                res[idx++] = l.get(j);
                                ++cnt;
                            }
                        } else {
                            res[idx++] = l.get(j);
                        }
                    }
                }
                x++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
int [] a = new int [] {}; 

        int [] res = s.frequencySort(a);

        System.out.println("");
        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i]);
        }
        System.out.println("");
    }
}
