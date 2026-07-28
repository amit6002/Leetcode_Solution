class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

       
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder first = new StringBuilder();
        String middle = "";

        
        for (int i = 0; i < 26; i++) {

           
            for (int j = 0; j < freq[i] / 2; j++) {
                first.append((char) ('a' + i));
            }

            
            if (freq[i] % 2 == 1 && middle.isEmpty()) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        String second = first.reverse().toString();

       
        first.reverse();

        return first.toString() + middle + second;
    }
}