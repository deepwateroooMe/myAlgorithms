#include <iostream>
#include <vector>
#include <stack>
using namespace std;
typedef vector<int> vs;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<int> postorderTraversal(TreeNode *root) {
    vector<int> result;
    if (!root) return result;
    stack<TreeNode*> s;
    s.push(root);
    TreeNode* prev = NULL;

    while (!s.empty()) {
        TreeNode* curr = s.top();
        // traveling down the tree
        if (!prev || prev->left == curr || prev->right == curr) { // down tree        
            if (curr->left)
                s.push(curr->left);
            else if (curr->right)
                s.push(curr->right);
            else {
                result.push_back(curr->val);
                s.pop();
            }
        }
        // traversing up the tree from the left
        else if (curr->left == prev) { // up tree
            if (curr->right) {                
                s.push(curr->right);
            } else {
                result.push_back(curr->val);
                s.pop();
            } 
        }
        // traversing up the tree from the right
        else if (curr->right == prev) {
            result.push_back(curr->val);
            s.pop();
        }
        prev = curr;
    }
    return result;
}

int main() {
    int a[4] = {1, 4, 2, 3};
    TreeNode* root = new TreeNode(0);
    for (int i = 0; i < 4; ++i){
        TreeNode* tmp = new TreeNode(a[i]);
        if (i >> 1)
            root->left = tmp;
        else
            root->right = tmp;
    }

    vs result = postorderTraversal(root);
    for (int i = 0; i < result.size(); ++i)
        cout << result[i] << endl;
        
    return 0;
}
