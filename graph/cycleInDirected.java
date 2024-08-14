package graph;

public class cycleInDirected {
    // Function to detect cycle in a directed graph using modified dfs.
    public static boolean cycleExist(int i, boolean visited[], boolean recStack[], ArrayList<ArrayList<Integer>> adj){
    //   if(recStack[i]){// if node is already in call stack -> satisfying cycle condition
    //       return false;
    //   }
       
        visited[i] = true;
        recStack[i] = true;
        for(int v : adj.get(i)){
            if(!visited[v] && cycleExist(v, visited, recStack, adj)){
                return true;
            }
            else if(recStack[v]){
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        
        for(int i = 0;i < V;i++){
            if(!visited[i] && cycleExist(i, visited, recStack, adj)){
                return true;
            }
        }
        return false;
    }
}
