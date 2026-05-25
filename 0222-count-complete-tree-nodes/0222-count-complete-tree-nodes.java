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
    public int countNodes(TreeNode root) {
        if(root==null){return 0;}
 
       
          return countNodes(root.left)+ countNodes(root.right)+1; 
    }  
    int lh(TreeNode root){
        int count=0;
        while(root!= null){
            root= root.left;
            count++;
        }
        return count;
        
    }
    int rh(TreeNode root){
        int count=0;
        while(root!= null){
            root= root.right;
            count++;
        }
        return count;

    }
}