#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    string ostr;
    cin >> str >> ostr;

    char bits[2];
    bits[0] = str[0];
    bits[1] = str[1];

    ostr[0] = bits[0];
    ostr[1] = bits[1];

    cout << ostr;
    return 0;
}