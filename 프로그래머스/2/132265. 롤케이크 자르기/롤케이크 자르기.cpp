#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> topping) {
    
    if(topping.size()==1) return 0;
    
    int answer = 0;
    
    unordered_map<int, int> umap; // 전체 넣기
    for(int target : topping) {
        if(umap.find(target) == umap.end())
            umap.insert({target, 1});
        else
            umap[target]++;
    }
    
    unordered_map<int, int> fmap; // 앞 부분 넣기
    fmap.insert({topping[0], 1});
    umap[topping[0]] -= 1;
    if(umap[topping[0]]==0) 
            umap.erase(topping[0]);
    
    for(int i=1; i<topping.size(); i++) { 
        if(fmap.size() == umap.size())
            answer++;
        
        if(fmap.find(topping[i]) == fmap.end()) {
            fmap.insert({topping[i], 1});
            umap[topping[i]]--;
        } else {
            fmap[topping[i]]++;
            umap[topping[i]]--;
        }
        
        if(umap[topping[i]]==0) 
            umap.erase(topping[i]);
    }
    
    return answer;
}

// map + 누적합(prefix)를 사용하면 될 듯