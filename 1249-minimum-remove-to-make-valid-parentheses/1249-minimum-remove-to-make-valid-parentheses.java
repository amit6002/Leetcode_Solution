class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> st = new Stack<>();
        HashSet<Integer> remove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } 
            else if (ch == ')') {

                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    remove.add(i);
                }
            }
        }

        while (!st.isEmpty()) {
            remove.add(st.pop());
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (!remove.contains(i))
                ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}