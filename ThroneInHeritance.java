import com.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class ThroneInHeritance {

    private List<String> currOder;
    private Node root;
    
    public ThroneInHeritance(String kingName) {
        currOder = new ArrayList<>();
        currOder.add(kingName);
        root = new Node(kingName);
        
    }
    
    public void birth(String parentName, String childName) {
        Node p = getNode(root, parentName);
        Node tmp = new Node(childName);
        if (p != null && p.children == null) {
            p.children = new ArrayList<Node>();
        }
        if (p != null) p.children.add(tmp);
    }
    
    public void death(String name) {
        Node p = getNode(root, name);
        p.dead = 1;
    }
    
    public List<String> getInheritanceOrder() {
        l = new ArrayList<>();
        getInheritanceOrderRecursive(root);
        return l;
    }

    List<String> l = new ArrayList<>();
    private void getInheritanceOrderRecursive(Node r) {
        if (r == null) return;
        if (r.dead != 1)
        l.add(r.val);
        if (r.children != null) {
            for (int i = 0; i < r.children.size(); i++) {
                getInheritanceOrderRecursive(r.children.get(i));
            }
        }
    }
    
    private Node getNode(Node r, String p) {
        if (r == null) return null;
        if (p == r.val) return r;
        if (r.children != null && r.children.size() >= 1) {
            int i = 0;
            for ( i = 0; i < r.children.size(); i++) {
                if (r.children.get(i).val == p) return r.children.get(i);
            }
            i = 0;
            Node tmp = getNode(r.children.get(i), p);
            while (i < r.children.size()-1 && tmp == null) {
                ++i;
                tmp = getNode(r.children.get(i), p);
            }
            return tmp;
        }
        return null;
    }

    public static void main(String[] args) {

        ThroneInHeritance t = new ThroneInHeritance("king"); // order: king
        t.birth("king", "andy"); // order: king > andy
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());
        
        t.birth("king", "bob"); // order: king > andy > bob
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());

        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());

        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());

        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());

        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());

        // t.getInheritanceOrder(); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println("t.getInheritanceOrder(): " + t.getInheritanceOrder());
        // t.getInheritanceOrder(); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }
}

// ["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
// [["king"],["king","andy"],["king","bob"],["king","catherine"],["andy","matthew"],["bob","alex"],["bob","asha"],[null],["bob"],[null]]

// ["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
// [["king"],["king","andy"],["king","bob"],["king","catherine"],["andy","matthew"],["bob","alex"],["bob","asha"],[null],["bob"],[null]]