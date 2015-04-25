#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* buildList(int a[], int n);

ListNode *swapPairs(ListNode *head) {
    if (!head) return NULL;
    else if (head && !head->next) return head;
    
    ListNode *prev, *curr, *futu;
    prev = head;
    curr = head->next;
    head = curr;
    futu = curr->next;
    curr->next = prev;
    prev = curr;
    curr = curr->next;
    curr->next = futu;
    while(futu && futu->next)  {
        prev = curr;
        curr = curr->next;
        prev->next = futu->next;
        prev = prev->next;
        futu = futu->next->next;
        prev->next = curr;
        curr->next = futu;
    }
    if (!futu) return head;
    if (futu && !futu->next) {
        curr->next = futu;
        return head;
    }
}

int main() {
    int n = 4;
    int a[] = {1, 2, 3, 4};
    ListNode* head = buildList(a, n);
    cout << endl;
    ListNode* curr = head;
    while(curr)  {
        cout << curr->val << ", ";
        curr = curr->next;
    }

    ListNode* result = swapPairs(head);

    cout << endl;
    while(result)  {
        cout << result->val << ", ";
        result = result->next;
    }
    return 0;
}

ListNode* buildList(int a[], int n) {
    ListNode* head, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0)  {
            head = new ListNode(a[i]);
            curr = head;
        } else  {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }
    return head;
}

