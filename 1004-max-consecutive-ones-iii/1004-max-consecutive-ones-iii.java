class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) k--;
            while(k<0){
                if(nums[left]==0) k++;
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}