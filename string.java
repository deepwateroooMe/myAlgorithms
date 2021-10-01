// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class string {
    public static class Solution {

        public static int base = 256;
        public static int module = 101;

        public static boolean match(String str1,String str2) {
            assert str1.length() == str2.length();
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i)! = str2.charAt(i))
                    return false; 
            }
            return true; 
        }
    
        public static int hash(String str) {
            int hash = 0; 
            for (int i = 0; i < str.length(); i++)
                hash = (hash*base+str.charAt(i))/module; 
            return hash; 
        }
    
        public int strStr(String haystack, String needle) {
            if (needle == "" || needle.length() == 0)
                return 0; 
            int n = haystack.length(), m = needle.length(); 
            int targetHash = hash(needle); 
            for (int i = 0; i < n-m+1; i++) {
                String str = haystack.substring(i,i+m); 
                if (hash(str) == targetHash)
                    if (match(str,needle))
                        return i; 
            }
            return -1; 
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution(); 
        char [][] a = new char [][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};  
        String [] b = new String []  {"oath", "pea", "eat", "rain"}; 
        System.out.println("a.length: " + a.length); 
        for  (int z = 0;  z  <  a.length;  ++z) {
            for  (int w = 0;  w  <  a[z].length;  w++) 
                System.out.print(a[z][w] + ", "); 
            System.out.print("\n"); 
        }
        System.out.println("b.length: " + b.length); 
        for  (int z = 0;  z  <  b.length;  ++z) 
            System.out.print(b[z] + ", "); 
        System.out.println(""); 

        List < String> res = s.findWords(a, b); 
        System.out.println("res.size(): " + res.size()); 
        for  (int z = 0;  z  <  res.size();  ++z) 
            System.out.print(res.get(z) + ", "); 
        System.out.print("\n"); 
    }
}