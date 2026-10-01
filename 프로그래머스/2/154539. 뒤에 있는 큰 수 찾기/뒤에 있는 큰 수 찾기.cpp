#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), 0);
    
    stack<pair<int, int>> s;
    s.push({0, numbers[0]});
    for(int i=1; i<numbers.size(); i++) {
        while(!s.empty()) {
            pair<int, int> comp = s.top();
            if(comp.second>=numbers[i]) break;

            answer[comp.first] = numbers[i];
            s.pop();  
        }
        s.push({i, numbers[i]});
    }
    
    while(!s.empty()) {
        pair<int, int> comp = s.top();
        answer[comp.first] = -1;
        s.pop();
    }
    
    return answer;
}