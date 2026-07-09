import java.lang.Math;

class Solution {
    public long solution(long n) {
        if(Math.sqrt(n)!=Math.floor(Math.sqrt(n)))
            return -1;
        long answer = (long) Math.pow(Math.floor(Math.sqrt(n))+1, 2);
        return answer;
    }
}