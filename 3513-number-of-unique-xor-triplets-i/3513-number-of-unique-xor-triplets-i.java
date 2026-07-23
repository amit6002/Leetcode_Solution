class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int bits = 0;
        while ((1 << bits) <= max) {
            bits++;
        }

        return 1 << bits;
    }
}