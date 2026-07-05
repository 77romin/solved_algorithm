import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(long n) {
        String[] nBits = Long.toString(n).split("");
        int[] numbers = new int[nBits.length];
        for(int i=0; i<nBits.length; i++)
            numbers[i] = Integer.parseInt(nBits[i]);
        
        Arrays.sort(numbers);
        long answer = 0;
        long pos = 1;
        for(int number : numbers) {
            answer += number*pos;
            pos *= 10;
        }
        return answer;
    }
}