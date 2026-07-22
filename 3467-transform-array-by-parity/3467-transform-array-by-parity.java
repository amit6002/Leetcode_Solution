class Solution {
    public int[] transformArray(int[] nums) {
        int odd=0;
        int ans[]=new int[nums.length];
        for(int num:nums){
            if(num%2!=0) odd++;
        }
        int j=nums.length-1;
        while(odd-->0){
            ans[j--]=1;
        }
        return ans;
    }
}