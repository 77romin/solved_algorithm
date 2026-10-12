import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length*5; // cache 크기가 0일때는 모두 cache miss이므로 [도시 배열 크기 * 5초]!!
        
        
        int runtime = 0; // 총 실행시간
        
        Deque<String> cache = new ArrayDeque<>(); // 캐시저장할 큐 (LRU)
        
        for(String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 없음
            if(!cache.contains(city)) { // 캐시에 city가 없으면 cache miss로 +5초
                runtime += 5;
                if(cache.size()==cacheSize) cache.pollFirst();
                cache.offerLast(city);
            } else { // 캐시에 city가 있으면 cache hit으로 +1초
                runtime += 1;
                Deque<String> tmpDq = new ArrayDeque<>();
                while(true) {
                    String chkQuery = cache.poll();
                    if(!chkQuery.equals(city)) {
                        tmpDq.offerLast(chkQuery);
                        continue;
                    }
                    
                    while(!tmpDq.isEmpty()) {
                        cache.offerFirst(tmpDq.pollLast());
                    }
                    cache.offerLast(city);
                    break;
                }
            }
        }
        
        return runtime;
    }
}