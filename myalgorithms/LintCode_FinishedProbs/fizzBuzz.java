import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public static class Solution {
        /**
         * param n: As description.
         * return: A list of strings.
         */
        public ArrayList<String> fizzBuzz(int n) {
            ArrayList<String> results = new ArrayList<String>();
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    results.add("fizz buzz");
                } else if (i % 5 == 0) {
                    results.add("buzz");
                } else if (i % 3 == 0) {
                    results.add("fizz");
                } else {
                    results.add(String.valueOf(i));
                }
            }
            return results;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 15;
        ArrayList<String> res = result.fizzBuzz(n);
        
        System.out.println(res);
    }
}
