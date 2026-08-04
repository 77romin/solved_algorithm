class Solution {
    public int[] solution(int brown, int yellow) {
        int n = brown+yellow; // 전체 격자의 개수
        
        /**
         * n의 약수가 가로, 세로 길이 (가로>=세로)
         * '달팽이'로 brown부터 채워나가자
         */
        int rh = 0; // right Height
        int rw = 0; // right Width
        
        for(int h=1; h<=Math.sqrt(n); h++) {
            if(n%h!=0) // 나누어 떨어지지 않으면 넘어가기
                continue;
            
            int w = n/h;
            
            int cnt = 0;
            int yellowArea = 1;
            while(yellowArea>0) {
                yellowArea = (h-(2*cnt))*(w-(2*cnt));
                if(yellow == yellowArea) { // yellow area
                    rh = h;
                    rw = w;
                    break;
                } else
                    cnt++;
            }
            if(rh!=0 && rw!=0)
                break;
        }
        
        
        int[] answer = {rw, rh};
        return answer;
    }
}