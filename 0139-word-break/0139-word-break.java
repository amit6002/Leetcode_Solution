class Solution {

    Boolean[] dp;

    boolean canBreak(int i, String s, Set<String> set) {

        if (i == s.length())
            return true;

        if (dp[i] != null)
            return dp[i];

        for (int j = i; j < s.length(); j++) {

            String word = s.substring(i, j + 1);

            if (set.contains(word)) {

                if (canBreak(j + 1, s, set)) {
                    return dp[i] = true;
                }
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        dp = new Boolean[s.length()];

        Set<String> set = new HashSet<>(wordDict);

        return canBreak(0, s, set);
    }
}