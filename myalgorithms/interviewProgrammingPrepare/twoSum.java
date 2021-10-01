import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class twoSum {
    public static class Solution {
        // need consider equal case

        public int[] twoSum(int[] numbers, int target) {
            // Awesome input is already sorted
            for (int i = 0; i < numbers.length; i++) {
                int j = binarySearch(numbers, target - numbers[i], i + 1);
                if (j != -1) {
                    return new int[]{i + 1, j + 1};
                }
            }
            throw new IllegalArgumentException("No two sume solutions found");
        }
        
        private int binarySearch(int [] A, int key, int start) {
            int L = start, R = A.length - 1;
            while (L < R) {
                int M = (L + R) / 2;
                if (A[M] < key) {
                    L = M + 1;
                } else {
                    R = M;
                }
            }
            return (L == R && A[L] == key) ? L : -1;
        }

        public int[] twoSum1(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int [] res = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                map.put(numbers[i], i);
            }
            return res;
        }
        
        public int[] twoSum0(int[] numbers, int target) {
            int [] result = new int[2];
            if (numbers == null || numbers.length == 0)
            	return null;
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            
            for (int i = 0; i < numbers.length; i++) {
                if (!hash.containsKey(numbers[i]))
                    hash.put(numbers[i], i+1);
                else if (numbers[i] * 2 == target && hash.containsKey(numbers[i])) {
                    result[0] = hash.get(numbers[i]) <= i + 1 ? hash.get(numbers[i]) : i+1;
                    result[1] = hash.get(numbers[i]) <= i + 1 ? i+1 : hash.get(numbers[i]);
                    return result;
                }
            }

            int two;
            for(int i : numbers) {
                two = target - i;
                if (hash.containsKey(two)) {
                    if (two != i) {
                        result[0] = hash.get(i) <= hash.get(two) ? hash.get(i) : hash.get(two);
                        result[1] = hash.get(i) <= hash.get(two) ? hash.get(two) : hash.get(i);
                        return result;
                    } 
                }
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 1, 4, 6}; // 3, 2, 4, :6
        int [] res = result.twoSum(a, 5);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
