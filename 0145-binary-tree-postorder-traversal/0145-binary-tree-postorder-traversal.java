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
    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> al= new ArrayList<>();
        postorder(root,al);
        return al;
        
    }
       void postorder(TreeNode node,List<Integer> al ){
    if(node==null){
        return;
    }
 
    postorder(node.left, al);
postorder(node.right,al);
       al.add(node.val);
    }
}