import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simplifyPath {
    // don't like array at all, why bother using array instead of two stack like minStack() ?
    public static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<String>();
            String [] s = path.split("\\/");
            StringBuffer res = new StringBuffer();
            if (s.length == 0) return res.append('/').toString();

            //System.out.println("s.length: " + s.length);
            for (int i = s.length - 1; i >= 0; i--)
                if (!s[i].equals("")) {
                    stack.push(s[i]);
                    //System.out.println("s[i]: " + s[i]);
                }

            int cnt = -1;
            String tmp = "";
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                System.out.println("tmp 0: " + tmp);
                if (stack.isEmpty())
                    if (!tmp.equals(".") && !tmp.equals("..")) 
                        s[++cnt] = tmp;
                    else {
                        res.append('/');
                        return res.toString();
                    }
                else if (!stack.isEmpty() && stack.peek().equals(".."))
                    if (cnt == -1)
                        tmp = stack.pop();
                    else {
                        tmp = stack.pop();
                        while (!stack.isEmpty() && tmp.equals("..") && cnt > -1)
                            tmp = stack.pop();
                        continue;
                    }
                else if (!stack.isEmpty() && stack.peek().equals(".")) {
                    s[++cnt] = tmp;
                    while (!stack.isEmpty() && stack.peek().equals(".")) {
                        tmp = stack.pop();
                    }
                } else {
                    s[++cnt] = tmp;
                    //System.out.println("tmp 1: " + tmp);
                }
                System.out.println("cnt: " + cnt);
                System.out.println("");
            }
            res.append('/');
            if (!tmp.equals(".") && !tmp.equals("..") && cnt == -1) {
                res.append(tmp);
                return res.toString();
            }
            System.out.println("cnt: " + cnt);
            if (cnt == -1) return res.toString();
            for (int i = 0; i <= cnt; i++) {
                res.append(s[i]);
                res.append('/');
            }
            return res.toString().substring(0, res.length()-1);
        }
    }
    public static void main(String[] args){
        Solution result = new Solution();
        String path = "/a/./b/../../c/";
        String res = result.simplifyPath(path);
        
        System.out.println(res);
    }
}
/*
  Input:	"/a/./b/../../c/"
  Output:	"/"
  Expected:	"/c"

  "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"
      
  Runtime Error Message:	Line 51: java.lang.ArrayIndexOutOfBoundsException: -1
  Last executed input:	"/.///../JY"
      
  "/home/../../.."
      
  Runtime Error Message:	Line 35: java.util.EmptyStackException
  Last executed infput:	"/Hhp/..///f/R///FM/DPPv///..//"

  Runtime Error Message:	Line 39: java.util.EmptyStackException
  Last executed input:	"/hzx/.././BVHm/../././..//"

  Input:	"/abc/..."
  Output:	"/..."
  Expected:	"/abc/..."

  Runtime Error Message:	Line 64: java.lang.ArrayIndexOutOfBoundsException: -1
  Last executed input:	"/..."

  Input:	"/home/foo/.ssh/../.ssh2/authorized_keys/"
  Output:	"/authorized_keys"
  Expected:	"/home/foo/.ssh2/authorized_keys"
*/
