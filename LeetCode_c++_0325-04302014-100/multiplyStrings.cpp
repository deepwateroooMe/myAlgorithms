#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

int toi(char a) {
    switch(a) {
    case '0': return 0;        
    case '1': return 1;        
    case '2': return 2;        
    case '3': return 3;        
    case '4': return 4;        
    case '5': return 5;        
    case '6': return 6;        
    case '7': return 7;        
    case '8': return 8;        
    case '9': return 9;        
    }
}

char toc(int a) {
    switch(a) {
    case 0: return '0';        
    case 1: return '1';        
    case 2: return '2';        
    case 3: return '3';        
    case 4: return '4';        
    case 5: return '5';        
    case 6: return '6';        
    case 7: return '7';        
    case 8: return '8';        
    case 9: return '9';        
    }
}

string mmul(string s, char a) {
    string tmp = "";
    if (s.size() == 0 || a == '0') return "0";
    int m = s.size();
    char pos;
    int one, rover = 0;
    
    for(int i = m-1; i >= 0; --i) {
        one = toi(s[i])*toi(a)+rover;
        pos = toc(one % 10);
        tmp.insert(0, 1, pos);
        rover = one / 10;
    }
    if (rover)
        tmp.insert(0, 1, toc(rover));
    return tmp;
}

string madd(string s, string t) {
    int m = s.size();
    int n = t.size();
    if (m == 0) return t;
    else if (n == 0) return s;
    int i = m-1, j = n-1;

    string tmp = "", tmp2;
    int one, rover = 0;
    char pos;
    while(i >= 0 && j >= 0) {
        one = toi(s[i])+toi(t[j])+rover;
        pos = toc(one % 10);
        tmp.insert(0, 1, pos);
        rover = one / 10;
        --i;
        --j;
    }
    if (i < 0 && j < 0) {    
        if (rover) tmp.insert(0, 1, toc(rover));
        return tmp;
    }
    if( i >= 0 || j >= 0) {
        tmp2 = (i >= j) ? s.substr(0, i+1) : t.substr(0, j+1);
        i = (i>=j) ? i : j;
        while ( i>= 0 && (toi(tmp2[i])+rover)/10 )  {
            one = toi(tmp2[i])+rover;
            tmp.insert(0, 1, toc(one % 10));
            rover = (toi(tmp2[i])+rover)/10;
            --i;
        }
        
        if (i < 0  && rover == 0) return tmp;
        else if (i >= 0)  {
            one = toi(tmp2[i])+rover;
            tmp.insert(0, 1, toc(one%10));
            rover = one / 10;
            --i;
        }
        if (rover)
            tmp.insert(0, 1, toc(rover));
        while(i >= 0)
            tmp.insert(0, 1, tmp2[i--]);
    } 
    return tmp;
}

string multiply(string num1, string num2) {
    int m = num1.size();
    int n = num2.size();
    if (m == 0 || n == 0) return "0";
    int i = m-1, j = n-1;
    char pos;
    string tmp = "";
    string rover = "", one;
    if (i == j && i == 0){
        one = madd(mmul(num1, num2[0]), "0");
        pos = one[one.size()-1];
        tmp.insert(0, 1, pos);
        if (one.size() > 1)
            rover = one.substr(0, one.size()-1);
        if(rover.size() > 0)  {
            rover.append(tmp);
            tmp = rover;
        }
        return tmp;
    } else if (i == 0 || j ==0)  {
        if (i == 0) return mmul(num2, num1[0]);
        else return mmul(num1, num2[0]);
    }

    tmp = ""; rover = "";
    while ( i >= 0 && ((madd(mmul(num2, num1[i]), rover).size() > 1)
                       || (num1[i] == '0')) )  {
        one = madd(mmul(num2, num1[i]), rover);
        pos = one[one.size()-1];
        tmp.insert(0, 1, pos);
        if (one.size() > 1)
            rover = one.substr(0, one.size()-1);  //remove last digit
        else rover = "0";
        one = "";
        --i;
    }
    if(rover.size() > 0)  {
        rover.append(tmp);
        tmp = rover;
    }
    return tmp;
}

int main(){
    // 121932631112635269
    /*
      Output:	
      Expected:	"491555843274052692"  
      Expected:	"29416568444878648" 
      Output:	"121400144694843391548"
      Expected:	"419254329864656431168468" 
      Output:	"498150774865846593600��8�91��485���2�"
      Expected:	"25311869173291309803201639921518923209" */
        
    string s1 = "103";
    string s2 = "98";
    //cout << madd("98", "2") << endl;
    cout << multiply(s1, s2) << endl;
    //
    
    return 0;
}
