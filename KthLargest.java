import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class KthLargest {

    private List<Integer> arr;
    private int kth;
    
    public KthLargest(int k, int[] nums) {
        kth = k;
        if (nums == null || nums.length ==0) return;
        Arrays.sort(nums);
        arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(0, nums[i]);
        }
    }
    
    public int add(int val) {
        if (arr == null) {
            arr = new ArrayList<>();
            arr.add(val);
            if (kth == 1) return val;
            return -1;
        }
        if (val > arr.get(0)) {
            arr.add(0, val);
            return  arr.size() >= kth ? arr.get(kth - 1) : -1;
        }
        int i = 0;
        for ( i = 0; i < arr.size(); i++) {
            if (arr.get(i) > val) continue;
            arr.add(i, val);
            return arr.get(kth-1);
        }
        if (i == arr.size() && arr.get(arr.size()-1) > val) {
            arr.add(val);
            return arr.get(kth - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a = new int [] {};
        KthLargest s = new KthLargest(1, a);

        int res = s.add(-3);
        System.out.println("res: " + res);

        int r = s.add(-2);   // return 5
        System.out.println("r: " + r);
        
        int r1 = s.add(-4);  // return 5
        System.out.println("r1: " + r1);
        
        int r2 = s.add(0);   // return 8
        System.out.println("r2: " + r2);
        
        int r3 = s.add(4);   // return 8
        System.out.println("r3: " + r3);

        // ["KthLargest","add","add","add","add","add"]
        //     [[1,[]],[-3],[-2],[-4],[0],[4]]

    }
}