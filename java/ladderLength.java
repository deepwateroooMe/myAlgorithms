import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class ladderLength {
    public static class Solution {

        public boolean diffOne(String one, String two) {
            int n = one.length();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (one.charAt(i) != two.charAt(i))
                    cnt++;
            }
            return cnt <= 1;
        }

        public class pos {
            StringBuilder val;
            int cnt;
            public pos() {
                val = new StringBuilder("");
                cnt = 0;
            }
            public pos pos(StringBuilder s, int x) {
                pos a = new pos();
                a.val = new StringBuilder(s);
                a.cnt = x;
                return a;
            }
        }

        // bfs find the shortest one
        public boolean bfs(String start, String end, Set<String> dict, List<Integer> tmp) {
            Queue<pos> q = new LinkedList<pos>();
            pos a = new pos();
            pos b = new pos();
            q.add(a.pos(new StringBuilder(start), 1));
            StringBuilder one;

            Set<String> set = new HashSet<String>();
            int n = start.length();
            int tmpa;
            
            while (!q.isEmpty()) {
                a = q.poll();
                for (int i = 0; i < start.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        one = new StringBuilder(a.val);
                        if (one.charAt(i) != j) 
                            one.setCharAt(i, j);
                        else continue;                        
                        if (dict.contains(one.toString())) {
                            if (set.contains(one.toString())) continue;
                            if (end.equals(one.toString())) {
                                tmp.add(0, a.cnt + 1);
                                return true;
                            } else {
                                tmpa = 0;
                                for (int x = 0; x < n; x++) {
                                    if (one.charAt(x) != end.charAt(x)) ++tmpa;
                                    if (tmpa >= 2) break;
                                }
                                if (tmpa == 1) {
                                    if (a.cnt + 2 < tmp.get(0).intValue())
                                        tmp.add(0, a.cnt + 2);
                                    return true;
                                }
                            }
                            q.add(b.pos(one, a.cnt+1));
                            set.add(one.toString());
                        }
                    }
                }
            }
            return false;
        }
        
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start.equals(end)) return 2;
            else if (dict.contains(end) && end.length() == 1) return 2;
            
            List<Integer> tmp = new ArrayList<Integer>(1);
            tmp.add(Integer.MAX_VALUE);   
            boolean done = bfs(start, end, dict, tmp);
            if (done)
                return tmp.get(0);
            return 0;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String start = "a";
        String end = "c";
        Set<String> dict = new HashSet<String>();
        String [] a = {"a","b","c"};
        for(String i : a)
            dict.add(i);
        int res = result.ladderLength(start, end, dict);

        System.out.println(res);
    }
}
/*
  // checking order matters,
  // pos mutate, if the same as original
  // if in the dict
  // if the end already
  // then next ...
  
  Input:	"hot", "dot", ["hot","dot","dog"]
Output:	4
Expected:	2

  Input:	"a", "c", ["a","b","c"]
Output:	3
Expected:	2

  // memory limit exceeded, not TLE ~~!!
  // changed HashMap to Set, removed diffOne helper function
  Last executed input:	"nape", "mild", ["dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"]
*/
