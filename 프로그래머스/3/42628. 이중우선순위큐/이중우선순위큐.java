import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        
        for(String operation : operations) {
            String[] operBits = operation.split(" ", 2);
            if(operBits[0].equals("I")) {
                pq.offer(Integer.parseInt(operBits[1]));
            } else {
                if(pq.isEmpty()) continue;
                
                if(pq.size()==1) {
                    pq.poll();
                    continue;
                }
                
                if(operBits[1].equals("1")) {
                    rpq.addAll(pq);
                    rpq.poll();
                    
                    pq.clear();
                    pq.addAll(rpq);
                    
                    rpq.clear();
                    
                } else if(operBits[1].equals("-1")) {
                    pq.poll();
                }
            }
        }

        if(pq.isEmpty()) {
            return new int[] {0, 0};
        } else {
            int small = pq.peek();
            rpq.addAll(pq);
            int big = rpq.peek();
            
            return new int[] {big, small};
        }
    }
}