import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class anagrams {
    public static class Solution {
        public String getAna(String a) {
            if (a == "") return "";
            StringBuffer res = new StringBuffer();
            for (int i = a.length()-1; i >= 0; i--) 
                res.append(a.charAt(i));
            return res.toString();
        }
        // atn nta ok, but tan failed
        public List<String> anagrams(String[] strs) {
            List<String> list = new ArrayList<String>();
            if (strs == null || strs.length < 2) return list;
            
            Map<String, Integer> map = new HashMap<String, Integer>();
            Map<String, Integer> res = new HashMap<String, Integer>();
            for(String i : strs)
                if (map.containsKey(i))
                    map.put(i, map.get(i) + 1);
                else 
                    map.put(i, 1);
            
            for(String key : map.keySet())
                if ( (map.containsKey(getAna(key))
                      && (!key.equals(getAna(key))
                          || (key.equals(getAna(key)) && map.get(key) == 2)))
                     || (!map.containsKey(getAna(key)) && map.get(key) == 2))
                    if (!res.containsKey(key)) {
                        res.put(key, 1);
                        if (!key.equals(getAna(key)) && map.containsKey(getAna(key)))
                            res.put(getAna(key), 1);
                        if (map.get(key) == 2)
                            res.put(key, res.get(key) + 1);
                    }
            for(String key : res.keySet()) {
                if (res.get(key) > 1)
                    for (int i = 0; i < map.get(key); i++) 
                        list.add(key);
                else
                        list.add(key);
            }
            return list;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] s = {"ant", "ant"};
        List<String> res = result.anagrams(s);
        
        System.out.println(res);
    }
}

/*  // completely understand the question wrong
Input:	["and","dan"]
Output:	[]
Expected:	["and","dan"]

 */
