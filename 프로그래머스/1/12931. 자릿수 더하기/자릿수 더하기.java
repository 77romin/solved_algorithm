import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = Integer.toString(n);
        String[] sBits = s.split("");
        
        int answer = 0;
        for(String sBit : sBits)
            answer += Integer.parseInt(sBit);
        return answer;
    }
}