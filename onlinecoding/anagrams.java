import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class anagrams {
    public static class Solution {
        /**
         * @param strs: A list of strings
         * @return: A list of strings
         */
        public String mySort(String s) {
            char [] tmp = s.toCharArray();
            Arrays.sort(tmp);
            return new String(tmp);   //tmp.toString(); doesn't work
        }

        public List<String> anagrams(String[] strs) {
            Map<String, List<Integer>> m = new HashMap<String, List<Integer>>();
            ArrayList<String> res = new ArrayList<String>();
            for (int i = 0; i < strs.length; i++) {
                String tmp = mySort(strs[i]);
                if (!m.containsKey(tmp))
                    m.put(tmp, new ArrayList<Integer>(Arrays.asList(i)));
                else m.get(tmp).add(i);
            }
            for (String key : m.keySet()) 
                if (m.get(key).size() > 1)
                    for (int i = 0; i < m.get(key).size(); i++) 
                        res.add(strs[m.get(key).get(i)]);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {"lint","intl","inlt","code"};
        List<String> res = result.anagrams(a);
        System.out.println(res);
    }
}
