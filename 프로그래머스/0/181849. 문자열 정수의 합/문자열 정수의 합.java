class Solution {
    public int solution(String num_str) {
        String[] numBits = num_str.split("");
        int answer = 0;
        for(String num : numBits)
            answer += Integer.parseInt(num);
        return answer;
    }
}