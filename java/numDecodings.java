import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class numDecodings {
    public static class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
            else if (s.charAt(0) == '0') return 0;
            else if (s.length() == 1) return 1;
            else if (s.length() >= 2 && s.charAt(0) - '0' > 2 && s.charAt(1) == '0') return 0;
            
            int j = 0; // idx for s
            char c;    // char at pos j
            int [] res = new int[s.length()];
            res[0] = 1;
            res[1] = 1;
            if (s.charAt(1) != '0'
                && ( (s.charAt(0) == '1'
                      || (s.charAt(0) == '2') && s.charAt(1) - '0' < 7)))
                res[1] = 2;
            
            for (int i = 2; i < s.length(); i++) {
                c = s.charAt(i);
                if (c != '0')
                    res[i] += res[i - 1]; // separate dijit // except '0', NO, 10, 20 ok

                switch (c) {
                case '0':
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                        if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')
                            res[i] = res[i - 2];  // 110 = 1 10, ... 11 0, NO~!
                        else
                            res[i] = res[i - 1]; 
                    else return 0;
                    break;
                case '7':     // 17, 18, 19
                case '8':
                case '9':
                    if (s.charAt(i - 1) == '1')
                        res[i] += res[i - 2];
                    break;
                default:     // 1, 2, 3, 4, 5, 6: Individual, 1-pre, 2-pre, 11, 21, 12, 22 ...
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                        res[i] += res[i - 2];
                    break;
                }
            }
            return res[s.length() - 1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "301";
        int res = result.numDecodings(s);
        
        System.out.println(res);
    }
}

/*
  Input:	"301"
Output:	1
Expected:	0

  Input:	"110"
Output:	2
Expected:	1

  Input:	"100"
Output:	1
Expected:	0

  Input:	"27"
Output:	2
Expected:	1

  Input:	"10"
Output:	2
Expected:	1
 */
