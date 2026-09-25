#include <bits/stdc++.h>

using namespace std;

int solution(string s) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    vector<char> str;
    for(int i=0; i<s.length(); i++) {
        str.push_back(s[i]);
    }
    
    int answer = 0;
    for(int i=0; i<s.length(); i++) {
        char move = str[0];
        str.erase(str.begin());
        str.push_back(move);
        
        deque<char> dq;
        bool isWrong = false;
        for(char c : str) {
            if(c=='[' || c=='{' || c=='(')
                dq.push_back(c);
            else {
                if(dq.empty()) {
                    isWrong = true;
                    break;
                }
                
                char temp = dq.back();
                if(!((c==']' && temp=='[')
                   ||(c=='}' && temp=='{')
                   ||(c==')' && temp=='('))) {
                    isWrong = true;
                    break;
                }
                dq.pop_back();
            }
        }
        if(!isWrong && dq.empty())
            answer++;
    }
    
    return answer;
}