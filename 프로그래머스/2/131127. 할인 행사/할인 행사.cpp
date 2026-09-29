#include <bits/stdc++.h>
using namespace std;

bool isOkay(vector<string> &want, unordered_map<string, int> &map, int &n) {
    for(string w : want) {
        if(map[w]>0) return false;
    }
    return true;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    int n = want.size();
    
    unordered_map<string, int> map;
    for(int i=0; i<n; i++)
        map.insert({want[i], number[i]});
    
    for(int i=0; i<10; i++) {
        string s = discount[i];
        if(map.find(s) == map.end()) continue;
        map[s] -= 1;
    }
    answer = isOkay(want, map, n) ? answer+1 : answer;
    
    for(int i=0; i<discount.size()-10; i++) {
        string os = discount[i];
        string is = discount[i+10];
        map[os] += 1;
        map[is] -= 1;
        if(isOkay(want, map, n)) answer++;
    }
    
    return answer;
}

// 투 포인터(슬라이딩 윈도우)
// n은 최대 10