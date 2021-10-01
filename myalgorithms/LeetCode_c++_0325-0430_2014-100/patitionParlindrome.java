public class Solution {
    
    HashMap<String,Boolean> palindromes = new HashMap<String,Boolean>();
    HashMap< String, ArrayList< ArrayList<String> > > dict;

    public ArrayList<ArrayList<String>> partition(String s) {
        dict = new HashMap<String,ArrayList<ArrayList<String>>>();
        return partitionSub(s);
    }

    public ArrayList<ArrayList<String>> partitionSub(String s){
        if(dict.containsKey(s)) // if already have the result, 
            return dict.get(s);     // return it, don't recalculate

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s.length()==0)
            res.add(new ArrayList<String>());  //if s is empty, start a new list
        else
            for(int i = 1; i <= s.length(); i++){    //for each possible starting palidrome
                String start = s.substring(0,i);
                if(isPalindrome(start)) {         //if not a palindrome, skip it
                    ArrayList<ArrayList<String>> part = partitionSub(s.substring(i));  //partition remaining string
                    for(ArrayList<String> sample : part){
                        ArrayList<String> added = new ArrayList<String>(sample);
                        added.add(0,start);   //add starting palindrome to each partial solution
                        res.add(added);
                    }
                }
            }
        dict.put(s,res);     //store result for future checks
        return res;
    }

    //check if s is a palindrome, might be skippable in interviews
    public boolean isPalindrome(String s){            
        if(palindromes.containsKey(s))
            return (palindromes.get(s)).booleanValue();
        int m=0;
        int n=s.length()-1;
        while(m<n){
            if(s.charAt(m++)!=s.charAt(n--)){
                palindromes.put(s,new Boolean(false));
                return false;
            }
        }
        palindromes.put(s,new Boolean(true));
        return true;
    }
    
}
