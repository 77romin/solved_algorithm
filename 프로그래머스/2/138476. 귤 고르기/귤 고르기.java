import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    private int remainNum;
    private int answer = 0;
    private int maxCnt = -1;
    
    public int solution(int k, int[] tangerine) {
        this.remainNum = k;
        
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int t:tangerine) // 해시맵에 크기별 귤 넣어주기 (key: 크기 / value: 개수)
            hashmap.put(t, hashmap.getOrDefault(t, 0)+1);
        
        int[] arr = new int[hashmap.size()];
        int i=0;
        for(int key:hashmap.keySet()) {
            arr[i] = hashmap.get(key);
            i++;
        }
        
        Arrays.sort(arr);
        for(int j=arr.length-1; j>=0; j--) {
            k-=arr[j];
            answer++;
            if(k<=0) break;
        }
        
        
        return answer;
    }

}