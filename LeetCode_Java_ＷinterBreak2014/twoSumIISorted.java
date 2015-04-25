import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class twoSumIISorted {
    public static class Solution {
        // don't need this one anymore
        public int findValue(int[] a, int val, int start, int end) {
            if (val == a[0]) {
                return 0;
            } else if (val == a[a.length-1]) {
                return a.length-1;
            }
            
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (a[mid] == val) {
                    return mid;
                } else if (a[mid] < val) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (a[start] == val) {
                return start;
            } else {
                return -1;
            }
        }

        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            int[] result = new int[2];
            int i;
            for( i = 0; i < numbers.length; ++i) {
                hash.put(numbers[i], i);
            }
            for(int j= 0; j < i; ++j) {
                int tmp = target - numbers[j];
                if (hash.containsKey(tmp)) {
                    result[0] = j + 1;
                    result[1] = hash.get(tmp) + 1;
                    break;
                } 
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution result = new Solution();
        int[] a = {-3, 3, 4, 90};
        System.out.println("a.length: " + a.length);
        
        int[] res = new int[2];
        res = result.twoSum(a, 0);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
