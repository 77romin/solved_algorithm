#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    cin >> str;
    int n;
    cin >> n;

    int len = str.length();

    if(n>len)
        n = len;
    for(int i=len-1; i>len-1-n; i--)
        cout << str[i];
    return 0;
}