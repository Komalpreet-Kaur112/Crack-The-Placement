package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraph {
     public static boolean check(int i, int color[], ArrayList<ArrayList<Integer>>adj){
         Queue<Integer> q = new LinkedList<>();
         q.add(i);
         color[i] = 0;
         while(!q.isEmpty()) {
             int curr = q.peek();
             q.remove();
             for(int v : adj.get(curr)){
                if(color[v] == -1){
                    color[v] = 1 - color[curr];
                    q.add(v);
                }
                else if(color[v] == color[curr]){
                    return false;
                }
            }
        }
        return true;
     }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i<V;i++){
            if(color[i] == -1){
                if(check(i, color, adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
