// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class RandomizedCollection {

    List<Integer> vals;
    Map<Integer, Set<Integer>> idxMap;
    Random random;
    
    public RandomizedCollection() {
        vals = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean res = !idxMap.containsKey(val);
        if (res) idxMap.put(val, new HashSet<>());
        idxMap.get(val).add(vals.size());
        vals.add(val);
        return res;
    }
    
    public boolean remove(int val) { //
        if (!idxMap.containsKey(val)) return false;
        Set<Integer> idxSet = idxMap.get(val);
        int idxToBeRemoved = idxSet.iterator().next();
        if (idxSet.size() == 1)
            idxMap.remove(val);
        else idxSet.remove(idxToBeRemoved);
        int lastIdx = vals.size()-1;
        if (idxToBeRemoved != lastIdx) {
            int lastVal = vals.get(lastIdx);
            Set<Integer> lastIdxSet = idxMap.get(lastVal);
            lastIdxSet.add(idxToBeRemoved);
            lastIdxSet.remove(lastIdx);
            vals.set(idxToBeRemoved, lastVal);
        }
        vals.remove(lastIdx);
        return true;
    }
    
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
    
    public static void main(String[] args) {

        int []  a = new int []  {1,  1,  2,  2,  2,  3};
        int []  b = new int []  {1,  4,  5,  2,  5,  4};

        FindSumPairs s = new FindSumPairs(a, b);
        
    }
}
