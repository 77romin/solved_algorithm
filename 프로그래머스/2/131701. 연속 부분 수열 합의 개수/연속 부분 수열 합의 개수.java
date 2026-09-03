import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        HashSet<Integer> hashSet = new HashSet<>(); // 중복된 합은 제외하려고 hashSet 사용
        
        int[] prefix = new int[2*n]; // 배열크기 확장
        prefix[0] = elements[0];
        for(int i=1; i<2*n; i++) { // 누적합 저장
            prefix[i] = prefix[i-1]+elements[i%n];
        }
        
        for(int i=1; i<=n; i++) { // 수열의 길이
            for(int j=0; j<n; j++) { // 수열의 시작인덱스
                hashSet.add(prefix[j+i]-prefix[j]);
            }
        }
        return hashSet.size();
    }
}

/**
 * 시간복잡도: O(N**2)
 * 원리: 배열의 길이를 두배로 확장해서, 누적합을 미리 저장하자.
 */


// --------|----|--------------------------
// ----------------------------------------
// -------------
// ---------