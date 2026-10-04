import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int n : arr) {
            for(int i=0; i<n; i++)
                res.add(n);
        }
        
        int[] answer = new int[res.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = res.get(i);
        
    
        return answer;
    }
}