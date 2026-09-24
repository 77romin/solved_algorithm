#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    cin >> str;
    str[1] = 'a';
    str[(int)str.length()-2] = 'a';

    cout << str;
    
    return 0;
}