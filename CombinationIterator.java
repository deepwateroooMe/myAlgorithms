import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class CombinationIterator {

    TreeSet<String> ts;
    Iterator it;
    public CombinationIterator(String characters, int combinationLength) {
        ts = new TreeSet<>();
        char [] ori = new StringBuilder(characters).reverse().toString().toCharArray();
        System.out.println(Arrays.toString(ori));
        
        int n = characters.length(), range = (1 << n), tmp = 0;
        for (int i = 1; i < range; i++) {
            if (Integer.bitCount(i) != combinationLength) continue;
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < n; j++) 
                if (((i >> j) & 1) == 1) cur.append(ori[j]);
            ts.add(cur.reverse().toString());
        }
        it = ts.iterator();
    }
    
    public String next() {
        if (it.hasNext())
            return (String)it.next();
        return null;
    }
    
    public boolean hasNext() {
        return it.hasNext();
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


