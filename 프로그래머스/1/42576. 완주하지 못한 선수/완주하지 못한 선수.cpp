#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> complete;
    
    for(string &p : participant)
        complete[p]++;;
    
    for(string &c : completion)
        complete[c]--;
    
    for(string &p : participant)
        if(complete[p]>0) return p;
    
    return "";
}