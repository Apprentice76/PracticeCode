#include <bits/stdc++.h>
#include <cmath>
#define FOR(i, j, k, in) for(int i=j; i<k; i+=in)
#define FORD(i, j) FOR(i, 0, j, 1)
#define RFOR(i, j, k, in) for(int i=j; i>=k; i-=in)
#define RFORD(i, j) RFOR(i, 0, j, 1)
using namespace std;

void abbreviate(string s, int l);

int main() {
    int n;
    cin >> n;
    cin.ignore(1,'\n');
    while (n--) {
        string str;
        getline(cin, str);
        int len = str.length() - 2;
        if (len > 8) abbreviate(str, len);
        else cout << str << endl;

    }
    return 0;
}

void abbreviate(string s, int l) {
    string tmp = s.at(0) + to_string(l) + s.at(l+1);
    cout << tmp << endl;
}