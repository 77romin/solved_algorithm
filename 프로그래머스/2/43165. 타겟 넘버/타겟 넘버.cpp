#include <string>
#include <vector>

using namespace std;

int ans;
vector<int> n;
int t;

void cal(int i, int res) {
    if(i==n.size()) {
        if(res==t)
            ans++;
        return;
    }
    
    cal(i+1, res+n[i]);
    cal(i+1, res-n[i]);
    
}

int solution(vector<int> numbers, int target) {
    ans = 0;
    n = numbers;
    t = target;
    
    cal(0, 0);
    
    return ans;
}

// DFS - O(2^N)