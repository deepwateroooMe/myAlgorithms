#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode* head);
ListNode* buildList(int a[], int n);

ListNode *partition(ListNode *head, int x) {
    if (!head) return NULL;
    ListNode *curr , *gcurr , *prev , *gprev, *lhead, *hhead, *tmp;
    curr = head, gcurr = head, prev = head, gprev = head;
    
    if (head->val < x) {
        lhead = head;
        while (curr->next && curr->next->val < x) {
            prev = curr;
            curr = curr->next;
        }
        if (!curr || !curr->next) return head;
        hhead = curr->next;
        gprev = hhead;
        gcurr = curr->next;
        tmp = curr->next->next;
    } else  {
        hhead = head;
        while (gcurr->next && gcurr->next->val >= x) {
            gprev = gcurr;
            gcurr = gcurr->next;
        }
        if (!gcurr || !gcurr->next) return head;
        lhead = gcurr->next;
        curr = gcurr->next;
        prev = gcurr->next;
        tmp = curr->next;
    }

    while(tmp) {
        while(tmp && tmp->val < x) {
            curr->next = tmp;
            prev = curr;
            curr = curr->next;
            tmp = tmp->next;
        }
        while (tmp && tmp->val >= x) {
            gcurr->next = tmp;
            gprev = gcurr;
            gcurr = gcurr->next;
            tmp = tmp->next;
        }
    }
    curr->next = hhead;
    gcurr->next = NULL;
    return lhead;
}

int main() {
    int n = 1;
    int a[] = {1};
    ListNode* head = buildList(a, n);
    printList(head);

    cout << endl;
    ListNode* root = partition(head, 2);
    printList(root);

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
    while(head != NULL)  {
        cout << head->val << ", " << endl;
        head = head->next;
    }
}
