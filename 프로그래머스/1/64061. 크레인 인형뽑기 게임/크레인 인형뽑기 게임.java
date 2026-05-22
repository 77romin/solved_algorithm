import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int move : moves) {
            boolean chk = true;
            int i=0;
            while(chk) {
                if(board[i][move-1]!=0) {
                    if(!stack.isEmpty() && stack.getLast() == board[i][move-1]) {
                        stack.removeLast();
                        answer+=2;
                    } else
                        stack.addLast(board[i][move-1]);
                    board[i][move-1] = 0;
                    chk = false;
                } else {
                    i++;
                }
                if(i>=board.length)
                    chk = false;
            }
        }
        return answer;
    }
}