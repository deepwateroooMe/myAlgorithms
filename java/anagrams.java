import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class anagrams {
    public static class Solution {
        public String getAna(String a) {
            if (a == "") return "";
            char [] s = a.toCharArray();
            Arrays.sort(s);
            return new String(s);
        }
        
        public List<String> anagrams(String[] strs) {
            List<String> list = new ArrayList<String>();
            if (strs == null || strs.length < 2) return list;
            Map<String, List<Integer>> res = new HashMap<String, List<Integer>>();
            String [] sorted = new String[strs.length];
            List<Integer> one = new ArrayList<Integer>();
            for (int i = 0; i < strs.length; i++) {
                sorted[i] = getAna(strs[i]);
                if (res.containsKey(sorted[i])) {
                    /*
                    one = new ArrayList<Integer>(res.get(sorted[i]));
                    one.add(i);
                    res.put(sorted[i], one);
                    */
                    res.get(sorted[i]).add(i);
                } else {
                    one.add(i);
                    res.put(sorted[i], one);
                    one = new ArrayList<Integer>();
                }
            }

            for (String key : res.keySet()) 
                    if (res.get(key).size() > 1) 
                        for (int i = 0; i < res.get(key).size(); i++) 
                            list.add(strs[res.get(key).get(i)]);
            return list;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] s = {"", "b", ""};
        List<String> res = result.anagrams(s);
        
        System.out.println(res);
    }
}

/*  
    Input:	["","b",""]
    Output:	["","b"]
    Expected:	["",""]

Time Limit ExceededMore Details repeats
Last executed input:	["ago","its","shy","nor","pie","rod","ray","vow","hip","get","web","old","gad","tex","tar","nan","goo","tug","ram","rim","chi","huh","mes","jut","noh","jam","via","hal","gel","via","tip","gap","pal","zoe"]
    
    Input:	["and","dan"]
    Output:	[]
    Expected:	["and","dan"]

*/
/* // wrote this one because didn't understand question, OJ passed oriented, ...
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
*/
