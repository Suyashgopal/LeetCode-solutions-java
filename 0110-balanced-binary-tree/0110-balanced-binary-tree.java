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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int r= findht(root.right);
        int l= findht(root.left);
        if(Math.abs(l-r)>1){
            return false;
        }
        boolean left= isBalanced(root.left);
        boolean right= isBalanced(root.right);
     if(!left|| !right){
        return false;
     }
      return true; 
        
    }
public int findht(TreeNode root){
    if(root== null){
        return 0;
    }
    int l= findht(root.left);
    int r= findht(root.right);
    return 1+ Math.max(l,r);
}


}