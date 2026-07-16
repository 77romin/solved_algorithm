class Solution {
    private int cnt = 0;
    private int elim0 = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2]; // {변환 횟수, 제거된 모든 0의 개수}
        while(!s.equals("1"))
            s = changeToBinary(s);
        answer[0] = cnt;
        answer[1] = elim0;
        return answer;
    }
    
    private String changeToBinary(String s) {
        cnt++;
        int n = 0; // 이진수인 s에서 0을 삭제한 값의 길이
        
        String[] Bits = s.trim().split("");
        for(String Bit : Bits) {
            if(Bit.equals("0")) elim0++;
            else n++;
        }
        
        return Integer.toBinaryString(n);
    }
}