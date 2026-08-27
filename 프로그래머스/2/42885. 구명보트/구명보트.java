import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        if(people.length==1)
            return 1;
        
        int cnt = 0; // num of boats
        
        int heavy_i = people.length-1;
        int light_i = 0;
        
        while(light_i<=heavy_i) {
            if(people[heavy_i]+people[light_i] <= limit) // 두 사람이 탈 수 있으면 가벼운 사람 index도 증가
                light_i++;
            
            // 두 사람이 타지 못하면 가벼운 사람 index는 증가하지 않음
            heavy_i--; // 무거운 사람은 항상 보트에 탑승
            
            cnt++; // 보트 수 증가
        }
        
        return cnt;
    }
}