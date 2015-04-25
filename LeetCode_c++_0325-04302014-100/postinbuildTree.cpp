#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

struct intNode {
    int dep;
    TreeNode* ptr;
};

void preOrder(TreeNode* root);
TreeNode* buildTree(int a[], int len);
void printVVI(vvi tmp);
void printVI(vi tmp);
void levelOrderPrint(TreeNode* root);

// consider pre to be post
TreeNode* postinbuildTree(vector<int> &inorder, vector<int> &postorder) {
    int size = postorder.size();
    if (!size) return NULL;
    else if (size == 1) {
        TreeNode* root = new TreeNode(inorder[0]);
        return root;
    }
    
    stack<TreeNode*> s;
    stack<int> si;

    int cnt = size-1, icnt = size-1, f = 0;
    TreeNode* root = new TreeNode(postorder[cnt]);
    si.push(postorder[cnt]);
    s.push(root);
    TreeNode* curr = root;
    TreeNode* r;
    cnt--;

    while (cnt >= 0) {
        if (!s.empty() && (s.top())->val == inorder[icnt]) {
            curr = s.top();
            s.pop();
            si.pop();
            f = 1; // right node insertion mark
            --icnt;
        } else {
            if (f == 0) {
                si.push(postorder[cnt]);
                curr->right = new TreeNode(postorder[cnt]);
                curr = curr->right;
                s.push(curr);
                cnt--;
            } else {
                f = 0; // not right any more
                si.push(postorder[cnt]);
                curr->left = new TreeNode(postorder[cnt]);
                curr = curr->left;
                s.push(curr);
                cnt--;
            }
        }
    }
    return root;
}

int main() {
    const int size = 2;
    int a[size] = {2, 1};
    int b[size] = {2, 1};
    vi va, vb;
    for (int i = 0; i < size; ++i) {    
        va.push_back(a[i]);
        vb.push_back(b[i]);
    }
    
    TreeNode* root;
    root = postinbuildTree(va, vb);
    levelOrderPrint(root);
    /*    
          TreeNode* tmp;
          TreeNode* curr;
          int cnt = 0;
          root = buildTree(a, size);
          cout << endl;
          levelOrderPrint(root);
          cout << endl;

          vector<vector<int> > vvi = levelOrder(root);
          printVVI(vvi);
    */
    return 0;
}

TreeNode* buildTree(int a[], int len) {
    TreeNode* root;
    TreeNode* curr;
    queue<TreeNode*> q;
    int idx = 0;
    if (idx == 0) {        
        root = new TreeNode(a[idx++]);
        curr = root;
        q.push(curr);
    }
    while(!q.empty() && idx < len) {
        curr = q.front();
        if (idx % 2 == 1) {            
            if (a[idx] != -1) {                
                curr->left = new TreeNode(a[idx]);
                q.push(curr->left);
            } else 
                curr->left = NULL;
            idx++;
        }
        if (idx % 2 == 0) {        
            if (a[idx] != -1) {                
                curr->right = new TreeNode(a[idx]);
                q.push(curr->right);
            } else 
                curr->right = NULL;
            idx++;
        }
        q.pop();
    }
    return root;
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

void postOrder(TreeNode* root) {
    if (!root) return;
    cout << root->val << ", ";
    postOrder(root->left);
    postOrder(root->right);
}

void printVI(vi tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVI(vvi tmp) {
    cout << endl << "vvi print: " << endl;
    for (int i = 0; i < tmp.size(); ++i)
        printVI(tmp[i]);
    cout << endl;
}

