// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class AllOne {

    TreeMap<Integer, HashSet<String>> reversedIndex;
    HashMap<String, Integer> index;
    
    /** Initialize your data structure here. */
    public AllOne() {
        this.reversedIndex = new TreeMap<>();
        this.index = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!this.index.containsKey(key)) {
            this.index.put(key, 1);
            if (!this.reversedIndex.containsKey(1)) 
                this.reversedIndex.put(1, new HashSet<String>());
            this.reversedIndex.get(1).add(key);
        } else {
            int currCnt = this.index.get(key);
            this.reversedIndex.get(currCnt).remove(key);
            if (this.reversedIndex.get(currCnt).size() == 0)
                this.reversedIndex.remove(currCnt);
            if (!this.reversedIndex.containsKey(currCnt + 1))
                this.reversedIndex.put(currCnt+1, new HashSet<String>());
            this.index.put(key, currCnt + 1);
            this.reversedIndex.get(currCnt + 1).add(key);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int currCnt = this.index.get(key);
        this.reversedIndex.get(currCnt).remove(key);
        if (this.reversedIndex.get(currCnt).size() == 0)
            this.reversedIndex.remove(currCnt);

        if (currCnt > 1) {
            if (!this.reversedIndex.containsKey(currCnt - 1))
                this.reversedIndex.put(currCnt-1, new HashSet<String>());
            this.reversedIndex.get(currCnt-1).add(key);
            this.index.put(key, currCnt -1);
        } else {
            this.index.remove(key);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (this.index.size() == 0) return "";
        return this.reversedIndex.get(this.reversedIndex.lastKey()).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (this.index.size() == 0) return "";
        return this.reversedIndex.get(this.reversedIndex.firstKey()).iterator().next();
    }
    
    public static void main(String[] args) {

        AllOne s = new AllOne();
        s.inc("hello");
        s.inc("hello");
        String r = s.getMaxKey(); // return "hello"
        System.out.println("r: " + r);
    
        String r1 = s.getMinKey(); // return "hello"
        System.out.println("r1: " + r1);
    
        s.inc("leet");
        String r2 = s.getMaxKey(); // return "hello"
        System.out.println("r2: " + r2);
    
        String r3 = s.getMinKey(); // return "leet"
        System.out.println("r3: " + r3);
    }
 }