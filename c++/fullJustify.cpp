#include <iostream>
#include <vector>
using namespace std;

typedef vector<string> vs;
void print(vs tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << "\"" << tmp[i] << "\"" << endl;
}

string printSpc(int cnt) {
    string result = "";
    for (int i = 0; i < cnt; ++i)
        result.append(" ");
    return result;
}
    
vector<string> fullJustify(vector<string> &words, int L) {
    vector<string> result;
    string line = "";
    int tword = words.size();
    int wsize[words.size()];    
    for (int i = 0; i < tword; ++i) 
        wsize[i] = words[i].length();
    
    int wcnt = 0; // number of words
    int lsize = wsize[0];
    int twsize = 0;
    int spc = 1;
    int mspc = 0;
    int low = 0;
    int high = 0;
    while (high <= tword-1) {
        while (high <= tword-2 && lsize+wsize[high+1]+1 <= L) {
            ++wcnt;
            high = low + wcnt;
            lsize += (1+wsize[high]);
        }

        for (int i = low; i <= high; ++i) 
            twsize += wsize[i];
        
        if (wcnt == 0) {
            spc = L-wsize[low];
            line.append(words[low]);
            line.append(printSpc(spc));
            result.push_back(line);
            line = "";
            low = high+1;
            high = low;
            twsize = 0;
            lsize = wsize[low];
        } else {
            spc = (L-twsize)/(wcnt);
            mspc = (L-twsize)%(wcnt);
            for (int i = low; i <= high; ++i) {
                line.append(words[i]);
                if (high < tword-1) {
                    if (i < high) {            
                        if (i-low < mspc)
                            line.append(printSpc(spc+1));
                        else
                            line.append(printSpc(spc));
                    }
                } else {
                    if (i < high) 
                        line.append(printSpc(1));
                    else
                        line.append(printSpc(L-twsize-wcnt));
                }
            }
            result.push_back(line);
            line = "";
            low = high +1;
            high = low;
            lsize = wsize[low];
            wcnt = 0;
            twsize = 0;
        }
    }
    return result;
}

int main() 
{
    int L = 14;
    //string tmp[7] = {"This", "is", "an", "example", "of", "text", "justification."};
    //string tmp[] = {"Listen","to","many,","speak","to","a","few."};
    //string tmp[] = {"What","must","be","shall","be."};
    string tmp[] = {"Imagination","is","more","important","than","knowledge."};
    vs words;
    for (int i = 0; i < 6; ++i) 
        words.push_back(tmp[i]);

    vs result = fullJustify(words, L);
    print(result);
        
    return 0;
}
