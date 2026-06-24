class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currMax = nums[0];
        int maxSum = nums[0];

        int currMin = nums[0];
        int minSum = nums[0];

        for (int x : nums) {
            totalSum += x;
        }

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            currMax = Math.max(x, currMax + x);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(x, currMin + x);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        int circular = totalSum - minSum;

        return Math.max(maxSum, circular);
    }
}