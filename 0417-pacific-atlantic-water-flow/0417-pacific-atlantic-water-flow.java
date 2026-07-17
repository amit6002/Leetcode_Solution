class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int c=0;c<n;c++)
            dfs(0,c,heights,pacific);

        for(int r=0;r<m;r++)
            dfs(r,0,heights,pacific);

        for(int c=0;c<n;c++)
            dfs(m-1,c,heights,atlantic);

        for(int r=0;r<m;r++)
            dfs(r,n-1,heights,atlantic);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    void dfs(int r,int c,int[][] heights,boolean[][] vis){

        if(vis[r][c])
            return;

        vis[r][c]=true;

        int m=heights.length;
        int n=heights[0].length;

        for(int[] d:dir){

            int nr=r+d[0];
            int nc=c+d[1];

            if(nr<0||nc<0||nr>=m||nc>=n)
                continue;

            if(heights[nr][nc] < heights[r][c])
                continue;

            dfs(nr,nc,heights,vis);
        }
    }
}