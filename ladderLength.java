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

        public boolean diffOne(String one, String two) {
            int n = one.length();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (one.charAt(i) != two.charAt(i))
                    cnt++;
            }
            return cnt <= 1;
        }
        
        // bfs find the shortest one
        public boolean bfs(String start, String end, Set<String> dict, int [] tmp) {
            Queue<pos> q = new LinkedList<pos>();
            pos a = new pos();
            pos b = new pos();
            q.add(a.pos(new StringBuilder(start), 1));
            StringBuilder one, two;
            Map<String, Boolean> hash = new HashMap<String, Boolean>();

            while (!q.isEmpty()) {
                a = q.poll();
                if (diffOne(a.val.toString(), end)) {
                    tmp[0] = a.cnt + 2;
                    return true;
                }
                for (int i = 0; i < start.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        one = new StringBuilder(a.val);
                        if (one.charAt(i) != j)
                            one.setCharAt(i, j);
                        else continue;
                        if (dict.contains(one.toString())) {
                            if (hash.containsKey(one.toString())) continue;
                            if (diffOne(one.toString(), end)) {
                                tmp[0] = a.cnt + 2;
                                return true;
                            }
                            q.add(b.pos(one, a.cnt+1));
                            hash.put(one.toString(), true);
                        }
                    }
                }
            }
            return false;
        }
        
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start.equals(end)) return 2;
            int [] tmp = new int[2];
            tmp[0] = 1; // for min
            boolean done = bfs(start, end, dict, tmp);
            if (done)
                return tmp[0];
            return 0;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        String [] a = {"hot","dot","dog","lot","log"};
        for(String i : a)
            dict.add(i);
        int res = result.ladderLength(start, end, dict);

        System.out.println(res);
    }
}
/*
  // memory limit exceeded
  
Last executed input:	"nape", "mild", ["dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"]
*/
