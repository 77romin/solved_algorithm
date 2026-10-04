class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        String[] sBits = my_string.split("");
        for(int i=0; i<sBits.length; i++) {
            if(sBits[i].equals(alp))
                sBits[i] = sBits[i].toUpperCase(); 
            answer += sBits[i];
        }
        return answer;
    }
}