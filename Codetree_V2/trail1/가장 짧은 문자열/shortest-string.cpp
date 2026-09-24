#include <bits/stdc++.h>
using namespace std;

int main() {
    string str[4];
    cin >> str[1] >> str[2] >> str[3];
    
    int minN = min({ (int)str[1].length(), (int)str[2].length(), (int)str[3].length() });
    int maxN = max({ (int)str[1].length(), (int)str[2].length(), (int)str[3].length() });

    cout << maxN-minN;
    return 0;
}