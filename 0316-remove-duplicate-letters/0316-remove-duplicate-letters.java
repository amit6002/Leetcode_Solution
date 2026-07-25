class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        Stack<Character> st = new Stack<>();
        boolean[] present = new boolean[26];

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (present[ch - 'a'])
                continue;

            while (!st.isEmpty()
                    && st.peek() > ch
                    && freq[st.peek() - 'a'] > 0) {

                present[st.pop() - 'a'] = false;
            }

            st.push(ch);
            present[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}