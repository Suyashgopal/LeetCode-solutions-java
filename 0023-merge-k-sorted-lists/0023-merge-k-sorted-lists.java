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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]== null){
                continue;
            }
            pq.offer(lists[i]);  
             }
            ListNode dummy = new ListNode(-1);
            ListNode temp= dummy;
            while(pq.peek()!= null){
                ListNode curr= pq.poll();
                if(curr.next!= null){
                    pq.offer(curr.next);
                }
                temp.next=curr;
                temp= curr;
                 
            }
            return dummy.next;



        
    }
}