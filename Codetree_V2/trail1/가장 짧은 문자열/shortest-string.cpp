#include <bits/stdc++.h>
using namespace std;

int main() {
    string str[4];
    cin >> str[1] >> str[2] >> str[3];
    
    int minN = min({ str[1].length(), str[2].length(), str[3].length() });
    int maxN = max({ str[1].length(), str[2].length(), str[3].length() });

    cout << maxN-minN;
    return 0;
}