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

    List<Integer> l;
    int idx;
    NestedInteger tmp;
    public NestedIterator(List<NestedInteger> nestedList) {
        if ( nestedList == null || nestedList.size() == 0 ) return;
        l = flattenNestedInteger(nestedList);
        idx = 0;
    }

    private List<Integer> flattenNestedInteger(List<NestedInteger> nestedList) {
        List<Integer> l = new ArrayList<>();
        if ( nestedList == null || nestedList.size() == 0) return l;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                l.add(nestedList.get(i).getInteger());
            } else {
                List<NestedInteger> ntmp = nestedList.get(i).getList();
                List<Integer> ll = flattenNestedInteger(ntmp);
                for (int j = 0; j < ll.size(); j++) {
                    l.add(ll.get(j));
                }
            }
        }
        return l;
    }
        
    @Override
    public Integer next() {
        Integer tmp = l.get(idx);
        ++idx;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return idx < l.size();
    }
    
    public static void main(String[] args) {
        NestedIterator s = new NestedIterator();

        // int [] a = new int [] {};
        NestedList nl = new NestedList {};
        
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        TreeNode res = s.(root4);
        res.levelPrintTree(res);
    }
}