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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        ListNode prev=null;
        for(int i=0;i<left;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode nextNode=prev;
        prev=null;
        ListNode tail=curr;
        for(int i=left;i<=right;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        nextNode.next=prev;
        tail.next=curr;
        return dummy.next;
    }
}