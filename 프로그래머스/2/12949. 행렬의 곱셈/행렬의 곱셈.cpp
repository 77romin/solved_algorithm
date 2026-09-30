#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    
    for(int i=0; i<arr1.size(); i++) {
        vector<int> row;
        for(int j=0; j<arr2[0].size(); j++) {
            int mult_sum = 0;
            for(int ii=0; ii<arr1[0].size(); ii++) {
                mult_sum += arr1[i][ii]*arr2[ii][j];
            }
            row.push_back(mult_sum);
        }
        answer.push_back(row);
    }
    
    return answer;
}