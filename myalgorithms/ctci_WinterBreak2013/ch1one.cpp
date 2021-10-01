#include <iostream>
#include <cstring>
using namespace std;

bool isUnique1(string s) {
  bool set[256]; 
  memset(set, 0, sizeof(set));
  int len = s.length();
  for (int i = 0; i < len; i++) {
    int val = (int)s[i];
    if (set[val])
      return false; 
    set[val] = true;
  }
  return true; 
}

bool isUnique2(string s) {
  int A[8];
  memset(A, 0, sizeof(A));
  int len = s.length();
  for (int i = 0; i < len; i++) {
    int val = (int)s[i];
    int index = val/32;
    int shift = val % 32;
    if (A[index] & (1<<shift))
      return false; 
    // A[index] ^ (1<<shift); // or A[index] | (1<<shift);  They are wrong!!!
    A[index] ^= (1<<shift); // or A[index] |= (1<<shift);
  }
  return true; 
}

bool isUnique3(string s) {
    int check = 0;
    int len = s.length();
    for(int i=0; i < len; ++i) {    
        int v = (int)(s[i]-'a');
        if(check & (1 << v)) return false;
        check |= (1 << v);
    }
    return true;
}

int main() {
    string s1 = "i am hawstein.";
    string s2 = "abcdefghijklmnopqrstuvwxyzABCD1234567890";
    cout << isUnique1(s1) << " " << isUnique1(s2) << endl;
    cout << isUnique2(s1) << " " << isUnique2(s2) << endl;
    return 0;
}
