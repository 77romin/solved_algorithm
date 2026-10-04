class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int start = my_string.length()-n;
        String[] sBits = my_string.split("");
        for(int i=start; i<my_string.length(); i++)
            answer += sBits[i];
        return answer;
    }
}