import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;


public class fourSum {
    public static class Solution {
        /**
         * @param numbers : Give an array numbersbers of n integer
         * @param target : you need to find four elements that's sum of target
         * @return : Find all unique quadruplets in the array which gives the sum of
         *           zero.
         */
        public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
            int n = numbers.length;
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (n < 4) return res;
            Arrays.sort(numbers);
            int x = 0, y = 0, tmp = 0;
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && numbers[i] == numbers[i - 1]) continue;
                for (int j = i + 1; j < n - 2; j++) {
                    x = j + 1;
                    y = n - 1;
                    while (x < y) {
                        tmp = target - numbers[i] - numbers[j];
                        if (numbers[x] + numbers[y] == tmp) {
                            set.add(new ArrayList<Integer>(Arrays.asList(numbers[i], numbers[j], numbers[x], numbers[y])));
                            x++;
                            y--;
                        }
                        else if (numbers[x] + numbers[y] < tmp) x++;
                        else y--;
                    }
                }
            }
            res.addAll(set);
            return res;
        }
    }
    // why this case failed?
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0,0,-1012,0,0,0,-3002,0,0,0,-10,-19,0,0,90,0,92,0,1,1,1,9,9,9,10,11,1001,2001,-404,201,203,201,999,345,1,1,1,1,1,1,1,-2,1,1,1,1,1,-1,1,1,-2,1,1,1,1,3,1,1,1,1,1,-1200,1,1,1,1,1,2,1202,2,2,-4,2,2,2,2,4,5,6,1,1,-11,1,1,1,1,1,1,1,1,101,1,1,1,1,1,-1,1,-6};
        int b = 92;
        ArrayList<ArrayList<Integer>> res = result.fourSum(a, b);
System.out.println("");
    for (int i = 0; i < res.size(); ++i) {
        System.out.println(res.get(i));
    }
    System.out.println("");
    

    }
}
