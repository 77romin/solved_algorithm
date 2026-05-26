import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<String, Integer> playerMap = new HashMap<>(); // 선수 위주 (key: 선수이름 / value: 등수)
    private final Map<Integer, String> rankMap = new HashMap<>(); // 등수 위주 (key: 등수 / value: 선수이름)
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        // 해시맵 두개를 사용하는 이유: 시간복잡도를 줄이기 위해서.
        playerMapping(players); // 선수이름 기준 매핑
        rankMapping(players); // 등수 기준 매핑
        
        hardGame(callings); // 엎치락 뒤치락~
        
        for(int rank:rankMap.keySet()) { // 등수 오름차순으로 배열에 저장
            answer[rank]=rankMap.get(rank);
        }
        
        return answer;
    }
    
    /* --- Business Logic --- */
    
    void playerMapping(String[] players) { // 해시맵에 선수이름:등수 넣어주기 (key: 선수이름 / value: 등수)
        int i=0;
        for(String player:players)
            playerMap.put(player, i++);
    }
        
    void rankMapping(String[] players) { // 해시맵에 등수:선수이름 넣어주기 (key: 등수 / value: 선수이름)
        int i=0;
        for(String player:players)
            rankMap.put(i++, player);
    }
    
    void hardGame(String[] callings) {
        // 호명될때마다 선수 등수 변화
        for(String call:callings) {
            int index = playerMap.get(call); // 추월할 선수(key: call / value: index)
            String loser = rankMap.get(index-1); // 추월당한 선수(key: index-1 / value: loser)
            playerMap.put(call, index-1);
            playerMap.put(loser, index);
            
            rankMap.put(index-1, call);
            rankMap.put(index, loser);
        }
    }
    
}