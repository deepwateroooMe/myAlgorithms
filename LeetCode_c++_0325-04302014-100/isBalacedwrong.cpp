#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int depth = 1;
int dep[1000];
int cnt = 0;

void getDepth(TreeNode* root) {
    if (!root) return;

    ++depth;
    if (root->left)
        getDepth(root->left);
    if (!root->left && !root->right) 
    {
        dep[cnt++] = depth;
        cout << "cnt: " << cnt << endl;
        cout << "depth: " << depth << endl << endl;
    }
    if (root->right)    
        getDepth(root->right);
    --depth;
}

bool isBalanced(TreeNode *root) {
    if (!root || (!root->left && !root->right)) return true;

    getDepth(root);
    cout << "cnt: " << cnt << endl;
    
    int mindep = dep[0], maxdep = dep[0];
    for (int i = 0; i < cnt; ++i) {
        cout << "dep[" << i << "]: " << dep[i] << endl;
        if (dep[i] < mindep) 
            mindep = dep[i];
        if (dep[i] > maxdep)
            maxdep = dep[i];
    }
    return maxdep-mindep < 1;
}

void preOrder(TreeNode* root) 
{
    if (!root) return ;
    cout << root->val << endl;
    preOrder(root->left);
    preOrder(root->right);
}

int main() {
    char a[5] = {'1', '#', '2', '#', '3'};
    TreeNode* root = new TreeNode(1);
    TreeNode* tmp;
    
    for (int i = 0; i < 4; ++i){
        if (a[i+1] != '#')
            tmp = new TreeNode(a[i+1]);
        else tmp = NULL;
        
        if (i >> 1)
            root->left = tmp;
        else
            root->right = tmp;
    }
    preOrder(root);
    
    cout << isBalanced(root) << endl;
    
    return 0;
}
