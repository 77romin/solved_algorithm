class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[names.length%5==0 ? names.length/5 : names.length/5+1];
        
        int cnt = 1;
        int ansCnt = 0;
        for(String name : names) {
            if(cnt==5) { cnt=1; continue;}
            if(cnt==1)
                answer[ansCnt++] = name;
            cnt++;
        }
        
        return answer;
    }
}