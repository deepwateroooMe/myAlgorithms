import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class LRUCacheSolution {
    // https://oj.leetcode.com/discuss/16010/o-1-java-solution
    // started by referring to his design and constructor
    public static class LRUCache {
        public class Node {
            int key;
            int value;
            Node prev;
            Node next;
            public Node(int x, int y){
                key = x;
                value = y;
            }
        }

        private HashMap<Integer, Node> hash;
        private int cap;
        private int number;
        Node head;
        Node tail;
        public LRUCache(int capacity) {
            cap = capacity;
            number = 0;
            head = new Node(-1, -1);
            head.prev = null;
            head.next = null;
            tail = head;
            hash = new HashMap<Integer, Node>(capacity); // so I can restrict a size !!
        }
    
        public int get(int key) {
            Node res = hash.get(new Integer(key)); // don't understand here
            if (res != null) {
                refresh(res);   // update usage frequence
                return res.value;
            } else {
                return -1;
            }
            /*
              if (hash.containsKey(key)) {
              //Node res = hash.get(new Integer(key)); // don't understand here
              Node res = hash.get(key);
              refresh(res);   // update usage frequence
              return res.value;
              } else {
              return -1;
              }
            */
        }

        // so still, must maintain a doubly-linked list to order usage frequency
        public  void refresh(Node tmp) {
            if (tmp == head.next) {
                return;   
            }  // it's head already
            
            Node temp = head.next;  // head node in the hash
            Node prevNode = tmp.prev;
            Node nextNode = tmp.next;
            // set to be most recently used~~ move the tmp node to be head.next, connections
            head.next = tmp;  
            tmp.prev = head;
            tmp.next = temp;
            temp.prev = tmp;
            prevNode.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = prevNode;
            } else {
                tail = prevNode;   // remember tail as well
            }
        }

        public void set(int key, int value) {
            Node res = hash.get(new Integer(key));
            if (res != null) {
                refresh(res);
                res.value = value;
            } else {
                //if (!hash.containsKey(key)) { // another way of detecting existing
                Node prevNode = new Node(key, value); 
                Node temp;
                if (number == cap) { // remove tail;
                    temp = tail.prev;
                    hash.remove(tail.key);      // remember to remove from hash too !!!
                    if (temp != null) {
                        temp.next = null;
                    }
                    tail.prev = null;
                    tail = temp;
                    number--;
                }
                // add to tail first
                tail.next = prevNode;
                prevNode.prev = tail;
                tail = prevNode;
                refresh(prevNode);
                hash.put(key, prevNode); 
                number++;  // count node numbers
            }
        }
    }

    public static void main(String[] args){
        LRUCache result = new LRUCache(2);
        result.set(2, 1);
        result.set(1, 1);
        int res = result.get(2);
        result.set(4, 1);
        res = result.get(1);
        res = result.get(2);

        System.out.println(res);
    }
}
/*
  2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]  // remember to remove from hash too !!!
  1,[set(2,1),get(2),set(3,2),get(2),get(3)]
*/
