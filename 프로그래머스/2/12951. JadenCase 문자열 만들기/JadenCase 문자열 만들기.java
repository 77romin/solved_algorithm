class Solution {
    public String solution(String s) {
        String answer = "";
        
        s=s.toLowerCase();
        
        String[] sBits = s.split("");
        
        boolean chk = true;
        for(String sBit:sBits) {
            if(chk) {
                sBit = sBit.toUpperCase();
                chk = false;
            }
            if(sBit.equals(" ")) chk = true;
            answer += sBit;
        }
        return answer;
    }
}