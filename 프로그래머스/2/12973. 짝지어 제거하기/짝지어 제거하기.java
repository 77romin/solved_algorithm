import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        int answer = -1;

        String[] sBits = s.split("");
        
        Deque<String> dq = new ArrayDeque<>();
        
        for(String sBit : sBits) {
            if(dq.isEmpty()) {
                dq.offerLast(sBit);
                continue;
            }
            
            if(dq.peekLast().equals(sBit))
                dq.pollLast();
            else
                dq.offerLast(sBit);
        }

        return answer=dq.isEmpty()?1:0;
    }
}