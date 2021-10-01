import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class myHashSet {

    private Stack<String> forward, backward;
    private StringBuilder curr;
    
    public BrowserHistory(String homepage) {
        forward = new Stack<>();
        backward = new Stack<>();
        curr = homepage;
    }
    
    public void visit(String url) {
        backward.push(curr);
        curr = url;
    }
    
    public String back(int steps) {
        while (steps > 0 && !backward.isEmpty()) {
            forward.push(curr);
            curr = backward.pop();
            --steps;
        }
        return curr;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !forward.isEmpty()) {
            backward.push(curr);
            curr = forward.pop();
            --steps;
        }
        return curr;
    }

    // private int [] arr;
    // public MyHashMap() {
    //     arr = new int [1000001];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = 1000001;
    //     }
    // }
    // public void put(int key, int value) {
    //     arr[key] = value;
    // }
    // public int get(int key) {
    //     return arr[key] == 1000001 ? -1 : arr[key];
    // }
    // public void remove(int key) {
    //     arr[key] = 1000001;
    // }
    
    // private int [] arr;
    // public myHashSet() {
    //     arr = new int[1000001];
    // }
    // public void add(int key) {
    //     arr[key] = 1;
    // }
    // public void remove(int key) {
    //     arr[key] = 0;
    // }
    // public boolean contains(int key) {
    //     return arr[key] == 1;
    // }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        TreeNode res = s.(root );
        res.levelPrintTree(res);
    }
}