#include <iostream>
using namespace std;

int main() {
    double sum;
    for(int i=0; i<8; i++) {
        double n;
        cin >> n;
        sum += n;
    }
    cout << fixed;
    cout.precision(1);
    cout << (sum/8);
    return 0;
}