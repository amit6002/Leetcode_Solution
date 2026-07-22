class Solution {
    public int maximumProduct(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
        }
        while (k-- > 0) {
            int smallest = pq.poll();
            pq.offer(smallest + 1);
        }

        long mod = 1_000_000_007;
        long product = 1;

        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % mod;
        }

        return (int) product;
    }
}