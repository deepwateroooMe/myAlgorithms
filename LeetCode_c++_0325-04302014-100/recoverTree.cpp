#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

typedef vector<TreeNode*> vi;

void printList(TreeNode* head);
TreeNode* buildList(int a[], int n);
void levelOrderPrint(TreeNode* root);
vector<TreeNode*> genIndiTree(int l, int r);

// referred to the website to get ideas first
// https://oj.leetcode.com/discuss/13034/no-fancy-algorithm-just-simple-and-powerful-order-traversal
TreeNode* first = NULL;
TreeNode* second = NULL;
TreeNode* prev = new TreeNode(INT_MIN);

void inOrderTraverse(TreeNode* root) {
    if (root == NULL) return;
    inOrderTraverse(root->left);

    // handle identifying the two out by rememberring them
    if (first == NULL && prev->val >= root->val) // first smaller value
        first = prev;
    if (first != NULL && root->val <= prev->val) // don't need <= because no equal value
        second = root;
    prev = root;
    
    inOrderTraverse(root->right);
}

vector<TreeNode*> recoverTree(TreeNode* root) {    
    // in-order traverse to find the two elements
    inOrderTraverse(root);
    // swap the two values to make the change
    int tmp = first->val;
    first->val = second->val;
    second->val = tmp;
}
/*
// don't want to build the tree by myself, but said runtime error
Submission Result: Runtime ErrorMore Details 
Last executed input:	{0,1}
 */

int main() {
    int n = 2;
    int a[] = {0, 1};
        
    
    /*
    vi root = recoverTree(n);
    for(int i = 0; i < root.size(); ++i)  {
        cout << i << ": " << endl;
        levelOrderPrint(root[i]);
        cout << endl;
    }
    */
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

vector<TreeNode*> genIndiTree(int l, int r) {
    vector<TreeNode*> result;
    if (l > r)  {
        result.push_back(NULL);
        return result;
    }
    for (int i = l; i <= r; ++i) {
        vector<TreeNode*> left = genIndiTree(l, i-1);
        vector<TreeNode*> right = genIndiTree(i+1, r);
        for (int x = 0; x < left.size(); ++x) {
            for (int y = 0; y < right.size(); ++y) {
                TreeNode* root = new TreeNode(i);
                root->left = left[x];
                root->right = right[y];
                result.push_back(root) ;
            }
        }
    }
    return result;
}

