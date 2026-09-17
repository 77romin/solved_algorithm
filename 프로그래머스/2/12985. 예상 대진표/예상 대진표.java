class Solution {
    public int solution(int n, int a, int b) {
        int round = 1; // 라운드는 1 라운드부터 시작
        
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(!(max%2==0&&min+1==max)) {
            max = max%2==0 ? max/2 : max/2+1;
            min = min%2==0 ? min/2 : min/2+1;
            round++;
        }

        return round;
    }
}