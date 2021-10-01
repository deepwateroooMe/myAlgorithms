// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class SnapshotArray {

    List<List<int []>> ll;
    int idx = -1;
    public SnapshotArray(int length) {
        ll = new ArrayList<>();
        for (int i = 0; i < length; i++) 
            ll.add(new ArrayList<>());
    }
    
    public void set(int index, int val) {
        if (ll.get(index).size() == 0)
            if (idx == -1) ll.get(index).add(new int [] {0, val});
            else ll.get(index).add(new int [] {idx, val});
        else {
            if (idx == -1) ll.get(index).set(0, new int [] {0, val});
            else ll.get(index).add(idx+1, new int [] {idx+1, val});
        }
        // System.out.println("ll.size(): " + ll.size());
        // for (int z = 0; z < ll.size(); ++z) {
        //     for (int y = 0; y < ll.get(z).size(); y++) 
        //         System.out.print(ll.get(z).get(y)[0] + "," + ll.get(z).get(y)[1] + "|,   ");
        //     System.out.print("\n ");
        // }
    }
    
    public int snap() {
        ++idx;
        return idx;
    }
    
    public int get(int index, int snap_id) {
        return ll.get(index).get(snap_id)[1];
    }
    
    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(1);

        s.set(0, 5);
        s.snap();
        s.set(0, 6);
        // s.set(0, 13);
        int r = s.get(0, 0);
        System.out.println("r: " + r);
    }
}

// ["SnapshotArray","set","snap","set","get"]
// [[3],[0,5],[],[0,6],[0,0]]

// ["SnapshotArray","set","set","set","snap","get","snap"]
// [[1],[0,4],[0,16],[0,13],[],[0,0],[]]