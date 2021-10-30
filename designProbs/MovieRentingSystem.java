// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class MovieRentingSystem {

    final Comparator<int []> cmp = (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]; // price, shop, movie
    final Map<Integer, Set<int []>> available = new HashMap<>(); // movie: [price, shop, movie]
    final Set<int []> rented = new TreeSet<>(cmp);
    final Map<Integer, Map<Integer, Integer>> prices = new HashMap<>(); // shop: [movie, price]

    public MovieRentingSystem(int n, int[][] entries) {
        for (int [] i : entries) {
            available.computeIfAbsent(i[1], z -> new TreeSet<>(cmp)).add(new int [] {i[2], i[0], i[1]});
            prices.computeIfAbsent(i[0], z -> new HashMap<>()).put(i[1], i[2]); 
        }
    }
    
    public List<Integer> search(int movie) {
        return available.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(i->i[1]).collect(Collectors.toList());
    }
    
    public void rent(int shop, int movie) {
        int [] item = {prices.get(shop).get(movie), shop, movie};
        available.get(movie).remove(item);
        rented.add(item);
    }
    
    public void drop(int shop, int movie) {
        int [] item = {prices.get(shop).get(movie), shop, movie};
        available.get(movie).add(item);
        rented.remove(item);
    }
    
    public List<List<Integer>> report() {
        return rented.stream().limit(5).map(i->List.of(i[1], i[2])).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {

        int [][] a = new int [][] {{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}};

        MovieRentingSystem s = new MovieRentingSystem(3, a);

        List<Integer> r = s.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
        
        s.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
        s.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
        s.report();   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
        s.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].

        List<Integer> r1 = s.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
        System.out.println("r1.size(): " + r1.size());
        System.out.println(Arrays.toString(r1.toArray()));
    }
}
