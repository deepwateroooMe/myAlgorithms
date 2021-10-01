import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicatesArrayII {
    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int i = 0;
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    if (cnt < 2) {
                        ++cnt;
                        nums[++i] = nums[j];
                    } 
                    continue;   
                } else {
                    nums[++i] = nums[j];
                    cnt = 1;
                }
            }
            return i + 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-14,-14,-14,-14,-14,-14,-14,-13,-13,-13,-13,-12,-11,-11,-11,-9,-9,-9,-7,-7,-7,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-3,-2,-2,-2,-1,-1,0,0,0,0,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,5,5,6,6,6,7,7,7,7,8,8,8,8,9,9,10,10,11,11,11,11,11,12,12,12,12,13,13,13,13,14,14,15,16,17,18,18,18,20,20,21,21,21,21,21,22,22,22,22,23,24,24,25};
        int res = result.removeDuplicates(a);
        System.out.println("");
        for(int val : a)
            System.out.print(val + ", ");
        System.out.println("");
        

System.out.println("res: " + res);
    }
}
