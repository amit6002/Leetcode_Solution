class Solution {
    public int countCompleteDayPairs(int[] hours) {

        int[] freq = new int[24];
        int ans = 0;

        for (int h : hours) {

            int rem = h % 24;

            int need = (24 - rem) % 24;

            ans += freq[need];

            freq[rem]++;
        }

        return ans;
    }
}