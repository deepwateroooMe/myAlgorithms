import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class majorityElement {
    public static class Solution {
        public int majorityElement(int[] num) {
            if (num.length == 1) {  // consider this special situation
                return num[0];
            }
            
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            for(int i : num) {
                if (hash.containsKey(i)) {
                    hash.put(i, hash.get(i)+1);
                    if (hash.get(i) > num.length / 2) {
                        return i;
                    }
                } else {
                    hash.put(i, 1);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int[] s = {1, 1, 2, 3, 4, 1, 1};
        int res = result.majorityElement(s);
        
        System.out.println(res);
    }
}
