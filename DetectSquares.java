// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javafx.util.Pair;
import static java.util.stream.Collectors.toMap;

public class DetectSquares {

    Map<Integer, Integer> pt;
    Set<int []> ts;

    public DetectSquares() {
        pt = new HashMap<>();
        ts = new TreeSet<>((a, b)->a[0]-b[0]);
    }
    
    public void add(int[] point) {
        int key = point[0] * 1000 + point[1];
        pt.put(key, pt.getOrDefault(key, 0) + 1);
        ts.add(point);
    }
    
    public int count(int[] point) {
        
    }
    
    public static void main(String[] args) {
        DetectSquares s = new DetectSquares();

    }
}