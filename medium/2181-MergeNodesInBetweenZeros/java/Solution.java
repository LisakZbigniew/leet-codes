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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode cur = head.next;
        ListNode result = new ListNode(-1);
        ListNode sumNode = result; 
        int sum = 0;
        while(cur.next != null){
            sum += cur.val;
            if(cur.val == 0){
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;
                sum = 0; 
            }
            cur = cur.next;
        }
        sumNode.next = new ListNode(sum);

        return result.next;
    }
}