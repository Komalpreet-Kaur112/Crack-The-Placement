package graph;

public class floodFills {
    public static void dfs(int[][] img, int sr, int sc, int newColor,int dr[], int dc[], int iniColor, int[][] ans){
        ans[sr] [sc] = newColor;
        int n = img.length;//row
        int m = img[0].length;//col
        for(int l = 0;l<4;l++){
            int nr = sr + dr[l];
            int nc = sc + dc[l];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && img[nr][nc]==iniColor && ans[nr][nc] != newColor){
                ans[nr][nc] = newColor;
                dfs(img, nr, nc, newColor, dr, dc, iniColor, ans);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int ans[][] = image;
        dfs(image, sr, sc, color, dr, dc, iniColor, ans);
        return ans;
    }
}
