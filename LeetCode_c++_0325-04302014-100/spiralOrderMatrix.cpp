#include <iostream>
#include <vector>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;

const int m = 3;
const int n = 3;

vvi toVector(int a[m][n]);
void printMatrix(int a[m][n]);
void printVVI(vvi tmp);
void printVI(vi tmp);

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

vector<int> spiralOrder(vector<vector<int> > &matrix) {
    int m = matrix.size();
    int n = matrix[0].size();
    vector<int> result;
    result.push_back(matrix[0]);
    
}

int main() {
    int a[m][n] = {{1, 2, 3 },
                   {4, 5, 6 },
                   {7, 8, 9 }};
    printMatrix(a);

    cout << endl;
    vvi matrix = toVector(a);

    vi result = spiralOrder(matrix);
    printVI(result);
    
    return 0;
}

vvi toVector(int a[m][n]) {
    vvi result;
    vi one;
    
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) 
            one.push_back(a[i][j]);
        result.push_back(one);
        for (int j = 0; j < n; ++j) 
            one.pop_back();
    }
    return result;
}

void printMatrix(int a[m][n]) {
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) 
            cout << a[i][j] << " ";
        cout << endl;
    }
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
