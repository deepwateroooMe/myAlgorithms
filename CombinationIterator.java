import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class CombinationIterator {

    int n;
    char [] arr;
    List<String> ll = new ArrayList<>();
    int size;
    boolean [] vis;
    int idx = 0;
    // private void helper(StringBuilder s) {
    //     if (s.length() == size) {
    //         String sorted = Stream.of(s.toString().split("")).sorted().collect(Collectors.joining());
    //         if (!ll.contains(sorted))
    //             ll.add(sorted);
    //         return;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         if (!vis[i]) {
    //             vis[i] = true;
    //             s.append(arr[i]);
    //             helper(s);
    //             s.deleteCharAt(s.length()-1);
    //             vis[i] = false;
    //         }
    //     }
    // }
    public CombinationIterator(String characters, int combinationLength) {
        n = characters.length();
        arr = characters.toCharArray();
        Arrays.sort(arr);
        // size = combinationLength;
        size = combinationLength << 1; // 所有的排列、组合是这个数,当我们需要长度为N的时，从某个数字特定的数字开始取串
        idx = 1;

        // vis = new boolean[n];
        // helper(new StringBuilder());
    }
    
    public String next() {
        int tmp = idx;
        int i = arr.length-1;
        StringBuilder s = new StringBuilder( );
        while (tmp > 0) {
            s.append(arr[i]);
            --i;
            tmp >>= 1;
        }
        ++idx;
        return s.toString();
    }
    
    public boolean hasNext() {
        return idx < size;
        // return idx < ll.size();
    }
    
    public static void main(String[] args) {
        // Solution s = new Solution();
        CombinationIterator s = new CombinationIterator("abc", 2);

        String r = s.next();    // return "ab"
        System.out.println("r: " + r);
        
        boolean r1 = s.hasNext(); // return True
        System.out.println("r1: " + r1);
        
        String r2 = s.next();    // return "ac"
        System.out.println("r2: " + r2);
        
        boolean r3 = s.hasNext(); // return True
        System.out.println("r3: " + r3);
        
        String r4 = s.next();    // return "bc"
        System.out.println("r4: " + r4);
        
        boolean r5 = s.hasNext(); // return False
        System.out.println("r5: " + r5);

        // boolean res = s.(a);
        // System.out.println("res: " + res);
    }
}


