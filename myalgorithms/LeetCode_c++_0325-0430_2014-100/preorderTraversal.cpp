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

vector<int> preorderTraversal(TreeNode *root) {
    vector<int> result;
    stack<TreeNode*> s;
    TreeNode* curr = root;
    bool done = false;

    while (!done) {
        if (curr) {        
            s.push(curr);
            result.push_back(curr->val);            
            curr = curr->left;
        } else {
            if (s.empty())
                done = true;
            else {
                curr = s.top();
                s.pop();
                curr = curr->right;
            }
        }
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

    vs result = preorderTraversal(root);
    for (int i = 0; i < result.size(); ++i)
        cout << result[i] << endl;
    
    return 0;
}
