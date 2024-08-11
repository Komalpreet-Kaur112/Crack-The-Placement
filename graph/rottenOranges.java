package graph;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public int orangesRotting(int[][] grid) {
        // base case
        if(grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;//rows
        int m = grid[0].length; //column
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;//count of fresh oranges
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    count_fresh++;//count of fresh oranges
                }
            }
        }
        if(count_fresh == 0){ // if there are no fresh oranges
            return 0;
        }
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int mins = 0; // no of minutes
        while(!queue.isEmpty()){
           int s = queue.size();
         //    while(size > 0){
            for(int i = 0; i<s; i++){
                int [] curr = queue.remove();
                int r = curr[0]; 
                int c = curr[1]; 
                for(int j = 0; j<4;j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 0){
                        continue;
                    }
                    if(grid[nr][nc] == 1){
                        queue.add(new int[]{nr, nc});
                        count_fresh--; 
                        grid[nr][nc] = 2;
                    }
                }
            }
            if(queue.size() > 0){
                mins++;
            }
        }
        return count_fresh == 0? mins : -1;
    }
}
