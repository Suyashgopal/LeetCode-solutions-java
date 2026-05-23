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
    public int maxDepth(TreeNode root) {
        
        ArrayList<Integer> al= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode node= root;
        if(node== null){
            return 0;
        }
        int count=0;
        q.offer(node);
        while(!q.isEmpty())
        {int n= q.size();
        for(int i=0;i<n;i++){
            node=q.poll();
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!= null){
                q.offer(node.right);
            }

        }
        count++;


        }        
    return count;
    }
}