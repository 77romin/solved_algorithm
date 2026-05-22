class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babble : babbling) {
            while(babble.length()!=0) {
                if(babble.startsWith("aya"))
                    babble=babble.substring(3);
                else if(babble.startsWith("ye"))
                    babble=babble.substring(2);
                else if(babble.startsWith("woo"))
                    babble=babble.substring(3);
                else if(babble.startsWith("ma"))
                    babble=babble.substring(2);
                else break;
            }
            if(babble.length()==0) answer++;
                
        }
        return answer;
    }
}