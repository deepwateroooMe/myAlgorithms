#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>

using namespace std;

class LRUCache {

    // Node to store the key-value pairs
    class Node  {
    public:
        int key;
        int value;
        Node* next;
        Node* prev;
        Node(int x, int y, Node *n, Node* p){
            key = x;
            value = y;
            next = n;
            prev = p;
        }
    };

    class DoubleLL {
    public:
        Node* first;
        Node* last;
        int size;
        int count;
        DoubleLL(int c){
            size = c;
            count = 0;
            first = NULL;
            last = NULL;
        }
    };

    // the map will store a reference to the Node in DLL corresponding to each key
    unordered_map<int, Node*> map;
    DoubleLL* dll;
    
public:
    
    LRUCache(int capacity) {
        dll = new DoubleLL(capacity); // why do I need new operator here? pointers
    }

    // get the value && put the node to be FIRST
    int get(int key) {
        if (map.count(key)) {
            Node* n = map[key];
            if (n->prev != NULL) {
                if(dll->last == n)
                    dll->last = n->prev;
                n->prev->next = n->next;
                if (n->next != NULL)
                    n->next->prev = n->prev;
                n->prev = NULL;
                n->next = dll->first;
                dll->first->prev = n;
                dll->first = n;
            }
            return (*n).value;
        } else
            return -1;
    }
    
    void set(int key, int value) {
        Node* n;

        // if doesn't EXIST
        if ( !map.count(key) ) {
            //cout << "i got here 1" << endl;
            
            n = new Node(key, value, NULL, NULL);
            if ((*dll).size != (*dll).count) {
                n->next = dll->first;
                if ((*dll).count != 0)
                    dll->first->prev = n;
                else
                    dll->last = n;
                dll->first= n;
                (*dll).count++;
            } else {
                if ((*dll).count != 1) {                    
                    map.erase((*dll->last).key);
                    dll->last->prev->next = NULL;
                    dll->last = dll->last->prev;
                    dll->first->prev = n;
                    n->next = dll->first;
                    dll->first = n;
                } else {
                    map.erase((*dll->first).key);
                    dll->first = n;
                    dll->last = n;
                }
            }
            map[key] = n;
        } else {
            n = map[key];
            (*n).value = value;
            if (n->prev != NULL) {
                if (dll->last == n)
                    dll->last = n->prev;
                n->prev->next = n->next;
                if (n->next != NULL)
                    n->next->prev = n->prev;
                n->prev = NULL;
                n->next = dll->first;
                dll->first->prev = n;
                dll->first = n;
            }
        }
    }
};

int main(){
    LRUCache cache = LRUCache(1);
    cache.set(2, 1);
    cout << "out: " << cache.get(1) << endl;
    
    return 0;
}
