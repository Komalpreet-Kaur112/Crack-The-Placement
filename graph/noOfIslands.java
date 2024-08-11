package graph;

class Solution {

     public static void bfs(int i, int j, char[][]grid, Queue<int[]> q, boolean visited[][], int n, int m){
            // visited.add(new int[]{i,j});
            visited[i][j] = true;
            q.add(new int[]{i,j});
            int dr[] = {-1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            while(!q.isEmpty()){
                int curr[] = q.remove();
                int r = curr[0];
                int c = curr[1];
                for(int l = 0;l<4;l++){
                    int nr = r + dr[l];
                    int nc = c + dc[l];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !visited[nr][nc]){
                        // visited.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        // HashSet<int[]> visited = new HashSet<>();
        boolean visited[][] = new boolean[n][m];
        // Arrays.fill(visited, false);
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(i,j, grid, q,visited, n,m);
                    islands++;
                }
            }
        }
        return islands;
    }
}