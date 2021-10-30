import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class FreqStack {
    // public static class Solution {

        Map<Integer, Integer> cnt;       // val, cnt
        Map<Integer, List<Integer>> map; // cnt: val list
        int maxCnt, lastVal;
        public FreqStack() {
            cnt = new HashMap<>();
            map = new HashMap<>();
            maxCnt = 0;
            lastVal = -1;
        }
    
        public void push(int val) {
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
            map.computeIfAbsent(cnt.get(val), k->new ArrayList<>()).add(val);
            lastVal = val;
            if (cnt.get(val) > maxCnt) maxCnt = cnt.get(val);
        }
    
        public int pop() {
            List<Integer> l = map.get(maxCnt);
            int res = l.remove(l.size()-1);
            if (l.size() == 0) {
                maxCnt--;
            }
            if (maxCnt > 0) {
                cnt.put(res, cnt.get(res)-1);
                System.out.println("cnt.get(res): " + cnt.get(res));
            }
            return res;
        }  
    // }
    public static void main(String[] args) {
        // Solution s = new Solution();

        FreqStack s = new FreqStack();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);

        int r = s.pop();
        System.out.println("r: " + r);
        int r1 = s.pop();
        System.out.println("r1: " + r1);
        int r2 = s.pop();
        System.out.println("r2: " + r2);
        
        int r3 = s.pop();
        System.out.println("r3: " + r3);
        
    }
}
// [null, null, null, null, null, null, null, 5, 7, 5, 4]