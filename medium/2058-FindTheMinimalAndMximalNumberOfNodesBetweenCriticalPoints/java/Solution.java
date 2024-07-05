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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode cur = head;
        int min = -1;
        int lastCrit = -1;
        int firstCrit = -1;
        int curIndex = 0;
        while(cur.next.next != null){
            curIndex++;
            int left = cur.val;
            int mid = cur.next.val;
            int right = cur.next.next.val;

            if((mid < left && mid < right) || (mid > left && mid > right)){
                
                if(firstCrit == -1){
                    firstCrit = curIndex;
                }

                if(lastCrit != -1 && (min == -1 || (curIndex - lastCrit < min))){
                    min = curIndex - lastCrit;
                }

                lastCrit = curIndex;
            }
            cur = cur.next;
        }
        if(min == -1){
            int[] result = {-1 , -1}; 
            return result; 
        }
        int[] result = {min , lastCrit - firstCrit}; 
        return result;
    }
}