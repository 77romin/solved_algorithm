#include <iostream>
using namespace std;

int main() {
    int input[4][4];
    for(int i=0; i<4; i++)
        for(int j=0; j<4; j++)
            cin >> input[i][j];
    
    for(int i=0; i<4; i++) {
        int sum = 0;
        for(int j=0; j<4; j++)
            sum += input[i][j];
        cout << sum << endl;
    }
    return 0;
}