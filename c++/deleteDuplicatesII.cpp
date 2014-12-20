#include <iostream>
#include <unordered_map>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode *deleteDuplicates(ListNode *head) {
    if (head == NULL) return NULL;

    ListNode *prev = head;
    ListNode *curr = head->next;
    unordered_map<int, int> hash;
    hash[head->val] = 1;

    while(curr) {
        if (hash[curr->val]) {
            hash[curr->val]++;
            ListNode* tmp = curr;
            curr = curr->next;
            prev->next = curr;
            delete tmp;
        } else {
            hash[curr->val] = true;
            prev = curr;
            curr = curr->next;
        }
    }

    prev = head;
    curr = head;
    while(curr != NULL) {
        if (hash[curr->val] > 1) {
            hash.erase(curr->val);
            ListNode* tmp = curr;
            curr = curr->next;            
            if (tmp == head) {
                head = curr;
                prev = curr;
            } else
                prev->next = curr;
            delete tmp;
        } else  {
            prev = curr;
            curr = curr->next;
        }
    }
    return head;
}

int main() {
    ListNode* prev;
    ListNode* curr;

    int n = 2;
    int a[] = {1, 1};
        
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            prev = new ListNode(a[i]);
            curr = prev;
        } else  {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }

    curr = prev;
    while(curr)  {
        cout << curr->val << ", " << endl;
        curr = curr->next;
    }
    
   ListNode* result = deleteDuplicates(prev);
    cout << endl;
    while(result != NULL)  {
        cout << result->val << ", " << endl;
        result = result->next;
    }


    return 0;
}
