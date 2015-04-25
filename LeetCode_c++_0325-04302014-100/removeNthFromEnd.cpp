#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode* head);
ListNode* buildList(int a[], int n);

ListNode* removeNthFromEnd(ListNode *head, int n) {
    ListNode *prev = head, *curr = head, *vst;
    while(n && curr) { // the very first element need to be considered
        curr = curr->next;
        --n;
    }
    if (!curr && n == 0){
        prev = head;
        head = head->next;
        delete prev;
        return head;
    } 
    
    prev = head;
    while(curr) {
        vst = prev;
        prev = prev->next;
        curr = curr->next;
    }
    vst->next = prev->next;
    delete prev;
    return head;
}


int main() {
    int a[] = {1};

    ListNode *l1, *l2, *head;
    l1 = buildList(a, 1);
    
    head = removeNthFromEnd(l1, 1);
    printList(head);

    return 0;
}

ListNode* buildList(int a[], int n) {
    ListNode* prev, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            prev = new ListNode(a[i]);
            curr = prev;
        } else  {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }
    return prev;
}

void printList(ListNode* head){
    while(head)  {
        cout << head->val << ", " << endl;
        head = head->next;
    }
}
