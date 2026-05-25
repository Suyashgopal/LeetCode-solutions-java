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
   
    
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> al= new ArrayList<>();
        if(root== null){return al;}
        q.offer(root);
        while(!q.isEmpty()){
            int rightval=0;
            int size= q.size();
            for(int i=0;i<size;i++){
              TreeNode node= q.poll();
              if(node.left!= null){
                q.offer(node.left);
              }
              if(node.right!=null){
                q.offer(node.right);
              }
              rightval= node.val;
             
            }
            al.add(rightval);
        }
        return al;
        
    }
}