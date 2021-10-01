import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class NestedInteger {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    // public interface NestedInteger {
    // Constructor initializes an empty nested list.
    List<List<Integer>> ll = new ArrayList<>();
    int curIdx = 0;

    public NestedInteger() {
        ll = new ArrayList<>();
    }
                
    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        if (ll == null)  ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(value);
        ll.add(l);
    }
                
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return ll.get(curIdx).size() == 1;
    }
                
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return ll.get(curIdx).get(0);
    }
                
    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        ll.get(curIdx).set(0, value);
    }
                
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        for (int i = 0; i < ni.size(); i++) {
            ll.add(new ArrayList<List<Integer>>(ni.get(i)));
        }
    }
                
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return ll;
    }
    public int size() {
        return ll.size();
    }
    public NestedInteger get(int i) {
        return ll.get(i);
    }
    // }

    public static class Solution {
        private void printNI(NestedInteger v) {
            
        }
        private int getMatedRIdx(String s, int idx) {
            int n = s.length();
            int i = 0, l = 0, r = 0;
            while (i < n) {
                if (s.charAt(i) == '[') ++l;
                else if (s.charAt(i) == ']') {
                    if (l > 0) --l;
                    else ++r;
                }
                if (l == r) break;
            }
            return i;
        }
        public NestedInteger deserialize(String s) {
            System.out.println("s: " + s);
            
            int n = s.length();
            if (n == 1) return null;
            int i = 0, j = 0;
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                return new NestedInteger(Integer.parseInt(s.substring(i, n)));
            }
            NestedInteger res = new NestedInteger(); // s.charAt(1) == '['
            ++i;
            while (i < n) {
                while (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                    j = i;
                    while (j < n && Character.isDigit(s.charAt(j))) ++j; // j: , or n
                    res.add(new NestedInteger(Integer.parseInt(s.substring(i, j))));
                    if (j == n) return res;
                    i = j+1;
                }
                if (s.charAt(i) == '[') {
                    j = getMatedRIdx(s, i);
                    NestedInteger nt = deserialize(s.substring(i+1, j));
                    res.add(nt);
                    if (j == n-1) return res;
                    i = j+2;
                }
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "[123,[456,[789]]]";

        NestedInteger res = s.deserialize(a);
        // System.out.println("res.size(): " + res.size());
        // for (int z = 0; z < res.size(); ++z) 
        //     System.out.print(res.get(z) + ", ");
        // System.out.print("\n");
    }
}

// List<Integer> l;
// int idx;
// NestedInteger tmp;
// public NestedIterator(List<NestedInteger> nestedList) {
//     if ( nestedList == null || nestedList.size() == 0 ) return;
//     l = flattenNestedInteger(nestedList);
//     idx = 0;
// }
// private List<Integer> flattenNestedInteger(List<NestedInteger> nestedList) {
//     List<Integer> l = new ArrayList<>();
//     if ( nestedList == null || nestedList.size() == 0) return l;
//     for (int i = 0; i < nestedList.size(); i++) {
//         if (nestedList.get(i).isInteger()) {
//             l.add(nestedList.get(i).getInteger());
//         } else {
//             List<NestedInteger> ntmp = nestedList.get(i).getList();
//             List<Integer> ll = flattenNestedInteger(ntmp);
//             for (int j = 0; j < ll.size(); j++) {
//                 l.add(ll.get(j));
//             }
//         }
//     }
//     return l;
// }
// @Override
// public Integer next() {
//     Integer tmp = l.get(idx);
//     ++idx;
//     return tmp;
// }
// @Override
// public boolean hasNext() {
//     return idx < l.size();
// }
