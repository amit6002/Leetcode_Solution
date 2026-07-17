class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                boolean[][] vis = new boolean[m][n];
                boolean pacific = dfs(i,j,heights,vis,true);

                vis = new boolean[m][n];
                boolean atlantic = dfs(i,j,heights,vis,false);

                if(pacific && atlantic){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    boolean dfs(int r,int c,int[][] h,boolean[][] vis,boolean pacific){

        int m=h.length;
        int n=h[0].length;

        if(pacific){
            if(r==0 || c==0)
                return true;
        }else{
            if(r==m-1 || c==n-1)
                return true;
        }

        vis[r][c]=true;

        for(int[] d:dir){

            int nr=r+d[0];
            int nc=c+d[1];

            if(nr<0||nc<0||nr>=m||nc>=n)
                continue;

            if(vis[nr][nc])
                continue;

            if(h[nr][nc]>h[r][c])
                continue;

            if(dfs(nr,nc,h,vis,pacific))
                return true;
        }

        return false;
    }
}