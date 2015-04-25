#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef vector<int> vi;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void printList(TreeNode* head);
ListNode* buildList(int a[], int n);
void levelOrderPrint(TreeNode* root);

TreeNode* creat_miniman_tree(ListNode* num[], int start, int end) {
    TreeNode* root;
    if (start == end)  {
        root = new TreeNode(num[start]->val);
        return root;
    }
    
    if (start <= end) {
        int mid = (start + end) / 2;
        root = new TreeNode(num[mid]->val);
        root->left = creat_miniman_tree(num, start, mid-1);
        root->right = creat_miniman_tree(num, mid+1, end);
        return root;
    }
    return NULL;
}

TreeNode *sortedListToBST(ListNode* head) {
    if (!head) return NULL;
    
    ListNode* curr = head;
    ListNode* ptr[1000000];
    int size = 0;
    while(curr) {
        ptr[size++] = curr;
        curr = curr->next;
    }

    int idx = 0;
    TreeNode* root = creat_miniman_tree(ptr, idx, size-1);    
    return root;
}

int main() {
    int n = 4;
    int a[] = {-1, 0, 1, 2};
    vi arr;
    ListNode* head = buildList(a, n);
    TreeNode* root = sortedListToBST(head);
    levelOrderPrint(root);
    
    return 0;
}

void levelOrderPrint(TreeNode* root) {
    queue<TreeNode*> q;
    if (!root) return;
    TreeNode* curr;
    
    q.push(root);
    while ( !q.empty() ) {    
        curr = q.front();
        if (curr) {
            if (curr->left && curr->right) {        
                q.push(curr->left);
                q.push(curr->right);
            } else if (curr->left && !curr->right) {
                q.push(curr->left);
                q.push(NULL);
            } else if (!curr->left && curr->right) {
                q.push(NULL);
                q.push(curr->right);
            } 
            cout << curr->val << ", ";                
        } else 
            cout << "#, ";
        q.pop();
    }
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

void printList(TreeNode* head){
    while(head)  {
        cout << head->val << ", " << endl;
        head = head->left;
    }
}
