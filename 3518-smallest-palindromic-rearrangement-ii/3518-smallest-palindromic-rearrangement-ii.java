class Solution {

    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }

        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
        }

        long total = countWays(half);

        if (k > total)
            return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (half[ch] == 0)
                    continue;

                half[ch]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }

                k -= ways;
                half[ch]++;
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (middle != 0)
            ans.append(middle);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

   
    private long countWays(int[] cnt) {

        int total = 0;

        for (int x : cnt)
            total += x;

        long res = 1;

        for (int f : cnt) {

            if (f == 0)
                continue;

            res *= nCr(total, f);

            if (res >= LIMIT)
                return LIMIT;

            total -= f;
        }

        return res;
    }


    private long nCr(int n, int r) {

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - i + 1) / i;

            if (ans >= LIMIT)
                return LIMIT;
        }

        return ans;
    }
}