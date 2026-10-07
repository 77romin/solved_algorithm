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
        if(parents[a] == a) return a;
        
        return parents[a] = find(parents[a]); 
    }
    
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        
        parents[rootA] = rootB;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        
        parents = new int[n];
        for(int i=0; i<n; i++)
            parents[i] = i;
        
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

// Kruskal 알고리즘(MST) 최소비용 구하기