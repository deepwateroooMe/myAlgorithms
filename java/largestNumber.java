import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class largestNumber {
    public static class Solution {
        public String largestNumber(int[] num) {
            List<String> ones = new ArrayList<String>(num.length);
            for (int i : num) 
                ones.add(String.valueOf(i));
            
            Collections.sort(ones, new Comparator<String>(){
                    @Override
                        public int compare(String a, String b) {
                        if (a.length() == b.length())
                            return b.compareTo(a);
                        else {
                            String ab = a + b;
                            String ba = b + a;
                            return ba.compareTo(ab);
                        }
                    }
                });
            if (ones.get(0).equals("0")) return "0";  /// ...
            
            StringBuffer res = new StringBuffer();
            for (String i : ones) 
                res.append(i);
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 0};
        String res = result.largestNumber(a);

        System.out.println(res);
    }
}
/*
  Input:	[0,0]
Output:	"00"
Expected:	"0"

 */
