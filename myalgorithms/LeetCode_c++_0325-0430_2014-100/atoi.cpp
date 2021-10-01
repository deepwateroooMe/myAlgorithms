#include <iostream>
#include <string.h>
#include <math.h>
#include <limits.h>
using namespace std;

int myatoi(const char *str)
{
    char sVal[11];
    int svIdx = 0;

    const char *tmp = str;
    const char *start = str;
    bool posi = true;
    bool pmark = false;
    bool zstar = false;
    long int result = 0;
    long int inter = 1;
    
    while (*tmp != '\0' && *tmp == ' ') // whitespace
        ++tmp;
    start = tmp;
    
    if (*start == '\0' || ((*tmp < '0') && (*tmp != '+') && (*tmp != '-')) || (*tmp > '9'))
        return 0;
    
    if ( (*start != '-') && (*start != '+') ) {// 0-9
        posi = true;
        if ( *start == '0' ) {        
            zstar = true;
            while (*start == '0' && *start != '\0')
                ++start;
            if (*start == '\0' || (*start < '0' || *start > '9') )
                return 0;
        }
        sVal[svIdx++] = *start;
        ++start;
    } else { // +/-      
        if (*start == '-')       
            posi = false;
        else if (*start == '+')
            pmark = true;
        ++start;
        if ( (pmark || !posi) && (*start < '0' || *start > '9'))
            return 0;
        if ( *start == '0' ) {        
            zstar = true;
            while (*start == '0' && *start != '\0')
                ++start;
            if (*start == '\0' || (*start < '0' || *start > '9') )
                return 0;
        }
        sVal[svIdx++] = *start;
        ++start;
    }

    while (*start != '\0' && *start >= '0' && *start <= '9' && svIdx < 11) {
        sVal[svIdx++] = *start;
        start++;
    }

    if (svIdx == 11) {    
        if (posi)
            return INT_MAX;
        else
            return INT_MIN;
    }
    
    for (int i = svIdx-1; i >= 0; i--) {        
        inter = (long)(pow((float)10.0, (svIdx-1-i)));
        if ( (i == 0) && (sVal[0]>='2') ){        
            if (posi && result >= 147483647)
                return INT_MAX;
            else if (!posi && result >= 147483648)
                return INT_MIN;
        }

        switch(sVal[i]) {
        case '0':
            result += 0;
            break;
        case '1':
            result += 1*inter;
            break;
        case '2':
            result += 2*inter;
            break;
        case '3':
            result += 3*inter;
            break;
        case '4':
            result += 4*inter;
            break;
        case '5':
            result += 5*inter;
            break;
        case '6':
            result += 6*inter;
            break;
        case '7':
            result += 7*inter;
            break;
        case '8':
            result += 8*inter;
            break;
        case '9':
            result += 9*inter;
            break;
        }
    }
    if (!posi)
        return (-1)*result;
    else
        return result;
}
 
int main()
{
    const char * b = "  1175109307q7 ";
    cout << myatoi(b) << endl;
    const char * a = "  ++1 ";
    const char * a0 = "   - 321   ";
    const char * a00 = "   +004500    ";
    const char * a000 = "   -000000009878.8679.h ";
    const char * a0000 = "1";
    const char * a00000 = "-1";
    const char * a000000 = "     +0a32";
    const char * a0000000 = "     +11191657170";
    const char * a00000000 = "2147483648";
    const char * a000000000 = "    +b12102370352";
    const char * a0000000000 = "    b11228552307";
    cout << myatoi(a) << endl;
    cout << myatoi(a0) << endl;
    cout << myatoi(a00) << endl;
    cout << myatoi(a000) << endl;
    cout << myatoi(a0000) << endl;
    cout << myatoi(a00000) << endl;
    cout << myatoi(a000000) << endl;
    cout << myatoi(a0000000) << endl;
    cout << myatoi(a00000000) << endl;
    cout << myatoi(a000000000) << endl;
    cout << myatoi(a0000000000) << endl;
    return 0;
}
