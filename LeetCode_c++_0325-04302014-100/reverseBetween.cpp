#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* buildList(int a[], int n);

ListNode *reverseBetween(ListNode *head, int m, int n) {
    if (!head || n-m == 0) return head;
    ListNode *prev, *curr, *futu, *start, *preend;
    int cntn = n-1;
    if (m == 1) {    
        start = head;
        prev = head;
        curr = head->next;
    } else  {    // m > 1
        int cntm = m-1;
        prev = head; curr = head->next; --cntm;
        while (cntm) {
            prev = curr;
            curr = curr->next;
            --cntn;
            --cntm;
        }
        preend = prev;
        start = curr;
    }
    while(cntn) {
        futu = curr->next;
        curr->next = prev;
        prev = curr;
        curr = futu;
        --cntn;
    }

    if (m == 1) {
        head = prev;
        start->next = curr;
    } else  {
        preend->next = prev;
        start->next = curr;
    }
    return head;
}

int main() {
    int n = 5;
    int a[] = {1, 2, 3, 4, 5};
    ListNode* head = buildList(a, n);
    cout << endl;
    ListNode* curr = head;
    while(curr)  {
        cout << curr->val << ", ";
        curr = curr->next;
    }

    ListNode* result = reverseBetween(head, 2, 5);

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



