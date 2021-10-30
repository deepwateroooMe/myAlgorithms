// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
        
    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new TreeMap<Integer, String>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tmp = map.get(key);
        if (tmp == null) return "";
        Integer floorKey = tmp.floorKey(timestamp);
        if (floorKey == null) return "";
        return tmp.get(floorKey);
    }

    public static void main(String[] args) {
        // Solution s = new Solution();
        TimeMap s = new TimeMap();

        s.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
     String r =    s.get("foo", 1);         // return "bar"
     System.out.println("r: " + r);

        s.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        s.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
        s.get("foo", 4);         // return "bar2"
        s.get("foo", 5);         // return "bar2"
    }
}