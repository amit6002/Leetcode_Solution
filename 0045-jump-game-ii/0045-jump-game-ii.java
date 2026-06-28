class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {

            int maxJump = Math.min(nums[i], n - 1 - i);

            for (int jump = 1; jump <= maxJump; jump++) {

                if (dp[i + jump] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i + jump] + 1);
                }
            }
        }

        return dp[0];
    }
}