import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++) // progress 인덱스 번호를 queue에 넣기
            queue.offerLast(i);
        
        while(!queue.isEmpty()) {
            for(int i=0; i<progresses.length; i++) { // 작업 1회
                if(progresses[i]<100)
                    progresses[i] += speeds[i];
                else
                    stack.offerLast(i);
            }
            
            if(stack.isEmpty()) continue;
            
            int cnt=0;
            while(!stack.isEmpty()) {
                if(!stack.contains(queue.peekFirst())) break;
                queue.pollFirst();
                cnt++;
            }
            
            if(cnt!=0)
                list.add(cnt);
        }
         
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * progress를 순서대로 queue에 넣고, queue의 front가 완료되기까지 완료된 모든 progress를 stack에 넣는다.
 * 이후 front progress가 완료되면 stack을 비운다.
 */