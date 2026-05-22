class Solution {
    public int solution(int n) {
        return  ((n*6)/gcd(n, 6))/6; // ((a*b)/최대공약수) / 피자슬라이스수
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
	    return gcd(b, a % b);
    }
}


// 최소공배수