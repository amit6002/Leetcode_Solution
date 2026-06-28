class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int count=0;
        int currRange=0;
        int lastIndex=0;
        for(int i=0;i<n-1;i++){
            lastIndex=Math.max(lastIndex,i+nums[i]);
            if(i==currRange){
                count++;
                currRange=lastIndex;
            }
        }
        return count;
    }
}