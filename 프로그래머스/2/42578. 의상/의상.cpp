#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<string>> clothes) {
    vector<string> kind;
    vector<int> kind_cnt;
    
    for(vector<string> cloth : clothes) {
        if(find(kind.begin(), kind.end(), cloth[1]) == kind.end()) {
            kind.push_back(cloth[1]);
            kind_cnt.push_back(1);
        } else {
            kind_cnt[find(kind.begin(), kind.end(), cloth[1])-kind.begin()] += 1;
        }
    }
    
    int answer = 1;
    for(int cnt : kind_cnt)
        answer *= (cnt+1);
    answer -= 1;
    return answer;
}