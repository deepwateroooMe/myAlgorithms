#include <iostream>
using namespace std;

  struct ListNode {
      int val;
      ListNode* next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
ListNode* hasCycle(ListNode *head) {
    if (head == NULL) return NULL;

    ListNode* fast = head, *slow = head;
    while(fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) break;
    }

    if (!fast || !fast->next) return NULL;
    while(fast != slow) {
        fast = fast->next;
        slow = slow->next;
    }
    return fast;
}

int main() {

    
    return 0;
}
