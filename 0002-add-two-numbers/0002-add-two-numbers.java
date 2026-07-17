/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            tail.next = newNode;
            tail = tail.next;
            if((l1 ==null ||l2==null) && carry==0) break;
        }
        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;
        if (carry > 0)
            tail.next = new ListNode(carry);
        return dummyNode.next;
    }
}