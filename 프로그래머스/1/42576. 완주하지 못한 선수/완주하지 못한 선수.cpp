#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> complete;
    
    for(string p : participant) {
        if(complete.count(p) == 0)
            complete.insert({p, 1});
        else
            complete[p] += 1;
    }
    
    for(string c : completion)
        complete[c] -= 1;
    
    for(string p : participant) {
        if(complete[p]>0) return p;
    }
    
    return "";
}