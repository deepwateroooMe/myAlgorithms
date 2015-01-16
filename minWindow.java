import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minWindow {
    public static class Solution {
        // t = "ABC", do I need to consider ABBC? wanna use OJ to help guide, lazy boy ...
        public String minWindow(String s, String t) {
            if (t == null || (s == null || s.length() < t.length()) ) return "";
            Map<Character, Integer> hash = new HashMap<Character, Integer>();
            Map<Character, Integer> fnd = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) 
                if (!hash.containsKey(t.charAt(i)))
                    hash.put(t.charAt(i), 1);
                else hash.put(t.charAt(i), hash.get(t.charAt(i)) + 1);

            if (s.length() == t.length()) {
                for (int i = 0; i < t.length(); i++)
                    if (!fnd.containsKey(s.charAt(i)))
                        fnd.put(s.charAt(i), 1);
                    else fnd.put(s.charAt(i), fnd.get(s.charAt(i)) + 1);
                for (Character i : hash.keySet()) {
                    if (!fnd.containsKey(i) || fnd.get(i) != hash.get(i))
                        return "";
                }
                return s;
            }
            
            int slow = 0, fast = slow + 1, size, minl = Integer.MAX_VALUE;
            StringBuffer res = new StringBuffer("");
            StringBuffer tmp = new StringBuffer("");
            while (fast < s.length()) {
                System.out.println("fast: " + fast);

                while (!hash.containsKey(s.charAt(slow))) ++slow;
                if (slow == s.length()) return "";
                fnd.put(s.charAt(slow), 1);
                fast = slow + 1;
                while (fast < s.length() && !hash.containsKey(s.charAt(fast))) ++fast;
                if (fast == s.length() && fnd.size() < hash.size()) return "";

                if (hash.containsKey(s.charAt(fast))) {
                    if (!fnd.containsKey(s.charAt(fast))) {
                        fnd.put(s.charAt(fast), 1);
                        if (fnd.size() == hash.size()) {
                            for (Character key : hash.keySet()) 
                                if (fnd.get(key) < hash.get(key)) {
                                    fast++;
                                } else {                                
                                    tmp = new StringBuffer(s.substring(slow, fast + 1));
                                    if (tmp.length() < minl) {
                                        minl = tmp.length();
                                        res = new StringBuffer(tmp);
                                    }
                                    //slow++;
                                    fast = slow + 1;
                                }
                        }
                    } else
                        fnd.put(s.charAt(fast), fnd.get(s.charAt(fast)) + 1);
                }
            }
            System.out.println("res.toString(): " + res.toString());

            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = result.minWindow(s, t);
        
        System.out.println(res);
    }
}
