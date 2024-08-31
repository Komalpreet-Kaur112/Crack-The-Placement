package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// public class topologicalSort {
    // 1. Using Dfs
    // static void dfs(int curr, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
    //     visited[curr] = true;
    //     for(int v : adj.get(curr)){
    //         if(!visited[v]){
    //             dfs(v, visited, stack, adj);
    //         }
    //     }
    //     stack.push(curr);
    // }
    
    
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     // add your code here
    //     boolean visited[] = new boolean[V];
    //     Arrays.fill(visited, false);
    //     Stack<Integer> stack = new Stack<>();
    //     for(int i = 0;i<V;i++){
    //         if(!visited[i]){
    //             dfs(i, visited, stack, adj);
    //         }
    //     }
    //     int ans[] = new int[V];
    //     int i = 0;
    //     while(!stack.isEmpty()){
    //         ans[i++] = stack.pop();
    //     }
    //     return ans;
    // }
// }

// 2. Using Kahns algorithm - modified BFS

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // indegree array 
        int []indegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[] = new int[V];
        int j = 0;
        while(!q.isEmpty()){
            int x = q.remove();
            topo[j] = x;
            j++;
            for(int it : adj.get(x)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
