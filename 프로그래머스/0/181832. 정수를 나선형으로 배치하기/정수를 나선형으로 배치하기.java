class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int x=0; 
        int y=0;
        int chk = 0; // 0:R, 1:D, 2:L, 3:U
        
        for(int i=1; i<=n*n; i++) {
            answer[y][x] = i;
            switch(chk) {
                case 0:
                    x++;
                    if(x==n||answer[y][x]!=0) {
                        x--;
                        chk++;
                    }
                    else break;
                case 1:
                    y++;
                    if(y==n||answer[y][x]!=0) {
                        y--;
                        chk++;
                    }
                    else break;
                case 2:
                    x--;
                    if(x<0||answer[y][x]!=0) { 
                        x++;
                        chk++;
                    }
                    else break;
                case 3:
                    y--;
                    if(y<0||answer[y][x]!=0) {
                        y++;
                        x++;
                        chk=0;
                    }
                    else break;
                default:
                    break;
            }
        }
        
        // D:[-1, 0], L: [0, -1] , U: [1, 0], R: [0, 1]
        // x [1, 0, -1, 0]
        // y [0, -1, 0, 1]
        
        
        return answer;
    }
}