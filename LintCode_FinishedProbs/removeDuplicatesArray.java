import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicatesArray {
    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int i = 0;
            for (int j = 1; j < n; j++) {
                if (nums[j] == nums[i]) continue;
                nums[++i] = nums[j];
            }
            return i + 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 1, 2};
        int res = result.removeDuplicates(a);
System.out.println("res: " + res);
    }
}
