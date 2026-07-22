class Solution {
    public boolean canConvertString(String s, String t, int k) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
           
            if (shift == 0) {
                continue;
            }
            int requiredMove = shift + 26 * count[shift];

            if (requiredMove > k) {
                return false;
            }

            count[shift]++;
        }

        return true;
    }
}