class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        int k=0;
        for(int i=0;i<nums1.length;i++){
            nums[k++]=nums1[i];
        }
         for(int i=0;i<nums2.length;i++){
            nums[k++]=nums2[i];
        }
        Arrays.sort(nums);
        int n=nums.length;
        if(n%2==0){
            return ((double)nums[n/2] + nums[n/2 - 1]) / 2;
        }
        return (double) nums[n/2];
    }
}