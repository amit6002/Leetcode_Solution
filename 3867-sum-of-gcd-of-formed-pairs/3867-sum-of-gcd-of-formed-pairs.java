class Solution {
    int gcd(int a,int b){
       while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            ans[i]=gcd(nums[i],max);
        }
        Arrays.sort(ans);
        int i=0;
        int j=ans.length-1;
        long val=0;
        while(i<j){
            val+=gcd(ans[i],ans[j]);
            i++;
            j--;
        }
        return val;
    }
}