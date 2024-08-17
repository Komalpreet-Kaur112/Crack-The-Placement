package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class topologicalSort {
    static void dfs(int curr, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        visited[curr] = true;
        for(int v : adj.get(curr)){
            if(!visited[v]){
                dfs(v, visited, stack, adj);
            }
        }
        stack.push(curr);
    }
    
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                dfs(i, visited, stack, adj);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
