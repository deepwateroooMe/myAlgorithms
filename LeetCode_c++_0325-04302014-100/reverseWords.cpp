#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

void reverseWords(string &s)
{
    string tmp = s;
    istringstream is(s);
    string word;
    vector<string> vs;
    int counter = 0;
    
    while(is >> word) {    
        ++counter;
        vs.push_back(word);
    }

    s = "";
    for (int i = 0; i < counter; ++i) {    
        s.append(vs[counter-1-i]);
        if (i < counter-1)
            s.append(" ");
    }
}

int main()
{
    string s = "         the sky is blue     ";
    string s1 = "I am pretty";
    
    reverseWords(s);
    cout << s << endl;

    return 0;
}
