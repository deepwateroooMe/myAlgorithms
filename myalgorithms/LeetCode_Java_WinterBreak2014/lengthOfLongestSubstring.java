import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class lengthOfLongestSubstring {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            if (s.length() == 1) return 1;
            Map<Character, Integer> hash = new HashMap<Character, Integer>();
            int slow = 0, fast = 1, result = 0;
            hash.put(s.charAt(slow), slow);
            while (fast < s.length()) {
                while (fast < s.length() && hash.containsKey(s.charAt(fast))) {
                    result = Math.max(result, fast-slow);
                    // the element I need to remove is a fragment
                    for (int i = slow; i < hash.get(s.charAt(fast)); i++) 
                        hash.remove(s.charAt(i));
                    slow = hash.get(s.charAt(fast)) + 1;
                    hash.put(s.charAt(fast), fast);
                    fast++;
                }
                if (fast < s.length()) {
                    hash.put(s.charAt(fast), fast);
                    fast++;
                }
            }
            result = Math.max(result, fast-slow);
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        int res = result.lengthOfLongestSubstring(s);
        
        System.out.println(res);
    }
}
