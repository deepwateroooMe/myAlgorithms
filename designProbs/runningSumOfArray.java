import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class runningSumOfArray {
    public static class Solution {
    
        public  int[] runningSum(int[] nums) {
            int [] res = new int [nums.length];
            res[0] = nums[0];
            for (int i = 1; i < nums.length; i++) 
            res[i] = res[i - 1] + nums[i];
            return res;
        }

        private  int [] withinMaxRange;
        private  int findMax(int [] arr) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max)
                max = arr[i];
            }
            return max;
        } 
        public  List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            withinMaxRange = new int[candies.length];
            List<Boolean> res = new ArrayList<Boolean>();

            int max = findMax(candies);

            System.out.println("max: " + max);
        
            for (int i = 0; i < candies.length; i++) {
                if (max - candies[i] <= extraCandies) {
                    res.add(true);
                } else
                res.add(false);
            }
            return res;
        }

        public int[] shuffle(int[] nums, int n) {
            int [] res = new int [2 * n];
            int cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) 
                    res[i] = nums[i / 2];
                else 
                    res[i] = nums[n + i / 2];
            }
            return res;
        }

        public int numIdenticalPairs(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j])
                        ++res;
                }
            }
            return res;
        }
// nums
        public void rotate(int[] nums, int k) {
            if (k == 0 || k % nums.length == 0 || nums.length == 1) return;
            int n = nums.length;
            int tmp;
            int cnt = 0;
            if (k > nums.length)
            k %= nums.length ;

            if (k < n / 2) {
                while (cnt < k) {
                    tmp = nums[n - 1]; // remember the last one
                    for (int i = n - 1; i > 0; i--) {
                        nums[i] = nums[i - 1];
                    }
                    nums[0] = tmp;
                    ++cnt;
                }
            } else if (k > n / 2 || (k % 2 == 1 && k == n / 2)){
                // System.out.println("$k > n / 2");

                while (cnt < n - k) {
                    tmp = nums[0]; // remember the first one
                    for (int i = 0; i < n - 1; i++) {
                        nums[i] = nums[i + 1];
                    }
                    nums[n - 1] = tmp;
                    ++cnt;
                }
            } else if (n % 2 == 0 && k == n / 2) {
                // System.out.println("$else");

                for (int i = 0; i < n / 2; i++) {
                    tmp = nums[i];
                    nums[i] = nums[n - 1 - i];
                    nums[n - 1 - i] = tmp;
                }

                for (int i = 0; i < n / 4; i++) {
                    tmp = nums[i];
                    nums[i] = nums[n / 2 - 1 - i];
                    nums[n / 2 - 1 - i] = tmp;

                    tmp = nums[i + n / 2];
                    nums[i + n / 2] = nums[n - i - 1];
                    nums[n - 1 - i] = tmp;
                }
            }
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // int [] a = {1,2,3,4,5,6,7}; // ,8,9,10
        // int [] a = {-1, -100, 3, 99};
        
        
s.rotate(a, 3);
System.out.println("");
for (int i = 0; i < a.length; ++i) {
    System.out.println(a[i]);
}
System.out.println("");


    }
}
