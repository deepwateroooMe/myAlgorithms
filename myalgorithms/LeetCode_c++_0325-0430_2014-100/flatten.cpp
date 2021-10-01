#include <iostream>
#include <cstdlib>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void flatten(TreeNode *root) {
    if (!root) return;
    TreeNode* ptr;
    
    while (root) {    
        if (root->left) 
        {
            ptr = root->left;
            while (ptr->right)
                ptr = ptr->right;
            ptr->right = root->right;
            root->right = root->left;
            root->left = NULL;
        }
        root = root->right;
    }
}

void preOrder(TreeNode* root) {
    if (!root) {    
        cout << "#, ";
        return;
    }
    cout << root->val << ", ";
    preOrder(root->left);
    preOrder(root->right);
}

int main() {
    int a[2] = {0, 1}; 
    TreeNode* root = new TreeNode(a[1]);
    TreeNode* tmp, *curr;
    curr = root;
        
    for (int i = 2; i < 2; ++i){
        if (!(i >> 1) && a[i] != -1) 
        { 
            tmp = new TreeNode(a[i]);
            curr->left = tmp;
            curr = curr->left;
        } else if (!(i >> 1)) {
                curr->left = NULL;
        } else if (a[i] != -1) {            
            tmp = new TreeNode(a[i]);
            curr->right = tmp;
            curr = curr->right;
        } else {
            curr->right = NULL;
        }
    }
    cout << "before flatten: " << endl;
    preOrder(root);

    //    flatten(root);
    
    cout << "after flatten: " << endl;
    preOrder(root);
    
    /*
    while (root) {    
        cout << root->val << "," << endl;
        root = root->right;
        }*/

    
    
    return 0;
}
