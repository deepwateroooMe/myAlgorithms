import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class lengthOfLongestSubstringTwoDistinct {
    public static class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            } else if (s.length() < 3) {
                return s.length();
            }

            HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
            int slow = 0, fast = 1, cnt = 0, max = 0;
            char one, two, tmp, temp;
            one = s.charAt(slow);
            two = one; tmp = one; 
            hash.put(s.charAt(slow), 0);
            while (fast < s.length()) {
                while (cnt < 2 && fast < s.length()) {
                    two = s.charAt(fast);
                    if (two != one) {
                        hash.put(two, fast);
                        ++cnt;
                        if (cnt == 1) {
                            tmp = two;
                        }
                    }
                    while (fast < s.length() &&
                           (s.charAt(fast) == one || (two == tmp && s.charAt(fast) == tmp)) ) {
                        if (s.charAt(fast) == one) {
                            hash.put(one, fast);
                            fast++;
                        }
                        if (fast < s.length() && two != one && s.charAt(fast) == tmp) {
                            hash.put(tmp, fast);
                            fast++;
                        }
                    }
                }
                max = Math.max(max, fast-slow); 
                temp = one;
                one = s.charAt(fast-1) == one ? one : tmp; 
                tmp = s.charAt(fast-1) == temp ? tmp : temp; 
                slow = hash.get(tmp) + 1;
                hash.remove(tmp);
                tmp = one; temp = one;
                cnt = 0;
            }
            return max;
        }
    };

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "aba";
        int tmp = result.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(tmp);
    }
}
