import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        for(int i=0; i<3; i++) {
            for(int j=i+1; j<4; j++) {
                int a = (dots[i][1]-dots[j][1]) / (dots[i][0]-dots[j][0]);
                int aa = (dots[i][1]-dots[j][1]) % (dots[i][0]-dots[j][0]);
                
                int[] others = new int[2];
                int cnt = 0;
                for(int k=0; k<4; k++)
                    if(k!=i && k!=j)
                        others[cnt++] = k;
                
                int b = (dots[others[0]][1]-dots[others[1]][1]) / (dots[others[0]][0]-dots[others[1]][0]);
                int bb = (dots[others[0]][1]-dots[others[1]][1]) % (dots[others[0]][0]-dots[others[1]][0]);
                if(a==b && aa==bb)
                    return 1;                                                        
            }
        }
        
        return 0;
    }
}


// y/x = yy/xx --> xyy = yxx