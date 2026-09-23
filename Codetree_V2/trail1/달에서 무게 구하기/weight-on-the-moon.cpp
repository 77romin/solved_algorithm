#include <iostream>
using namespace std;

int main() {
    int m = 13;
    double g = 0.165;

    cout << m << " * ";
    cout << fixed;
    cout.precision(6);
    cout << g << " = " << m*g;
    return 0;
}