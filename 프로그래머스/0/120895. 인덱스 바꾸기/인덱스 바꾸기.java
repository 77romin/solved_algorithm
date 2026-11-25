class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] strBits = my_string.split("");
        String bit1 = strBits[num1];
        String bit2 = strBits[num2];
        strBits[num1] = bit2;
        strBits[num2] = bit1;
        for(String strBit : strBits)
            answer += strBit;
        return answer;
    }
}