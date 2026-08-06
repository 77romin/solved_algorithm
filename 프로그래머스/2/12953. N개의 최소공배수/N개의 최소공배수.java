class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            int smallN = answer<=arr[i]? answer : arr[i];
            int bigN = answer>arr[i]? answer : arr[i];
            answer = lcm(bigN, smallN); // 큰수, 작은수 순으로 넣어주기. 최소공배수 결과 저장 -> 매번 갱신됨.
            // {a, b, c, d, e} --> a,b의 최소공배수 a', a'과 c의 최소공배수는 c', ... 이런식으로 모든 값을 하나씩 최소공배수 최신화
        }
        return answer;
    }
    
    private int lcm(int n1, int n2) { // 두 수의 최소공배수 반환
        int g = gcd(n1, n2); // 1. 최소공약수 구하기
        return n1*n2/g; // 2. 두 수를 곱하고, 최대공약수로 나누기
    }
    
    private int gcd(int n1, int n2) { // 두 수의 최대공약수 반환
        if(n1%n2==0)
            return n2;
        else
            return gcd(n2, n1%n2);
    }
    
    
}

// 2 4 6 8
// 2
// 1*2*3*4*2 = 48

// 2 6 8 14
// 2 
// 1*3*4*7 = 84
// 