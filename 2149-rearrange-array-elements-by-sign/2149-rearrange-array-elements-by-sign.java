class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] arr=new int[nums.length];
        int i=0;
        int j=1;
        int k=0;
        while(k<nums.length){
            if(nums[k]>0) {
                arr[i]=nums[k];
                k++;
                i+=2;
            }
            else{
                arr[j]=nums[k];
                k++;
                j+=2;
            }
        }
     return arr;
    }
}