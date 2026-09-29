#include <string>
#include <vector>

using namespace std;

void change(int idx, string cur, string& target, vector<string>& words, vector<int>& dp, int cnt, int& answer) {
    // 종료조건
    if(answer<cnt) return;
    if(cur==target) {
        answer = cnt;
        return;
    }
    if(idx!=-1) {
        if(dp[idx]<=cnt) return;
        else dp[idx] = cnt;
    }
    
    for(int i=0; i<words.size(); i++) {
        int diff = 0;
        for(int j=0; j<words[i].length(); j++) {
            if(cur[j] != words[i][j]) diff++; 
        }
        if(diff!=1) continue;
        change(i, words[i], target, words, dp, cnt+1, answer);
    }
}

int solution(string begin, string target, vector<string> words) {
    int INF = 1e9;
    
    int answer = INF;
    vector<int> dp(words.size(), INF);
    
    change(-1, begin, target, words, dp, 0, answer);
    
    return answer==INF ? 0 : answer;
}

// dfs + dp활용