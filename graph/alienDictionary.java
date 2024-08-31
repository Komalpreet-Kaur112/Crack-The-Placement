package graph;

import java.util.LinkedList;
import java.util.Queue;

// using topological sorting
public class alienDictionary {
    // given strings in order of alien dictionary
    // compare consecutive strings
    // find the point of differentiation
    // we are using topological sorting, so create a directed graph first.
    // create a list of list storing integer values first.

   public static int[] topoSort(ArrayList<ArrayList<Integer>> ans, int k){
        int []indegree = new int[k];
        Arrays.fill(indegree, 0);
        //calculating indegree
        for(int i = 0;i<k;i++){
            for(int v: ans.get(i)){
                indegree[v]++;
            }
        }
        //create a queue and put the nodes with indegree 0 in it.
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //run a while loop
        int topo[] = new int[k];
        int y=0;
        while (!q.isEmpty()) {
            int x = q.remove();
            topo[y] = x;
            y++;
            for (int z : ans.get(x)) {
                indegree[z]--;
                if (indegree[z]==0) {
                    q.add(z);
                }
            }
        }
        return topo;
    }
    
    
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
     ArrayList<ArrayList<Integer>> ans = new ArrayList<>(k);
     for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());  // Initialize each list
        }
    for(int i = 0;i<n-1;i++){
        String s1 = dict[i];
        String s2 = dict[i+1];
        int len = Math.min(s1.length(), s2.length());
        for(int j = 0;j<len;j++){
            if(s1.charAt(j) != s2.charAt(j)){
                ans.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                break;
            }// adding directed edges
        }
    }
        int topo[] = topoSort(ans, k);
        String str ="";
        for(int i = 0;i<k;i++){
            str += (char)(topo[i] + (int)('a'));
        }
return str;
    }
}