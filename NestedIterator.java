import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger();
                
        // Constructor initializes a single integer.
        public NestedInteger(int value);
                
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
                
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
                
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);
                
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);
                
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class Solution {

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
    }    
    public static void main(String[] args) {
        String a = "[123,[456,[789]]]";

        NestedInteger res = deserialize(a);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) 
            System.out.print(res.get(z) + ", ");
        System.out.print("\n");

        // NestedIterator s = new NestedIterator();
        // NestedList nl = new NestedList {};

    }
}