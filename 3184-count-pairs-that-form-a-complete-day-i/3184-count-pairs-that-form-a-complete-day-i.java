class Solution {
    public int countCompleteDayPairs(int[] hours) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        for (int h : hours) {

            int rem = h % 24;

            int need = (24 - rem) % 24;

            ans += map.getOrDefault(need, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}