#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = string(phone_number.length()-4, '*');
    answer.append(phone_number.substr(phone_number.length()-4));
    return answer;
}