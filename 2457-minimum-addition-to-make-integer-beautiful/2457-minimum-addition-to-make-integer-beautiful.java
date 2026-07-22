class Solution {

    public long makeIntegerBeautiful(long n, int target) {

        long ans = 0;
        long base = 1;

        while (digitSum(n) > target) {

            long digit = (n / base) % 10;
            long add = ((10 - digit) ) * base;

            ans += add;
            n += add;

            base *= 10;
        }

        return ans;
    }

    private int digitSum(long n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}