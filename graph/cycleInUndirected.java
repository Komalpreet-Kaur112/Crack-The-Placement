package graph;

import java.util.ArrayList;

public class cycleInUndirected {
    public static boolean cycleExist(int i, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj){
         visited[i] = true;
         for(int v : adj.get(i)){
             if(!visited[v]){
                 if(cycleExist(v, i, visited, adj)){
                 return true;
                 }
             }
             else if(v != parent){
                 return true;
             }
         }
         return false;
     }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(cycleExist(i, -1, visited, adj)){
                return true;
                }
            }
        }
        return false;
    }
}
