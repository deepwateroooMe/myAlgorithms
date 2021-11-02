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
        public int getMinTime(int x, int y) { // [1, x]
            Set<Integer> vis = new HashSet<>();
            int cnt = 0, ans = 0;
            vis.add(1);
            int next = 2, size = 0;
            Set<Integer> sn = new HashSet<>();
            while (vis.size() < x && next <= x) {
                sn.clear();
                for (Integer v : vis) {
                    sn.add(next);
                    next += 1;
                    while (vis.contains(next) || sn.contains(next)) next++;
                    cnt++;
                    if (cnt == y) {
                        cnt = 0;
                        break;
                    }
                }
                ans++;
                vis.addAll(sn);
            }
            return ans;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("onesur.txt");
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);

        }
        scanner.close();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java-read-text-file.html


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
            int ans = s.getMinTime(m, n);
        }
        */
    }
}