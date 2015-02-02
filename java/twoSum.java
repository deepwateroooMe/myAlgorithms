import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class twoSum {
    public static class Solution {
        // need consider equal case
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int [] res = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                map.put(number[i], i);
                
            }


        }
        
        public int[] twoSum0(int[] numbers, int target) {
            int [] result = new int[2];
            if (numbers == null || numbers.length == 0) return null;
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
        int [] a = {0, 4, 3, 0}; // 3, 2, 4, :6
        int [] res = result.twoSum(a, 0);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
