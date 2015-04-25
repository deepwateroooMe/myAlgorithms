#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode* head);
ListNode* buildList(int a[], int n);

ListNode *rotateRight(ListNode *head, int x) {
    if (!head) return NULL;
    if (x == 0) return head;

    ListNode *slow = head, *fast = head, *pfast = head;
    int cnt = 0;
    while(fast) {
        ++cnt;
        fast = fast->next;
    }
    if (x % cnt == 0) return head;

    fast = head;
    while (x) {
        if (fast->next)
            fast = fast->next;
        else
            fast = head;
        --x;
    }

    if (!fast) return head;
    while (fast)  {
        fast = fast->next;
        slow = slow->next;
    }
    ListNode* root = slow;
    fast = slow;
    while (fast)  {
        pfast = fast;
        fast = fast->next;
    }
    pfast->next = head;
    while(pfast->next != slow)
        pfast = pfast->next;
    pfast->next = NULL;
    head = root;
    return head;
}

int main() {
    int n = 2;
    int a[] = {1, 2};
    ListNode* head = buildList(a, n);
    printList(head);
    cout << endl;
    
    ListNode* root = rotateRight(head, 1);
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
    while(head)  {
        cout << head->val << ", " << endl;
        head = head->next;
    }
}
