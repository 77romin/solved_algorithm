#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end());
    int sp = 0;
    int ep = people.size()-1;
    
    int answer = 0;
    while(sp<=ep) {
        if(people[sp]+people[ep]<=limit) {
            sp++;
            ep--;
            answer++;
        } else {
            ep--;
            answer++;
        }
    }
    
    return answer;
}