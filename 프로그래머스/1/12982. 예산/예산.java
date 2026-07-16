import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int cnt = 0;
        for(int dBit : d) {
            sum += dBit;
            if(sum<=budget) cnt++;
            else break;
        }
        
        return cnt;
    }
}