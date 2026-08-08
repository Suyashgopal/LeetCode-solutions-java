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
        int n = lists.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ListNode head= lists[i];

            ListNode temp= head;
            while(temp!= null){
                int num= temp.val;
                pq.offer(num);
                temp= temp.next;

            }



        }
        
        ListNode res= new ListNode(-1);
        ListNode temp= res;

        while(!pq.isEmpty()){
            int value= pq.poll();
                    ListNode a= new ListNode(value);
                    temp.next=a;
                    temp= temp.next;

            
        }
        return res.next;

    }
}