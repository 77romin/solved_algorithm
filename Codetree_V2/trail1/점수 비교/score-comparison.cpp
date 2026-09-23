#include <iostream>
using namespace std;

int main() {
    int aMath, aEng;
    cin >> aMath >> aEng;

    int bMath, bEng;
    cin >> bMath >> bEng;

    cout << (aMath > bMath && aEng > bEng) ? 1 : 0;
    
    return 0;
}