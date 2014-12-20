#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

void reorderList(ListNode *head) {
    if (!head || !head->next || !head->next->next) return;
    
    ListNode* a[1000000];
    int cnt = -1;

    ListNode* tmp = head;
    while(tmp != NULL) {
        a[++cnt] = tmp;
        tmp = tmp->next;
    }
    
    int low = 0, high = cnt;
    int counter = 0;
    ListNode* curr = head;
    
    while (counter < cnt/2) {
        curr->next = a[high--];
        curr = curr->next;
        curr->next = a[++low];
        curr = curr->next;
        counter++;
    }
    
    if (cnt % 2 == 0 && counter == cnt / 2)
        curr->next = NULL;
    else  {
        curr->next = a[++low];
        curr = curr->next;
        curr->next = NULL;
    }
}

int main() {
    ListNode* head, *curr;
    int n = 4;
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            head = new ListNode(i);
            curr = head;
        } else {
            curr->next = new ListNode(i);
            curr = curr->next;
        }
    }

    curr = head;
    for (int i = 0; i < n; ++i) {
        cout << curr->val << ", " << endl;
        curr = curr->next;
    }

    reorderList(head);
    while(head)  {
        cout << head->val << ", " << endl;
            head = head->next;
    }
    
    return 0;
}
