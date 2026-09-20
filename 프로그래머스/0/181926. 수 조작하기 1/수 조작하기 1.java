class Solution {
    public int solution(int n, String control) {
        String[] cmd = control.split("");
        for(String c : cmd) {
            switch(c) {
                case "w":
                    n+=1;
                    break;
                case "s":
                    n-=1;
                    break;
                case "d":
                    n+=10;
                    break;
                case "a":
                    n-=10;
                    break;
                default:
                    break;
            }
        }
        
        
        return n;
    }
}