class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int ans = 0;

        
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {

                    if (j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (dp[i][j] == 0)
                    continue;

                int minWidth = dp[i][j];

                for (int k = i; k >= 0; k--) {

                    if (dp[k][j] == 0)
                        break;

                    minWidth = Math.min(minWidth, dp[k][j]);

                    int height = i - k + 1;

                    ans = Math.max(ans, minWidth * height);
                }
            }
        }

        return ans;
    }
}