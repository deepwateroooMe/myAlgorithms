import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simplifyPath {
    public static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<String>();
            Stack<String> f = new Stack<String>();
            String [] s = path.split("\\/");
            StringBuffer res = new StringBuffer();
            if (s.length == 0) return res.append('/').toString();
            for (int i = s.length - 1; i >= 0; i--)
                if (!s[i].equals("")) {
                    stack.push(s[i]);
                }

            String tmp = "";
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                if (tmp.equals("."));
                else if (tmp.equals("..")) {
                    if (!f.isEmpty()) 
                        f.pop();
                } else f.push(tmp); 
            }

            if (!f.isEmpty()) {
                while (!f.isEmpty()) {
                    tmp = f.pop();
                    res.insert(0, tmp);
                    res.insert(0, "/");
                }
            } else 
                res.append('/');
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String path = "/abc/...";
        String res = result.simplifyPath(path);
        
        System.out.println(res);
    }
}
/*
  Input:	"/abc/..."
  Output:	"/..."
  Expected:	"/abc/..."

  Input:	"/..."
  Output:	"/"
  Expected:	"/..."
  // up: after two stack

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
