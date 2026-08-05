import java.util.*;

class Solution {
    boolean solution(String s) {
        String[] sBits = s.split("", s.length());
        
        int cnt = 0;
        for(String sBit : sBits) {
            cnt = sBit.equals("p") ? cnt+1 : cnt;
            cnt = sBit.equals("P") ? cnt+1 : cnt;
            cnt = sBit.equals("y") ? cnt-1 : cnt;
            cnt = sBit.equals("Y") ? cnt-1 : cnt;
        }

        return cnt==0?true:false;
    }
}