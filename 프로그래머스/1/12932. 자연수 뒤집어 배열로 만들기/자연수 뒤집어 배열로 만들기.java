import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            answer[str.length()-1-i] = str.charAt(i) - '0'; // 문자를 정수형 숫자로 변환
        }
        return answer;
    }
}