import java.util.*;

public class Solution {
    public int solution(int n) {
        int useBattery = 1; // 일단 한 칸 움직이고 시작해야지 가능하니까 +1
        while(n>1) {
            if(n%2==0) {
                n /= 2;
            } else {
                n -= 1;
                useBattery++;
            }
        }
        return useBattery;
    }
}