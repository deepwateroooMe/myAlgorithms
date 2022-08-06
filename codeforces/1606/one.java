// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStreamReader;

public class one {
    public static class solution {
        
        public String getMin(String s) {
            int n = s.length(), ca = 0, cb = 0;
            for (int i = 0; i+2 <= n; i++) 
                if (s.substring(i, i+2).equals("ab")) ca++;
                else if (s.substring(i, i+2).equals("ba")) cb++;
            if (ca == cb) return s;
            int min = Math.min(ca, cb), max = Math.max(ca, cb);
            String cur = "";
            if (ca > cb) cur = "ab";
            else cur = "ba";
            int cnt = 0, i = 0;
            StringBuilder sb = new StringBuilder(s);
            for (i = 0; i+2 <= n; i += 2) 
                if (s.substring(i, i+2).equals("ab")) {
                    cnt++;
                    if (cnt == min) break;
                }
            for (; i+2 < n; i += 2) {
                if (s.substring(i, i+2).equals(cur)) 
                    if (i > 0 && s.charAt(i-1) == 'a') {
                        sb.setCharAt(i, 'a');
                        sb.setCharAt(i+1, 'a');
                    } else {
                        sb.setCharAt(i, 'b');
                        sb.setCharAt(i+1, 'b');
                    }
            }
            return sb.toString();
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("onesur.txt");
        Scanner scanner = new Scanner(path);
        String line = scanner.nextLine();
        int tests = Integer.parseInt(line);
        String [] sur = new String [tests];
        int cnt = 0, idx = 0;
        while(scanner.hasNextLine()) 
            sur[idx++] = scanner.nextLine();
        scanner.close();
        System.out.println(Arrays.toString(sur));
        for (int i = 0; i < tests; i++) {
            String sb = s.getMin(sur[i]);
            System.out.println("sb: " + sb);
        }
    }

/*
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  int tests = 0;
  String [] sur = new String [5];
  int cnt = 0, idx = 0;
  while (cnt < 5) {
  sur[idx++] = reader.readLine();
  cnt++;
  }
  System.out.println(Arrays.toString(sur));
  for (int i = 1; i < 5; i++) {
  String [] cur = sur[i].split("\\s+");
  int m = Integer.parseInt(cur[0]), n = Integer.parseInt(cur[1]);
  int sb = s.getMinTime(m, n);
  }
*/
}
