// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class FindSumPairs {

    Map<Integer, Integer> m = new HashMap<>();
    Map<Integer, Integer> n = new HashMap<>();
    int [] a;
    int [] b;
    public FindSumPairs(int[] a, int[] b) {
        this.a = Arrays.copyOf(a, a.length);
        this.b = Arrays.copyOf(b, b.length);
        for (Integer v : a) 
            m.put(v, m.getOrDefault(v, 0) + 1);
        for (Integer v : b) 
            n.put(v, n.getOrDefault(v, 0) + 1);
    }
    
    public void add(int index, int val) {
        n.put(b[index], n.get(b[index])-1);
        if (n.get(b[index]) == 0) n.remove(b[index]);
        b[index] += val;
        n.put(b[index], n.getOrDefault(b[index], 0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for (Integer key : m.keySet()) 
            if (n.containsKey(tot - key)) ans += m.get(key) * n.get(tot-key);
        return ans;
    }
    
    public static void main(String[] args) {

        int []  a = new int []  {1,  1,  2,  2,  2,  3};
        int []  b = new int []  {1,  4,  5,  2,  5,  4};

        FindSumPairs s = new FindSumPairs(a, b);
        
    }
}
