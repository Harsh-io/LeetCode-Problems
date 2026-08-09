class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        // for(int[] e : edges){
        //     adj.get(e[0]).add(e[1]);
        //     adj.get(e[1]).add(e[0]);
        // }

        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int cnt = 0;
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){

            if(!vis[i]){

                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                vis[i] = true;

                int vertices = 0;
                int edgeCount = 0;

                while(!q.isEmpty()){
                    
                    int node = q.poll();
                     vertices++;

                    // Every edge appears twice
                    edgeCount += adj.get(node).size();

                    for(int child : adj.get(node)){

                       

                        if(!vis[child]){
                            vis[child] = true;
                            q.offer(child);
                        }
                    }
                }
                
                edgeCount /= 2;

                if (edgeCount == vertices * (vertices - 1) / 2) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}