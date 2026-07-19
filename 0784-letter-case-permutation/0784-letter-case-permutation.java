import java.util.*;

class Solution {
    List<String> arr = new ArrayList<>();

    void solve(int i, String s, StringBuilder curr) {
        if (i == s.length()) {
            arr.add(curr.toString());
            return;
        }

        if (Character.isLetter(s.charAt(i))) {
            curr.append((char)(s.charAt(i) ^ 32)); 
            solve(i + 1, s, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        curr.append(s.charAt(i));
        solve(i + 1, s, curr);
        curr.deleteCharAt(curr.length() - 1);
    }

    public List<String> letterCasePermutation(String s) {
        solve(0, s, new StringBuilder());
        return arr;
    }
}