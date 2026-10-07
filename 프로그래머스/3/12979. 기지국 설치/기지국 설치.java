class Solution {
    
    public int solution(int n, int[] stations, int w) {
        
        /* 
            DP: 기지국과 기지국 사이로 나눠서 추가 설치하기
        */
        
        int cnt = 0; // 추가 설치 기지국
        
        int range = 0; // 구간 길이
        int sp = 1; // 구간 시작점
        int ep = -1; // 구간 끝점
        for(int station : stations) {
            ep = station-w-1; 
            
            if(sp<=ep) {
                range = ep-sp+1;
                cnt += range%(2*w+1)==0 ? range/(2*w+1) : range/(2*w+1)+1;
            }
            
            
            sp = station+w+1;
        }
        
        if(sp<=n) {
            range = n-sp+1;
            cnt += range%(2*w+1)==0 ? range/(2*w+1) : range/(2*w+1)+1;
        }
        
        
        return cnt;
    }
}