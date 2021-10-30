// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.TreeSet;

public class Bank {

    long [] arr;
    int n;
    public Bank(long[] balance) {
        n = balance.length;
        arr = Arrays.copyOf(balance, balance.length);
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > n || account2 < 1 || account2 > n || arr[account1-1] < money) return false;
        arr[account1-1] -= money;
        arr[account2-1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (account < 1 || account > n) return false;
        arr[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account < 1 || account > n || arr[account-1] < money) return false;
        arr[account-1] -= money;
        return true;
    }
    
    public static void main(String[] args) {
        long []  a = new long []  {10,  100,  20,  50,  30};

        Bank s = new Bank(a);
        
    }
 }
