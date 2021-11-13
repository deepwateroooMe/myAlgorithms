// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.stream.Collectors.toMap;

public class one {
    public static class solution {

        public int getCost(char [] s, char [] t) {
            int m = s.length, n = t.length;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) 
                map.put(s[i], i);
            int ans = 0;
            for (int i = 1; i < n; i++) 
                ans += Math.abs(map.get(t[i]) - map.get(t[i-1]));
            return ans;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

// Path path = Paths.get("onesur.txt");
//         Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        int tests = Integer.parseInt(in.nextLine());
        // System.out.println("tests: " + tests);
        String [] sur = new String [2 * tests];
        for (int i = 0; i < 2 * tests; i++) 
            sur[i] = in.nextLine();
        // System.out.println(Arrays.toString(sur));
        in.close();
        int idx = 0;
        for (int i = 0; i < tests; i++) {
            String ss = sur[idx++];
            String t = sur[idx++];
            int v = s.getCost(ss.toCharArray(), t.toCharArray());
            System.out.println(v);
        }

    }
}
