import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        return chkDupl(phone_book);
    }
    
    private boolean chkDupl(String[] phones) {
        Map<String, Integer> map = new HashMap<>();
        for(String phone : phones) {
            String[] phoneBits = phone.split("", phone.length());
            String chkQuery = "";
            for(int i=0; i<phoneBits.length; i++) {
                chkQuery += phoneBits[i];
                map.put(chkQuery, map.getOrDefault(chkQuery, 0)+1);
            }
        }
        for(String phone : phones) {
            if(map.get(phone)>1)
                return false;
        }
        return true;
    }
}

/**
 * <Memo>
 * Node를 활용하여 문자열의 문자토큰이 들어올때마다 자식노드 생성하는 식으로 함. 만일 문자열이 끝났을 때의 위치한 노드가 이미 존재한 노드이면 false 반환!
 * 시간복잡도: O(N)
 */