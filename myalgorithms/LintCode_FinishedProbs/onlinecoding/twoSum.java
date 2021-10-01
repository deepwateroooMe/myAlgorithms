import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class twoSum {
    public static class Solution {
        /*
         * @param numbers : An array of Integer
         * @param target : target = numbers[index1] + numbers[index2]
         * @return : [index1 + 1, index2 + 1] (index1 < index2)
         */
        // don't know this one yet, 
        public int[] twoSum(int[] numbers, int target) { // O(nlogn), O(1)
            Arrays.sort(numbers); // shouldn't sort
            int [] res = new int[2];
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
                if (numbers[i] + numbers[j] < target) i++;
                else j--;
            }
            return res;
        }
        
        public int[] twoSum0(int[] numbers, int target) { // O(n), O(n)
            Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
            int [] res = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (!m.containsKey(numbers[i]))
                    m.put(numbers[i], new ArrayList<Integer>(Arrays.asList(i)));
                else m.get(numbers[i]).add(i);
            }

            int other = 0;
            for (int i = 0; i < numbers.length ; i++) {
                other = target - numbers[i];
                if (m.containsKey(other)
                    && (other != numbers[i]
                        || (other == numbers[i] && m.get(other).size() > 1))) {
                    res[0] = i + 1;
                    res[1] = m.get(other).get(0) + 1;
                    return  res;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 7, 11, 15};
        int b = 9;
        int [] res = result.twoSum(a, b);
System.out.println("");
for(int val : res)
    System.out.print(val + ", ");
System.out.println("");



    }
}
