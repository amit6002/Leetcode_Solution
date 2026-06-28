class Solution {
    public boolean canJump(int[] nums) {
        int maxJumps=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxJumps) return false;
            maxJumps=Math.max(maxJumps,i+nums[i]);
        }
        return true;
    }
}