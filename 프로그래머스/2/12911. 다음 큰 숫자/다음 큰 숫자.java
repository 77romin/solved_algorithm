import java.util.Arrays;
import java.lang.Integer;

class Solution {
    public int solution(int n) {
//         String binaryN = Integer.toBinaryString(n); // 10진수 -> 2진수
//         String[] bBits = binaryN.split("");
        
//         int cnt = 0;
//         for(String bBit : bBits)
//             cnt = bBit.equals("1") ? cnt+1 : cnt;
        
//         int nextBig = n; // n보다 큰 수를 하나하나 2진수로 바꿔서 가장 먼저 1의 갯수가 같은 것을 반환 --> 시간초과...
//         while(true) {
//             int nCnt=0;
//             String binaryNextN = Integer.toBinaryString(++nextBig);
//             String[] bNBits = binaryNextN.split("");
//             for(String bNBit : bNBits)
//                 nCnt = bNBit.equals("1") ? nCnt+1 : nCnt;
            
//             if(cnt==nCnt)
//                 break;
//         }
//         return nextBig;
        
        int cntOne = Integer.bitCount(n);
        while(true) {
            int cntOneNext = Integer.bitCount(++n);
            if(cntOneNext == cntOne)
                break;
        }
        
        return n;
    }
}