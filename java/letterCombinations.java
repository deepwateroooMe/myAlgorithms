import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static class Solution {
        public char [] getArr(char x) {
            char [] two = {'a', 'b', 'c'};
            char [] thr = {'d', 'e', 'f'};
            char [] fou = {'g', 'h', 'i'};
            char [] fiv = {'j', 'k', 'l'};
            char [] six = {'m', 'n', 'o'};
            char [] sev = {'p', 'q', 'r', 's'};
            char [] eig = {'t', 'u', 'v'};
            char [] nin = {'w', 'x', 'y', 'z'};
            switch (x) {
            case '2': return two;
            case '3': return thr;
            case '4': return fou;
            case '5': return fiv;
            case '6': return six;
            case '7': return sev;
            case '8': return eig;
            case '9': return nin;
            }
            return null;
        }

        public void recursion(String digits, List<String> result) {
            char [] base = getArr(digits.charAt(digits.length()-1));
            int n = result.size();
            //for(String x : result) // ConcurrentModificationException, result is changing
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < base.length; i++)
                    result.add(new StringBuffer(base[i]+ result.get(j)).toString());
            }
            for (int i = n-1; i >= 0; i--)
                result.remove(i);
            if (digits.length() > 1)
                recursion(digits.substring(0, digits.length()-1), result);
        }
        
        public List<String> letterCombinations(String digits) {
            if (digits == null) return null;

            List<String> result = new ArrayList<String>();
            if (digits.equals("")) {
                result.add("");
                return result;
            }
            char [] base = getArr(digits.charAt(digits.length()-1));
            for (int i = 0; i < base.length; i++) 
                result.add("" + base[i]);
            if (digits.length() > 1)
                recursion(digits.substring(0, digits.length()-1), result);
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "234";
        List<String> res = new ArrayList<String>();
        res = result.letterCombinations(s);
        for(String i : res)
            System.out.println(i);
        }
}
