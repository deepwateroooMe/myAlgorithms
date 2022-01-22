import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import javafx.util.Pair;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class graph {
    public static class Solution {

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{3,4,5},{3,2,6},{2,2,1}};
        int [][] a = new int [][] {{9,9,4},{6,6,8},{2,1,1}};

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }
        int res = s.longestIncreasingPath(a);
        System.out.println("res: " + res);
    }
}
