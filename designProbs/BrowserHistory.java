import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class BrowserHistory {

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

    private Stack<String> forward, backward;
    private String curr;
    public BrowserHistory(String homepage) {
        forward = new Stack<>();
        backward = new Stack<>();
        curr = homepage;
    }
    public void visit(String url) {
        backward.push(curr);
        curr = url;
        while (!forward.isEmpty()) forward.pop();
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

    
    public static void main(String[] args) {
        BrowserHistory s = new BrowserHistory("leetcode.com");
         s.visit("google.com");
         s.visit("facebook.com");
         s.visit("youtube.com");
         
         String param_2 = s.back(1);
         System.out.println("param: " + param_2);
         
         String param_3 = s.back(1);
         System.out.println("param_3: " + param_3);

         String res = s.forward(1);
         System.out.println("res: " + res);

         s.visit("linkedin.com");
         String res2 = s.forward(2);
         System.out.println("res2: " + res2);
         
         
    }
}