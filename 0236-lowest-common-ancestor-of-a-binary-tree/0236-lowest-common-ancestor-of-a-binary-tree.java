/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
     return    lca(root,p,q);
    }
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q){

        if(root==null| root==p|| root==q){
            return root;
        }
        TreeNode l= lca(root.left, p,q);
        TreeNode r= lca(root.right,p,q);
        if(l== null){
            return r;
        }
        else if(r== null){
            return l;
        }
        else{
            return root;
        }
    }
}