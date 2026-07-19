class Solution {
    public String smallestSubsequence(String s) {
        int[] arr = new int[26];
        boolean visited[] = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']--;
            if (visited[s.charAt(i) - 'a'])
                continue;
            while (!st.isEmpty() && st.peek() > s.charAt(i) && arr[st.peek() - 'a'] > 0) {
                visited[st.peek() - 'a'] = false;
                st.pop();

            }

            st.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}