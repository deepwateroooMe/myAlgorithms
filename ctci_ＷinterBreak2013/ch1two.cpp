#include <iostream>
#include <cstring>
using namespace std;

void swap(char &a, char &b){  // not understanding yet
    a = a^b;
    b = a^b;
    a = a^b;
}

void reverse(char* s) {
  int len = strlen(s);
  char tmp;
  for (int i = 0; i < len/2; ++i) {
    tmp = s[len-1-i];
    s[len-1-i] = s[i];
    s[i] = tmp;
  }
}

void reverseP(char* s) {
  if(!s) return; // I forgot this line at beginning
  char *f = s, *b = s; 
  char tmp; 
  while(*b) b++;
  b--;
  //while(f != b) {
  while(f < b) {
    tmp = *f;
    *f = *b;
    *b = tmp;
    f++;
    b--;
  }
}

void reverseFinal(char* str) {
  char * end = str; 
  char tmp;
  if (str) {           // equvilent to: if(!str) return;
    while(*end) ++end;
    --end;
    while(str < end) {
      tmp = *str;
      *str++ = *end;
      *end-- = tmp;
    }
  }
}

void reverse2(char *s){
    int n = strlen(s);
    for(int i=0; i<n/2; ++i)
        swap(s[i], s[n-i-1]);
}

void reverse1(char *s){
    if(!s) return;
    char *p = s, *q = s;
    while(*q) ++q;
    --q;
    while(p < q)
        swap(*p++, *q--);
}

int main(){
  char s[] = "1234567890";
  char a[] = "abcdefg";
  char b[]= "hijklmn";
  char c[]= "hijklmn";
  char d[]= "hijklmn";
  reverse(b);
  reverseP(c);
  reverseFinal(d);
  reverse1(s);
  reverse2(a);
  cout << "reverse:" << b << endl;
  cout << "reverseP:" << c << endl;
  cout << "reverseFinal:" << d << endl;
  cout << "reverse1:" << s << endl;
  cout << "reverse2:" << a << endl;
  return 0;
}
