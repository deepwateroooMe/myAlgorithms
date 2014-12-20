#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef vector<int> vi;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void printList(TreeNode* head);
TreeNode* buildList(int a[], int n);
void levelOrderPrint(TreeNode* root);

TreeNode* creat_miniman_tree(vector<int> &num, int start, int end) {
    TreeNode* root;
    if (start == end)  {
        root = new TreeNode(num[start]);
        return root;
    }
    
    if (start <= end) {
        int mid = (start + end) / 2;
        root = new TreeNode(num[mid]);
        root->left = creat_miniman_tree(num, start, mid-1);
        root->right = creat_miniman_tree(num, mid+1, end);
        return root;
    }
    return NULL;
}

TreeNode *sortedArrayToBST(vector<int> &num) {
    int size = num.size();
    if (size == 0) return NULL;
    int idx = 0;
    TreeNode* root = creat_miniman_tree(num, idx, size-1);    
    return root;
}

int main() {
    int n = 4;
    int a[] = {-1, 0, 1, 2};
    vi arr;
    for (int i = 0; i < n; ++i)
        arr.push_back(a[i]);
    TreeNode* root = sortedArrayToBST(arr);
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

TreeNode* buildList(int a[], int n) {
    TreeNode* prev, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            prev = new TreeNode(a[i]);
            curr = prev;
        } else  {
            curr->left = new TreeNode(a[i]);
            curr = curr->left;
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
