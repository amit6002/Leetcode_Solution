class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums, k-1);
    }

    private int atMost(int[] A, int k){
        int i = 0, res = 0, count[] = new int[A.length+1];
        for(int j=0;j<A.length;j++){
            if(count[A[j]]++ == 0) k--;
            while(k<0){
                if(--count[A[i++]]==0) k++;
            }
            res += j-i+1;
        }
        return res;
    }
}