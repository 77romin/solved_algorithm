import java.util.List;
import java.util.ArrayList;

class Solution {
    private int[] answer;
    public int[] solution(int[] num_list, int n) {
        if(num_list.length%n==0)
            answer = new int[num_list.length/n];
        else
            answer = new int[num_list.length/n+1];
        
        int cnt = 0;
        for(int i=0; i<num_list.length; i++) {
            if(i%n==0)
                answer[cnt++] = num_list[i];
        }
        
        return answer;
    }
}