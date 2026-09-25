#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int mid = s.length()/2;
    
    string ans = "";
    if(s.length()%2 == 0)
        ans+=s[mid-1];
    ans+=s[mid];
    return ans;
}