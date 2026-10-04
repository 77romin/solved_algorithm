import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int aPos = 0;
        for(int i=0; i<=4; i++) {
            int ap = (int)Math.pow(10, i);
            if(a/ap == 0) {
                aPos = i;
                break;
            }
        }
        int bPos = 0;
        for(int i=0; i<=4; i++) {
            int bp = (int)Math.pow(10, i);
            if(b/bp == 0) {
                bPos = i;
                break;
            }
        }
        System.out.println(aPos+" "+bPos);
        int resA = (int)Math.pow(10,bPos)*a+b;
        int resB = (int)Math.pow(10,aPos)*b+a;
        
        return Math.max(resA, resB);
    }
}