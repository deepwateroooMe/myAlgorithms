#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
#include <unordered_map>
using namespace std;

// time limit exceeded
int lengthOfLongestSubstring(string s) {
    if (s == "") return 0;
    int n = s.size();

    if ( n == 1) return 1;
    else if (n == 2) {
        if (s[0] == s[1]) return 1;
        return 2;
    }

    unordered_map<char, int> hash;
    int low = 0;
    int len = 0;
    int i = 0;
    while (i < n)  {
        if (!hash.count(s[i])) 
            hash[s[i]] = i;
        else {
            if (len < i - low)  {
                len = i - low;
            }
            for(int j = low; j < hash[s[i]]; ++j)
                hash.erase(s[j]);
            low = hash[s[i]]+1;
            hash[s[i]] = i;
        }
        ++i;
    }
    if (i == n) {
        if (len < i - low)
            len = i - low;
    }
    return len;
}

int main(){
    //string s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
    string s = "qopubjguxhxdipfzwswybgfylqvjzhar";
    cout << lengthOfLongestSubstring(s) << endl;
    
    return 0;
}

/*
  time limit exceeded
  int lengthOfLongestSubstring(string s) {
  if (s == "") return 0;
  int n = s.size();
  if ( n == 1) return 1;
  else if (n == 1) {
  if (s[0] == s[1]) return 1;
  else return 2;
  }

  unordered_map<char, int> hash;
  unordered_map<char, int> fnd;
  int low = 0;
  int len = 0;
  int i = 0;
  while (i < n)  {
  if (!fnd.count(s[i])) {
  hash[s[i]] = i;
  fnd[s[i]] = 1;
  } else {
  //cout << "i: " << i << endl;
  //cout << "low: " << low << endl;
  if (len < i - low)
  len = i-low;
  //cout << "len: " << len << endl << endl;
  //cout << "hash[s[i]]: " << hash[s[i]] << endl;
  if (hash[s[i]] == i-1)
  low = i;
  else low = hash[s[i]]+1;
  if (hash[s[i]] == i-1) fnd.clear();
  else  {
  for(int i = 0; i <= hash[s[i]]; ++i)
  if (fnd.count(s[i])) fnd.erase(s[i]);
  }
  fnd[s[i]] = 1;
  hash[s[i]] = i;
  }
  ++i;
  }
  return len;
  }
*/
