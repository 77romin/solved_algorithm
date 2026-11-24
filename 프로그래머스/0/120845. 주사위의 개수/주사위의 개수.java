class Solution {
    public int solution(int[] box, int n) {
        int ans = 1;
        for(int val : box)
            ans *= val/n;
        
        return ans;
    }
}