import java.util.*;

class Solution {
    
    /*
        n: 처음 표의 행 개수
        k: 행의 위치
        cmd: 명령어들
    */
    
    private class Node {
        boolean isExist;
        int pre, next;
        Node(boolean isExist, int pre, int next) {
            this.isExist = isExist;
            this.pre = pre;
            this.next = next;
        }
    }
    
    private static Node[] nodes;
    
    public String solution(int n, int k, String[] cmd) {
        // 표 초기화
        nodes = new Node[n];
        
        for(int i=0; i<n; i++) 
            nodes[i] = new Node(true, i-1, i+1);
        
        nodes[0].pre = -1;
        nodes[n-1].next = -1;
        
        Stack<Integer> stack = new Stack<>();
        for(String oneLine : cmd) {
            int nextK=-1;
            String[] lineBits = oneLine.split(" ");
            switch(lineBits[0]) {
                case "D": 
                    
                    for(int i=0; i<Integer.parseInt(lineBits[1]); i++)
                        k = nodes[k].next;
                    
                    break;
                    
                case "U":
                    
                    for(int i=0; i<Integer.parseInt(lineBits[1]); i++)
                        k = nodes[k].pre;
                    
                    break;
                    
                case "C":
                    nodes[k].isExist = false;
                    stack.push(k);
                    
                    int pre = nodes[k].pre;
                    int next = nodes[k].next;

                    // 양옆 노드 연결 갱신
                    if (pre != -1) nodes[pre].next = next;
                    if (next != -1) nodes[next].pre = pre;
                    
                    if(next != -1)
                        k = next;
                    else
                        k = pre;
                    
                    break;
                    
                case "Z":
                    if(stack.isEmpty()) break; 
                    int revive = stack.pop();
                    nodes[revive].isExist = true;
                    
                    pre = nodes[revive].pre;
                    next = nodes[revive].next;
                    
                    if (pre != -1) nodes[pre].next = revive;
                    if (next != -1) nodes[next].pre = revive;
                    
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Node node : nodes)
            if(node.isExist)
                sb.append("O");
            else
                sb.append("X");
        
        return sb.toString();
    }
}