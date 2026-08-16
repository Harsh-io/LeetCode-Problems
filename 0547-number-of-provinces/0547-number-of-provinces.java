class Solution {
    public int findCircleNum(int[][] arr) {
        
        int n = arr.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(arr[i][j] == 1 & i != j){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }

        boolean vis[] = new boolean[n+1];
        int cnt = 0;

        for(int i=1; i<=n; i++){

            if(vis[i] == false){
                cnt++;
                dfs(i, adj, vis);
            }
        }
       return cnt;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        
        vis[node] = true;

        for(int it : adj.get(node)){
            if(vis[it] == false) dfs(it, adj, vis);
        }
    }
}

//SC: O(N) +O(N) [visited array + recursion stack space]
//TC: O(N) + O(V + 2E) 