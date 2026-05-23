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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al= new ArrayList<>();
        inorder(root, al);
        return al;

        
    }
    void inorder(TreeNode node,  List<Integer>al){
        if(node== null){
            return ;
        }
        inorder(node.left,al);
        al.add(node.val);
        inorder(node.right,al);


      
    }
}