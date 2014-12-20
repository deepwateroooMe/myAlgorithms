#include <iostream>
#include <queue>
using namespace std;
typedef vector<int> vi;
typedef vector< vector<int> > vvi;

struct TreeLinkNode {
    int val;
    TreeLinkNode *left, *right, *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

struct pos {
    TreeLinkNode* ptr;
    int dep;
    pos():ptr(NULL), dep(0){}
    pos(TreeLinkNode* tmp, int x): ptr(tmp), dep(x){}
};

void levelOrderPrint(TreeLinkNode* root);
void levelOrderPrintII(TreeLinkNode* root);
TreeLinkNode* buildTree(int a[], int len);

/*
// time limit exceeded
void connect(TreeLinkNode *root) {
if (!root) return;
else if (root && !root->left && !root->right) return;
queue<pos> q;
int cnt = 1;
pos prev;
    
q.push(pos(root, cnt));
prev = q.front();
q.pop();
++cnt;
if (prev.ptr->left)
q.push(pos(prev.ptr->left, cnt));
if (prev.ptr->right)
q.push(pos(prev.ptr->right, cnt));
prev = q.front();
q.pop();
++cnt;
    
while(!q.empty())  {
while(prev.dep == q.front().dep) {
if (prev.ptr->left)
q.push(pos(prev.ptr->left, cnt));
if (prev.ptr->right)
q.push(pos(prev.ptr->right, cnt));
prev.ptr->next = (q.front()).ptr;
if (!q.empty())  {
prev = q.front();
q.pop();
}
}
        
if (prev.dep < q.front().dep)  {
prev.ptr->next = NULL;
if (prev.ptr->left)
q.push(pos(prev.ptr->left, cnt));
if (prev.ptr->right)
q.push(pos(prev.ptr->right, cnt));
++cnt;
if (!q.empty())  {
prev = q.front();
q.pop();
}
}
}
}
*/

void connect(TreeLinkNode *root) {
    if (!root) return;
    else if (root && !root->left && !root->right) return;
    
    TreeLinkNode* curr = root;  // curr node of curr level
    TreeLinkNode* head = NULL;  // head of next level
    TreeLinkNode* prev = NULL;  // curr leading node of next level

    while (curr)  {
        while (curr) {
            if (curr->left)  {
                if (prev)
                    prev->next = curr->left;
                else head = curr->left;
                prev = curr->left;
            }
            if (curr->right)  {
                if (prev)
                    prev->next = curr->right;
                else head = curr->right;
                prev = curr->right;
            }
            curr = curr->next;
        }
        curr = head;
        head = NULL;
        prev = NULL;
    }
}

int main() {
    /*
      int n = 11;
      int a[] = {1, 2, 8, 3, -1, -1, 5, 4, -1, -1, 7};
    */
    int n = 11;
    int a[] = {1, 2, 2, 3, 3, -1, -1, 4, -1, -1, 4};   // time limit exceeded 
    //int a[] = {1, 2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1, 8};
    TreeLinkNode* root = buildTree(a, n);
    levelOrderPrint(root);
    cout << endl;
    
    connect(root);
    levelOrderPrintII(root);
    
    return 0;
}

TreeLinkNode* buildTree(int a[], int len) {
    TreeLinkNode* root;
    TreeLinkNode* curr;
    queue<TreeLinkNode*> q;
    int idx = 0;
    if (idx == 0) {        
        root = new TreeLinkNode(a[idx++]);
        curr = root;
        q.push(curr);
    }
    while(!q.empty() && idx < len) {
        curr = q.front();
        if (idx % 2 == 1) {            
            if (a[idx] != -1) {                
                curr->left = new TreeLinkNode(a[idx]);
                q.push(curr->left);
            } else 
                curr->left = NULL;
            idx++;
        }
        if (idx % 2 == 0) {        
            if (a[idx] != -1) {                
                curr->right = new TreeLinkNode(a[idx]);
                q.push(curr->right);
            } else 
                curr->right = NULL;
            idx++;
        }
        q.pop();
    }
    return root;
}

void levelOrderPrintII(TreeLinkNode* root) {
    queue<TreeLinkNode*> q;
    if (!root) return;
    TreeLinkNode* curr;
    
    q.push(root);
    while ( !q.empty() ) {    
        curr = q.front();
        //if (curr) {
        if (curr->left && curr->right) {        
            q.push(curr->left);
            q.push(curr->right);
        } else if (curr->left && !curr->right) {
            q.push(curr->left);
            //q.push(NULL);
        } else if (!curr->left && curr->right) {
            //q.push(NULL);
            q.push(curr->right);
        } 
        cout << curr->val << ",";
        if (curr->next)
            cout << curr->next->val << " ";
        else
            cout << "n ";
        /*        } else 
                  cout << "#,  ";    */
        q.pop();
    }
    cout << endl;
}

void levelOrderPrint(TreeLinkNode* root) {
    queue<TreeLinkNode*> q;
    if (!root) return;
    TreeLinkNode* curr;
    
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

void preOrder(TreeLinkNode* root) {
    if (!root) return;
    cout << root->val << ", ";
    preOrder(root->left);
    preOrder(root->right);
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

/*
// recursion, not quite working yet
void connect(TreeLinkNode *root) {
if (!root) return;
else if (root && !root->left && !root->right) return;

if (root->left)
root->left->next = root->right;
if (root->right)
root->right->next = (root->next) ?
((root->next->left)? root->next->left : root->next->right) : NULL;
connect(root->left);
connect(root->right);
}
*/
