#include <iostream>
using namespace std;

int main() {
    int n;
    string s;
    cin >> n;
    for(int i=0; i<n; i++) {
        string next;
        cin >> next;
        s.append(next);
    }
    
    cout << s;

    return 0;
}