import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minDeletionSize {
    public static class Solution {

        public int minDeletionSize(String[] strs) {
            if (strs.length == 1) return 0;
            int cnt = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                        ++cnt;
                        break;
                    }
                }
            }
            return cnt;
        }

        public int findSpecialInteger(int[] arr) {
            if (arr.length == 1) return arr[0];
            int n = arr.length;
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    ++cnt;
                    if (cnt > n / 4.0)
                    return arr[i];
                } else {
                    cnt = 1;
                }
            }
            return -1;
        }

        public void squareUp(int [] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * arr[i];
            }
        }
        
        public int[] sortedSquares(int[] nums) {
            if (nums[0] >= 0 || nums.length == 1) {
                squareUp(nums);
                return nums;
            }
            int p = 0, cnt = 0;
            int n = nums.length;

            while (p < n && nums[p] < 0) {
                ++cnt;
                p++;
            }
            if (p == n || (p == n - 1 && nums[n - 1] == 0)) {
                int tmp = 0;
                for (int i = 0; i < n / 2; i++) {
                    tmp = nums[i];
                    nums[i] = nums[n - i - 1];
                    nums[n - i - 1] = tmp;
                }
                squareUp(nums);
                return nums;
            }

            int i = 0;
            int [] res = new int[nums.length];
            int q = p - 1;

            while (p < n && q >= 0 && i < nums.length) {
                while (p < n && q >= 0 && nums[p] <= Math.abs(nums[q])) {
                    res[i++] = nums[p++];
                }
                if (q >= 0)
                res[i++] = nums[q--];
            }
            if (q < 0) {
                while (p < n) {
                    res[i++] = nums[p++];
                }
            } else if (p == n) {
                while (q >= 0) {
                    res[i++] = nums[q--];
                }
            }
            squareUp(res);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = {-7, -3, 2, 3, 11};
        // int [] a = {-4,-1,0,3,10};
        // int [] a = {-5, -3, -2, -1};
        // int [] a = {-4,-1,0,3,10};
        int [] a = {-3, -3, -2, 1};
        
        int [] res = s.sortedSquares(a);

        System.out.println("");
        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i]);
        }
        System.out.println("");
    }
}