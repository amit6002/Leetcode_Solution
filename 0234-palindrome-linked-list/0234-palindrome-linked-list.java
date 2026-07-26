class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (!list.get(i).equals(list.get(j)))
                return false;

            i++;
            j--;
        }

        return true;
    }
}