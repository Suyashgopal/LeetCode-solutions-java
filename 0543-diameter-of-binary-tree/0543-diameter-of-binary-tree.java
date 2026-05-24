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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){return 0;}
        int left= maxdepth(root.left);
        int right= maxdepth(root.right);
        max= Math.max(max,left+right) ;
        diameterOfBinaryTree( root.left);
        diameterOfBinaryTree( root.right);
        return max;
        
    }


    public int maxdepth(TreeNode root){
        if(root== null){return 0;}
        int l= 1+maxdepth(root.left);
        int r= 1+maxdepth(root.right);
        return Math.max(l, r);
    }
}