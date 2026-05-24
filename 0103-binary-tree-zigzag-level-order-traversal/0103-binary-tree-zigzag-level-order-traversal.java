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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
   boolean f= true;
        List<List<Integer>> outer= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null){
            return outer;
        }
        q.offer(root);
        int count=0;
        while(!q.isEmpty()){
            int n= q.size();
            ArrayList<Integer> li= new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node= q.poll();
                if(node.left!= null){ q.offer(node.left);}
                 if(node.right!= null){ q.offer(node.right);}
                 if(f){
            li.add(node.val);
                 }
                 else{
                    li.addFirst(node.val);
                 }

            }
           f=!f;
            outer.add(li);

        }
        return outer;
        
    }
}