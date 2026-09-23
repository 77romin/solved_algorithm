#include <iostream>
using namespace std;

int main() {
    double ft = 30.48;
    double part;
    cin >> part;
    cout << fixed;
    cout.precision(1);
    cout << part*ft;
    return 0;
}