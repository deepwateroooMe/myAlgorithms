#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <cstring>
#include <unordered_map>
using namespace std;

typedef vector<char> vc;
typedef vector<vector<char> > vvc;

const int m = 3;
const int n = 4;

vvc charToV(char a[m][n]) {
    vvc result;
    vc one;
    for(int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j)
            one.push_back(a[i][j]);
        result.push_back(one);
        for (int j = 0; j < n; ++j)
            one.pop_back();
    }
    return result;
}

void printVC(vc tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVC(vvc tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        printVC(tmp[i]);
    cout << endl;
}

bool exist(vector<vector<char> > &board, string word) {
    if (!word) return false;
    if (board.size() == 0 && !word) return true;

    int m = board.size();
    int n = board[0].size();
    char curr;
    stack<char> s;
    unordered_map<char, int> hash;
    for(int i = 0; i < word.length(); ++i) {
        for(int i = 0; i < m; ++i) {
            tmp[i][j] = 0;
        }
    }
    
    for(int i = 0; i < word.length(); ++i) {
        curr = substr(word, i, 1);
        cout << "curr: " << curr << endl;
        for(int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == curr && tmp[i][j] == 0)  {
                    s.push(curr);
                    tmp[i][j] = 1;
                }
            }
        }
        
        while(!s.empty())    
        {
            
        }
        
    }
}

int main() {
    char a[m][n] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    vvc tmp = charToV(a);
    printVVC(tmp);
    
    return 0;
}
