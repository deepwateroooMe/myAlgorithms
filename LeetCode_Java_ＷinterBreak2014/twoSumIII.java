import java.util.HashMap;
import java.util.Map;

public class twoSumIII {
    public static class TwoSum {
        private Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        public void add(int number) {
            hash.put(number, hash.containsKey(number) ? hash.get(number)+1 : 1);
            /*
            if (hash.containsKey(number)) {
                hash.put(number, hash.get(number)+1);
            } else {
                hash.put(number, 1);
            }
            */
        }

        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
                int key = entry.getKey();
                int second = value - key;
                if ( (key == second && entry.getValue() > 1) ||
                     (key != second && hash.containsKey(second)) ) {
                    return true;
                }
            }
            return false;
            /*
            int second;
            for (Integer key : hash.keySet()) {
                second = value - key;
                    
                if (hash.containsKey(second)) {
                    if (second != key || (second == key && hash.get(second) > 1)) {
                        return true;
                    } 
                } 
            }
            return false;
            */
        }
    };
        
    public static void main(String[] args) {
       TwoSum result = new TwoSum();
        result.add(1);
        result.add(-1);
        result.add(5);
                
        //System.out.println(result.find(4));
        System.out.println(result.find(0));
        //System.out.println(result.find(7));
    }
}
