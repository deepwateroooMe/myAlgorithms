import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class twoSumClass {

    public static class Solution {

        private Map<Integer, Integer> table = new HashMap<>();

        public void add(int input) {
            int cnt = table.containsKey(input) ? table.get(input) : 0;
            table.add(input, cnt + 1);
        }

        public boolean find(int val) {
            for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
                int num = table.getKey();
                int y = val - num;
                if (y == num) {
                    if (entry.getValue() >= 2) return true;
                } else if (table.containsKey(y)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        

        System.out.println(res);
    }
}