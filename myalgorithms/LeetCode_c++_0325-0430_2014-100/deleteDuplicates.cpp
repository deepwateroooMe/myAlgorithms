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
    unordered_map<int, bool> hash;
    hash[head->val] = true;

    while(curr) {
        if (hash[curr->val]) {
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
    return head;
}

int main() {
    ListNode* prev;
    ListNode* curr;

    int n = 7;
    int a[] = {-1, 0, 0, 0, 0, 3, 3};
        
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
    
    deleteDuplicates(prev);
    while(prev)  {
        cout << prev->val << ", " << endl;
        prev = prev->next;
    }


    return 0;
}
