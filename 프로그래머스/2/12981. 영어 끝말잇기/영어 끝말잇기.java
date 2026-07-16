import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) { // n: 참가자 수, words[]: 끝말잇기 내용
        int[] answer = {0, 0}; // {가장 먼저 탈락한 사람 번호, 몇번째에 탈락인지}
        
        Deque<String> queue = new ArrayDeque<>();
        for(String word : words)
            queue.addLast(word);
        
        HashSet<String> hashSet = new HashSet<>();
        
        int cnt = 0;
        int firstMember = 0;
        String recentWord = "";
        boolean breakTime = false;
        while(!queue.isEmpty()) {
            cnt++;
            for(int i=0; i<n; i++) {
                if(queue.isEmpty()) {
                    cnt = 0;
                    breakTime = true;
                    break;
                }
                String currentWord = queue.removeFirst();
                if(hashSet.contains(currentWord)) {
                    firstMember = i+1;
                    breakTime = true;
                    break;
                }
                if(!recentWord.isEmpty() && recentWord.charAt(recentWord.length()-1) != currentWord.charAt(0)) {
                    firstMember = i+1;
                    breakTime = true;
                    break;
                }
                hashSet.add(currentWord);
                recentWord = currentWord;
            }
            if(breakTime) break;
        }
        answer[0] = firstMember;
        answer[1] = cnt;
        if(!breakTime) answer[1] = 0;

        return answer;
    }
}