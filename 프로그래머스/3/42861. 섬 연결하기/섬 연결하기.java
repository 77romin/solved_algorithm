import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private int[] parents;
    
    private class Edge implements Comparable<Edge> {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    private int find(int a) {
        if(parents[a] < 0) return a; // **음수이면 본인**
        
        return parents[a] = find(parents[a]); 
    }
    
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        
        if(parents[rootA]<parents[rootB]) { // a 집합의 크기가 크면 b 집합의 부모를 a 집합의 부모로!
            parents[rootB] = rootA;
            parents[rootA]--; // a 집합의 크기 증가
        } else {
            parents[rootA] = rootB;
            parents[rootB]--; // a 집합의 크기 증가
        }
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        
        parents = new int[n];
        for(int i=0; i<n; i++)
            parents[i] = -1; // **-1로 초기화! --> 집합의 크기가 자기 자신뿐이므로 1**
        
        List<Edge> edges = new ArrayList<>();
        
        for(int[] cost : costs)
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        
        Collections.sort(edges);
        
        int minCost = 0;
        int edgeCnt = 0;
        for(Edge curEdge : edges) {
            if(union(curEdge.from, curEdge.to)) {
                minCost += curEdge.cost;
                edgeCnt++;
                if(edgeCnt==n-1) return minCost;
            }
        }
        
        return -1;
    }
}

// Kruskal 알고리즘(MST) 최소비용 구하기 **집합의 크기가 큰 것이 작은 것 흡수하는 식으로 트리깊이 얕게 유지하기**