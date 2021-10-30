// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class UndergroundSystem {

    // static Map<String, List<int []>> cin; // bug bug bug: 不知道自己哪里写得不对
    // static Map<String, List<int []>> cout;
    // public UndergroundSystem() {
    //     cin = new HashMap<>();
    //     cout = new HashMap<>();
    // }
    // public void checkIn(int id, String stationName, int t) {
    //     cin.computeIfAbsent(stationName, k -> new ArrayList<>()).add(new int [] {id, t});;
    // }
    // public void checkOut(int id, String stationName, int t) {
    //     cout.computeIfAbsent(stationName, k -> new ArrayList<>()).add(new int [] {id, t});
    // }
    // private int binarySearch(List<int []> li, int v, int l, int r) {
    //     if (l == r) return li.get(l)[0] == v ? l : -1;
    //     if (l == r-1) return li.get(l)[0] == v ? l : (li.get(r)[0] == v ? r : -1);
    //     int m = l + (r-l)/2;
    //     if (li.get(m)[0] >= v) return binarySearch(li, v, l, m);
    //     return binarySearch(li, v, m+1, r);
    // }
    // public double getAverageTime(String startStation, String endStation) {
    //     long sum = 0;
    //     int i= 0, cnt = 0;
    //     List<int []> sout = cout.get(endStation);
    //     List<int []> sin = cin.get(startStation);
    //     Collections.sort(sin, (a, b) -> a[0] - b[0]);
    //     Collections.sort(sout, (a, b) -> a[0] - b[0]);
    //     if (sin.size() <= sout.size()) 
    //         for (int [] one : sin) {
    //             i = binarySearch(sout, one[0], 0, sout.size()-1);
    //             if (i != -1) {
    //                 sum += sout.get(i)[1] - one[1];
    //                 ++cnt;
    //             }
    //         }
    //     else for (int [] one : sout) {
    //             i = binarySearch(sin, one[0], 0, sin.size()-1);
    //             if (i != -1) { // binarySearch returned wrong idx ?
    //                 sum += one[1] - sin.get(i)[1];
    //                 ++cnt;
    //             }
    //         }
    //     return (double)(sum / (double)cnt);
    // }

    Map<Integer, String []> entry = new HashMap<>();
    Map<String, double []> store = new HashMap<>();
    public UndergroundSystem() {
        entry = new HashMap<>();
        store = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        entry.put(id, new String [] {stationName, ""+t});
    }
    public void checkOut(int id, String stationName, int t) {
        String bgn = entry.get(id)[0];
        int check = Integer.parseInt(entry.get(id)[1]);
        String key = bgn + "-" + stationName;
        if (store.containsKey(key)) {
            double [] tmp = store.get(key);
            tmp[0] += (double)(t - check);
            tmp[1]++;
            store.put(key, tmp);
        } else store.put(key, new double [] {t-check, 1});
    }
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        return (double)(store.get(key)[0] / store.get(key)[1]);
    }

    public static void main(String[] args) {
        UndergroundSystem s = new UndergroundSystem();

        s.checkIn(596854,"EQH524YN",13);
        s.checkIn(29725,"Y1A2ROGU",17);
        s.checkOut(596854,"8AYN1B7O",115);
        s.checkIn(579716,"EQH524YN",145);
        s.checkOut(579716,"8AYN1B7O",199);
        s.checkOut(29725,"8AYN1B7O",295);
        s.checkIn(939079,"16MTS56Z",371);

        double r = s.getAverageTime("EQH524YN","8AYN1B7O");
        System.out.println("r: " + r);

        double r2 = s.getAverageTime("Y1A2ROGU","8AYN1B7O");
        System.out.println("r2: " + r2);
        
        s.checkIn(697035,"EQH524YN",442);
        s.checkIn(90668,"Y1A2ROGU",508);
        double r3 = s.getAverageTime("EQH524YN","8AYN1B7O");
        System.out.println("r3: " + r3);
        
    }
}
