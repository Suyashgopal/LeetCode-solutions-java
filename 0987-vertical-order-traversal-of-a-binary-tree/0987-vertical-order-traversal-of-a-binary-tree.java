/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    class tuple {
        TreeNode node;
        int row;
        int col;//level

        tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col= col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
       
        Queue<tuple> q = new LinkedList<>();


        if (root == null) {
            return list;
        }
        q.add(new tuple(root,0,0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>(); 

    while(!q.isEmpty()){
        int size= q.size();

        for(int i=0;i<size;i++){
            tuple curr= q.poll();
            TreeNode node = curr.node;
            int row= curr.row;
            int col= curr.col;//level
            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }

            map.get(row).get(col).offer(node.val);
            if(node.left!= null){
                q.offer(new tuple(node.left, row-1, col+1));

            }

           if(node.right!= null){
                q.offer(new tuple(node.right, row+1, col+1));
                
            }
       }
          

    }


   //adding vals 
   for( TreeMap<Integer, PriorityQueue<Integer>> ab : map.values() ){
    list.add(new ArrayList<>());
    for(PriorityQueue<Integer> node: ab.values()){
        while(!node.isEmpty()){
        list.get(list.size()-1).add(node.poll());

        }
    }
   }

    
        
   return list;
       
    }
}