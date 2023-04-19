import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
public class swapNodesPairs {
    public static class Solution {
        // public ListNode swapNodesPairs(ListNode head) {
        //     ListNode dummy = new ListNode(0);
        //     dummy.next = head;
        //     ListNode p = head;
        //     ListNode prev = dummy;
        //     ListNode q, r;
        //     while (p != null && p.next != null) {
        //         q = p.next;
        //         r = p.next.next;
        //         prev.next = q;
        //         q.next = p;
        //         p.next = r;
        //         prev = p;
        //         p = r;
        //     }
        //     return dummy.next;
        // }

        public static boolean shouldWeWakeUp(boolean barking, int hourOfDay) {
            if (hourOfDay < 0 || hourOfDay > 23) return false;
            if (barking && ( hourOfDay < 8 || hourOfDay > 22)) return true;
            return false;
        }
        public static String printEqual(int num1, int num2, int num3) {
            if (num1 < 0 || num2 < 0 || num3 < 0)
                return "Invalid value";
            if (num1 == num2 && num1 == num3)
                return "All numbers are equal";
            else if (num1 != num2 && num1 != num3)
                return "All numbers are different";
            else
                return "Neither all are equal of different";
        }
        
        public boolean hasEqualSum(int num1, int num2, int num3) {
            return (num1 + num2 == num3) ? true : false;
            
        }
        
        public String numberInWord(int num) {
            // StringdsBuilder res = new StringdsBuilder();
            // if (num >= 0 && num <= 5)
            //     res = String.valueOf(num);
            // return res.toString();
            String res;
            switch (num) {
            case 0:
                res = "Zero";
                break;
            case 1:
                res = "One";
                break;
            case 2:
                res = "Two";
                break;
            case 3:
                res = "THREE";
                break;
            case 4:
                res = "FOUR";
                break;
            case 5:
                res = "FIVE";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                res = "Other";
                break;
            default:
                res = "";
                break;
            }
            return res;
            
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.printEqual(1, 1, 2));

        // System.out.println(s.nuInWord(0));
        // System.out.println(s.numberInWord(5));
        // System.out.println(s.numberInWord(3));
        // System.out.println(s.numberInWord(6));
        // System.out.println(s.numberInWord(10));
        // System.out.println(s.numberInWord(11));
    }
}