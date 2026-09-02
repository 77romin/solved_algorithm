import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : arr)
            if(num%divisor==0)
                list.add(num);
        
        int[] answer = new int[list.size()];
        
        if(list.size()==0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int i=0;
        for(int n : list)
            answer[i++]=n;
        
        Arrays.sort(answer);
        
        return answer;
    }
}