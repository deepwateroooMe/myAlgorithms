import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class compareString {
    public static class Solution {
        /**
         * @param A : A string includes Upper Case letters
         * @param B : A string includes Upper Case letter
         * @return :  if string A contains all of the characters in B return true else return false
         */
        public boolean compareStrings(String a, String b) {
            if (b == null) return a == null;
            if (a.length() < b.length()) return false;
            Map<Character, Integer> bm = new HashMap<Character, Integer>();
            Map<Character, Integer> am = new HashMap<Character, Integer>();
            for (int i = 0; i < b.length(); i++) {
                if (!bm.containsKey(b.charAt(i)))
                    bm.put(b.charAt(i), 1);
                else bm.put(b.charAt(i), bm.get(b.charAt(i)) + 1);
            }
            for (int i = 0; i < a.length(); i++) {
                if (!am.containsKey(a.charAt(i)))
                    am.put(a.charAt(i), 1);
                else am.put(a.charAt(i), am.get(a.charAt(i)) + 1);
            }
            for (Character key : bm.keySet()) 
                if (!am.containsKey(key) || am.get(key) < bm.get(key)) return false;
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
