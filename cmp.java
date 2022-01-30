// import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        // public int findFinalValue(int[] a, int ori) {
        //     int n = a.length, ans = ori;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     while (s.contains(ori)) {
        //         ori *= 2;
        //         ans = ori;
        //     }
        //     return ans;
        // }

        // public List<Integer> maxScoreIndices(int[] arr) {
        //     int m = arr.length, n = m + 2, max = 0, tmp = 0;
        //     int [] a = new int [n], sum = new int [n];
        //     System.arraycopy(arr, 0, a, 1, m);
        //     a[0] = 1;
        //     a[n-1] = 0;
        //     System.arraycopy(a, 0, sum, 0, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     List<Integer> ans = new ArrayList<>();
        //     int [] cnt = new int [n];
        //     for (int i = 1; i < n; i++) {
        //        cnt[i] = sum[n-1] - sum[i-1] + i - sum[i-1];
        //         max = Math.max(max, cnt[i]);
        //     }
        //     for (int i = 1; i < n; i++) 
        //         if (cnt[i] == max) ans.add(i-1);
        //     return ans;
        // }

        // public String subStrHash(String t, int pow, int mod, int k, int hval) {
        //     long [] p = new long [k+1];
        //     p[0] = 1;
        //     for (int i = 1; i <= k; i++) 
        //         p[i] = p[i-1] * pow % mod;
        //     String tt = new StringBuilder(t).reverse().toString();
        //     char [] s = tt.toCharArray();
        //     List<String> ls = new ArrayList<>();
        //     long hash = 0;
        //     for (int i = 0; i < k; i++) 
        //         hash = (hash * pow % mod + s[i] - 'a' + 1 + mod) % mod;
        //     if ((int)hash == hval) ls.add(tt.substring(0, k));
        //     for (int i = k; i < t.length(); i++) {
        //         hash = ((hash - (s[i-k] - 'a' + 1) * p[k-1] % mod + mod) * pow % mod + s[i] - 'a' + 1 + mod) % mod;
        //         if ((int)hash == hval) ls.add(tt.substring(i-k+1, i+1));
        //     }
        //     return new StringBuilder(ls.get(ls.size()-1)).reverse().toString();
        // }

        public int[] groupStrings(String[] sa) { // 71/97 passed
            int n = sa.length, cur = 0; 
            DSU uf = new DSU(n);
            Map<Integer, Set<Integer>> cnt = new HashMap<>();
            boolean connected = false;
            for (int i = 0; i < n; i++) {
                cur = getMask(sa[i]);
                if (i == 0) {
                    cnt.computeIfAbsent(cur, z -> new HashSet<>()).add(i);
                    // cnt.put(cur, i);
                    continue;
                }
                // if (cnt.keySet().contains(cur)) { // 特殊情况：完全相等
                //     uf.union(i, cnt.get(cur));
                //     continue;
                // }
                connected = false;
                for (Integer key : cnt.keySet()) {
                    int v = key ^ cur;
                    // if (v == 0) {
                    //     uf.union(i, (int)((Integer)cnt.get(key).iterator().next()));
                    //     break;
                    // }
                    // if (v == 0 || Integer.bitCount(v) == 1 && Math.abs(sa[i].length() - sa[cnt.get(key)].length()) == 1
                    // || Integer.bitCount(v) == 2 && Math.abs(sa[i].length() - sa[cnt.get(key)].length()) == 0) {
                    for (int idx : cnt.get(key)) {
                        if (Integer.bitCount(v) == 1 && Math.abs(sa[i].length() - sa[idx].length()) == 1
                            || (Integer.bitCount(v) == 2 || Integer.bitCount(v) == 0) && Math.abs(sa[i].length() - sa[idx].length()) == 0) {
                            System.out.println("\n i: " + i);
                            System.out.println("cnt.get(key): " + cnt.get(key));
                            uf.union(i, idx);
                            // connected = true;
                            break;
                        }
                        if (connected) break;
                    }
                    if (connected) break;
                }
                cnt.computeIfAbsent(cur, z -> new HashSet<>()).add(i);
                // cnt.put(cur, i);
            }
            return new int [] {uf.getCnt(), uf.getLargestComponnetCnt()};
        }
        int getMask(String t) {
            char [] s = t.toCharArray();
            int ans = 0;
            for (int i = 0; i < t.length(); i++) 
                ans |= 1 << (s[i] - 'a');
            return ans;
        }
        static class DSU {
            int [] par;
            int [] rank; // 关于 rank 和 size 的部分
            int size;
            public boolean union(int x, int y) {
                int px = find(x), py = find(y);
                if (px == py) return false;
// if (rank[x] >= rank[y]) { // BUG
                if (rank[px] >= rank[py]) {
                    par[py] = px;
                    if (rank[px] == rank[py])
                        ++rank[px];
// rank[x] += rank[y]; // BUG: 这里自己写错了
                } else {
                    par[px] = py;
// rank[y] += rank[x];
                }
                --size;
                return true;
            }
            public int getCnt() {
                return size;
            }
            int find(int x) {
// if (par[x] != x) par[x] = find(par[x]); // BUG
                while (par[x] != x) {
                    par[x] = par[par[x]];
                    x = par[x];
                }
                return par[x];
            }
            public int getLargestComponnetCnt() {
                for (int i = 0; i < par.length; i++) find(i);
                Map<Integer, Integer> cnt = new HashMap<>();
                int max = 0;
                for (int i = 0; i < par.length; i++) {
                    cnt.put(par[i], cnt.getOrDefault(par[i], 0) + 1);
                    // max = Math.max(max, cnt.get(par[i]));
                }
                return Collections.max(cnt.values());
                // return max;
            }
            public DSU(int n) {
                size = n;
                par = new int [n];
                rank = new int [n];
                for (int i = 0; i < n; i++)
                    par[i] = i;
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // String []  a = new String []  {"qamp", "am", "khdrn"};
        // String [] a = new String [] {"ghnv","uip","tenv","hvepx","e","ktc","byjdt","ulm","cae","ea"};
        String [] a = new String [] {"dj", "ecswxv", "ujnmvy", "btyza", "dljmkaz", "ovjy", "ajdxgosnlmp", "iqtnymusr", "jpfqx", "fo", "oivahsbej", "padchmjonvrw", "pot", "pr", "yl", "uy", "k", "sn", "akqvsfrlxhniy", "fucgy", "hv", "iu", "qcb", "d", "ovwkuq", "uklstbpvnoaydj", "wqvmtfius", "f", "gryumas", "jxefythb", "uej", "d", "ewlirvydspgnzxc", "bem", "dsjzlpvtfume", "kxwgarz", "whsnjgef", "g", "vmycjb", "rpyckafivm", "brufxntcpghqyjs", "pscgxqykj", "toz", "jxiuaehmoycpf", "zubcsvflm", "l", "nbes", "engilwdbv", "ujpwmbdegvcha", "g", "nrvazpxsgfet", "qiyworsanb", "fdrskpwyvho", "qsrhkeunbdlo", "aiub", "efqzdvoawhnckym", "dvzosebrjy", "zydfevx", "bjtmzpg", "bj", "gznfrdlmxacpws", "bwyvhkdxzi", "tikbwgodrmanc", "badezyqlsgjmp", "mfqesrznbpvxwl", "qcpxvmjbhkuzdo", "ztwqo", "pgmeacdtbvlfwhs", "u", "j", "cdtgbmfiaxnyqe", "xrq", "t", "ugmcisdfvhapkn", "xkfvitucwrjndaq", "kmlzxftou", "vuphizdtbcw", "lqanovukxtr", "nxmpzivqbcu", "jyixvqcrwm", "eavzrgojlq", "ofzwvegqn", "rbcqlmnzou", "tludkceqvasmp", "g", "pobeirza", "uxhgwla", "irnauzqpt", "zuhfqnlskejc", "uzhtgjepby", "cekymrtpwbv", "oxkzviatulrwnem", "nqyi", "ewlvxqufoiy", "mqthaey", "nel", "rosgtypemxqlbwk", "nia", "yeablxwgt", "vnkqsxjughoday", "jlegbiwpfzqanvc", "ikcofu", "khrs", "auqihrdsnfz", "hju", "to", "jeyosha", "guyc", "xyobjmvp", "feogsl", "vhtcal", "pfbklge", "nmwijx", "yhdlwmos", "zajdcrypvgol", "xzyos", "qubyht", "czkd", "jciewlamyr", "gbjmq", "k", "pax", "svgxocydrqnmu", "jmfrtnz", "cmq", "ytgqfkhalxjizc", "ubx", "vaobhcd", "sjywtlgcqmp", "cybifp", "cvzflndgy", "cer", "cwyevgtxjapdq", "jcmzqiwsaen", "ozlwjf", "ajgk", "gsyktma", "gstznoadwhcy", "kb", "yagfxduepon", "sideoytluh", "algouidbnqmkfz", "lwzadfkpixe", "cduaflzgo", "wuxhfbk", "latbfqn", "eubnxifcorpqa", "kwbomtjyvnqz", "puqfhc", "xgwkiszjnvdc", "xwfomql", "elihmgfjqwatnro", "irbg", "lgio", "cuhovknbefgdt", "xuqwsvgpykbtld", "gku", "btl", "ombniufgthavlc", "qfzhludnvrijg", "uiqoazhfebvd", "upcraqxbghmo", "yef", "fcnakqxz", "xtq", "l", "ibsxv", "gyn", "otyapbkelfiwv", "wevpoukgsfdzil", "ceszidghyvm", "x", "kxmwtlg", "faezqusvhnd", "gfz", "ocgqrmvif", "civkuzlamyow", "a", "zmd", "gruiwnbhlkxtvde", "dosvzyituwjfb", "zftrjg", "cidyw", "movbkjclgnx", "fcwvlqokgrz", "f", "dtrw", "meudhyaqok", "jypngmzksd", "bzulrnqxjemvwos", "vndarwepiku", "gaoiutmdfwzhbx", "tm", "jh", "s", "klers", "cikhptbjowgav", "qftxpbnucdvzs", "lvdpqgxknwte", "mx", "ipxqdwbasghz", "fscyjzl", "yedb", "fmcx", "wiqrc", "tohvi", "gomy", "salg", "rwceoqztdnub", "ez", "kdbw", "m", "y", "qaho", "efuxrtzyqoniwja", "awodncypjme", "nocqwrjepifuds", "rhxzjmfea", "mges", "naespl", "xjznftmkwvuciq", "jpouklcqrm", "ophckegsb", "gujitzp", "hn", "gkayxzu", "ghqdpaxim", "erc", "efm", "rjbquvz", "gfvruzhkonx", "svo", "hunoaczx", "hn", "oskcuba", "jwzrufpxya", "xwegbkaopc", "duiztlnqahejb", "qzcfiyhawu", "gldofvbmrhjaupw", "a", "hnjgimrzx", "jivdhezao", "bwzoftryhgxi", "t", "ujn", "ehq", "t", "ehmtpkxn", "gfidjxpcm", "khuqv", "zuca", "fnuhoqvdizge", "wufabtxh", "sqh", "tkruefjwmadshv", "ctwohzglrfupd", "watnmgip", "tnkbcdgfiezhvr", "dypfe", "mdtaoji", "bdcsqoi", "peaicmuxbvhw", "wivumfq", "mqaplhnxrof", "uer", "ysmz", "xtnmi", "xeufnwbict", "hemnkfviz", "jdktsuopavrcny", "auktslp", "masvntjufxkipo", "nfkljhbuxr", "elpvftrbwhngqm", "k", "zybkrt", "aqexjozhi", "urjlixh", "btp", "htbgwqpyxfivme", "eukhrzfsbl", "gxbdsoenihyfqlr", "f", "bqgozphir", "jpkuowlfibnh", "xuvgjnmwtqbk", "waov", "qwybo", "zl", "hockjta", "fkxghzp", "k", "jltiswyfb", "yvzl", "clkdufrxbq", "brefn", "hfwzivd", "jkyxqozmrs", "stwdvabeucpxzm", "gu", "hyud", "wqhmfaduvie", "ofpjuqibhwyt", "nwgxajylor", "bfeiplaunyjdgvs", "vhgjaqbfznsl", "sitvwhlbox", "ftra", "hl", "esgphzkd", "fzrbxpv", "cfk", "jqvryiunap", "n", "lqtniaehckmby", "kmqvayr", "qrpmbga", "vfnesiowdr","wtx","yvcqatzmhsifule","zatjnpq","px","vytlgxenfawhzk","ri","eiltwb","efuwzy","avbxnwfs","kqlasczrdjvexhn","mk","xsiwndcvploj","lwnsd","yzlpbrvf","axepbm","ekl","utdoiazegxp","uncexfiplkqadvb","wzjxcy","hbvgaeqxp","irlkxuqmowazp","hwz","hmqpblzugiyeaok","kdajyh","odycgusza","lpb","tujvdp","jhcbetu","yruvmob","vpongfduthijqmz","v","mlpghxrtucq","jtp","bodtcuwhin","pxbvzd","uhtkfcevzwmx","vepy","hu","p","yjpqu","porxdfjvglec","xcqesork","axjmv","seoucnlzdabfir","iznghmdsok","ogyrzb","visq","awporeikqltmhdb","rcptm","cxsuqbdnme","u","vncqyjuao","xl","hakf","djgpircyhm","ojm","mpxfrin","wivnj","al","ybvpowlknh","ivtonphfz","qrcptue","unqbafldks","pyqvtlwxsnmgza","fxhjl","alit","xsgtqjvep","pwbftml","ngtkvsalqy","yo","qglwrdkaezfxtiv","ioxcnzsym","ximswuhcjrvl","wrletzpycdfxkqm","dolhwrajkmbqx","omtqnbr","fmsndabuh","donqshx","kasupzf","ktmiruwebofs","gjdevflbrzusn","ybvf","c","rc","kwhexmisdbjrn","puoxvjmidfn","uylkjocvbw","xr","uykvmncwhsj","fpcvg","rc","mhgvfzrisbplux","jags","tzgyvjqfapkherw","hnkizcwsvqxura","asxhc","ybgvuhesaczr","dnkyjclsbh","xs","xayes","eovz","tdfaxmlwjcq","zauksdwy","axmfoenqzpuv","oxldfzeacqypiw","fadnlrogk","boxcvu","jsvb","nsaecromxbh","vf","jzfydvxobu","shalqprfnxid","vtpcam","ilkahpdcutjwmeb","bnqmlo","jbplxaishzqkw","xuqabg","ejp","ozrjlt","pkqmsvdezf","vm","moxwgvrp","xzilbptngf","zeacvsohdp","z","uizwjngxsk","qe","b","glirwnfkhx","amxpei","oabutlvsz","zonmq","eqcvl","ovgrnxswpqh","onatxgivhwfrzcb","irjb","qbowtsyezulrf","zmuawhco","bp","bhwntcuixjfqeks","sygquvakifpjdw","ialsd","erh","jdxsfebithkmzp","onmxjbrw","akxugpyrswomihf","ciwhzjfyeutvsa","pvnqtsiwr","bespzt","dvcupmisxatrq","qemjkhyiwc","wzghxnjedq","utovcsrhzlkn","iagezksoubrwftj","luorkmabvncwhs","fngubvxeoypd","axzndvby","jxsydwhcnztuav","pkczqajmldrxog","qiedlpjtxgnsrhf","zoawgmtbercynxl","rbsjdoylkcvupqe","l","fab","lrmojneuzi","tbvkzrnifcu","sd","irgmpcu","jdisrzcvewxfl","mdjseybquhzn","qhr","dversfglquwczph","pmidwtqhjuc","rhxdwqvemilpyc","pc","goxchvjemwryzfb","ourdqfye","afctquzlrkwhg","voxr","frizya","knpcrwjlaevbfu","r","rdoxewtpzfj","cxnsybuzwtqdf","liqyzmputse","cbhsy","ovizgjncmsr","kodjhebusxgp","vlagtjhfwekbd","dkmwixevryhjbq","bhmonutaweiv","smobvkdipewf","skilzjfcvdxmu","qcyfuo","pjmqzocas","it","eskpywjlibonuta","nxcitdvpkha","yoa","tvfyrdj","gwnihuapydzto","b","qmevwhdfri","qbutx","bfketmp","wcp","bxurwq","hr","zfrhdakujqswpg","whntsxf","dyfplzmusgiq","jsogptb","jlz","ucx","tzqrkb","lpsxz","cpd","rf","zqrbdoa","nfypqbtvmh","spgmvaf","mfjhu","nrtwcmkxiepbfa","hafxpvokbdj","ndxrwzcoefhqvb","znxauydqh","azd","puko","vctwn","xebgcwqvnpu","byoesiuvrm","fcemdaby","vcniq","odpxkavctyhwsle","ogbjpe","w","zeysqmjg","fgzcha","gqokhmxne","k","nv","alyqm","yqn","k","lkpwog","hyuqwcfvapbns","moy","rh","kaytguxs","yzdkixr","g","bsv","qnzscfiepwjyrxt","s","kjtdywhbl","axqwblzfynj","kiqar","fbp","zlexirtdwgopu","o","yodfunwb","kfathcubomr","bwczmfolykjpv","tykihxljesvo","iad","qgh","dhvri","dewvlyhnskzbrpx","vzi","lmhjts","vfjmghwrbuakz","pxfwiahblmtdgsk","qgsxplrkmidtw","ftwru","lngyrchbfx","kcgh","thzwmgokevx","hfoiqp","hglxsbwz","k","g","o","rtdgxmqw","etufikw","srd","rxcd","gyupxhvfeasjtb","ctnxqfrlhzwvb","ftqjlosehba","cnabeqx","gcxtvalrszuymbi","jtnewyhlvd","dihmtuxpag","xldmehkbap","bjmhwinecxsql","ehzblp","zasxj","sy","awjyhcemkx","symtd","sqkjivp","ykbumrions","fxlwmcbpyoa","ikprczexh","m","zpfjcmo","mvpfurwni","cydxleawkhn","x","xcvtngewzy","v","agzqiujp","qr","qabzekpivdhxlj","cbdg","aefrocgjiuxy","ntxluqpavr","torhwvkpudngcal","xdi","qfgbxmo","carevdn","ctn","w","ibofvcgxdhua","vcatnqzfe","nchuvjaymt","ugsokwtfnmialh","jgasqkznhuo","gnpuolmar","xwopucmqj","asjoltdqvx","enk","ukemiwnydspqtf","qfm","rwaxbcvziq","ethicsqpouknw","c","ufgrbaxit","btvmhnrcad","umjwha","xerl","vrhxlweu","vhpxbtnylzf","blpknu","ucita","p","kgiesb","bomkqgupxa","vorqy","uycpdzimoeaw","cfreslmqx","jcgxdmavfzruip","fjkwzyilvqgo","unhtwqoryibce","slqixjbrywe","uvztklaixs","vahqx","d","wycubdohjxvfkn","mvajztpekxswlyg","pfqzgvxshjceu","ue","adgexnsc","iwlyxratdqh","htb","aqfloydbtzwj","aymukbthgceiz","walrisxyp","cp","ulvedobgzjxhwpm","qidsoantvyglr","omtecqiskdhluvn","sldbxmiv","xkhtubl","lhtjqasvncoz","dcgaubrpkq","dtg","qsgchtp","zlghvadocsq","snhcizqgxamol","vpftxanwhluod","pyndurstko","qgsrchdtyzvpeo","kafgjpcznmbilu","v","pa","flwbumzisvkyx","anyjsrzu","vrchmluyxtzpsb","ulprhienjowzg","xdft","dbcmfzjyrhistul","yvrdklmh","cwgs","ye","bafezh","eqv","kxhbiruznpm","xuhlimjptvdek","dg","biohgvwtxz","xoghsvn","uwi","nazqbvktprecx","qojftkvigx","tnomsfcprlva","qigbtxkdl","cfmybaxkt","hk","vnhg","wylxzkohvnr","x","bhiyplxnvqr","dlkjxtnwhbmpzus","xfhiobsamw","snfahoe","ms","vfmxe","ajlcovftsekh","dpcelyngvxwjtum","udns","gsrupxtaqycdz","unaicvyofewqs","nhmewcdtg","zlwbk","ijxruyvo","imkqdvtfxulozjw","sbhquyptxwzcgml","cvyf","hcx","gncatmwqkzlubx","xymiahu","rgisd","psgcq","ns","slbvpxjztyhm","pb","clzqd","katdzjsepg","pvwaujqm","koqyscldmt","evhzrwfxtcly","ckqxsrwjazmi","adeivnyxkmqwz","uw","onihvmfkeswqj","rged","tr","ftaksnmypzglcvu","ljcmzktnqibreg","shcr","jfcikmqorz","p","mrtchjgp","qhlgakrdsbc","fmlewhvod","khjaflyp","pdysrnmzu","qfynabmvl","lsb","zvrxfd","rgqbwtuicdplxnf","wmhfir","mil","dltohqbns","tdqjzkiramsvecb","ctwrpaldvihjns","bwiplcgyjnxetro","qojcedw","ztlcwqjynrovsbh","igvwhz","wnso","dafmjibpsxn"};
        

        System.out.println(Arrays.toString(a));
        
        int [] r = s.groupStrings(a);
        System.out.println(Arrays.toString(r));
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
