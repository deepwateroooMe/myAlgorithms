// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class two {
    public static class solution {

        private boolean poss(int [] arr, int k, int target) {
            int [] dp = new int [target + 1];
            Arrays.fill(dp, target+1);
            dp[0] = 0;
            for (int i = 0; i <= target; i++) {
                for (Integer v : arr) {
                    if (i - v < 0) continue;
                    dp[i] = Math.min(dp[i], dp[i-v]+1);
                }
            }
            return (dp[target] == target+1 || dp[target] > k) ? false : true;
        }
        public int getNextImpossible(int [] arr, int n, int k) {
            int sum = Arrays.stream(arr).sum();
            int next = 1;
            while (poss(arr, k, next)) next++;
            return next;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt(), n = 2 * tests;
		sc.nextLine();  
		String [] arr = new String[n];
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextLine();
        for (int i = 0; i < n; i += 2) {
            String [] cur = arr[i].split("\\s+");
            int x = Integer.parseInt(cur[0]), k = Integer.parseInt(cur[1]);
            String [] b = arr[i+1].split("\\s+");
            int [] aval = new int [b.length];
            for (int j = 0; j < b.length; j++) 
                aval[j] = (int)Math.pow(10, Integer.parseInt(b[j]));
            int v = s.getNextImpossible(aval, x, k);
        }
    }
}