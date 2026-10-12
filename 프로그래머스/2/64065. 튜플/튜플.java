import java.util.*;

class Solution {
    
    private class Element implements Comparable<Element> {
        int[] elem;
        int size;
        
        Element (int[] elem) {
            this.elem = elem;
            this.size = elem.length;
        }
        
        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.size, o.size);
        }
    }
    
    public int[] solution(String s) {
        
        List<Element> elements = new ArrayList<>();
        
        s = s.substring(1, s.length()-1); // 양쪽 끝 감싼 {, } 삭제
        
        String[] sBits = s.split("}"); // } 기준으로 문자열 쪼개기
        
        for(String sBit : sBits) {
            if(sBit.startsWith(",")) sBit = sBit.substring(2); // `,`로 시작할 경우
            else sBit = sBit.substring(1); // `{`로 시작할 경우
            
            String[] eBits = sBit.split(","); // 부분문자열 내 요소 쪼개서 배열에 저장
            int[] e = new int[eBits.length];
            int i=0;
            for(String eBit : eBits)
                e[i++] = Integer.parseInt(eBit);
            
            elements.add(new Element(e)); // 저장한 부분문자열을 elements 리스트에 넣어주기 (Type: Element)
        }
        
        Collections.sort(elements); // 부분문자열 크기 기준 오름차순 정렬
        
        List<Integer> ans = new ArrayList<>(); // 부분문자열 오름차순으로 확인하며 정답배열 채워가기
        for(Element element : elements) {
            for(int e : element.elem) {
                if(!ans.contains(e))
                    ans.add(e);
            }
        }
        
        int[] answer = new int[ans.size()];
        int t = 0;
        for(int e : ans)
            answer[t++] = e;
        
        return answer;
    }
}